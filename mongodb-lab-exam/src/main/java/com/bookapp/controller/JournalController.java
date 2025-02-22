package com.bookapp.controller;

import com.bookapp.entities.JournalEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class JournalController {
    private JournalService journalService;

    @Autowired
    public JournalController(JournalService journalService) {
        this.journalService = journalService;
    }

    @GetMapping("/journal")
    public ResponseEntity<List<JournalEntry>> getAllJournalEntries() {
        return ResponseEntity.status(HttpStatus.OK).body(journalService.getAll());
    }

    @GetMapping("/journal/{id}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(journalService.getById(id));
    }

    @GetMapping("/journal/user/{id}")
    public ResponseEntity<List<JournalEntry>> getJournalEntryByUserId(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(journalService.getByUserId(id));
    }
}
