package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import pages.DashboardPage;
import pages.LoginPage;
import pages.TaskPage;
import pages.ProjectPage;
import resources.PagerDataHelper;

public class JiraTests {
    // можно поместить в конфиг или какую-то структуру данных
    private final String username = "AT7";
    private final String password = "Qwerty123";
    private final String taskTitle = "mytask";
    private final String query = "TestSeleniumATHomework";
    private final String status = "СДЕЛАТЬ";
    private final String version = "Version 2.0";
    private final String bugTitle = "mybug";
    private final String bugDesc = "This is description";
    private final String bugEnv = "This is env";

    private final LoginPage loginPage = new LoginPage();
    private final DashboardPage dashboardPage = new DashboardPage();
    private final ProjectPage projectPage = new ProjectPage();
    private final TaskPage taskPage = new TaskPage();

    private final PagerDataHelper helper = new PagerDataHelper();

    @AfterEach
    public void reset() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }

    @Test
    public void login_whenDataCorrect_redirectsToDashboard() {
        loginPage.open();
        loginPage.login(username, password);

        Assertions.assertFalse(loginPage.isDisplayed());
        Assertions.assertTrue(dashboardPage.isDisplayed());

    }

    @Test
    public void openTestPrj_whenExist_redirectsToTestPage() {
        loginPage.open();
        loginPage.login(username, password);

        dashboardPage.openTestProject();

        Assertions.assertTrue(projectPage.isDisplayed());
    }

    @Test
    public void createTask_whenCreated_pagesCountCorrect() {
        loginPage.open();
        loginPage.login(username, password);

        dashboardPage.openTestProject();

        var pagesCount = helper.getPagesCount(projectPage.getPagerData());
        projectPage.createEmptyTask(taskTitle);

        Selenide.webdriver().driver().getWebDriver().navigate().refresh();

        var pagesCountAfter = helper.getPagesCount(projectPage.getPagerData());

        Assertions.assertEquals(pagesCount + 1, pagesCountAfter);
    }

    @Test
    public void checkTaskStatusAndVersion() {
        loginPage.open();
        loginPage.login(username, password);

        dashboardPage.openTestProject();
        dashboardPage.searchAndOpen(query);

        var isStatusCorrect = taskPage.checkStatus(status);
        var isVersionCorrect = taskPage.checkVersionToFixOn(version);

        Assertions.assertTrue(isStatusCorrect);
        Assertions.assertTrue(isVersionCorrect);
    }

    @Test
    public void createIssue() {
        loginPage.open();
        loginPage.login(username, password);

        dashboardPage.openTestProject();

        dashboardPage.createBug(bugTitle, bugDesc, version, bugEnv);
    }
}
