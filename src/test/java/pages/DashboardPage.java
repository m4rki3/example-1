package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DashboardPage extends HeaderPage {
    private final SelenideElement title =
        $x("//div[@id='dashboard-content']/descendant::h1[text()='System Dashboard']");

//    private final SelenideElement projectsButton =
//        $x("//header[@id='header']/descendant::a[@id='browse_link' and text()='Проекты']");
//
//    private final SelenideElement testPrjButton =
//        $x("//div[@id='browse_link-content']/descendant::a[contains(text(), 'Test')]");

    public boolean isDisplayed() {
        return projectsButton.isDisplayed();
    }

    public void openTestProject() {
        projectsButton.click();
        testPrjButton.click();
    }
}
