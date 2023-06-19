package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            //            ID, Name, charge, date
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    public static void main(String[] args) {
        boolean uniqueCustomer;
        int id;

        //Iterate through a List<String[]> that contains multiple records for each Customer,
        //converting it into List<Customer> where there is only one copy of each customer
        //(Integer.parseInt() converts a String to an integer).
        List<Customer> customers = new ArrayList<>();

        //Iterate through all data entries
        for(String[] data : customerData){
            //flag will tell us if this Customer already exists
            uniqueCustomer = true;
            //parse data
            id = Integer.parseInt(data[0]);
            String name = data[1];
            int chargeAmt = Integer.parseInt(data[2]);
            String chargeDate = data[3];

            //charge will always be registered (assuming there are no duplicate charges)
            AccountRecord currCharge = new AccountRecord();
            currCharge.setCharge(chargeAmt);
            currCharge.setChargeDate(chargeDate);
            //AccountRecord currCharge = new AccountRecord(chargeAmt,chargeDate);

            //check if customer already exists
            for(Customer c: customers){
                //iff it does exist then we set flag to false and add charge to our
                //history, at this point we can advance to new entry.
                if(c.getId() == id) {
                    uniqueCustomer = false;
                    c.getCharges().add(currCharge);
                    //System.out.println(c.toString());
                    break;
                }
            }

            //if this customer is unique we can add to our customer list with a new charge
            if(uniqueCustomer) {
                Customer currCustomer = new Customer();
                currCustomer.setId(id);
                currCustomer.setName(name);
                currCustomer.getCharges().add(currCharge);
                customers.add(currCustomer);
                //System.out.println(currCustomer.toString());
            }

        }

        List<Customer> PositiveCustomers = new ArrayList<Customer>();
        List<Customer> NegativeCustomers = new ArrayList<Customer>();

        /*for(Customer customer : customers){
            if(customer.getBalance() >= 0){
                PositiveCustomers.add(customer);
            }else {
                NegativeCustomers.add(customer);
            }
        }

        System.out.println("Positive accounts:");
        for(Customer c : PositiveCustomers){
            System.out.println(c.toString());
        }

        System.out.println("Negative accounts:");
        for(Customer c : NegativeCustomers){
            System.out.println(c.toString());
        }*/

        //customer use story printing positive and negative accounts
        System.out.println("Positive accounts:");
        customers.stream()
                .filter(customer -> customer.getBalance() >=0)
                .forEach(customer -> System.out.println(customer.toString()));

        System.out.println("Negative accounts:");
        customers.stream()
                .filter(customer -> customer.getBalance() < 0)
                .forEach(customer -> System.out.println(customer.toString()));

    }
}