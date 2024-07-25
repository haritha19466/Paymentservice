package com.scaler.paymentservice.PaymentGateways;

import com.razorpay.RazorpayException;
import com.scaler.paymentservice.DTOs.paymentrequestdto;

public interface PaymentGatewayinterface {
    public String generatepaymentURL(Long orderId, Long amount) throws RazorpayException;
}
