package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.sleep;

public class TestBase {

    @BeforeAll
    static void beforeAll() {;
//        Configuration.browser = System.getProperty("browser", "chrome");
//        Configuration.browserVersion = System.getProperty("version", "91");
//        Configuration.browserSize = System.getProperty("size", "1920x1080");/
        String browser = System.getProperty("browser", "chrome");
        String version = System.getProperty("version", "99");
        String size = System.getProperty("size", "1920x1080");
        String remoteUrl = System.getProperty("remoteUrl", "selenoid.autotests.cloud/wd/hub");
        String login = System.getProperty("login", "user1");
        String pass = System.getProperty("pass", "1234");

        Configuration.baseUrl = "https://www.wildberries.ru/";

        String url = "https://" + login + ":" + pass + "@" + remoteUrl;
        Configuration.remote = url;
        Configuration.browser = browser;
        Configuration.browserVersion = version;
        Configuration.browserSize = size;

        //password and user for remote browser
//        String user = System.getProperty("user");
//        String password = System.getProperty("password");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

//        Configuration.remote = "https://" + user + ":" + password + "@" + System.getProperty("remoteBrowser");

        SelenideLogger.addListener("allure", new AllureSelenide());
        Attach.attachAsText("Browser: ", browser);
        Attach.attachAsText("Version: ", version);
        Attach.attachAsText("Remote Url: ", remoteUrl);
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        sleep(5000);
        closeWebDriver();
    }
}