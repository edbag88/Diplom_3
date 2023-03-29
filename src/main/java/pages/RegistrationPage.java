package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage {
    @FindBy(how = How.XPATH, using = "(//*[contains(@class, 'input pr-6 pl-6')]/input)[1]")
    private SelenideElement nameInput;
    @FindBy(how = How.XPATH, using = "(//*[contains(@class, 'input pr-6 pl-6')]/input)[2]")
    private SelenideElement emailInput;
    @FindBy(how = How.XPATH, using = ".//input[@type='password']")
    private SelenideElement passwordInput;
    @FindBy(how = How.XPATH, using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement signupSubmit;
    @FindBy(how = How.XPATH, using = ".//a[@href='/login']")
    private SelenideElement loginBtn;
    @FindBy(how = How.XPATH, using = ".//p[@class='input__error text_type_main-default']")
    private SelenideElement passwordHasInvalidLength;
}
