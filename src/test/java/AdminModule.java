import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import configs.BaseChromeTest;
import data.WebsiteData;

public class AdminModule extends BaseChromeTest {

    @Test
    public void HomePageHasTitle() {
        _driver.get(WebsiteData.TravelAppUrl());
        String title = _driver.getTitle();
        System.out.println("Title: " + title);
        assertTrue(title.isBlank() == false);
    }

    @Test
    public void AdminLoginWithCorrectLogindDetails_Test() {
        _driver.get(WebsiteData.TravelAppUrl());

        _driver.findElement(By.xpath("//*[@id='container']/div[1]/button[2]")).click();
        _driver.findElement(By.name("Name")).sendKeys("admin");
        _driver.findElement(By.name("Pwd")).sendKeys("admin");

        _driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[1]/input")).click();
        try {
            Thread.sleep(5000);
            // #region OLD CODE
            // WebElement adminLandingPageBody =
            // _driver.findElement(By.xpath("/html/body/table/tbody"));
            // String adminLandingPageBodyText = adminLandingPageBody.getText();
            // assertEquals("Administrator Options", adminLandingPageBodyText);

            // ==================

            // WebElement viewRoutes = _driver.findElement(By.name("ViewRoutes"));
            // viewRoutes.click();

            // WebElement getRoutesList =
            // _driver.findElement(By.xpath("/html/body/table/tbody")); /html/body/h4
            // String adminLandingPageBodyText = adminLandingPageBody.getText();
            // ================
            // _driver.findElement(By.cssSelector("td:nth-child(1) > input")).click();
            // WebElement adminPageContent = _driver.findElement(By.cssSelector("h4"));

            // assertEquals("Administrator Options", adminLandingPageBodyText);
            // #endregion

            _driver.switchTo().frame(1);
            WebElement textBody = _driver.findElement(By.xpath("/html/body/h4"));
            String textBodyContent = textBody.getText();
            assertEquals("Administrator Options", textBodyContent.trim());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    @Test
    public void AdminLoginWithWrongLogindDetails_Test() {
        _driver.get(WebsiteData.TravelAppUrl());

        _driver.findElement(By.xpath("//*[@id='container']/div[1]/button[2]")).click();
        _driver.findElement(By.name("Name")).sendKeys("asdf");
        _driver.findElement(By.name("Pwd")).sendKeys("lkj");

        _driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[1]/input")).click();
        try {
            Thread.sleep(5000);
            
            _driver.switchTo().frame(1);
            WebElement textBody = _driver.findElement(By.xpath("/html/body/h4"));
            String textBodyContent = textBody.getText();
            assertNotEquals("Administrator Options", textBodyContent.trim());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}
