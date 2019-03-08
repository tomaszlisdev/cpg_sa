package com.pivovarit.movies;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieDetailsControllerContractVerifier {

    @Autowired
    private MovieDetailsController movieDetailsController;

    @MockBean
    private MovieDetailsRepository movieDetailsRepository;

    @Before
    public void setup() {
        when(movieDetailsRepository.getDetails("idkfa7")).thenReturn("idkfa7-details");

        StandaloneMockMvcBuilder standaloneMockMvcBuilder = MockMvcBuilders.standaloneSetup(movieDetailsController);
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
    }
}