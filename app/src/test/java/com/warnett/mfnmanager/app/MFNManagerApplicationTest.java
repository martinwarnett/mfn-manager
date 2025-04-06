package com.warnett.mfnmanager.app;

import com.warnett.mfnmanager.ui.controller.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MFNManagerApplicationTest {


    @Test
    void whenApplicationStarted_thenContextLoadsWithoutError(ApplicationContext context) {
        assertThat(context).isNotNull();
    }

    @Test
    void whenApplicationStarted_thenHomeControllerInCOntext(ApplicationContext context) {
        assertThat(context.getBean(HomeController.class)).isNotNull();
    }
}