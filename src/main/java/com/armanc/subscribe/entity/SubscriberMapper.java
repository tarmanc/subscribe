package com.armanc.subscribe.entity;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubscriberMapper {

    Subscriber subscriberDTOToSource(SubscriberDTO subscriber);
    SubscriberDTO sourceToDTO(Subscriber subscriberDTO);

    List<SubscriberDTO> sourceListToSubscriberDTO(List<Subscriber> subscriber);

}
