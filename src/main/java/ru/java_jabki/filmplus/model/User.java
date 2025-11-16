package ru.java_jabki.filmplus.model;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;

public class User {
    private static final AtomicLong count = new AtomicLong();
    private final Long id;
    private String login;
    private String name;
    private String email;
    private LocalDate birthday;


    public User(final String name, final String email, final String login, final LocalDate birthday){
        this.id = count.incrementAndGet();
        this.name = name;
        this.email = email;
        this.login = login;
        this.birthday = birthday;
    }

    public Long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }
    public String getLogin(){
        return this.login;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setBirthday(LocalDate birthday){
        this.birthday = birthday;
    }
}
