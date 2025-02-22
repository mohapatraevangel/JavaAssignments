package com.bookapp;

import com.bookapp.entities.JournalEntry;
import com.bookapp.entities.User;
import com.bookapp.exceptions.ResourceNotFoundException;
import com.bookapp.repo.JournalEntryRepo;
import com.bookapp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class BookappApplication implements CommandLineRunner {

	
	public static void main(String[] args)
	{
		SpringApplication.run(BookappApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
//		JournalEntry journalEntry4 = new JournalEntry("Koerber", "I am a koerber employeee",
//				LocalDateTime.now());
//		JournalEntry journalEntry5 = new JournalEntry("UST", "I am a UST Employee", LocalDateTime.now());
//		JournalEntry journalEntry6 = new JournalEntry("Accenture", "Accenture Employee", LocalDateTime.now());
//
//		User user = new User("Merin", "Merin@gmail.com");
//		User user1 = new User("Tony", "Tony@gmail.com");
//
//		user.getJournalEntries().add(journalEntry4);
//		user.getJournalEntries().add(journalEntry5);
//		user.getJournalEntries().add(journalEntry6);
//
//		user1.getJournalEntries().add(journalEntry4);
//		user1.getJournalEntries().add(journalEntry5);
//		user1.getJournalEntries().add(journalEntry6);
//		mongoTemplate.save(journalEntry4);
//		mongoTemplate.save(journalEntry5);
//		mongoTemplate.save(journalEntry6);
//
//		// Save User objects
//		mongoTemplate.save(user);
//		mongoTemplate.save(user1);

	}
}
