package com.cledsonleite.orderservice.service.input.application;

import com.cledsonleite.orderservice.core.domain.entity.Order;
import com.cledsonleite.orderservice.core.domain.exception.OrderNotFoundException;
import com.cledsonleite.orderservice.core.domain.valueObject.TrackingId;
import com.cledsonleite.orderservice.service.dto.track.TrackOrderQuery;
import com.cledsonleite.orderservice.service.dto.track.TrackOrderResponse;
import com.cledsonleite.orderservice.service.mapper.OrderDataMapper;
import com.cledsonleite.orderservice.service.output.repository.IOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Component
public class OrderTrackCommandHandler {
    @Autowired
    private OrderDataMapper mapper;

    @Autowired
    private IOrderRepository repository;

    @Transactional(readOnly = true)
    public TrackOrderResponse trackOrder(TrackOrderQuery query) {
        Optional<Order> orderResponse = repository
                .findByTrackingId(new TrackingId(query.getTrackingId()));
        if (orderResponse.isEmpty()) {
            log.warn(
                    "Não foi possivel encontrar o pedido com codigo { }",
                    query.getTrackingId()
            );
            throw new OrderNotFoundException(
                    String.format(
                            "Não foi possivel encontrar o pedido com codigo { }"
                            , query.getTrackingId()
                    )
            );
        }
        return mapper.toTrackOrderResponse(orderResponse.get());
    }
}
