package com.example.projectandroidnft;

public class ContactUsModel {

    String firstname, lastname, email, messages;

    public ContactUsModel(String firstname, String lastname, String email, String messages) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.messages = messages;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }
}