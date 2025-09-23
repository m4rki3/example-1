package pages;

import com.codeborne.selenide.Selenide;

public abstract class Page {

    protected void open(String url) {
        Selenide.open(url);
        Selenide.webdriver().driver().getWebDriver().manage().window().maximize();
    }

    public abstract boolean isDisplayed();
}
