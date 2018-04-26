package com.example.demo.user.entity;

import com.example.demo.auth.entity.AuthEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "test", catalog = "")
public class UsersEntity {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Timestamp regDate;
    private AuthEntity authEntity;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "reg_date")
    public Timestamp getRegDate() {
        return regDate;
    }

    public void setRegDate(Timestamp regDate) {
        this.regDate = regDate;
    }

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    public AuthEntity getAuthEntity() {
        return authEntity;
    }

    public void setAuthEntity(AuthEntity authEntity) {
        this.authEntity = authEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(email, that.email) &&
                Objects.equals(regDate, that.regDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName, email, regDate);
    }
}
