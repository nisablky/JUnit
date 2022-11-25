package day14_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {

    @Test
    public void test01() throws IOException {

        //dosya yolunu bir string degiskene atayalim
        String dosyYolu ="src/resources/baskentler-listesi.xlsx";
        
        //FileInputStream objesi olusturup, parametre olarak dosya yolunua girelim
        FileInputStream fis = new FileInputStream(dosyYolu);

        //Workbook objesi olusturalim, parametre olarak fileInputStream objesini girelim
        //WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);

        //Sheet objesi olusturun workbook.getSheetAt(index)
        //Row objesi olusturun sheet.getRow(index)
        //Cell objesi olusturun row.getCell(index)
        //3.index'deki satirin 3. index'indeki datanin Kabul oldugunu test edin

        String actualData = workbook
                .getSheet("Table 1")
                .getRow(3)
                .getCell(3)
                .toString();



       

    }
}
