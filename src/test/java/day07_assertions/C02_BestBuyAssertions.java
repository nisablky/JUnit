package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BestBuyAssertions {
    /*
    https://www.bestbuy.com/ adresine gidin
     */

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");

    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){
        //sayfa Url'inin https://www.bestbuy.com/'a esit oldugunu test edin
        String expectedUrl= "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @Test
    public void test02(){
       // titleTest --> sayfa basliginin "Rest" icermedigini(contains) test edin
        String istenmeyenKelime ="Rest";
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));
    }

    @Test
    public void test03(){
       // logoTest --> BestBuy logosunun goruntulendigini test edin
        WebElement logoElementi = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logoElementi.isDisplayed());
    }

    @Test
    public void test04() throws InterruptedException {
       // FrancaisLinkTest --> Fransizca Linkin goruntulendigini test edin
       WebElement francaisElementi = driver.findElement(By.xpath("//button[@lang='fr']"));
       Thread.sleep(3000);
       Assert.assertTrue(francaisElementi.isDisplayed());
    }
}
