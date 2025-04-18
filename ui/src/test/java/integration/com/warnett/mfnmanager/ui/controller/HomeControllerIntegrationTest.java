package integration.com.warnett.mfnmanager.ui.controller;

import com.warnett.mfnmanager.ui.controller.HomeController;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(controllers= HomeController.class)
class HomeControllerIntegrationTest extends BaseControllerIntegrationTest {
    HomeControllerIntegrationTest() {
        super("/", "pages/mfn-home");
    }
}
