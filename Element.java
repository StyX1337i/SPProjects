public interface Element {
    // Common operation
    void print(); 
    
    // Composite-related operations (default to throwing exception for Leaves later)
    void add(Element element);
    void remove(Element element);
    Element get(int index);
}