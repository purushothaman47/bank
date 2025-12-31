package com.example.bank.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class BankDao  {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createAccount(String accNo, String name,
                              String mobile, String gender,
                              double balance) {

        String sql = "INSERT INTO account (account_number,name,mobile,gender,balance) VALUES (?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,accNo,name,mobile,gender,balance);
    }

    public double getBalance(String accNo) {
        String sql = "SELECT balance FROM account WHERE account_number = ?";
        return jdbcTemplate.queryForObject(sql, Double.class, accNo);
    }
}
