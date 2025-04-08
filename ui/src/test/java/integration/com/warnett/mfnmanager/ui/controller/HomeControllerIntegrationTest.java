package integration.com.warnett.mfnmanager.ui.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class HomeControllerIntegrationTest extends BaseControllerIntegrationTest {

    @Test
    @DisplayName("Check that Home page generated correctly")
    void getHomePageTest() throws Exception {
        final var page = mockMvc.perform(MockMvcRequestBuilders.get("/"));

        pageChecker.checkPage(page, 200, "pages/mfn-home");
    }

}
