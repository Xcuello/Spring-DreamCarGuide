package com.DreamCarGuideApp.DreamCarGuideApp;

import com.DreamCarGuideApp.DreamCarGuideApp.models.Question;
import com.DreamCarGuideApp.DreamCarGuideApp.repositories.QuestionRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class DreamCarGuideAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(DreamCarGuideAppApplication.class, args);
	}
}


