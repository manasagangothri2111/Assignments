package com.example.demo.components;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class EmailClient {

	private SpellChecker spellChecker;

	public EmailClient(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	public void sendEmail(String message) {

		spellChecker.spellCheck(message);

	}
}
