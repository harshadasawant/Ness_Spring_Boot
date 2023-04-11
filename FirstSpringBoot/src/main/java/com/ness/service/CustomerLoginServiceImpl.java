package com.ness.service;

import com.ness.dto.CustomerLoginDTO;
import com.ness.exception.HndBankException;
import com.ness.repository.CustomerLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service(value="customerLoginService")
public class CustomerLoginServiceImpl implements CustomerLoginService {
    @Autowired
    private CustomerLoginRepository customerLoginRepository;
    public String authenticateCustomer(CustomerLoginDTO customerLogin) throws HndBankException {
        System.out.println("Inside service impl class");
        String toRet = null;
        CustomerLoginDTO customerLoginFromRepository = customerLoginRepository
                .getCustomerLoginByLoginName(customerLogin.getLoginName());
        if (customerLogin.getPassword().equals(customerLoginFromRepository.getPassword())){
            toRet = "SUCCESS";
        }else{
            throw new HndBankException("Service.WRONG_CREDENTIALS");
        }
        return toRet;
    }
}