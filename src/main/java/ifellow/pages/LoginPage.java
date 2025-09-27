package ifellow.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends Page {
    private final SelenideElement usernameField =
        $x("//label[text()='огин']/following-sibling::input[@id='login-form-username']");

    private final SelenideElement passwordField =
        $x("//label[text()='ароль']/following-sibling::input[@id='login-form-password']");

    private final SelenideElement loginButton = $x("//input[@id='login-form-submit' and @value='Вход']");

    public DashboardPage login(String username, String password) {
        usernameField.setValue(username);
        passwordField.setValue(password);
        loginButton.click();
        return Selenide.page(DashboardPage.class);
    }

    @Override
    public boolean isDisplayed() {
        return usernameField.isDisplayed() && passwordField.isDisplayed() && loginButton.isDisplayed();
    }
}