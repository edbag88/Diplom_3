import jdk.jfr.Description;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest {
    @Test
    @Description("checkBuns")
    public void checkBuns() {
        final boolean isGetBunsCorrect = mainPage
                .isIngredientsCorrect("Булки");
        assertTrue("Ошибка отображения булок", isGetBunsCorrect);
    }
    @Test
    @Description("проверить отображение заголовка после нажатия кнопки - соусы")
    public void checkSauces() {
        final boolean isGetSaucesCorrect = mainPage
                .clickSaucesBtn()
                .isIngredientsCorrect("Соусы");
        assertTrue("Ошибка отображения соусов", isGetSaucesCorrect);
    }

    @Test
    @Description("проверить отображение заголовка после нажатия кнопки - начинки")
    public void checkFillings() {
        final boolean isGetFillingsCorrect = mainPage
                .clickFillingBtn()
                .isIngredientsCorrect("Начинки");
        assertTrue("Ошибка отображения начинок", isGetFillingsCorrect);
    }

}
