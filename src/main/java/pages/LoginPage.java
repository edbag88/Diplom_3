package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
    @FindBy(how = How.NAME, using = "name")
    private SelenideElement nameInput;
    @FindBy(how = How.XPATH,using = ".//input[@type='password']")
    private SelenideElement passwordInput;
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement loginSubmit;
    @FindBy(how = How.XPATH, using = ".//a[@href='/register']")
    private SelenideElement signupBtn;
    @FindBy(how = How.XPATH, using = ".//a[@href='/forgot-password']")
    private SelenideElement recoverPasswordBtn;



}
