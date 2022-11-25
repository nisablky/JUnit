package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {

    @Test
    public void test01() throws IOException {
        //input olarak verilen
        //satirNou, sutunNo degerlerini parametre olarak alip
        //0 cell'deki datayi String olarak bana donduren bir method olusturun

        int satirNo =12;
        int sutunNo =3;

        //donen String'in Kabul oldugunu test edin
        String expectedData = "Kanberra";

        String actualData=  banaDataGetir(satirNo-1,sutunNo-1); //cunku excel index ile calisir
        Assert.assertEquals(expectedData,actualData);
    }

    public static String banaDataGetir(int satirIndex, int sutunIndex) throws IOException {
        String istenenData ="";
        String dosyaYolu ="src/resources/baskentler-listesi.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        istenenData =workbook
                .getSheet("Table 1")
                .getRow(satirIndex)
                .getCell(sutunIndex)
                .toString();


        return istenenData;
    }
}
