import clients.UserClient;
import jdk.jfr.Description;
import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class TransitionToConstructorTest extends BaseTest{
    User user;
    UserClient userClient;
    String accessToken;
    @Before
    public void setUp() {
        userClient = new UserClient();
        user = User.getRandom();
        accessToken = userClient.createUser(user);
    }
    @After
    public void deleteUser() {
        if (accessToken != null) {
            userClient.deleteUser(accessToken);
        }
    }
    @Test
    @Description("Проверка перехода из личного кабинета в конструктор")
    public void successTransitionToConstructorFromAccountPageViaConstructorBtn() {
        final boolean isTransitionToConstructorViaConstructorBtnCorrect = mainPage
                .clickLogInToYourAccountBtn()
                .login(user.getEmail(), user.getPassword())
                .clickPersonalAccountBtnFromAccount()
                .clickConstructorBtn()
                .isBunsBtnDisplayed();
        assertTrue("Переход из личного кабинета в конструктор через кнопку 'Конструктор' не выполнен или выполнен некорректно", isTransitionToConstructorViaConstructorBtnCorrect);
    }

    @Test
    @Description("Проверка перехода по клику на «Конструктор» и на логотип Stellar Burgers.")
    public void successTransitionToConstructorFromAccountPageViaLogoBtn() {
        final boolean isTransitionToConstructorViaLogoBtnCorrect = mainPage
                .clickLogInToYourAccountBtn()
                .login(user.getEmail(), user.getPassword())
                .clickPersonalAccountBtnFromAccount()
                .clickLogoBtn()
                .isBunsBtnDisplayed();
        assertTrue("Переход из личного кабинета в конструктор при нажатии на логотип не выполнен или выполнен некорректно", isTransitionToConstructorViaLogoBtnCorrect);
    }
}
