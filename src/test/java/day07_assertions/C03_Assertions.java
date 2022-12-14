package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertions {

     WebDriver driver;

    @Before
    public  void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public  void tearDown(){
       driver.close();
    }

    @Test
    public void test01(){
        //https://automationpratice.com/index.php sayfasina gidelim
        driver.get("http://automationpractice.com/index.php");

        //Sign in botonuna basalim
        driver.findElement(By.xpath("//a[@class='login']")).click();

        // Email kutusuna @isareti olmayan bir mail yazip enter'a bastigimizda
        WebElement mailKutusu= driver.findElement(By.xpath("//input[@id='email_create']"));
        mailKutusu.sendKeys("mehmetgmail.com"+ Keys.ENTER);

        // "Invalid email address" uyarisi test edelim
       WebElement uyariYazisiElementi = driver.findElement(By.xpath("//*[text()='Invalid email address.']"));
       Assert.assertTrue(uyariYazisiElementi.isDisplayed());


    }
}
