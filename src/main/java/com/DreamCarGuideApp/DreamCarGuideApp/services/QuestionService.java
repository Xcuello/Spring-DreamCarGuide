package com.DreamCarGuideApp.DreamCarGuideApp.services;

import com.DreamCarGuideApp.DreamCarGuideApp.models.Question;
import com.DreamCarGuideApp.DreamCarGuideApp.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public void saveQuestion(Question question) {

        questionRepository.save(question);
    }

    public Iterable<Question> getAllQuestions() {

        return questionRepository.findAll();
    }


}
