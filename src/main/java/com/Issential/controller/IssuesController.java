package com.Issential.controller;

import com.Issential.data.entity.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Issential.service.IssueService;

@RestController
@RequestMapping("/issues")
public class IssuesController {
    @Autowired
    private IssueService issueService;

    @PostMapping("/create")
    public ResponseEntity<?> createIssue(@RequestBody Issue issue) {
        try {
            Issue createdIssue = issueService.createIssue(issue);
            return ResponseEntity.ok(createdIssue);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
