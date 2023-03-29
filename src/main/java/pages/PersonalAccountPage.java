package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PersonalAccountPage {
    @FindBy(how = How.NAME, using = "Name")
    private SelenideElement nameInput;

    @FindBy(how = How.NAME, using = "name")
    private SelenideElement loginInput;

    @FindBy(how = How.XPATH, using = ".//a[@href='/account/profile']")
    private SelenideElement profileBtn;

    @FindBy(how = How.XPATH, using = ".//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive']")
    private SelenideElement logoutBtn;
}
