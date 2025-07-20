package com.data.session_06.model.service.Impl;

import com.data.session_06.model.entity.Customer;

public interface ICustomerService {
    Customer login(String username, String password);
}
