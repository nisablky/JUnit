package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        //1- https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");

        //2- "Create an Account" button'una basin
        driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();

        // "radio buttons" elementlerini locate edin
        WebElement femaleButton = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement maleButton = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement cutomButton = driver.findElement(By.xpath("//input[@value='-1']"));

        // Secili degilse cinsiyet buttonuna size uygun olani secin

        Thread.sleep(3000);
        if (!femaleButton.isSelected()){
            femaleButton.click();
        }
        Thread.sleep(3000);
    }

}
