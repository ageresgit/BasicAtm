package com.github.ageresgit.client;

import com.github.ageresgit.client.request.Request;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
    @GetMapping("/request")
    public Request getRequest() {
        return new Request(297, "id999000999", "What's your name?");
    }

}
