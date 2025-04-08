package integration.com.warnett.mfnmanager.ui.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

class CustomErrorControllerIntegrationTest extends BaseControllerIntegrationTest {
    @Test
    @DisplayName("Check error page renders correctly")
    void handleErrorTest() throws Exception {
        final var page = mockMvc.perform(MockMvcRequestBuilders.get("/error"));

        pageChecker.checkPage(page, 200, "pages/mfn-error");
    }
}
