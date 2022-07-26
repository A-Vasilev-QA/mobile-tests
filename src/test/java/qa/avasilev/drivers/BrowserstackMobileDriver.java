package qa.avasilev.drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import qa.avasilev.config.Project;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", Project.config.login());
        mutableCapabilities.setCapability("browserstack.key", Project.config.password());

        // Set URL of the application under test
        //mutableCapabilities.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");
        mutableCapabilities.setCapability("app", "bs://9979c840aafcda0127767656f8027522af902420");
        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", Project.config.device());
        mutableCapabilities.setCapability("os_version", Project.config.osVersion());

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", "AVasilevQA mobile automation project ");
        mutableCapabilities.setCapability("build", Project.config.build());
        mutableCapabilities.setCapability("name", "Selenide Android final test");
        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
