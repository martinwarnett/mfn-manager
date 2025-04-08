package unit.com.warnett.mfnmanager.ui.config;

import com.warnett.mfnmanager.ui.config.UIConfigResourceResolver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UIConfigResourceResolverTest {
    @InjectMocks
    private UIConfigResourceResolver resolver;

    @Mock
    private ResourceHandlerRegistry registry;

    @Mock
    private ResourceHandlerRegistration registration;

    @Test
    void whenResolverInvoked_thenResourcesCorrectlyDefined() {
        when(registry.addResourceHandler("/css/**")).thenReturn(registration);

        resolver.addResourceHandlers(registry);

        verify(registry).addResourceHandler("/css/**");
        verify(registration).addResourceLocations("classpath:/static/css/");
    }
}
