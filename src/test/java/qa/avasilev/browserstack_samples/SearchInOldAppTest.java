package qa.avasilev.browserstack_samples;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;
import qa.avasilev.tests.TestBase;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchInOldAppTest extends TestBase {

// Commented code: same actions without Selenide

    @Test
    void searchTest() {
        $(AppiumBy.accessibilityId("Search Wikipedia")).click();
//        AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
//                ExpectedConditions.elementToBeClickable(
//                        MobileBy.AccessibilityId("Search Wikipedia")));
//        searchElement.click();

        $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
//        AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
//                ExpectedConditions.elementToBeClickable(
//                        MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
//        insertTextElement.sendKeys("BrowserStack");
//        Thread.sleep(5000);

        $$(AppiumBy.className("android.widget.TextView")).shouldHave(sizeGreaterThan(0));
//        List<AndroidElement> allProductsName = driver.findElementsByClassName(
//                "android.widget.TextView");
//        assert (allProductsName.size() > 0);

//        // Invoke driver.quit() after the test is done to indicate that the test is completed.
//        driver.quit();
    }
}