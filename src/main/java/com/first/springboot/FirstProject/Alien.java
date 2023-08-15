package com.first.springboot.FirstProject;

// this is an example class to demonstrate to if we have multiple request params we can attach it to a model class and 
// assosiate each of the params to the attributes of this class
public class Alien {
    public int aid;
    public String alienName;
    public String lang;

    // it's compulsory to create setter for each field inorder for this model class to automatically link with the request params
    public void setAid(int aid) {
        this.aid = aid;
    }

    public void setAlienName(String alienName) {
        this.alienName = alienName;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
