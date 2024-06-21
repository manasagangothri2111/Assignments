package com.cts.components;

import org.springframework.stereotype.Component;

@Component(value = "adv")
public class AdvancedSpellChecker implements SpellChecker {

	@Override
	public void spellCheck(String email) {
		if (!email.isBlank()) {
			System.out.println("Email is being checked for spelling by " + getClass().getSimpleName());
			try {
				Thread.sleep(2000);
				System.out.println("Spelling Check done. All is good!!");
				System.out.println("");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			throw new IllegalArgumentException("Email Message Can't Be Blank!!");
		}
	}
}
