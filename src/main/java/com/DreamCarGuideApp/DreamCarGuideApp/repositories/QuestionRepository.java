package com.DreamCarGuideApp.DreamCarGuideApp.repositories;

import com.DreamCarGuideApp.DreamCarGuideApp.models.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<Question,Integer> {

}
