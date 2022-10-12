package org.users.list.dtos;

public class UserDTO {
    private Integer id;
    private String login;
    private String password;
    private String email;
    private Integer age;
    private String registration;

    public UserDTO() {

    }

    public UserDTO(Integer id, String login, String password, String email, Integer age, String registration) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.age = age;
        this.registration = registration;
    }

    public UserDTO(String login, String password, String email, Integer age, String registration) {
        this.login = login;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
