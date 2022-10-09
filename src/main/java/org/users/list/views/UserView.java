package org.users.list.views;

public class UserView {
    private Integer id;
    private String login;
    private String name;
    private String email;
    private Integer age;
    private String registration;

    public UserView(Integer id, String login, String name, String email, Integer age, String registration) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.email = email;
        this.age = age;
        this.registration = registration;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }
}
