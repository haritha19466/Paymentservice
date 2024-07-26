package com.scaler.paymentservice.Controller;

import com.razorpay.RazorpayException;
import com.scaler.paymentservice.DTOs.paymentrequestdto;
import com.scaler.paymentservice.Service.paymentservice;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;

@RestController
@RequestMapping("/payments")
public class paymentcontroller {
    private paymentservice ps;
    public paymentcontroller(paymentservice ps){
        this.ps=ps;
    }
    @PostMapping("/")
    public String Initiatepayment(@RequestBody paymentrequestdto paymentrequest) throws RazorpayException {
        //System.out.println("enetred controller block");
        try {
            return ps.initiatepayment(paymentrequest.getOrderId(),paymentrequest.getAmount());
        } catch (RazorpayException e) {
            throw new RuntimeException(e);
        }
    }
}
