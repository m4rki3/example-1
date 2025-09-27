package ifellow.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import ifellow.tools.Config;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.Properties;

public class WebHook {
    protected static Config config;

    @BeforeAll
    public static void init() {
        config = new Config();
    }

    @BeforeEach
    public void setup() {
        Configuration.timeout = 4000;
        Selenide.open(config.getProperty("page"));
        Selenide.webdriver().driver().getWebDriver().manage().window().maximize();
    }

    @AfterEach
    public void reset() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }

    protected void refresh() {
        Selenide.webdriver().driver().getWebDriver().navigate().refresh();
    }
}
