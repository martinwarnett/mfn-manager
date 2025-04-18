package com.warnett.mfnmanager.ui.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;

@Component
public class RenderedPageChecker {

    public void checkPage(final ResultActions result, final int status, final String pageName) throws Exception {
        result.andExpectAll(MockMvcResultMatchers.status().is(status),
                MockMvcResultMatchers.view().name(pageName));
    }

    public void checkMenuBar(final MvcResult result) throws Exception {

        final var doc = Jsoup.parse(result.getResponse().getContentAsString());

        final var menuBarDiv = doc.select("div#mfn-navbar-id");

        assertThat(menuBarDiv).hasSize(1);

        final var topLevelMenuItems = menuBarDiv.select("nav>ul>li");
        assertThat(topLevelMenuItems).hasSize(2);

        final var homeItem = topLevelMenuItems.getFirst();
        checkMenuElement(homeItem, "Home", "mfn-navbar-home-id", "/");

        final var toolsItem = topLevelMenuItems.get(1);
        checkMenuElementHWithNoHref(toolsItem, "Tools", "mfn-navbar-tools-id");
    }

    private void checkMenuElementHWithNoHref(Element link, String name, String id) {
        checkMenuElement(link, name, id, "");
    }

    private void checkMenuElement(Element element, String name, String id, String expectedHrefLink) {
        assertThat(element.text()).isEqualTo(name);
        final var aElement = element.select("a").first();

        assertThat(aElement).isNotNull();

        assertThat(aElement.attr("href")).isEqualTo(expectedHrefLink);
        assertThat(aElement.id()).isEqualTo(id);
    }
}
