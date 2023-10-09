package com.matrixcampus.product;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ProductApplicationITTest {

	@Autowired
	private MockMvc mvc;

	final int productId = 35455;

	final int brandId = 1;

	final String date1 = "2020-06-14 10:00:00";
	final String date2 = "2020-06-14 16:00:00";
	final String date3 = "2020-06-14 21:00:00";
	final String date4 = "2020-06-15 10:00:00";
	final String date5 = "2020-06-16 21:00:00";


	@Test
	void firstTest() throws Exception {
		this.mvc.perform(get("/prices/get")
				.param("product_id", String.valueOf(productId))
				.param("brand_id", String.valueOf(brandId))
				.param("date_time", date1))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.productId").value(35455))
			.andExpect(jsonPath("$.brandId").value(1))
			.andExpect(jsonPath("$.startDate").value("2020-06-14T00:00:00"))
			.andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"))
			.andExpect(jsonPath("$.price").value(35.5));
	}

	@Test
	void secondTest() throws Exception {
		this.mvc.perform(get("/prices/get")
						.param("product_id", String.valueOf(productId))
						.param("brand_id", String.valueOf(brandId))
						.param("date_time", date2))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.productId").value(35455))
				.andExpect(jsonPath("$.brandId").value(1))
				.andExpect(jsonPath("$.startDate").value("2020-06-14T15:00:00"))
				.andExpect(jsonPath("$.endDate").value("2020-06-14T18:30:00"))
				.andExpect(jsonPath("$.price").value(25.45));
	}

	@Test
	void thirdTest() throws Exception {
		this.mvc.perform(get("/prices/get")
						.param("product_id", String.valueOf(productId))
						.param("brand_id", String.valueOf(brandId))
						.param("date_time", date3))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.productId").value(35455))
				.andExpect(jsonPath("$.brandId").value(1))
				.andExpect(jsonPath("$.startDate").value("2020-06-14T00:00:00"))
				.andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"))
				.andExpect(jsonPath("$.price").value(35.5));
	}

	@Test
	void fourthTest() throws Exception {
		this.mvc.perform(get("/prices/get")
						.param("product_id", String.valueOf(productId))
						.param("brand_id", String.valueOf(brandId))
						.param("date_time", date4))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.productId").value(35455))
				.andExpect(jsonPath("$.brandId").value(1))
				.andExpect(jsonPath("$.startDate").value("2020-06-15T00:00:00"))
				.andExpect(jsonPath("$.endDate").value("2020-06-15T11:00:00"))
				.andExpect(jsonPath("$.price").value(30.5));
	}

	@Test
	void fifthTest() throws Exception {
		this.mvc.perform(get("/prices/get")
						.param("product_id", String.valueOf(productId))
						.param("brand_id", String.valueOf(brandId))
						.param("date_time", date5))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.productId").value(35455))
				.andExpect(jsonPath("$.brandId").value(1))
				.andExpect(jsonPath("$.startDate").value("2020-06-15T16:00:00"))
				.andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"))
				.andExpect(jsonPath("$.price").value(38.95));
	}
}
