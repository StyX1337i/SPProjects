package ro.uvt.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.uvt.commands.*;
import ro.uvt.models.Book;
import ro.uvt.observer.AllBooksSubject;
import ro.uvt.persistence.CrudRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final CrudRepository<Book, Long> booksRepository;
    private final CommandExecutor commandExecutor;
    private final AllBooksSubject allBooksSubject;
    private final Map<String, RequestStatus> requestStatuses = new ConcurrentHashMap<>();

    public BooksController(CrudRepository<Book, Long> booksRepository, CommandExecutor commandExecutor, AllBooksSubject allBooksSubject) {
        this.booksRepository = booksRepository;
        this.commandExecutor = commandExecutor;
        this.allBooksSubject = allBooksSubject;
    }

    @GetMapping
    public ResponseEntity<?> getBooks() {
        CommandContext context = new CommandContext(booksRepository, null);
        GetBooksCommand command = new GetBooksCommand(context);
        Object result = commandExecutor.execute(command);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBook(@PathVariable String id) {
        CommandContext context = new CommandContext(booksRepository, id);
        GetBookCommand command = new GetBookCommand(context);
        Object result = commandExecutor.execute(command);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<?> createBook(@RequestBody Map<String, Object> bookData) {
        String requestId = UUID.randomUUID().toString();
        CommandContext context = new CommandContext(booksRepository, bookData);
        context.setAllBooksSubject(allBooksSubject);
        CreateBookCommand command = new CreateBookCommand(context);
        
        requestStatuses.put(requestId, new RequestStatus("PENDING", null));
        
        commandExecutor.executeAsync(command, requestId, requestStatuses);
        
        Map<String, Object> response = new HashMap<>();
        response.put("requestId", requestId);
        response.put("status", "ACCEPTED");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable String id, @RequestBody Map<String, Object> bookData) {
        String requestId = UUID.randomUUID().toString();
        CommandContext context = new CommandContext(booksRepository, bookData);
        context.setId(Long.parseLong(id));
        UpdateBookCommand command = new UpdateBookCommand(context);
        
        requestStatuses.put(requestId, new RequestStatus("PENDING", null));
        
        commandExecutor.executeAsync(command, requestId, requestStatuses);
        
        Map<String, Object> response = new HashMap<>();
        response.put("requestId", requestId);
        response.put("status", "ACCEPTED");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable String id) {
        CommandContext context = new CommandContext(booksRepository, id);
        DeleteBookCommand command = new DeleteBookCommand(context);
        Object result = commandExecutor.execute(command);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/status/{requestId}")
    public ResponseEntity<?> getRequestStatus(@PathVariable String requestId) {
        RequestStatus status = requestStatuses.get(requestId);
        if (status == null) {
            return ResponseEntity.notFound().build();
        }
        Map<String, Object> response = new HashMap<>();
        response.put("requestId", requestId);
        response.put("status", status.getStatus());
        response.put("result", status.getResult());
        return ResponseEntity.ok(response);
    }
}

