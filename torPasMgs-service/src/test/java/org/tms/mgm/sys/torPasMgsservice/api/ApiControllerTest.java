package org.tms.mgm.sys.torPasMgsservice.api;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.tms.mgm.sys.torPasMgsservice.TorPasMgsServiceApplication;
import org.tms.mgm.sys.torPasMgsservice.api.util.TestUtil;
import org.tms.mgm.sys.torPasMgsservice.model.City;
import org.tms.mgm.sys.torPasMgsservice.model.Pass;
import org.tms.mgm.sys.torPasMgsservice.service.PassService;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = TorPasMgsServiceApplication.class)

public class ApiControllerTest implements TestUtil {

	@Autowired
	protected MockMvc mockMvc;

	String URL = "/api/topas/mgm/v1/";

	PassService passService = Mockito.mock(PassService.class);

	@Test
	public void when_request_all_passes() throws Exception {

		Mockito.when(passService.fingAllPassess()).thenReturn(findAll());

		String url = new StringBuilder().append("/").append(BASE_URL).toString();

		mockMvc.perform(MockMvcRequestBuilders.get(url).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(content().json(FIND_ALL_RESULT)).andDo(print()).andReturn();

	}

	@Test
	public void when_find_past_by_past_number() throws Exception {

		String url = new StringBuilder().append("/").append(BASE_URL).append("/BV3078D").toString();

		City city = new City();
		city.setCustomerCity("BEDFORD");
		city.setPassCity("LONDON");
		Pass payloadResult = new Pass();
		payloadResult.setId(2);
		payloadResult.setPassNo("BV3078D");
		payloadResult.setCustomerNo("CSG2DB");
		payloadResult.setCity(city);
		payloadResult.setExpiraryDate("2020-03-01");
		payloadResult.setPassActive("NO");

		Mockito.when(passService.findByPassNo("BV3078D")).thenReturn(payloadResult);

		ObjectMapper Obj = new ObjectMapper();
		String jsonStr = Obj.writeValueAsString(payloadResult);

		mockMvc.perform(MockMvcRequestBuilders.get(url).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(content().json(jsonStr)).andReturn();

	}

	@Test
	public void when_renew_expire_pass() throws Exception {

		String url = new StringBuilder().append("/").append(BASE_URL).append("/BV3078D").toString();

		MockHttpServletRequestBuilder theRequest = MockMvcRequestBuilders.post(url);
		theRequest.param("id", "7");
		theRequest.param("passNo", "RE2435");
		theRequest.param("customerNo", "RE142");
		theRequest.param("expiraryDate", "2020-09-01");
		theRequest.param("passActive", "YES");
		theRequest.param("customerCity", "LONDON");
		theRequest.param("passCity", "LONDON");
		ResultActions result = mockMvc.perform(theRequest);
		result.andExpect(MockMvcResultMatchers.status().is4xxClientError()).andReturn();
	}

	@Test
	public void when_renew_delete_pass() throws Exception {

		String url = new StringBuilder().append("/").append(BASE_URL).toString();

		MockHttpServletRequestBuilder theRequest = MockMvcRequestBuilders.delete(url);
		theRequest.param("id", "10");
		theRequest.param("passNo", "test123");
		theRequest.param("customerNo", "cus123");
		theRequest.param("expiraryDate", "2020-09-01");
		theRequest.param("passActive", "YES");
		theRequest.param("customerCity", "LONDON");
		theRequest.param("passCity", "LONDON");
		ResultActions result = mockMvc.perform(theRequest);
		result.andExpect(MockMvcResultMatchers.status().is4xxClientError()).andReturn();

	}

	@Test
	public void create_new_pass() throws Exception {

		String url = new StringBuilder().append("/").append(BASE_URL).toString();

		MockHttpServletRequestBuilder theRequest = MockMvcRequestBuilders.post(url);
		theRequest.param("id", "10");
		theRequest.param("passNo", "test123");
		theRequest.param("customerNo", "cus123");
		theRequest.param("expiraryDate", "2020-09-01");
		theRequest.param("passActive", "YES");
		theRequest.param("customerCity", "LONDON");
		theRequest.param("passCity", "LONDON");
		ResultActions result = mockMvc.perform(theRequest);
		result.andExpect(MockMvcResultMatchers.status().is4xxClientError()).andReturn();

	}

		
	private List<Pass> findAll() {
		List<Pass> passList = new ArrayList<>();

		City city = new City();
		city.setCustomerCity("LONDON");
		city.setPassCity("LONDON");
		Pass payloadResult = new Pass();
		payloadResult.setId(1);
		payloadResult.setPassNo("P3078D");
		payloadResult.setCustomerNo("CTR12D");
		payloadResult.setCity(city);
		payloadResult.setExpiraryDate("2020-03-01");
		payloadResult.setPassActive("YES");

		passList.add(payloadResult);

		city.setCustomerCity("BEDFORD");
		city.setPassCity("LONDON");
		payloadResult.setId(2);
		payloadResult.setPassNo("BV3078D");
		payloadResult.setCustomerNo("CSG2DB");
		payloadResult.setCity(city);
		payloadResult.setExpiraryDate("2020-03-01");
		payloadResult.setPassActive("NO");

		passList.add(payloadResult);

		city.setCustomerCity("LONDON");
		city.setPassCity("LONDON");
		payloadResult.setId(3);
		payloadResult.setPassNo("PR978D");
		payloadResult.setCustomerNo("CFR12D");
		payloadResult.setCity(city);
		payloadResult.setExpiraryDate("2020-03-01");
		payloadResult.setPassActive("NO");

		passList.add(payloadResult);

		city.setCustomerCity("WATFORD");
		city.setPassCity("LONDON");
		payloadResult.setId(4);
		payloadResult.setPassNo("RA278D");
		payloadResult.setCustomerNo("CP12DK");
		payloadResult.setCity(city);
		payloadResult.setExpiraryDate("2020-03-01");
		payloadResult.setPassActive("YES");

		passList.add(payloadResult);
		return passList;
	}

}
