/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dha.pojo;

/**
 *
 * @author hairua's lap
 */
public class Word {
    private int id;
    private String vietnamese;
    private String english;

    public Word(int id, String vietnamese, String english) {
        this.id = id;
        this.vietnamese = vietnamese;
        this.english = english;
    }

    public Word(String vietnamese, String english) {
        this.vietnamese = vietnamese;
        this.english = english;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the vietnamese
     */
    public String getVietnamese() {
        return vietnamese;
    }

    /**
     * @param vietnamese the vietnamese to set
     */
    public void setVietnamese(String vietnamese) {
        this.vietnamese = vietnamese;
    }

    /**
     * @return the english
     */
    public String getEnglish() {
        return english;
    }

    /**
     * @param english the english to set
     */
    public void setEnglish(String english) {
        this.english = english;
    }
    

    
}
