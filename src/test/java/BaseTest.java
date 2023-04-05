import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static pages.MainPage.MAIN_PAGE_URL;

public class BaseTest {
    MainPage mainPage;

    @Before
    public void startBrowser() {
        //Для прогона через Яндекс убрать комментарии
        //ChromeDriver driver;
        //System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
        //driver = new ChromeDriver();
        //WebDriverRunner.setWebDriver(driver);
        mainPage = Selenide.open(MAIN_PAGE_URL, MainPage.class);
        Configuration.browserSize = "1980x1000";
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }
}
