package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_ReadExcel {

    @Test
    public void test01() throws IOException {


        //dosya yolunu bir string degiskene atayalim
        String dosyYolu ="src/resources/baskentler-listesi.xlsx";

        //FileInputStream objesi olusturup, parametre olarak dosya yolunua girelim
        FileInputStream fis = new FileInputStream(dosyYolu);

        //Workbook objesi olusturalim, parametre olarak fileInputStream objesini girelim
        //WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);

        //sayfa 2'ye gidip
        //satir sayisinin 175, kullanilan satir sayisinin ise 175 oldugunu test edin

        int sonStirIndex = workbook
                .getSheet("Table 2")
                .getLastRowNum();

        int expectedSatirSayisi =175;
        Assert.assertEquals(expectedSatirSayisi,sonStirIndex+1);

        int kullanilanSatirSayisi = workbook
                .getSheet("Table 2")
                .getPhysicalNumberOfRows();

        int expectedKullanilanSatirSayisi =175;
        Assert.assertEquals(expectedKullanilanSatirSayisi,kullanilanSatirSayisi);


    }
}
