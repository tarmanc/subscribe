package com.armanc.subscribe.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@JsonIgnoreProperties(value = {"subId", "subStatus"}, allowGetters = true)
public class Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("subId")
    private long id;

    //Unique user name
    @NotBlank(message = "User Name is Mandatory")
    @Column(unique = true)
    private String userName;

    //Subscription status
    @JsonProperty("subStatus")
    private boolean subs = true;

    //Subscription date
    private LocalDate subDate = LocalDate.now();


    public Subscriber() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isSubs() {
        return subs;
    }

    public void setSubs(boolean subs) {
        this.subs = subs;
    }

    public LocalDate getSubDate() {
        return subDate;
    }

    public void setSubDate(LocalDate subDate) {
        this.subDate = subDate;
    }
}
