package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_MavenTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2- Signin butonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        //3- Login alanine "username" yazdirin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");

        //4- Password alanine "password" azdirin
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");

        //5- Sign in buttonuna tiklayin (hata mesaji icin back tusuna tiklayin)
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        driver.navigate().back();

        //6- Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

        //7- amount kismina yaptirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//input[@name='amount']")).sendKeys("500");

        //8- tarih kismina "2020-09-10" yazdirin
        driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2020-09-10");

        //9- Pay buttonuna tiklayim
        driver.findElement(By.id("pay_saved_payees")).click();

        //10- "The payment was succerssfully submitted." mesajinin ciktigini control edin
        WebElement sonucYazisiElement =driver.findElement(By.xpath("//div[@id='alert_content']"));

        if (sonucYazisiElement.isDisplayed()){
            System.out.println("test PASSED");
        }else{
            System.out.println("test FAILED");
        }

        driver.close();
    }
}
