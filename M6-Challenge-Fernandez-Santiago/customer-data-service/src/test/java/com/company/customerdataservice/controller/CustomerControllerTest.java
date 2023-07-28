package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper mapper = new ObjectMapper();

    @MockBean
    private CustomerRepository customerRepository;
    private Customer testCustomer = new Customer();


    @BeforeEach
    public void setUp() throws Exception{
        customerRepository.deleteAll();
        testCustomer.setId(1);
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
    public void shouldPOSTCustomer() throws Exception{

        mockMvc.perform(post("/customers")
                .content(mapper.writeValueAsString(testCustomer))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldPUTUpdatedCustomer() throws Exception{
        mockMvc.perform(put("/customers")
                .content(mapper.writeValueAsString(testCustomer))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldDELETECustomer() throws Exception{
        mockMvc.perform(delete("/customers/{id}", testCustomer.getId()))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    void shouldGETByID() throws Exception {
        mockMvc.perform(get("/customers/{id}",testCustomer.getId()))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void shouldGETByState() throws Exception {
        mockMvc.perform(get("/customers/state/{state}",testCustomer.getState()))
                .andDo(print())
                .andExpect(status().isOk());
    }


}
