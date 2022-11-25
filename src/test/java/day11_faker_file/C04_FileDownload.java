package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //1- https://the-internet.herokuapp.com/download  adresine gidelim
        driver.get("https://the-internet.herokuapp.com/download");

        //2- testFile.txt dosyasini indirelim
        WebElement testFileLinki = driver.findElement(By.xpath("//a[text()='testFile.txt']"));
        testFileLinki.click();
        Thread.sleep(5000);
        //3- dosyanin basariyla indirilip indirilmedigini test edelim
        //dosya downloads'a indirilecektir, bize downloads'un dosya yolu lazim

        String farkliKisim = System.getProperty("user.home");
        String ortakKisim  = "\\Downloads\\testFile.txt";

        String arananDosyaYolu = farkliKisim+ortakKisim;

        //dosya yolundaki dosyanin var oldugunu assert edelim
        Assert.assertTrue(Files.exists(Paths.get(arananDosyaYolu)));



    }


}
