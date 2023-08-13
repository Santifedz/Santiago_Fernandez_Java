package com.company.summative1.controllers;

import com.company.summative1.controllers.WordController;
import com.company.summative1.models.Definition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(WordController.class)
class WordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WordController wordController;

    @Test
    public void testGetWordOfTheDay() throws Exception {
        List<Definition> words = new ArrayList<>();
        words.add(new Definition(0, "choice", "an act of selecting or making a decision when faced with two or more possibilities."));

        when(wordController.getWordOfTheDay()).thenReturn(words.get(0));

        mockMvc.perform(get("/word"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(0))
                .andExpect(jsonPath("$.word").value("choice"))
                .andExpect(jsonPath("$.definition").value("an act of selecting or making a decision when faced with two or more possibilities."));


    }
}
