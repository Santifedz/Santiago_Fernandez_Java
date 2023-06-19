package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BalanceTest {

    Customer c1;
    AccountRecord a1;
    AccountRecord a2;
    AccountRecord a3;
    AccountRecord a4;

    @BeforeEach
    public void setUp(){
        c1 = new Customer();
        a1 = new AccountRecord();
        a2 = new AccountRecord();
        a3 = new AccountRecord();
        a4 = new AccountRecord();
    }

    @Test
    public void negativeBalanceTest(){
        c1.setId(1);
        c1.setName("one");

        a1.setCharge(1000);
        a2.setCharge(-10000);
        a3.setCharge(1);
        a4.setCharge(-5);

        c1.getCharges().add(a1);
        c1.getCharges().add(a2);
        c1.getCharges().add(a3);
        c1.getCharges().add(a4);

        assertEquals(-9004,c1.getBalance());
        assertEquals("1 one -9004", c1.toString());

    }

    @Test
    public void zeroBalanceTest(){

        c1.setId(2);
        c1.setName("two");

        a2.setCharge(-1);
        a3.setCharge(1);

        c1.getCharges().add(a2);
        c1.getCharges().add(a3);

        assertEquals(0,c1.getBalance());
        assertEquals("2 two 0", c1.toString());
    }

    @Test
    public void positiveBalanceTest(){
        c1.setId(3);
        c1.setName("three");

        a1.setCharge(1000);
        a2.setCharge(-10000);
        a3.setCharge(40050000);
        a4.setCharge(-5);

        c1.getCharges().add(a1);
        c1.getCharges().add(a2);
        c1.getCharges().add(a3);
        c1.getCharges().add(a4);

        assertEquals(40040995,c1.getBalance());
        assertEquals("3 three 40040995", c1.toString());
    }

}