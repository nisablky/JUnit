package day09_handleWindows_testBase;

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
import java.util.Set;

public class C03_windowHandles {


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
        // https://the-internet.herokuapp.com/windows adresine gidin
        driver.get("https://the-internet.herokuapp.com/windows");

        //Sayfadaki textin "Opening a new window" oldugunu dogrulayin
        WebElement sayfadakiYaziElementi = driver.findElement(By.xpath("//h3"));
        String expectedYazi = "Opening a new window";
        String actualYazi = sayfadakiYaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        //Sayfa basliginin(title) "The Internet" oldugunu dogrulayin
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        /*
        eger kontrolsuz acilan bir tab veya window varsa
        o zaman sayfalarin window handle degerlerini elde etmem gerekir
        oncelikle 2.sayfa acilmadan once
        ilk sayfanin window handle degerini bir String'e atalim
         */

        String ilkSayfaWindowHandleDegeri = driver.getWindowHandle();
        System.out.println(ilkSayfaWindowHandleDegeri);
        



        //Click Here butonuna basin
        driver.findElement(By.linkText("Click Here")).click();
        /*
         switchTo().newWindow() demeden link tiklayarak yeni tab ve veya window olustugunda
         biz driver'a yeni sayfaya gec demedikce, driver eski sayfada kalir
         ve yeni sayfa ile ilgili hicbir islem yapamaz
         yeni sayfada driver'i calistirmak isterseniz
         once driver'i yeni sayfaya yollamalisiniz
         */

        /*
        yeni sayfaya gecebilmek icin oncelikle ikinciSayfaWindowHandleDegeri'ni bulmamiz gerekir
        bunun icin driver.getWindowHandles() method'unu kullanarak
        acik olan tum sayfalarin window handle degerlerini alip bir set' alip set'e assign ederiz.

        ilk sayfanin window handle degerini zaten biliyoruz
        Set'deki window handle degerine esit olmayan
        ikinci sayfanin window handle degeri deriz
         */

        Set<String> windowHandleSeti = driver.getWindowHandles();
        System.out.println(windowHandleSeti);

        String ikinciSayfaWindowHandleDegeri ="";
        for (String each: windowHandleSeti
             ) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                 ikinciSayfaWindowHandleDegeri=each;
            }
        }

        //artik ikinci sayfanin window handle degerini biliyoruz
        //rahatlikla sayfalar arasi gecis yapabiliriz
        driver.switchTo().window(ikinciSayfaWindowHandleDegeri);


        //Acilan yeni pencerenin sayfa basliginin (title) "New Window" oldugunu dogrulayin
        String expectedIkinciTitle ="New Window";
        String actualIkinciTitle = driver.getTitle();
        Assert.assertEquals(expectedIkinciTitle,actualIkinciTitle);

        //Sayfadaki textin "New Window" oldugunu dogrulayin
        WebElement ikinciSayfaYaziElementi = driver.findElement(By.xpath("//h3"));
        String expectedIkinciYazi = "New Window";
        String actualIkinciYazi = ikinciSayfaYaziElementi.getText();
        Assert.assertEquals(expectedIkinciYazi,actualIkinciTitle);

        //Bir onceki pencereye geri dondukten sonra sayfa basliginin "The Internet" oldugunu dogrulayin
        driver.switchTo().window(ilkSayfaWindowHandleDegeri);
         expectedTitle = "The Internet";
         actualTitle = driver.getTitle();
         Assert.assertEquals(expectedTitle,actualTitle);
    }
}
