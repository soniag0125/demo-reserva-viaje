package com.sguama.client.controllers;

import com.sguama.client.models.Message;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class AppControllers {

    @GetMapping("/list")
    public List<Message> list(){
        return Collections.singletonList(new Message("Test List"));
    }

    @PostMapping("/create")
    public Message create(@RequestBody Message message){
        System.out.println("Mensaje Guardado: " + message);
        return message;
    }

    @GetMapping("/authorized")
    public Map<String, String> authorized(@RequestParam String code){
        return Collections.singletonMap("code", code);
    }
}
