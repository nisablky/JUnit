package day14_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void test01() throws IOException {

        //dosya yolunu bir string degiskene atayalim
        String dosyaYolu ="src/resources/baskentler-listesi.xlsx";

        //FileInputStream objesi olusturup, parametre olarak dosya yolunua girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);

        //Workbook objesi olusturalim, parametre olarak fileInputStream objesini girelim
        //WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);

        //Sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet = workbook.getSheet("Table 1");

        //Row objesi olusturun sheet.getRow(index)
        Row row = sheet.getRow(3);

        //Cell objesi olusturun row.getCell(index)
        Cell cell = row.getCell(3);

        System.out.println(cell);

        //3.index'deki satirin 3. index'indeki datanin Kabul oldugunu test edin
        String expectedData ="Kabul";
        String actualData = cell.toString();

        Assert.assertEquals(expectedData,actualData);
       // Assert.assertEquals(expectedData,cell.getStringCellValue());

    }
}
