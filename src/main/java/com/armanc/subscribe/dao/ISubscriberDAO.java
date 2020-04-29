package com.armanc.subscribe.dao;

import com.armanc.subscribe.entity.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


//DAO Interface for JPA

@Repository
public interface ISubscriberDAO extends JpaRepository<Subscriber, Long> {


    //Spring Derived Query
    //Checks if user already exists
    //boolean existsByUserName(String name);

    //Gets ID by User Name
    Subscriber findByUserName(String name);


    List<Subscriber> findAllBySubDateIsBefore(@Param("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate);

    List<Subscriber> findAllBySubDateIsAfter(@Param("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate);


}
