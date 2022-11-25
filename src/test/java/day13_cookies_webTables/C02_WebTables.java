package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {

    @Test
    public void test01() {
         //login() methodu olusturun ve oturum acin
        // https://www.hotelmycamp.com    admin/HotelRoomAdmin adresine gidin
        //      username : manager
        //      passwoed : Manager1!
        girisYap();


        //table() methodu olusturun
        //     tum table body'sinin boyutunu(sutun sayisi) bulun./ tbody
        List<WebElement> sutunBasliklariListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("Sutun sayisi : " +sutunBasliklariListesi.size());

        //     Table'daki tum body'I ve basliklari(headers) konsolda yazdirin
        //tum body'yi bir string olarak yazdirmak isterseniz
        //body webElementini locate edip, getText() method'u ile yazdirabilirsiniz
        WebElement tumBody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());

        //printRows() methodu olusturun //tr
        //     table body'sinde bulunan toplam satir(row) sayisini bulun
        List<WebElement> satirlarListesi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Satir sayisi : " +satirlarListesi.size());

        //     table body'sinde bulunan satirlari(rows) konsolda yazdirin
        for (WebElement each: satirlarListesi
             ) {
            System.out.println(each.getText());

        }
        //     4. satirdaki(row) elementleri konsolda yazdirin
        List<WebElement> cellList = driver.findElements(By.xpath("//tbody//tr[4]//td"));
        for (WebElement each: cellList
             ) {
            System.out.println(each.getText());

        }
        // Email basligindaki tum elementleri(sutun) konsolda yazdirin
        //once email baslıgının kacıncı sutunda oldugunu bulalim
        List<WebElement> basliklarListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));
        int emailSutunNo= 0;
        for (int i = 0; i <basliklarListesi.size() ; i++) {
           if ( basliklarListesi.get(i).getText().equals("Email")){
               emailSutunNo=i;
           }

        }
        List<WebElement> emailSutununListesi =
                driver.findElements(By.xpath("//tbody//td["+(emailSutunNo+1)+"]"));
        for (WebElement each: emailSutununListesi) {
            System.out.println(each.getText());
        }


    }

    public void girisYap() {
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.linkText("Log in")).click();
        Actions actions = new Actions(driver);
        WebElement username = driver.findElement(By.id("UserName"));
        actions.click(username)
                .sendKeys("manager")
                .sendKeys(Keys.TAB)
                .sendKeys("Manager1!")
                .sendKeys(Keys.ENTER)
                .perform();




    }
}
