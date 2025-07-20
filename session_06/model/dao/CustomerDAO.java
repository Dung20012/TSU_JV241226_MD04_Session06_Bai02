package com.data.session_06.model.dao;

import com.data.session_06.model.dao.Impl.ICustomerDAO;
import com.data.session_06.model.entity.Customer;
import com.data.session_06.model.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class CustomerDAO implements ICustomerDAO {
    @Override
    public Customer findByUsernameAndPassword(String username, String password) {
        Customer customer = null;
        String sql = "select * from customers where username=? and password=?";
        try {
            Connection conn = ConnectionDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                customer = new Customer();
                customer.setId(rs.getLong("id"));
                customer.setUsername(rs.getString("username"));
                customer.setPassword(rs.getString("password"));
                customer.setPhone(rs.getString("phone"));
                customer.setAddress(rs.getString("address"));
                customer.setGender(rs.getString("gender"));
                customer.setEmail(rs.getString("email"));
                customer.setRole(Customer.Role.valueOf(rs.getString("role")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return customer;
    }
}
