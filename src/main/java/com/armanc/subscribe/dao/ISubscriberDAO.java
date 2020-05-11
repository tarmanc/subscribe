package com.armanc.subscribe.dao;

import com.armanc.subscribe.entity.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;


//DAO Interface for JPA

@RepositoryRestResource
public interface ISubscriberDAO extends JpaRepository<Subscriber, Long> {


    List<Subscriber> findAllBySubDateIsBefore(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate);
    List<Subscriber> findAllBySubDateIsAfter(LocalDate localDate);
    List<Subscriber> findAllBySubDateEquals(LocalDate localDate);
}
