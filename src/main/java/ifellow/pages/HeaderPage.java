package ifellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public abstract class HeaderPage extends Page {
    protected final String descFrameId = "mce_12_ifr";
    protected final String envFrameId = "mce_13_ifr";

    protected final SelenideElement projectsButton =
        $x("//header[@id='header']//a[@id='browse_link' and text()='Проекты']");

    protected final SelenideElement testPrjButton =
        $x("//div[@id='browse_link-content']//a[contains(text(), 'Test')]");

    protected final SelenideElement createTaskButton =
        $x("//header[@id='header']//a[@id='create_link' and text()='Создать']");

    protected final SelenideElement taskTitleField =
        $x("//form[@id='dialog-form']//" +
           "label[text()='Тема ']/following-sibling::input[@id='summary']");

    protected final SelenideElement visualDescModeBtn =
        $x("//form[@id='dialog-form']//div[@field-id='description']//button[text()='Визуальный']");

    protected final SelenideElement descField = $x("//body[@id='tinymce']/child::p");

    protected final ElementsCollection selectVersionToFixOn =
        $$x("//form[@id='dialog-form']//select[@id='fix-versions']//option");

    protected final SelenideElement visualEnvModeBtn =
        $x("//form[@id='dialog-form']//div[@field-id='environment']//button[text()='Визуальный']");

    protected final SelenideElement envField = $x("//body[@id='tinymce']/child::p");

    protected final SelenideElement submitTaskCreation =
        $x("//section[@id='create-issue-dialog']//" +
            "input[@id='create-issue-submit' and @value='Создать']");

    protected final SelenideElement searchField =
        $x("//header[@id='header']//" +
           "form[@id='quicksearch']/child::input[@placeholder='Поиск']");

    protected final ElementsCollection searchElements =
        $$x("//header[@id='header']//" +
            "form[@id='quicksearch']//li[@class='quick-search-result-item']");

    public ProjectPage openTestProject() {
        projectsButton.click();
        testPrjButton.click();
        return Selenide.page(ProjectPage.class);
    }

    public HeaderPage createEmptyTask(String title) {
        createTaskButton.click();
        taskTitleField.setValue(title);
        submitTaskCreation.click();
        return this;
    }

    public TaskPage searchAndOpen(String query) {
        searchField.setValue(query);
        var filtered = searchElements.filterBy(Condition.attribute("original-title", query)).first();

        if (filtered.isDisplayed()) {
            filtered.click();
        }

        return Selenide.page(TaskPage.class);
    }

    public void createBug(String title, String desc, String versionToFixOn, String env) {
        createTaskButton.click();

        taskTitleField.setValue(title);
        visualDescModeBtn.click();

        $$("iframe").forEach(frame -> {
            System.out.println("Frame id: " + frame.getAttribute("id"));
            System.out.println("Frame name: " + frame.getAttribute("name"));
            System.out.println("Frame src: " + frame.getAttribute("src"));
        });

        sleep(2000);
        if ($x("//form[@id='dialog-form']//iframe[@id='mce_12_ifr']").isDisplayed()) {
            switchTo().frame(descFrameId);
            descField.setValue(desc);
            switchTo().defaultContent();
        }

        var filtered = selectVersionToFixOn.filterBy(Condition.text(versionToFixOn)).first();
        if (filtered.isDisplayed()) {
            filtered.click();
        }

        visualEnvModeBtn.click();


//        switchTo().frame(envFrameId);
//        envField.setValue(env);
//        switchTo().defaultContent();

        submitTaskCreation.click();
    }
}
