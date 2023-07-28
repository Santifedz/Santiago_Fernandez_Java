package com.company.customerdataservice.repository;

import static org.junit.jupiter.api.Assertions.*;
import com.company.customerdataservice.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class CustomerRepositoryTest {

    Customer testCustomer = new Customer();

    @Autowired
    CustomerRepository customerRepository;

    @BeforeEach
    public void setUp() throws Exception{
        customerRepository.deleteAll();

        testCustomer.setFirstName("Bruce");
        testCustomer.setLastName("Wayne");
        testCustomer.setEmail("BWayne@aol.com");
        testCustomer.setCompany("Wayne Enterprises");
        testCustomer.setPhone("+1-312-465-7809");
        testCustomer.setAddress1("123 Forest Dr");
        testCustomer.setAddress2("apt 42");
        testCustomer.setCity("Gotham");
        testCustomer.setState("Illinois");
        testCustomer.setPostalCode("60647");
        testCustomer.setCountry("United States");

    }

    @Test
    public void shouldCreateCustomer(){
        customerRepository.save(testCustomer);

        Optional<Customer> fetchedCustomer = customerRepository.findById(testCustomer.getId());

        assertEquals(fetchedCustomer.get(), testCustomer);
    }

    @Test
    public void shouldUpdateCustomer(){
        customerRepository.save(testCustomer);

        Customer newTestCustomer = new Customer();
        newTestCustomer.setId(testCustomer.getId());
        newTestCustomer.setFirstName("Santiago");
        newTestCustomer.setLastName("Fernandez");
        newTestCustomer.setEmail("santiferuseche@gmail.com");
        newTestCustomer.setCompany("Netflix ;)");
        newTestCustomer.setPhone("+1-111-111-1111");
        newTestCustomer.setAddress1("123 Oak ave");
        newTestCustomer.setAddress2("unit 1");
        newTestCustomer.setCity("Miami");
        newTestCustomer.setState("Florida");
        newTestCustomer.setPostalCode("33433");
        newTestCustomer.setCountry("United States");

        customerRepository.save(newTestCustomer);

        Optional<Customer> fetchedCustomer = customerRepository.findById(testCustomer.getId());
        assertEquals(fetchedCustomer.get(), newTestCustomer);
    }

    @Test
    public void shouldDeleteCustomer(){
        customerRepository.save(testCustomer);

        customerRepository.deleteById(testCustomer.getId());

        Optional<Customer> fetchedCustomer = customerRepository.findById(testCustomer.getId());
        assertFalse(fetchedCustomer.isPresent());
    }

    @Test
    public void shouldGetCustomerById(){

        customerRepository.save(testCustomer);

        Optional<Customer> fetchedCustomer = customerRepository.findById(testCustomer.getId());
        assertEquals(fetchedCustomer.get(), testCustomer);
    }

    @Test
    public void shouldGetCustomerByState(){
        customerRepository.save(testCustomer);

        List<Customer> fetchedCustomers = customerRepository.findByState(testCustomer.getState());

        assertTrue(fetchedCustomers.contains(testCustomer));
    }


}
