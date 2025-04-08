package unit.com.warnett.mfnmanager.ui.controller;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
abstract class BaseControllerTest<T > {
    protected T controller;

    @Mock
    protected Model model;

    void checkAttributeSet(String attributeKey, String attributeName) {
        verify(model,atMostOnce()).addAttribute(attributeKey, attributeName);
    }
}
