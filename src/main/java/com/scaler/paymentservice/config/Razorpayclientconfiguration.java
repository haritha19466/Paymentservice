package com.scaler.paymentservice.config;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Razorpayclientconfiguration {

   @Value("${razorpay.key.id}")  // The both key and secret both are defined in application.properties
   //The values are injected as environment variables
    private String razorPayId;

   @Value("${razorpay.key.secret}")
    private String razorPaySecret;
    @Bean
    public RazorpayClient generaterazorpayclient() throws RazorpayException {
        return new RazorpayClient(razorPayId,razorPaySecret); // in order to use a single razorpayclient
        // for the purpose we are registering it as a bean
    }

}
