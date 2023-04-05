import jdk.jfr.Description;
import models.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BaseTest {
    User user;

    @Before
    public void startUp() {
        user = User.getRandom();
    }

    @Test
    @Description("Проверка регистрации пользователя")
    public void successfulRegistration() {
        final boolean isRegistrationComplited = mainPage
                .clickPersonalAccountBtn()
                .clickSignupBtn()
                .signup(user)
                .isLoginBtnDisplayed();
        assertTrue("Регистрация пользователя завершилась ошибкой", isRegistrationComplited);
    }

    @Test
    @Description("Проверка регистрации пользователя. Заполнить поле пароль 5 символов.")
    public void registrationWithInvalidPassword() {
        user.setPassword(RandomStringUtils.randomAlphanumeric(5));
        final boolean isRegistrationEndedWithError = mainPage
                .clickPersonalAccountBtn()
                .clickSignupBtn()
                .signupWithError(user)
                .isPasswordErrorCorrect();
        assertTrue("Ошибка неверной длины пароля отсутствует или имеет неверный текст", isRegistrationEndedWithError);
    }
}
