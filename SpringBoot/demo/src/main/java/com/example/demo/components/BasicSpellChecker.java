package com.example.demo.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class BasicSpellChecker implements SpellChecker{
    private static final  Logger LOGGER = LoggerFactory.getLogger(BasicSpellChecker.class);
    @Override
    public void spellCheck(String email) {


        if (!email.isBlank()) {
            LOGGER.info("Email is being checked for spelling by " + getClass().getSimpleName());
            try {
                Thread.sleep(2000);
                LOGGER.info("Spelling Check done. All is good!!");
                LOGGER.info("Actual Email Message : " + email);
                LOGGER.info("");
            } catch (InterruptedException e) {
                LOGGER.error(e.getMessage());
                e.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("Email Message Can't Be Blank!!");
        }
    }

}
