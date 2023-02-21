package com.demo.flight.management;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class FlightManagementApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testAddEconomyFlightValid() throws Exception {
		// MvcResult mockMvcResult =;
		// .equals(true);
		// .andReturn();
		// assertEquals(true, mockMvcResult);
		mockMvc.perform(post("/flights/economy").contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"shelby\",\"vip\":\"false\"}")).andExpect(status().isOk())
				.andExpect(content().string("true"));
	}

	@Test
	void testAddEconomyFlight() throws Exception {
		mockMvc.perform(post("/flights/economy").contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"shelby,\",\"vip\":\"false\"}")).andExpect(status().isOk())
				.andExpect(content().string("true"));
	}

	@Test
	void testAddVipBusinessFlight() throws Exception {
		mockMvc.perform(post("/flights/business").contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"shelby,\",\"vip\":\"true\"}")).andExpect(status().isOk())
				.andExpect(content().string("true"));
	}

	@Test
	void testAddVipEconomyFlight() throws Exception {
		mockMvc.perform(post("/flights/economy").contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"shelby\",\"vip\":\"true\"}")).andExpect(status().isOk())
				.andExpect(content().string("true"));
	}

	@Test
	void testAddNonVipEconomyFlight() throws Exception {
		mockMvc.perform(post("/flights/economy").contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"shelby\",\"vip\":\"false\"}")).andExpect(status().isOk())
				.andExpect(content().string("true"));
	}

	@Test
	void testAddNonVipBusinessFlight() throws Exception {
		mockMvc.perform(post("/flights/business").contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"shelby,\",\"vip\":\"false\"}")).andExpect(status().isOk())
				.andExpect(content().string("false"));
	}

	@Test
	void testRemoveVipEconomyFlight() throws Exception {
		mockMvc.perform(delete("/flights/economy").contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"shelby\",\"vip\":\"true\"}")).andExpect(status().isOk())
				.andExpect(content().string("false"));
	}

	@Test
	void testRemoveVipBusinessFlight() throws Exception {
		mockMvc.perform(delete("/flights/business").contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"shelby,\",\"vip\":\"true\"}")).andExpect(status().isOk())
				.andExpect(content().string("false"));
	}

	@Test
	void testRemoveNonVipEconomyFlight() throws Exception {
		mockMvc.perform(delete("/flights/economy").contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"shelby\",\"vip\":\"false\"}")).andExpect(status().isOk())
				.andExpect(content().string("true"));
	}

	@Test
	void testRemoveNonVipBusinessFlight() throws Exception {
		mockMvc.perform(delete("/flights/business").contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"shelby,\",\"vip\":\"false\"}")).andExpect(status().isOk())
				.andExpect(content().string("true"));
	}
}
