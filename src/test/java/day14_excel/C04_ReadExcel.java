package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_ReadExcel {

    @Test
    public void test01() throws IOException {


        //dosya yolunu bir string degiskene atayalim
        String dosyYolu ="src/resources/baskentler-listesi.xlsx";

        //FileInputStream objesi olusturup, parametre olarak dosya yolunua girelim
        FileInputStream fis = new FileInputStream(dosyYolu);

        //Workbook objesi olusturalim, parametre olarak fileInputStream objesini girelim
        //WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);

        //ingilizce baskentler sutununu yazdiralim
        int sonSatir =workbook.getSheet("Table 1").getLastRowNum();
        System.out.println(sonSatir);
        String satirdakiData ="";

        for (int i = 0; i <=sonSatir; i++) {
            satirdakiData= C03_ReadExcel.banaDataGetir(i,1);
            System.out.println(satirdakiData);

        }
    }
}
