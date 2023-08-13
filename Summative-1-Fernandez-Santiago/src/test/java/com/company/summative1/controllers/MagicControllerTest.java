package com.company.summative1.controllers;

import com.company.summative1.models.Answer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MagicController.class)
public class MagicControllerTest {

    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    // A list of Answer Objects for testing purposes
    private List<Answer> AnswerList;

    // testing POST question happy path
    @Test
    public void shouldReturnCreatedOnGetRandomAnswer() throws Exception{

        // ARRANGE
        Answer inputQuestion = new Answer();
        inputQuestion.setQuestion("Does this work??");

        //Answer expectedResponse = new Answer();

        String inputJason = mapper.writeValueAsString(inputQuestion);

        //ACT
        ResultActions perform = mockMvc.perform(
                post("/magic")
                        .content(inputJason)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isCreated());

    }






}
