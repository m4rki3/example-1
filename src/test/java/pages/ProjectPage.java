package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProjectPage extends HeaderPage {

    private final SelenideElement pager =
        $x("//div[@class='pager']/descendant::span[contains(text(), '1 из ')]");

    public String getPagerData() {
        return pager.getText();
    }

    public boolean isDisplayed() {
        return true;
    }
}
