package com.madhu.rest.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.madhu.rest.Models.Address;
import com.madhu.rest.Models.Student;
import com.madhu.rest.POJO.Word;
import com.madhu.rest.commands.AddressCommand;
import com.madhu.rest.commands.StudentCommand;
import com.madhu.rest.service.MyRestService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyControlllerTest {

	MyController controller;

	MockMvc mvc;

	@Mock
	MyRestService service;

	private static StudentCommand student = new StudentCommand();
	private static AddressCommand address = new AddressCommand();
	private static final Long ID = 1L;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		controller = new MyController(service);
		mvc = MockMvcBuilders.standaloneSetup(controller).build();

		student.setId(ID);
		student.setName("John");
		address.setId(ID);
		address.setAddress_line("2350 club meridian");
		address.setCity("Okemos");
		address.setZip(48864);
		student.addAddress(address);

	}

	@Test
	public final void testProcess() throws Exception {
		// fail("Not yet implemented"); // TODO
		List<Word> words = new ArrayList<Word>();
		words.add(new Word("a", 1));
		words.add(new Word("b", 1));
		when(service.findNoOfOccurance(Mockito.anyString())).thenReturn(words);
		mvc.perform(get("/process?para=this is a test")).andExpect(MockMvcResultMatchers.status().isOk());
		verify(service, times(1)).findNoOfOccurance(Mockito.anyString());
		mvc.perform(get("/process?para=")).andExpect(MockMvcResultMatchers.status().isBadRequest());

	}

	@Test
	public final void testSave() throws Exception {
		// given
		when(service.save(any())).thenReturn(student);

		String expected = "{\"id\":1,\"name\":\"John\",\"addresses\":[{\"id\":1,\"address_line\":\"2350 club meridian\",\"city\":\"Okemos\",\"zip\":48864}]}";
		MvcResult result = mvc
				.perform(post("/save").contentType(MediaType.APPLICATION_JSON).content(asJsonString(student)))
				.andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals("http://locolhost:8080/save", response.getHeader("save"));
		assertEquals(expected, response.getContentAsString());
		verify(service, times(1)).save(any());
	}
	
	@Test
	public final void testFetchStudent() throws Exception{
		//given
		//when
		when(service.fetchStudent(Mockito.anyString())).thenReturn(student);
		mvc.perform(get("/fetchStudent?id=1")).andExpect(MockMvcResultMatchers.status().isOk());
		verify(service, times(1)).fetchStudent(Mockito.anyString());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
