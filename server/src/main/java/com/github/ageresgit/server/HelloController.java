package com.github.ageresgit.server;

import com.github.ageresgit.common.Request;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/hello/{clientName}")
    public String getHelloClient(@PathVariable("clientName") String clientName) {
        return "Hello, dear " + clientName + "!";
    }

    @GetMapping("/hello")
    public String getHello() {
        return "Yo, man!";
    }

    @PostMapping("/balancerequest")
    public String balanceRequestProcess(@RequestBody Request request) {
        return "You send me card N" + request.getCardPan() + " and pin = " + request.getCardPan() + ". Thank YOU!";
    }
}
