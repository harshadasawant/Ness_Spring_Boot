package com.ness.controller;

import com.ness.dto.CustomerLoginDTO;
import com.ness.exception.HndBankException;
import com.ness.service.CustomerLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
@Controller(value="customerLoginController")
public class CustomerLoginController {
    @Autowired
    private CustomerLoginService customerLoginService;
    public String authenticateCustomer(CustomerLoginDTO customerLogin) throws HndBankException {
        String b = customerLoginService.authenticateCustomer(customerLogin);
        return b;
    }
}
