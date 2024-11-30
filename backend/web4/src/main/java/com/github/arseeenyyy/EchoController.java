package com.github.arseeenyyy;

import org.springframework.web.bind.annotation.*;

@RestController
public class EchoController {

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/echo")
    public String echo(@RequestBody String message) {
        return "Hello huesos ti ebanii: " + message;
    }
}
