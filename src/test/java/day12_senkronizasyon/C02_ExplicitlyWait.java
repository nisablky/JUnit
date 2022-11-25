package day12_senkronizasyon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExplicitlyWait extends TestBase {

    @Test
    public void test01() {
        //1- https://the-internet.herokuapp.com/dynamic_controls  adresine gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2- Textbox'İn etkin olmadigini(enabled) dogrulayin
        WebElement enableKutusu = driver.findElement(By.xpath("//input[@type=\"text\"]"));
        Assert.assertFalse(enableKutusu.isEnabled());

        //3- Enable butonuna tiklayin ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//button[text()=\"Enable\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(enableKutusu));

        //4- "It's enabled!" mesajinin goruntulendigini dogrulayin
        WebElement itsEnabledYaziElementi = driver.findElement(By.xpath("//p[text()=\"It's enabled!\"]"));
        Assert.assertTrue(itsEnabledYaziElementi.isDisplayed());

        //5- Textbox'in etkin oldugunu(enabled) dogrulayin
        Assert.assertTrue(enableKutusu.isEnabled());

    }
}
