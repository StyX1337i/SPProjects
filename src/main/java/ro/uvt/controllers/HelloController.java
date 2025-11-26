package ro.uvt.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.uvt.difexamples.ClientComponent;

@RestController
public class HelloController {
    
    private final ClientComponent clientComponent;
    
    public HelloController(ClientComponent clientComponent) {
        this.clientComponent = clientComponent;
    }

    @GetMapping("/")
    public String helloRoot() {
        return "Hello from Spring Boot";
    }
    
    @GetMapping("/client")
    public String helloClient() {
        return "Hello from ClientComponent = " + clientComponent;
    }
}