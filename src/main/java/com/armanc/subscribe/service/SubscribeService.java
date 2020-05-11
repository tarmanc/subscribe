package com.armanc.subscribe.service;

import com.armanc.subscribe.dao.ISubscriberDAO;
import com.armanc.subscribe.entity.Subscriber;
import com.armanc.subscribe.entity.SubscriberDTO;
import com.armanc.subscribe.entity.SubscriberMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
@AllArgsConstructor
public class SubscribeService {

    private final ISubscriberDAO subscriberDAO;
    private final SubscriberMapper mapper;


    public List<SubscriberDTO> getAllUsers() {
        List<Subscriber> subscriberList = subscriberDAO.findAll();
        return mapper.sourceListToSubscriberDTO(subscriberList);
    }

    public SubscriberDTO getSubByID(long id) {
        Subscriber subscriber = subscriberDAO.findById(id).get();
        return mapper.sourceToDTO(subscriber);
    }

    public Subscriber newSubscriber(SubscriberDTO subscriberDTO) {

        Subscriber subscriber = mapper.subscriberDTOToSource(subscriberDTO);

        if (!(subscriber.isSubs())) {
            subscriber.setSubs(true);
        }

        subscriberDAO.save(subscriber);
        return subscriber;
    }

    public SubscriberDTO subUnsub(long id) {

        Subscriber subscriber = subscriberDAO.findById(id).get();
        subscriber.setSubs(!(subscriber.isSubs()));

        return mapper.sourceToDTO(subscriber);
    }

    public void updateSub(SubscriberDTO subscriberDTO, long id) {
        Subscriber subscriber = mapper.subscriberDTOToSource(subscriberDTO);
        subscriber.setId(id);
        subscriberDAO.save(subscriber);
    }

    public void deleteSub(long id) {
        subscriberDAO.deleteById(id);
    }

    public List<SubscriberDTO> getByDate(char operation, LocalDate localDate) {
 
        List<Subscriber> subscriberList = new ArrayList<>();

        switch (operation) {
            case '=':
                subscriberList = subscriberDAO.findAllBySubDateEquals(localDate);
                break;
            case '>':
                subscriberList = subscriberDAO.findAllBySubDateIsAfter(localDate);
                break;
            case '<':
                subscriberList = subscriberDAO.findAllBySubDateIsBefore(localDate);
                break;
        }

        return mapper.sourceListToSubscriberDTO(subscriberList);
    }

}
