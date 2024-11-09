package com.Issential.service;

import com.Issential.data.entity.Issue;
import com.Issential.data.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IssueService {
    @Autowired
    private IssueRepository issueRepository;

    public Issue createIssue(Issue issue) {
        return issueRepository.save(issue);
    }

    public Issue getIssue(Long id) {
        return issueRepository.findById(id).orElseThrow(() -> new RuntimeException("Issue not found"));
    }
}
