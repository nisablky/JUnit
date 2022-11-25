package pratic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class test01 {



    @Test
    public void tekrar(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.google.com/");

        //sayfa basliginin "Google" ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        String arananKelime ="Google";
        if (actualTitle.contains(arananKelime)){
            System.out.println("Title testi PASSED");
        }else{
            System.out.println("Title testi FAILED");
        }

        //Arama cubuguna "Nutella" yazdirin
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Nutella");

        //Buttona tiklayin
        driver.findElement(By.xpath("//input[@class='gNO89b']")).click();

        //sonuc sayisini yazdirin
       WebElement sonucSayisi =driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonucSayisi.getText());

        //sonuc sayisinin 10 milyon'dan fazla oldugunu test edin
       int actualSayi= driver.hashCode();
       int arananSayi= 10000000;
       if (actualSayi>arananSayi){
           System.out.println("sonuc sayisi PASSED");
       }else {
           System.out.println("sonuc sayisi FAILED");
       }

       driver.close();





    }
}
