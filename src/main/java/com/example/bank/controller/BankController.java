package com.example.bank.controller;

import com.example.bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private BankService service;

    @PostMapping("/create")
    public String create(@RequestParam String name,
                         @RequestParam String mobile,
                         @RequestParam String gender,
                         @RequestParam double balance) {

        return service.createAccount(name, mobile, gender, balance);
    }

    @GetMapping("/balance")
    public String balance(@RequestParam String accNo) {
        double bal = service.viewBalance(accNo);
        return "Current Balance: ₹" + bal;
    }
}
