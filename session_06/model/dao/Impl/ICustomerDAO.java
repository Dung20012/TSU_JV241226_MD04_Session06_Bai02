package com.data.session_06.model.dao.Impl;

import com.data.session_06.model.entity.Customer;

public interface ICustomerDAO {
    Customer findByUsernameAndPassword(String username, String password);
}
