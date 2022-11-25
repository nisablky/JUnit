package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_Actions extends TestBase {

    @Test
    public void test01(){
        //1- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //2- cizili olan uzerinde sag click yapalim
        Actions actions = new Actions(driver);
        WebElement cizgiliAlanElementi = driver.findElement(By.id("hot-spot"));
        actions.contextClick(cizgiliAlanElementi).perform();

        //3- alert'te cikan yazinin "You selected a context menu" oldugunu test edelim
        String expectedYazi = "You selected a context menu";
        String actualYazi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        //4- tamam diyerek alert'i kapatalim
        driver.switchTo().alert().accept();

        //5- Elemental Selenium linkine tiklayalim
        String ilkSayfaWHDegeri = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        Set<String> handleSeti = driver.getWindowHandles();
        String ikinciSayfaWHDegeri = "";
        System.out.println(handleSeti);
        for (String each :handleSeti
             ) {
            if (!each.equals(ilkSayfaWHDegeri)){
                ikinciSayfaWHDegeri=each;

            }
            
        }

        //6- Acilan sayfada h1 taginda "Elemental Selenium" yazdigini test edelim
        driver.switchTo().window(ilkSayfaWHDegeri);
        WebElement yaziElementi = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        String expectedIkinciYazi = "Elemental Selenium";
        String actualIkinciYazi = yaziElementi.getText();
        Assert.assertEquals(expectedIkinciYazi,actualIkinciYazi);

    }
}
