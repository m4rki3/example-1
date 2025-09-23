package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TaskPage extends HeaderPage {
    private final SelenideElement statusSpan =
        $x("//div[@id='details-module']/descendant::span[@id='status-val']/child::span");

    private final SelenideElement versionToFixOn =
        $x("//div[@id='details-module']/descendant::span[@id='fixVersions-field']/child::a");

    public boolean checkStatus(String status) {
        return statusSpan.text().equals(status);
    }

    public boolean checkVersionToFixOn(String version) {
        return versionToFixOn.text().equals(version);
    }

    @Override
    public boolean isDisplayed() {
        return statusSpan.isDisplayed() && versionToFixOn.isDisplayed();
    }
}
