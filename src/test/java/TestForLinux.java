import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestForLinux {
   public WebDriver driver;

   @Test
   public void firstTest() throws InterruptedException, IOException {
       System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
       ChromeOptions chromeOptions = new ChromeOptions();
       chromeOptions.setBinary("/usr/bin/google-chrome-stable");
       chromeOptions.addArguments("--headless");
       chromeOptions.addArguments("--ignore-certificate-errors");
       chromeOptions.addArguments("--no-sandbox");
       chromeOptions.addArguments("--disable-dev-shm-usage");
       chromeOptions.addArguments("--disable-gpu");
       driver = new ChromeDriver(chromeOptions);
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.manage().window().maximize();

       driver.get("https://lista.atzma.im/en/home");

       String title = driver.findElement(By.cssSelector("h1")).getText();
       System.out.println(title);
       Assert.assertEquals(title, "Manage Business Easily");

       Thread.sleep(5000);
       driver.quit();
       Runtime.getRuntime().exec("killall chromedriver");
       Runtime.getRuntime().exec("killall chrome");
   }
}
