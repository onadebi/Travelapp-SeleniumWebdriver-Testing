import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import configs.BaseChromeTest;
import data.WebsiteData;

public class UserModule extends BaseChromeTest {

    @Test
    public void AdminLoginWithCorrectLogindDetails_Test() {
        _driver.get(WebsiteData.TravelAppUrl());

        _driver.findElement(By.xpath("//*[@id='container']/div[1]/button[1]")).click();
        _driver.findElement(By.name("Name")).sendKeys("capstone");
        _driver.findElement(By.name("Pwd")).sendKeys("info6068");

        _driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[1]/input")).click();
        try {
            Thread.sleep(2000);
            _driver.switchTo().frame("tgt");
            WebElement textBody = _driver.findElement(By.xpath("/html/body/h4"));
            String textBodyContent = textBody.getText();
            assertEquals("Welcome to EasyJourney: Online bus reservation.", textBodyContent.trim());
            System.out.println("Successfully logged in as a user!!!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    @Test
    public void AdminLoginWithWrongLogindDetails_Test() {
        _driver.get(WebsiteData.TravelAppUrl());

        _driver.findElement(By.xpath("//*[@id='container']/div[1]/button[1]")).click();
        _driver.findElement(By.name("Name")).sendKeys("capone");
        _driver.findElement(By.name("Pwd")).sendKeys("donjazzy");

        _driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[1]/input")).click();
        try {
            Thread.sleep(2000);
            _driver.switchTo().frame("tgt");
            WebElement textBody = _driver.findElement(By.xpath("/html/body/h4"));
            String textBodyContent = textBody.getText();
            assertEquals("Welcome to EasyJourney: Online bus reservation.", textBodyContent.trim());
            System.out.println("Successfully logged in as a user!!!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }


}
