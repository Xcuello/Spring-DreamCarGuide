package com.DreamCarGuideApp.DreamCarGuideApp.models;

import javax.persistence.*;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String query;

    public Question() {

    }

    public Question(Integer id, String query) {
        this.id = id;
        this.query = query;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public String getQuery() {

        return query;
    }

    public void setQuery(String query) {

        this.query = query;
    }

}
