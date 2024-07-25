package com.scaler.paymentservice.PaymentGateways;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Utils;
import com.scaler.paymentservice.DTOs.paymentrequestdto;
import org.json.JSONObject;
import org.springframework.context.annotation.Configuration;

@Configuration // we have to annotating it as component sicne it is helper class not service or controller.
public class RazorpaypaymentGW implements PaymentGatewayinterface{
    private RazorpayClient razorpayClient;
    public RazorpaypaymentGW(RazorpayClient razorpayClient){
        this.razorpayClient=razorpayClient;
    }
    @Override
    public String generatepaymentURL(Long orderID, Long amount) throws RazorpayException {
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount", amount); // 1000 - > 10.00
        paymentLinkRequest.put("currency","INR");
//        paymentLinkRequest.put("accept_partial",true);
//        paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by", 1721933778);// here we have to entire future time be cautious of that.
        paymentLinkRequest.put("reference_id", orderID.toString());
        paymentLinkRequest.put("description","Payment for orderId " + orderID.toString());


        // CUSTOMER DETAILS
        JSONObject customer = new JSONObject();
        customer.put("name","+919123456891");
        customer.put("contact","Haritha Pottimutya");
        customer.put("email","haritha@scaler.com");
        paymentLinkRequest.put("customer",customer);


        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);

        // notify details..
        paymentLinkRequest.put("notify",notify);
//        paymentLinkRequest.put("reminder_enable",true);
        JSONObject notes = new JSONObject();
//        notes.put("policy_name","Jeevan Bima");
        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://www.scaler.com/academy/instructor-dashboard/");//after payment
        //to where it should be redirected that is mentioned here.
        paymentLinkRequest.put("callback_method","get");

        PaymentLink link = razorpayClient.paymentLink.create(paymentLinkRequest);

        return link.toString();
    }
}
