package com.DreamCarGuideApp.DreamCarGuideApp.services;

import com.DreamCarGuideApp.DreamCarGuideApp.models.Question;
import com.DreamCarGuideApp.DreamCarGuideApp.models.User;
import com.DreamCarGuideApp.DreamCarGuideApp.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;


    @PostConstruct
    public void initIt() throws Exception {

        questionRepository.save(new Question(0, "Is storage important you?"));
        questionRepository.save(new Question(1, "Is high gas mileage important to you?"));
        questionRepository.save(new Question(2, "Is speed and acceleration important to you"));
        questionRepository.save(new Question(3, "Do you need All-Wheel Drive?"));
    }

    public Question save(Question question) {

        return questionRepository.save(question);
    }

    public Question update(Question question) {

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
