package com.cledsonleite.orderservice.service.input.listener;

import com.cledsonleite.orderservice.service.dto.message.PaymentResponse;

public interface IPaymentResponseMessageListener {
    void paymentCompleted(PaymentResponse response);
    void paymentCancelled(PaymentResponse response);
}
