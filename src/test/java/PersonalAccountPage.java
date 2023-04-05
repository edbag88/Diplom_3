import clients.UserClient;
import jdk.jfr.Description;
import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PersonalAccountPage extends BaseTest {
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
    @Description("Проверка перехода по клику на Личный кабинет.")
    public void successfulLoginViaLoginToAccountButton() {
        pages.PersonalAccountPage personalAccountPage = mainPage
                .clickLogInToYourAccountBtn()
                .login(user.getEmail(), user.getPassword())
                .clickPersonalAccountBtnFromAccount();
        final boolean isPersonalAccountPageDisplayedCorrect = personalAccountPage
                .isProfileBtnDisplayed();
        assertTrue("Переход в личный кабинет после аутентификации не выполнен", isPersonalAccountPageDisplayedCorrect);
        // проверка правильности отображения имени и почты в личном кабинете
        assertEquals(personalAccountPage.getNameValue(), user.getName());
        assertEquals(personalAccountPage.getLoginValue(), user.getEmail().toLowerCase(Locale.ROOT));
    }
}
