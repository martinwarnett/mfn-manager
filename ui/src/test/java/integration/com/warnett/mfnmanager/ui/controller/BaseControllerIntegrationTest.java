package integration.com.warnett.mfnmanager.ui.controller;

import com.warnett.mfnmanager.ui.utils.RenderedPageChecker;
import com.warnett.mfnmanager.ui.utils.TestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = TestConfig.class)
@AutoConfigureMockMvc
public class BaseControllerIntegrationTest {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected RenderedPageChecker pageChecker;
}
