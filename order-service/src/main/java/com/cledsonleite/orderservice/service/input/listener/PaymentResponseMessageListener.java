package com.cledsonleite.orderservice.service.input.listener;

import com.cledsonleite.orderservice.service.dto.message.PaymentResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class PaymentResponseMessageListener
        implements IPaymentResponseMessageListener{
    @Override
    public void paymentCompleted(PaymentResponse response) {

    }

    @Override
    public void paymentCancelled(PaymentResponse response) {

    }
}
