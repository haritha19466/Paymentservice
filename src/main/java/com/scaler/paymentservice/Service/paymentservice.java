package com.scaler.paymentservice.Service;

import com.razorpay.RazorpayException;
import com.scaler.paymentservice.PaymentGateways.PaymentGatewayinterface;
import org.springframework.stereotype.Service;

@Service
public class paymentservice{
    private PaymentGatewayinterface paymentGatewayinterface;
    public paymentservice(PaymentGatewayinterface paymentGatewayinterface){
        this.paymentGatewayinterface=paymentGatewayinterface;
    }
    public String initiatepayment(Long orderid, Long amount) throws RazorpayException {
        return paymentGatewayinterface.generatepaymentURL(orderid,amount);
    }

}
