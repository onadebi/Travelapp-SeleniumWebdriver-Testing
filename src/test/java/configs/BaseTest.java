package configs;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Paths;
import java.time.Duration;

public class BaseTest {

    protected WebDriver _driver;

    public BaseTest() {
        System.out.println("****Constructor - Initializing Chrome Driver");
        //get current directory
        String currentDir = System.getProperty("user.dir");
        String fullPath = Paths.get(currentDir, "drivers","X64", "chromedriver.exe").toString();
        System.setProperty("webdriver.chrome.driver", fullPath);
    }

    protected ChromeDriver startChromeDriver(){
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless");
        options.setImplicitWaitTimeout(Duration.ofSeconds(1));
        ChromeDriver driver =  startChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    protected ChromeDriver startChromeDriver(ChromeOptions options){
        if(options != null){
            _driver  = new ChromeDriver(options);
        }
        else{
            startChromeDriver();
        }
        return (ChromeDriver)_driver;
    }

    @AfterEach
    public void tearDown(){
        if(_driver != null){
            System.out.println("****TearDown - Closing Driver");
            _driver.quit();
        }
    }
}
