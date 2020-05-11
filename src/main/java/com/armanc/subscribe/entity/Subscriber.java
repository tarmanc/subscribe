package com.armanc.subscribe.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //Unique user name
    @Column(unique = true)
    private String userName;

    //Subscription status
    private boolean subs = true;

    //Subscription date
    private LocalDate subDate = LocalDate.now();


}
