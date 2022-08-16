package qa.avasilev.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import qa.avasilev.config.Project;
import qa.avasilev.drivers.BrowserstackMobileDriver;
import qa.avasilev.drivers.LocalMobileDriver;
import qa.avasilev.helpers.Attach;


import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.qameta.allure.Allure.step;
import static qa.avasilev.helpers.Attach.sessionId;



public class TestBase {

    private static boolean videoEnabled;

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = null;
        switch (Project.config.deviceHost()) {
            case "emulate", "real" ->
                    Configuration.browser = LocalMobileDriver.class.getName();
            /*case "selenoid" -> {
                videoEnabled = true;
            }*/
            default -> {
                Configuration.browser = BrowserstackMobileDriver.class.getName();
                videoEnabled = true;
            }
        }
    }

    @BeforeEach
    public void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    public void tearDown() {
        String sessionId = sessionId();
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        step("Close driver", Selenide::closeWebDriver);
        if (videoEnabled) {
            Attach.video(sessionId);
        }
    }
}
