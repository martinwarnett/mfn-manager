package com.warnett.mfnmanager.ui.utils;

import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@Component
public class RenderedPageChecker {

    public void checkPage(final ResultActions result, final int status, final String pageName) throws Exception {
        result.andExpectAll(MockMvcResultMatchers.status().is(status),
                MockMvcResultMatchers.view().name(pageName));
    }
}
