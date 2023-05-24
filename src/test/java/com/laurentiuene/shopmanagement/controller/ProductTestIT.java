package com.laurentiuene.shopmanagement.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.laurentiuene.shopmanagement.dto.product.ProductDto;
import com.laurentiuene.shopmanagement.repository.ProductRepository;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductTestIT {

    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private ProductRepository productRepository;

    private MockMvc      mockMvc;
    private ObjectMapper mapper;

    @BeforeAll
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
    }

    @Test
    @Order(1)
    void whenCallingCreateProductEndpointWithCorrectDataThenReceiveIdOfNewlyCreatedEntity() throws Exception {
        String productDtoJson = readInputAsString("input/product-dto.json");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .post("/product")
                .content(productDtoJson)
                .contentType(APPLICATION_JSON))
            .andExpect(status().is2xxSuccessful())
            .andReturn();

        Integer result = mapper.readValue(mvcResult.getResponse().getContentAsString(), Integer.class);
        productRepository.findAll();
        assertThat(result).isEqualTo(3);
    }

    @Test
    @Order(2)
    @WithMockUser(username = "manager", authorities = {"ADMIN"})
    void whenCallingGetAllProductsThenReturnListWithNewlyAddedProduct() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .get("/product/all")
                .contentType(APPLICATION_JSON))
            .andExpect(status().is2xxSuccessful())
            .andReturn();

        List<ProductDto> result = mapper.readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<>() {
        });
        assertThat(result.size()).isEqualTo(3);
        assertThat(result.get(2).price()).isEqualTo(100);
    }

    @Test
    @Order(3)
    @WithMockUser(username = "manager")
    void whenCallingGetAllProductsWithoutAuthentificationAndAuthorizationThenThrowException() throws Exception {
        try {
            mockMvc.perform(MockMvcRequestBuilders
                .get("/product/all")
                .contentType(APPLICATION_JSON));
        } catch (ServletException ex) {
            assertThat(ex.getCause()).isInstanceOf(AccessDeniedException.class);
        }
    }

    protected String readInputAsString(String filePath) throws URISyntaxException, IOException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        return Files.lines(Paths.get(loader.getResource(filePath).toURI()))
            .parallel()
            .collect(Collectors.joining());
    }

}
