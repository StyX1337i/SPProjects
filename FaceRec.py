import cv2
import mediapipe as mp
import os
import numpy as np

mp_face_mesh = mp.solutions.face_mesh
mp_hands = mp.solutions.hands

face_mesh = mp_face_mesh.FaceMesh(max_num_faces=1, refine_landmarks=True)
hands = mp_hands.Hands(max_num_hands=1, min_detection_confidence=0.7, min_tracking_confidence=0.7)


def apply_overlay(frame, overlay, landmark, h, w, scale=2.5):
    if overlay is None: return frame
    face_size = int(scale * h * 0.4)
    cx, cy = int(landmark.x * w), int(landmark.y * h)
    x1, y1 = cx - face_size // 2, cy - face_size // 2
    x2, y2 = x1 + face_size, y1 + face_size
    x1, y1, x2, y2 = max(0, x1), max(0, y1), min(w, x2), min(h, y2)
    try:
        overlay_res = cv2.resize(overlay, (x2 - x1, y2 - y1))
        if overlay_res.shape[2] == 4:
            alpha = overlay_res[:, :, 3] / 255.0
            for c in range(3):
                frame[y1:y2, x1:x2, c] = (alpha * overlay_res[:, :, c] + (1 - alpha) * frame[y1:y2, x1:x2, c])
        else:
            frame[y1:y2, x1:x2] = overlay_res[:, :, :3]
    except:
        pass
    return frame


base_path = os.path.dirname(os.path.abspath(__file__))
path = os.path.join(base_path, "reaction_pics")

pics = {
    "wow": cv2.imread(os.path.join(path, "wow.png"), cv2.IMREAD_UNCHANGED),
    "shock": cv2.imread(os.path.join(path, "shock.png"), cv2.IMREAD_UNCHANGED),
    "angry": cv2.imread(os.path.join(path, "angry.png"), cv2.IMREAD_UNCHANGED),
    "think": cv2.imread(os.path.join(path, "think.png"), cv2.IMREAD_UNCHANGED),
    "finger": cv2.imread(os.path.join(path, "finger.png"), cv2.IMREAD_UNCHANGED),
    "middle": cv2.imread(os.path.join(path, "middle.png"), cv2.IMREAD_UNCHANGED)
}

cap = cv2.VideoCapture(0)

while cap.isOpened():
    success, frame = cap.read()
    if not success: break
    frame = cv2.flip(frame, 1)
    h, w, _ = frame.shape
    rgb = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)

    f_res = face_mesh.process(rgb)
    h_res = hands.process(rgb)
    active = False

    if h_res.multi_hand_landmarks:
        hand = h_res.multi_hand_landmarks[0]
        lms = hand.landmark

        index_up = lms[8].y < lms[6].y - 0.05
        middle_up = lms[12].y < lms[10].y - 0.05
        ring_up = lms[16].y < lms[14].y - 0.05
        pinky_up = lms[20].y < lms[18].y - 0.05

        if middle_up and not index_up and not ring_up:
            frame = apply_overlay(frame, pics["middle"], lms[12], h, w, scale=1.5)
            active = True
        elif index_up and not middle_up:
            frame = apply_overlay(frame, pics["finger"], lms[8], h, w, scale=1.2)
            active = True

    #LOGICA EXPRESII
    if not active and f_res.multi_face_landmarks:
        face = f_res.multi_face_landmarks[0]

        mouth = face.landmark[14].y - face.landmark[13].y
        b_left = face.landmark[159].y - face.landmark[52].y
        b_right = face.landmark[386].y - face.landmark[282].y
        avg_brows = (b_left + b_right) / 2
        diff_brows = abs(b_left - b_right)

        if mouth > 0.04:
            frame = apply_overlay(frame, pics["wow"], face.landmark[1], h, w)
        elif avg_brows > 0.038:
            frame = apply_overlay(frame, pics["shock"], face.landmark[1], h, w)
        elif diff_brows > 0.02:
            frame = apply_overlay(frame, pics["think"], face.landmark[1], h, w)
        elif avg_brows < 0.022:
            frame = apply_overlay(frame, pics["angry"], face.landmark[1], h, w)

    cv2.imshow('Ultimate Meme Detector', frame)
    if cv2.waitKey(1) & 0xFF == ord('q'): break

cap.release()
cv2.destroyAllWindows()