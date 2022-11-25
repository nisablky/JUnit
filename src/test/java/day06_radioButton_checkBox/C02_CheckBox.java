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

public class C02_CheckBox {

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown(){
        driver.close();
    }


    @Test
    public void test01() throws InterruptedException {
        //1- Verilen web sayfasina gidin
        //2- https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //3- Checkbox1 ve checkbox2 elementlerini locate edin
       WebElement checkBox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
       WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        //4- Checkbox1 secili degilse onay kutusuna tiklayin
        Thread.sleep(3000);
        if (!checkBox1.isSelected()){
            checkBox1.click();
        }
        //5- Checkbox2 secili degilse onay kutusunu tiklayin
        Thread.sleep(3000);
        if (!checkBox2.isSelected()){
            checkBox2.click();
        }
        Thread.sleep(3000);
    }
}
