package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_KeyboardActions extends TestBase {

    @Test
    public void test01(){
        //facebook anasayfaya gidip
        driver.get("https://www.facebook.com");

        //yeni kayit olustur butonuna basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        //isim kutusunun locate edip,
        WebElement isimKutusu = driver.findElement(By.xpath("//input[@name='firstname']"));

        //geriye kaln alanlari TAB ile dolasarak
        //formu doldurun

        Actions actions = new Actions(driver);
        actions.click(isimKutusu)
                .sendKeys("Talha")
                .sendKeys(Keys.TAB)
                .sendKeys("Ustaoglu")
                .sendKeys(Keys.TAB)
                .sendKeys("jdjgddlk@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("jdjgddlk@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345buKL")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("Jan")
                .sendKeys(Keys.TAB)
                .sendKeys("15")
                .sendKeys(Keys.TAB)
                .sendKeys("2000")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
    }

}
