package com.WeCanDebugIt.rest.webservices.restfulwebservices;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class Bug {

    @Id
    @GeneratedValue
    private Long id;

    private String subject;
    private String status;
    private Date targetDate;
    private String description;
    private String username;

    public Bug(String subject, long id, String status, Date targetDate, String description, String username) {
        this.subject = subject;
        this.id = id;
        this.status = status;
        this.targetDate = targetDate;
        this.description = description;
        this.username = username;
    }

    public Bug() {

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return targetDate;
    }

    public void setDate(Date date) {
        this.targetDate = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bug bug = (Bug) o;
        return id == bug.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
