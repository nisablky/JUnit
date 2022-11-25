package day08_alerts_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Alerts {

    // https://the-internet.herokuapp.com/javascript_alerts  adresine gidin


    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();

    }

    @Test
    public void acceptAlert() {
        //    1. butona tiklayin, yukaridaki OK butonuna tiklayin ve result mesajinin
        //    "You successfully clicked an alert" oldugunu test edin
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        String axpectedResultYazisi = "You successfully clicked an alert";
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//p[@id='result']"));
        String actualResultYazisi = sonucYaziElementi.getText();

        Assert.assertEquals(axpectedResultYazisi,actualResultYazisi);

    }

    @Test
    public void dismissAlert() {
        //    2. butona tiklayin, uyaridaki Cancel butonuna tiklayin ve result mesajinin
        //      succesfully" icermedigini test edin
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        String istenmeyenKelime = "succesfully";
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//*[text()='You clicked: Cancel']"));
        String actualSonucYazisi = sonucYaziElementi.getText();

        Assert.assertFalse(istenmeyenKelime.contains(actualSonucYazisi));


    }

    @Test
    public void sendKeysAlert() {
        //    3. butona tiklayin, uyaridaki metin kutusuna isminizi yazin,
        //    OK butonun tiklayin ve result mesajinda isminizin goruntulendigini dogrulayin
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("Nisa BALKAYA");
        driver.switchTo().alert().accept();
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//p[@id='result']"));
        String sonucYazisiStr = sonucYaziElementi.getText();
        String girilenIsim ="Nisa BALKAYA";

        Assert.assertTrue(sonucYazisiStr.contains(girilenIsim));


    }
}
