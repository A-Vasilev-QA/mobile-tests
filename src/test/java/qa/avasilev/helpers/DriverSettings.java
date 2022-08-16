package qa.avasilev.helpers;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import qa.avasilev.config.Project;
import qa.avasilev.drivers.BrowserstackMobileDriver;
import qa.avasilev.drivers.LocalMobileDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverSettings {
    public static boolean videoEnabled = false;
    public static boolean isSelenoid = false;
    public static void configure() {
        Configuration.browserSize = null;
        switch (Project.config.deviceHost()) {
            case "emulate", "real" ->
                    Configuration.browser = LocalMobileDriver.class.getName();
            case "selenoid" -> {
                isSelenoid = true;
                videoEnabled = true;
            }
            default -> {
                Configuration.browser = BrowserstackMobileDriver.class.getName();
                videoEnabled = true;
            }
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (isSelenoid) { // for chrome only
            Map<String, Object> mobileDevice = new HashMap<>();
            mobileDevice.put("deviceName", Project.config.device());
            ChromeOptions chromeOptions = new ChromeOptions();

            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-infobars");
            chromeOptions.addArguments("--disable-popup-blocking");
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("--lang=en-en");

            chromeOptions.setExperimentalOption("mobileEmulation", mobileDevice);
            capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        }

        if (videoEnabled) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.remote = Project.config.remoteDriverUrl();
        }

        Configuration.browserCapabilities = capabilities;
    }

}
