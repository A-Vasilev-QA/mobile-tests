package qa.avasilev.tests;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {

    @Test
    @Description("Test from the lesson")
    @DisplayName("Verify search results appear")
    void searchTest() {
        back();

        step("Type query", () -> {
                    $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
                    $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
                });

        step("Verify that there are more than 0 results", () -> {
            $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0));
        });
    }

    @Test
    @DisplayName("Page theme selection available")
    void themeIsChangeable() {
        back();

        step("Type query", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Selenium");
        });

        step("Click the Selenium link", ()-> {
            $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_description"))
                    .findBy(text("Testing framework for web applications")).click();
        });
        step("Verify the article header description", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/page_theme")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/button_font_family_sans_serif")).shouldBe(visible);
        });
    }
}