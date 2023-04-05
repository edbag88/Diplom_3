import clients.UserClient;
import jdk.jfr.Description;
import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {
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
    @Description("вход по кнопке «Войти в аккаунт» на главной")
    public void successfulLoginViaLoginToAccountButton() {
        final boolean isLoginCompletedViaLogInToAccount = mainPage
                .clickLogInToYourAccountBtn()
                .login(user.getEmail(), user.getPassword())
                .isUrlCorrectAfterLogin();
        assertTrue("Аутентификация через кнопку 'Войти в аккаунт' пользователя завершилась ошибкой", isLoginCompletedViaLogInToAccount);
    }

    @Test
    @Description("вход через кнопку «Личный кабинет»")
    public void successfulLoginViaPersonalAccountButton() {
        final boolean isLoginCompletedViaPersonalAccount = mainPage
                .clickPersonalAccountBtn()
                .login(user.getEmail(), user.getPassword())
                .isUrlCorrectAfterLogin();
        assertTrue("Аутентификация через личный кабинет пользователя завершилась ошибкой", isLoginCompletedViaPersonalAccount);
    }

    @Test
    @Description("вход через кнопку в форме регистрации")
    public void successfulLoginViaSignUpPageButton() {
        final boolean isLoginCompletedViaSignPage = mainPage
                .clickPersonalAccountBtn()
                .clickSignupBtn()
                .clickLoginBtn()
                .login(user.getEmail(), user.getPassword())
                .isUrlCorrectAfterLogin();
        assertTrue("Аутентификация со страницы регистрации пользователя завершилась ошибкой", isLoginCompletedViaSignPage);
    }

    @Test
    @Description("вход через кнопку в форме восстановления пароля")
    public void successfulLoginViaRecoverPasswordPageButton() {
        final boolean isLoginCompletedViaRecoverPasswordPage = mainPage
                .clickPersonalAccountBtn()
                .clickRecoverPasswordBtn()
                .clickLoginBtn()
                .login(user.getEmail(), user.getPassword())
                .isUrlCorrectAfterLogin();
        assertTrue("Аутентификация со страницы восстановления пароля завершилась ошибкой", isLoginCompletedViaRecoverPasswordPage);
    }
}
