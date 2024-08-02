package com.keyin.finalsprint.routes;

import com.fasterxml.jackson.databind.JsonNode;
import com.keyin.finalsprint.services.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class TreeController {

    @Autowired
    private TreeService service;

    @GetMapping("enter-numbers")
    public String enterNumbers() {
        return "enter-numbers";
    }

    @PostMapping("process-numbers")
    public ResponseEntity<JsonNode> processNumbers(@RequestBody ProcessBody body) {
        if (body.numbers == null || body.numbers.length == 0) return ResponseEntity.badRequest().build();
        return ResponseEntity.ofNullable(this.service.create(body.numbers).asJson());
    }

    @GetMapping("previous-trees")
    public String previousTrees(Model model) {
        model.addAttribute("trees", this.service.get());
        return "previous-trees";
    }

    public record ProcessBody(int[] numbers) {}
}
