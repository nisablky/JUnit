package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C06_DropDown {


    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
       driver.quit();

    }

    @Test
    public void test01() throws InterruptedException {
        // https://the-internet.herokuapp.com/dropdown
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //1- Index kullanarak secenek1'i (Option 1) secin ve yazdirin
        WebElement ddm= driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(ddm);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        //2- Value kullanarak secenek2'yi (Option 2) secin ve yazdirin
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        //3- Visible Text (Gorunen metin) kullanarak secenek1'i (Option 1) secin ve yazdirin
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        //4- Tum dropdrown option'i yazdirin
        List<WebElement> tumOpsiyonlar = select.getOptions();

        for (WebElement each: tumOpsiyonlar
             ) {
            System.out.println(each.getText());
        }

        //5- DropDrown'un boyutunu bulun, DropDrow'da 4 ege varsa konsolda True, degilse False yazdirir
        int dropdowBoyut = tumOpsiyonlar.size();
        if (dropdowBoyut==4){
            System.out.println("true");
        }else{
            System.out.println("false");
        }


    }

}
