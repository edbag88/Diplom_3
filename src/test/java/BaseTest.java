import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;
import pages.MainPage;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static pages.MainPage.MAIN_PAGE_URL;

public class BaseTest {
    MainPage mainPage;
    @Before
    public void startBrowser() {
        mainPage = Selenide.open(MAIN_PAGE_URL, MainPage.class);
        Configuration.browserSize = "1980x1000";
    }
    @After
    public void tearDown() {
        closeWebDriver();
    }

}
