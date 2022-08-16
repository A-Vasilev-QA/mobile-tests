package qa.avasilev.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import qa.avasilev.helpers.Attach;
import qa.avasilev.helpers.DriverSettings;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.qameta.allure.Allure.step;
import static qa.avasilev.helpers.Attach.sessionId;
import static qa.avasilev.helpers.DriverSettings.videoEnabled;


public class TestBase {

    @BeforeAll
    static void beforeAll() {
        DriverSettings.configure();
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
