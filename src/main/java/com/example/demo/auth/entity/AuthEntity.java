package com.example.demo.auth.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "auth", schema = "test", catalog = "")
public class AuthEntity {
    private String id;
    private String apiKey;
    private Timestamp regDate;
    private String regId;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "api_key")
    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    @Basic
    @Column(name = "reg_date")
    public Timestamp getRegDate() {
        return regDate;
    }

    public void setRegDate(Timestamp regDate) {
        this.regDate = regDate;
    }

    @Basic
    @Column(name = "reg_id")
    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthEntity that = (AuthEntity) o;
        return Objects.equals(apiKey, that.apiKey) &&
                Objects.equals(regDate, that.regDate) &&
                Objects.equals(regId, that.regId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(apiKey, regDate, regId);
    }

}
