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

        questionRepository.save(new Question(0, "How much do you have to spend?"));
        questionRepository.save(new Question(1, "Would you prefer 2 doors or 4 doors?"));
        questionRepository.save(new Question(2, "Is gas mileage important to you?"));
        questionRepository.save(new Question(3, "Would you prefer Automatic or Manual transmission?"));
        questionRepository.save(new Question(4, "Do you need All-Wheel Drive?"));
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
