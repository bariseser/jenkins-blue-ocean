package org.bariseser.jenkins.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(SimpleController.class)
@AutoConfigureMockMvc
class SimpleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getMessageTest() throws Exception {
        String testMessage = "testMessage";
        mockMvc.perform(MockMvcRequestBuilders.get("/" + testMessage))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(testMessage));
    }

    @Test
    void getHelloMessageTest() throws Exception {
        String testUsername = "testUser";
        String expectedMessage = String.format("hello, %s", testUsername);
        mockMvc.perform(MockMvcRequestBuilders.get("/hello/" + testUsername))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedMessage));
    }

}