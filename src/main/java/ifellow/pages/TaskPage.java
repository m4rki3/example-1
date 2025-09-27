package ifellow.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TaskPage extends HeaderPage {
    private final SelenideElement statusSpan =
        $x("//div[@id='details-module']//span[@id='status-val']/span");

    private final SelenideElement versionToFixOn =
        $x("//div[@id='details-module']//span[@id='fixVersions-field']/a");

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
