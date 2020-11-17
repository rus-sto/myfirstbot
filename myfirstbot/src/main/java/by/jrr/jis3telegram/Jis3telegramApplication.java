package by.jrr.jis3telegram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class Jis3telegramApplication {

    public static void main(String[] args) {
//        System.out.println("hello");
        ApiContextInitializer.init();
        SpringApplication.run(Jis3telegramApplication.class, args);
    }

}

