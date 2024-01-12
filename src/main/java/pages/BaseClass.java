package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import listener.TestCaseListener;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.util.concurrent.TimeUnit;


@Listeners(TestCaseListener.class)
public class BaseClass {
    Logger log = LogManager.getLogger(BaseClass.class);
    private static final String BROWSER = "chrome";
    private static final boolean HEADLESS = false;
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void login(){
    }
    public BaseClass(String url){
        WebDriverManager.chromedriver().setup();
        createLocalWebDriver().get(url);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();;
    }

    public BaseClass(){
        createLocalWebDriver();
    }

    private WebDriver createLocalWebDriver(){
        try {
            switch (BROWSER) {
                case "firefox":
                    setDriver(new FirefoxDriver());
                    break;
                case "chrome":
                    setDriver(new ChromeDriver());
                    break;
                default:
                    throw new Exception(BROWSER + " is not supported");
            }
            log.info("Yulgun Kaiser Created new browser");
        }catch (Exception e){
            e.printStackTrace();
        }
        return getDriver();
    }

    private MutableCapabilities getCapabilities(){
        MutableCapabilities caps = null;
        try {
            switch (BROWSER) {
                case "firefox":
                    if (!HEADLESS) {
                        caps = new FirefoxOptions();
                    } else {
                        log.info("Headless firefox is not supported by framework");
                    }
                    break;
                case "chrome":
                    caps = new ChromeOptions();
                    break;
                default:
                    throw new Exception(BROWSER + " is not supported");
            }
            log.info("Created new browser - {}", driver.getClass());
            return caps;
        }catch (Exception e){
            e.printStackTrace();
        }
        return caps;
    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass(){

    }

    @AfterClass
    public void afterClass(){

    }

}
