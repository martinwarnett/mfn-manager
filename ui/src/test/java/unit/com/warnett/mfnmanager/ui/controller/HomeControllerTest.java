package unit.com.warnett.mfnmanager.ui.controller;

import static org.assertj.core.api.Assertions.assertThat;

import com.warnett.mfnmanager.ui.controller.HomeController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HomeControllerTest extends BaseControllerTest<HomeController> {

    @BeforeEach
    void setup() {
        controller = new HomeController();
    }

    @Test
    void whenHomePageMethodInvoked_thenPageTitleSetCorrectly() {
        assertThat(controller.homePage(model)).isEqualTo("pages/mfn-home");
    }

    @Test
    void whenHomePageMethodInvoked_thenModelAttributesSetCorrectly() {
        controller.homePage(model);

        checkAttributeSet("page_title", "MFN Manager - Home");
    }
}
