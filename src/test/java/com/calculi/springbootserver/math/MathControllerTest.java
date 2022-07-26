package com.calculi.springbootserver.math;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MathControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello CloudBees!")));
	}

	@Test
	public void getAdd() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/add/3/2").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("5.0")));
	}

	@Test
	public void getSub() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/sub/3/2").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("1.0")));
	}

	@Test
	public void getMult() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/mult/3/2").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("6.0")));
	}

	@Test
	public void getDiv() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/div/3/2").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("1.5")));
	}

	@Test
	public void getDivByZero() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/div/3/0").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("\"Infinity\"")));
	}

	@Test
	public void getSqrt() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/sqrt/4").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("2.0")));
    }

	@Test
	public void getCbrt() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/cbrt/27").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("3.0")));
	}

}
