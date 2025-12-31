package com.example.bank.service;

import com.example.bank.dao.BankDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    private static final Logger log = LoggerFactory.getLogger(BankService.class);

    private final BankDao bankDao;

    public BankService(BankDao bankDao) {
        this.bankDao = bankDao;
    }

    public String createAccount(String name, String mobile,
                                String gender, double balance) {

        log.info("Creating account ");

        String accNo = "ACC" + System.currentTimeMillis();
        bankDao.createAccount(accNo, name, mobile, gender, balance);

        log.info("Account created successfully. ");

        return "Account Created Successfully. Account No: " + accNo;
    }

    public double viewBalance(String accNo) {

        log.info("Fetching balance ");

        double balance = bankDao.getBalance(accNo);

        log.info("Balance fetched ");

        return balance;
    }
}
