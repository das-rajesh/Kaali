/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rajesh.webapp.entity;

/**
 *
 * @author Dell
 */
public class RootWord {
    
    private int id;
    private String keyWord;

    public RootWord() {
    }

    public RootWord(int id, String keyWord) {
        this.id = id;
        this.keyWord = keyWord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    @Override
    public String toString() {
        return "RootWord{" + "id=" + id + ", keyWord=" + keyWord + '}';
    }
    
    
}
