package ifellow.tests;

import org.junit.jupiter.api.*;
import ifellow.pages.DashboardPage;
import ifellow.pages.LoginPage;
import ifellow.pages.TaskPage;
import ifellow.pages.ProjectPage;
import ifellow.tools.PagerDataHelper;

public class JiraTests extends WebHook {
    private final String username = config.getProperty("username");
    private final String password = config.getProperty("password");
    private final String taskTitle = config.getProperty("taskTitle");
    private final String query = config.getProperty("query");
    private final String status = config.getProperty("status");
    private final String version = config.getProperty("version");
    private final String bugTitle = config.getProperty("bugTitle");
    private final String bugDesc = config.getProperty("bugDesc");
    private final String bugEnv = config.getProperty("bugEnv");

    private final LoginPage loginPage = new LoginPage();
    private final DashboardPage dashboardPage = new DashboardPage();
    private final ProjectPage projectPage = new ProjectPage();
    private final TaskPage taskPage = new TaskPage();

    private final PagerDataHelper helper = new PagerDataHelper();

    @Test
    @DisplayName("Логин")
    public void loginTest() {
        loginPage.login(username, password);

        Assertions.assertFalse(loginPage.isDisplayed());
        Assertions.assertTrue(dashboardPage.isDisplayed());
    }

    @Test
    @DisplayName("Открыть проект Test")
    public void openTestProjectTest() {
        loginPage
            .login(username, password)
            .openTestProject();

        Assertions.assertTrue(projectPage.isDisplayed());
    }

    @Test
    @DisplayName("Проверить количество задач после создания новой")
    public void checkTaskCountTest() {
        loginPage
            .login(username, password)
            .openTestProject();

        var pagesCount = helper.getPagesCount(projectPage.getPagerData());
        projectPage.createEmptyTask(taskTitle);

        refresh();

        var pagesCountAfter = helper.getPagesCount(projectPage.getPagerData());

        Assertions.assertEquals(pagesCount + 1, pagesCountAfter);
    }

    @Test
    @DisplayName("Проверить статус задачи")
    public void checkTaskStatusTest() {
        loginPage
            .login(username, password)
            .openTestProject()
            .searchAndOpen(query);

        var isStatusCorrect = taskPage.checkStatus(status);
        var isVersionCorrect = taskPage.checkVersionToFixOn(version);

        Assertions.assertTrue(isStatusCorrect);
        Assertions.assertTrue(isVersionCorrect);
    }

    @Test
    @DisplayName("Создать баг")
    public void createIssueTest() {
        loginPage
            .login(username, password)
            .openTestProject()
            .createBug(bugTitle, bugDesc, version, bugEnv);
    }
}
