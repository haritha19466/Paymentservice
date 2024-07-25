package com.scaler.paymentservice.DTOs;

import lombok.Data;

@Data
public class paymentrequestdto {
    private Long orderId;
    private Long amount;
}
