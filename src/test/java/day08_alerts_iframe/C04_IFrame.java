package day08_alerts_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_IFrame {
    // https://the-internet.herokuapp.com/iframe


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
        driver.get("https://the-internet.herokuapp.com/iframe");

        //"An IFrame containinf..." testinin erisilebilir oldugunu test edin
        //  ve konsolda yazdirin
        WebElement baslikElementi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslikElementi.isEnabled());
        System.out.println(baslikElementi.getText());

        //Text Box'a "Merhaba Dunya!" yazin.
        //textbox'i dogruolarak locate etmemize ragmen driver bulamadı
        //bunun  uzerine HTML kodlari inceleyince
        //textbox'in aslinda bir IFrame icerisinde oldugunu gorduk
        //bu durumda once iframe'i locate edip
        //switchTo() ile o iFrame'e gecmeliyiz

        WebElement iFrameElementi = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrameElementi);

        WebElement textKutusu = driver.findElement(By.xpath("//body[@id='tinymce']"));
        textKutusu.clear();
        textKutusu.sendKeys("Merhaba Dunya");

        //TextBox'in altinda bulunan "Elemental Selenium"
        // linkini textinin gorunur oldugunu dogrulayin ve konsola yazdirin

        //link yazi elemnetini dogru elocate etmemize ragmen yazdirmadi
        //cunku yukarida iFrame'e gecis yapmistik
        //once cikmamiz lazim

        driver.switchTo().defaultContent();

        WebElement linkYaziElementi = driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(linkYaziElementi.isDisplayed());
        System.out.println(linkYaziElementi.getText());


        Thread.sleep(5000);
    }
}
