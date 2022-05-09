package com.javaDemo.crm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaDemo.crm.controller.CompanyController;
import com.javaDemo.crm.dao.UserDao;
import com.javaDemo.crm.dto.CompanyDto;
import com.javaDemo.crm.paramDto.ParamAddCompanyDto;
import com.javaDemo.crm.service.CompanyService;

@WebMvcTest(CompanyController.class)
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@ContextConfiguration
@WebAppConfiguration
public class CompanyControllerTests {

	@MockBean
	private UserDao userDao;

	@MockBean
	private CompanyService companyService;

	@MockBean
	private UserDetailsService userDetailsService;

	@Autowired
	private WebApplicationContext context;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	FilterChainProxy springSecurityFilterChain;

	@BeforeEach
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
				.apply(SecurityMockMvcConfigurers.springSecurity(springSecurityFilterChain)).build();
	}

	@Test
	@WithMockUser(username = "op2", password = "admin")
	void addByOperator() throws Exception {
		ParamAddCompanyDto p = new ParamAddCompanyDto("unitName", "unitAdress");
		ObjectMapper Obj = new ObjectMapper();
		String jsonStr = Obj.writeValueAsString(p);
		CompanyDto dto = new CompanyDto(100, "unitName", "unitAddress");

		Mockito.when(companyService.addCompany(p)).thenReturn(dto);

		this.mockMvc.perform(MockMvcRequestBuilders.post("/company/add")
				.contentType(MediaType.APPLICATION_JSON).content(jsonStr))
		
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
