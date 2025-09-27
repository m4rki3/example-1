package ifellow.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DashboardPage extends HeaderPage {
    private final SelenideElement title =
        $x("//div[@id='dashboard-content']//::h1[text()='System Dashboard']");

    @Override
    public boolean isDisplayed() {
        return projectsButton.isDisplayed();
    }
}
