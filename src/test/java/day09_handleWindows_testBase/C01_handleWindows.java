package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_handleWindows {


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
    public void test01() {
        //1- amazon ana sayfaya gidin
        driver.get("https://amazon.com");
        String ilkSayfaHandleDegeri = driver.getWindowHandle();

        //2- nutella icin arama yaptirin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);

        /*
        CDwindow-26D63500E1888D8B67A5D6B9E1B9D897
        bu kod acilan sayfanin unique hash kodudur
        selenium sayfalar arasi geciste bu window handle degerini kullanir

        eger sayfalar arasi driver'imizi gezdiriyorsak ve herhangi bir sayfana
        suanda bulundugumuz sayfaya gecmek istiyorsak
        driver.switchTo().window("CDwindow-26D63500E1888D8B67A5D6B9E1B9D897");
        bu sayfanin window handle degerini girerek bu sayfaya gecisi saglayabiliriz
         */

        //3- ilk urunun resmini tiklayarak farkli bir tab olarak acin
        WebElement ilkUrunResmi = driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"));
        driver.switchTo().newWindow(WindowType.TAB);
        /*
        bu komutu kullandigimizda driver otomatik olarak olusturulan//span[@id='productTitle']
        new Tab' gecer
        yeni tab'da gorevi gerceklestirmek icin
        adimlari bastan almamiz gerekir
         */

        driver.get("https://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();

        //4- yeni tab'da acilan urunun title'ini yazdirin
        WebElement urunTitleElementi = driver.findElement(By.xpath("//span[@id='productTitle']"));
        System.out.println(urunTitleElementi.getText());
        System.out.println(driver.getCurrentUrl());


        //ilk sayfaya gecip url'i yazdiralim
        driver.switchTo().window(ilkSayfaHandleDegeri);
        System.out.println(driver.getCurrentUrl());


    }
}