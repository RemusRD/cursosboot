package com.cdelhoyo.cursosboot.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = { "spring.jmx.enabled:true", "spring.datasource.jmx-enabled:true" })
@ActiveProfiles("scratch")
public class TeacherControllerIT {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void testEndpoints() throws Exception {
		mvc.perform(get("/teachers")).andExpect(status().isOk());
		mvc.perform(get("/teachers?name=rober&page=0&size1")).andExpect(status().isOk());
		mvc.perform(get("/teachers/1")).andExpect(status().isOk());
		mvc.perform(get("/teachers/1/courses")).andExpect(status().isOk());
		mvc.perform(get("/teachers/1/courses?name=metodo&page=0&size1")).andExpect(status().isOk());
	}

}
