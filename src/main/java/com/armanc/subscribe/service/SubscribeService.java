package com.armanc.subscribe.service;

import com.armanc.subscribe.entity.Subscriber;
import com.armanc.subscribe.dao.ISubscriberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;


@Service
@Transactional
public class SubscribeService {

    @Autowired
    private ISubscriberDAO subscriberDAO;


    public Subscriber getSubByID(long id) {
        return subscriberDAO.findById(id).get();
    }

    public Subscriber getSubByName(String userName) {

        return subscriberDAO.findByUserName(userName);
    }

    public String subUnsub(String name) {

        Subscriber subscriber = subscriberDAO.findByUserName(name);
        subscriber.setSubs(!(subscriber.isSubs()));
        return ("User Name: " + subscriber.getUserName() +
                "\nSub Status Updated: " + subscriber.isSubs());
    }

    public String subUnsub(long id) {

        Subscriber subscriber = subscriberDAO.findById(id).get();

        subscriber.setSubs(!(subscriber.isSubs()));
        return ("User Name: " + subscriber.getUserName() +
                "\nSub Status Updated: " + subscriber.isSubs());

    }

    //    public void newSubscriber(Subscriber subscriber) {
//
//        String userName = subscriber.getUserName();
//
//        if (!(subscriberDAO.existsByUserName(userName))) {
//
//            if (!(subscriber.isSubs())) {
//                subscriber.setSubs(true);
//            }
//
//            if (subscriber.getSubDate() == null) {
//                subscriber.setSubDate(LocalDate.now());
//            }
//
//            subscriberDAO.save(subscriber);
//        }
//    }
}
