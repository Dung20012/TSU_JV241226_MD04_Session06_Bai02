package com.data.session_06.model.service;

import com.data.session_06.model.dao.Impl.ICustomerDAO;
import com.data.session_06.model.entity.Customer;
import com.data.session_06.model.service.Impl.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerDAO customerDAO;

    @Override
    public Customer login(String username, String password) {
        return  customerDAO.findByUsernameAndPassword(username, password);
    }
}
