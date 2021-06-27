package com.backbase.webapp.webmodulemoviecatalog;

import com.backbase.webapp.webmodulemoviecatalog.controller.MovieController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;

import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SpringSecurityWebAuxTestConfig.class)
class WebModuleMovieCatalogApplicationTests {
    @Autowired
    MovieController controller;

    @Test
    @WithUserDetails("mikku")
    void contextLoads() {
        assertThat(controller).isNotNull();
    }
}
