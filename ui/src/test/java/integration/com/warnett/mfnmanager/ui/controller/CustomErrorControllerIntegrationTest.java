package integration.com.warnett.mfnmanager.ui.controller;

import com.warnett.mfnmanager.ui.controller.CustomErrorController;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(controllers= CustomErrorController.class)
class CustomErrorControllerIntegrationTest extends BaseControllerIntegrationTest {

    CustomErrorControllerIntegrationTest() {
        super("/error","pages/mfn-error");
    }
}
