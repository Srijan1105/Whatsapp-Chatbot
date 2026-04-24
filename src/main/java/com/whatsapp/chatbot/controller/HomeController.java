package com.whatsapp.chatbot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController {

    /**
     * Redirect root URL to the chat frontend
     */
    @GetMapping("/")
    public RedirectView home() {
        return new RedirectView("/index.html");
    }

    /**
     * Health check for Railway/deployment platforms
     */
    @GetMapping("/health")
    @ResponseBody
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("OK");
    }
}
