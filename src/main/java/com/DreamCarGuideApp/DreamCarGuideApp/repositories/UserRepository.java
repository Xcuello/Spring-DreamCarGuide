package com.DreamCarGuideApp.DreamCarGuideApp.repositories;

import com.DreamCarGuideApp.DreamCarGuideApp.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {


}
