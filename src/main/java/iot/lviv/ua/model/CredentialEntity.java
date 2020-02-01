package iot.lviv.ua.model;

import javax.persistence.*;

@Entity
@Table(name = "credential")
public class CredentialEntity {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "password")
    private String password;
    @Column(name = "login")
    private String login;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "email")
    private String email;

    public CredentialEntity() {
    }

    public CredentialEntity(String password, String login,
                            String telephone, int userId, String email) {
        this.password = password;
        this.login = login;
        this.telephone = telephone;
        this.userId = userId;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %s",
                id, password, login, telephone, userId, email);
    }
}
