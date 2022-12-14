package day12_senkronizasyon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitlyWait extends TestBase {
    //1- iki tane method olusturun : implicitlyWit(), explicitWait()

    @Test
    public void test01() {
        //2- https://the-internet.herokuapp.com/dynamic_controls  adresine gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //3- Remove butonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //4- "It's gone!" mesajinin goruntulendigini dogrulayin
        WebElement itsGoneYaziElementi = driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        Assert.assertTrue(itsGoneYaziElementi.isDisplayed());

        //5- Add butonuna basin
         driver.findElement(By.xpath("//button[text()=\"Add\"]")).click();

        //6- It's back mesajinin gorundugunu test edin
        WebElement itsBackElementi = driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));
        Assert.assertTrue(itsBackElementi.isDisplayed());
        

    }


    @Test
    public void test02() {
        //2- https://the-internet.herokuapp.com/dynamic_controls  adresine gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //3- Remove butonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //4- "It's gone!" mesajinin goruntulendigini dogrulayin
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        /*
        WebElement itsGoneYaziElementi = driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        wait.until(ExpectedConditions.visibilityOf(itsGoneYaziElementi));
        Assert.assertTrue(itsGoneYaziElementi.isDisplayed());

        yazinin gorunur olmasini beklerken yazinin locate'ini kullanmak sorun olusturur
        cunku henuz gorunmeyen bir yazinin locate edilmesi de mumkun olmayabilir
        (HTML kodlari developer farkli uygulamalar yapabilir)
        bu durumda bekleme islemi ve locate'i birlikte yapmaliyiz

         */

        WebElement itsGoneYaziElementi = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()=\"It's gone!\"]")));
        Assert.assertTrue(itsGoneYaziElementi.isDisplayed());


        //5- Add butonuna basin
        driver.findElement(By.xpath("//button[text()=\"Add\"]")).click();

        //6- It's back mesajinin gorundugunu test edin
        WebElement itsBackElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's back!\"]")));
        Assert.assertTrue(itsBackElementi.isDisplayed());

    }
}
