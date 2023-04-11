package com.ness.service;

import com.ness.dto.CustomerLoginDTO;
import com.ness.exception.HndBankException;

public interface CustomerLoginService {
    public String authenticateCustomer(CustomerLoginDTO customerLogin) throws HndBankException;
}

