package com.Issential.data.repository;

import com.Issential.data.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {

    List<Issue> findByTitle(String title);

    List<Issue> findByAsignee_Id(Long id);

    List<Issue> findByDueDateBefore(LocalDate date);

    List<Issue> findByDueDateIsNull();
}
