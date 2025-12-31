package com.example.bank.service;

import com.example.bank.dao.BankDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BankServiceTest {

    @Mock
    private BankDao bankDao;

    @InjectMocks
    private BankService bankService;

    @Test
    void testCreateAccount() {

        String name = "Purushothaman D";
        String mobile = "9800043210";
        String gender = "MALE";
        double balance = 5000;

        String result = bankService.createAccount(name, mobile, gender, balance);

        assertNotNull(result);
        assertTrue(result.contains("Account Created Successfully"));

        verify(bankDao, times(1))
                .createAccount(anyString(), eq(name), eq(mobile), eq(gender), eq(balance));
    }

    @Test
    void testViewBalance() {

        String accNo = "ACC123";
        double expectedBalance = 8000;
        when(bankDao.getBalance(accNo)).thenReturn(expectedBalance);

        double actualBalance = bankService.viewBalance(accNo);

        assertEquals(expectedBalance, actualBalance);
    }
}
