package com.cledsonleite.orderservice.service;

import com.cledsonleite.orderservice.service.dto.track.TrackOrderQuery;
import com.cledsonleite.orderservice.service.dto.track.TrackOrderResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderTrackCommandHandler {
    public TrackOrderResponse trackOrder(TrackOrderQuery query){
        return null;
    }
}
