package com.cledsonleite.orderservice.service.listener;

import com.cledsonleite.orderservice.service.dto.message.RestaurantApprovalResponse;

public interface IRestaurantApprovalResponseMessageListener {
    void orderApproved(RestaurantApprovalResponse response);
    void orderRejected(RestaurantApprovalResponse response);
}
