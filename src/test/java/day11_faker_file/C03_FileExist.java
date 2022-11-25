package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {

    @Test
    public void test01() {

        System.out.println(System.getProperty("user.dir"));
        //bana icinde oldugum projenin dosya yolunu(path) verir

        System.out.println(System.getProperty("user.home"));
        // C:\Users\nisan  yani benim bilgisayarimin bana ozel kismini verir

        //homePath + "\Downloads"
        //C:\Users\nisan\Downloads

        //masa ustumuzdeki text dosyasinin varligini test edelim
        //"C:\Users\nisan\Desktop\text.txt"
        String dosyaYolu= System.getProperty("user.home") + "\\Desktop\\text.txt";
        System.out.println(dosyaYolu);

        /*
        bilgisayarimizdaki bir dosyanin varligini test etmek icin
        once o dosyaya ulasmamız gerekir
        Java'da dosyay erisim icin dosya yoluna (path) ihtiyac vardir
        Her bilgisayarin kullanici adi farkli olacagindan
        masaustu dosya yolu da birbirinden farkli olacaktir
        Testlerimizin tum bilgisayarlarda calismasi icin dosya yolunu DİNAMİK yapmak zorundayiz

        Bunun icin
        her bilgisayarin birbirinden farkli olan yolunu bulmak icin

         */

        String farkliKisim = System.getProperty("user.home");

        //herkesin bilgisayarinda ortak olan kisim ise
        String ortakKisim ="\\Desktop\\text.txt";

        String masaustuDosyYolu = farkliKisim + ortakKisim ;

        Assert.assertTrue(Files.exists(Paths.get(masaustuDosyYolu)));

    }
}
