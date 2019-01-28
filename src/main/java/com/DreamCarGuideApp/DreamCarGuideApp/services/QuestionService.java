package com.DreamCarGuideApp.DreamCarGuideApp.services;

import com.DreamCarGuideApp.DreamCarGuideApp.models.Question;
import com.DreamCarGuideApp.DreamCarGuideApp.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;


    public QuestionService() {

        if (questionRepository != null) {

            questionRepository.save(new Question(0, "How much do you have to spend?"));
        }
        if (questionRepository != null) {

            questionRepository.save(new Question(1, "Would you prefer 2 doors or 4 doors?"));
        }
        if (questionRepository != null) {

            questionRepository.save(new Question(2, "Is gas mileage important to you?"));
        }
        if (questionRepository != null) {

            questionRepository.save(new Question(3, "Automatic or Manual Transmission?"));
        }

    }

    public Question save(Question question) {

        return questionRepository.save(question);
    }

    public Optional<Question> findById(Integer id) {

        return questionRepository.findById(id);
    }

    public Iterable<Question> findAll() {

        return questionRepository.findAll();
    }

    public void delete(Question question) {

        questionRepository.delete(question);
    }
}
