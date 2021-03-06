/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaali.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "related_words")
public class RelatedWord implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
   
    @Column(name = "related_word")
    private String relatedWord;

    @JoinColumn(name = "root_word_id")
    @ManyToOne
    private RootWord rootWord;

    public RelatedWord() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRelatedWord() {
        return relatedWord;
    }

    public void setRelatedWord(String relatedWord) {
        this.relatedWord = relatedWord;
    }

    public RootWord getRootWord() {
        return rootWord;
    }

    public void setRootWord(RootWord rootWord) {
        this.rootWord = rootWord;
    }

   

}
