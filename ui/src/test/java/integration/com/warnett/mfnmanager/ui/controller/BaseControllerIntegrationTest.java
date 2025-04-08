package integration.com.warnett.mfnmanager.ui.controller;

import com.warnett.mfnmanager.ui.utils.RenderedPageChecker;
import com.warnett.mfnmanager.ui.utils.TestConfig;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

//@SpringBootTest(classes = TestConfig.class)
//@AutoConfigureMockMvc
//@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
public abstract class BaseControllerIntegrationTest {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected RenderedPageChecker pageChecker;

    protected String url;
    protected String viewPage;

    BaseControllerIntegrationTest(String url, String viewPage) {
        this.url = url;
        this.viewPage = viewPage;
    }

    @Test
    void whenUrlRequestMade_thenNoErrorAndCorrectViewReturned() throws Exception {
        final var page = mockMvc.perform(MockMvcRequestBuilders.get(url));
        pageChecker.checkPage(page, 200, viewPage);
    }

    @Test
    void whenUrlRequestMade_thenMenuBarRenderedCorrectly() throws Exception {
        pageChecker.checkMenuBar(mockMvc.perform(MockMvcRequestBuilders.get(url)).andReturn());
    }
}
