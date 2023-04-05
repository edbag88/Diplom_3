import clients.UserClient;
import jdk.jfr.Description;
import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LogoutTest extends BaseTest {
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
    @Description("Проверка выхода по кнопке «Выйти» в личном кабинете.")
    public void successLogout() {
        final boolean isLogoutCorrect = mainPage
                .clickLogInToYourAccountBtn()
                .login(user.getEmail(), user.getPassword())
                .clickPersonalAccountBtnFromAccount()
                .clickLogoutBtn()
                .isLoginBtnDisplayed();
        assertTrue("Ошибка выхода из личного кабинета", isLogoutCorrect);
    }
}
