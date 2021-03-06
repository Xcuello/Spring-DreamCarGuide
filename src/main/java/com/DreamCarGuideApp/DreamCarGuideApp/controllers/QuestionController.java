package com.DreamCarGuideApp.DreamCarGuideApp.controllers;

import com.DreamCarGuideApp.DreamCarGuideApp.models.Question;
import com.DreamCarGuideApp.DreamCarGuideApp.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping("/question")
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {

        return new ResponseEntity<>(questionService.save(question), HttpStatus.CREATED);
    }

    @GetMapping("/question/{id}")
    public ResponseEntity<Question> getQuestion(@PathVariable Integer id) {

        Optional<Question> question = questionService.findById(id);

        if (!question.isPresent()) {

            return new ResponseEntity<>(question.get(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(question.get(), HttpStatus.OK);
    }

    @GetMapping("/question")
    public ResponseEntity<Iterable<Question>> getQuestionList() {

        return new ResponseEntity<>(questionService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/question/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Integer id, @RequestBody Question updatedQuestion) {

        Optional<Question> question = questionService.findById(id);

        if (!question.isPresent()) {

            return new ResponseEntity<>(updatedQuestion, HttpStatus.OK);
        }

        updatedQuestion.setId(id);

        questionService.save(updatedQuestion);

        return new ResponseEntity<>(updatedQuestion, HttpStatus.CREATED);
    }

    @DeleteMapping("/question/{id}")
    public ResponseEntity<?> deleteQuestion(@RequestBody Question question) {

        questionService.delete(question);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

}

