package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C06_ReadExcel {

    @Test
    public void test01() throws IOException {
        //excel dosyasindaki tum verileri alip
        //bir Java objesine store edelim
        //boylece her seferinde excel'e ulasip satir, sutun vs.. ugrasmayalim

        //database yapisinda olan excel'i
        // koyabilecegimiz en uygun java objesi map'dir

        Map<String,String> ulkelerMap = new HashMap<>();

        //dosya yolunu bir string degiskene atayalim
        String dosyYolu ="src/resources/baskentler-listesi.xlsx";

        //FileInputStream objesi olusturup, parametre olarak dosya yolunua girelim
        FileInputStream fis = new FileInputStream(dosyYolu);

        //Workbook objesi olusturalim, parametre olarak fileInputStream objesini girelim
        //WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);
        int sonSatirIndex = workbook.getSheet("Table 1").getLastRowNum();

        for (int i = 0; i <=sonSatirIndex ; i++) {
            //key i. satirindaki 0 indexindeki data olacak
           String key =  workbook.getSheet("Table 1").getRow(i).getCell(0).toString();

           //value ise i. satirindaki 1,2 ve 3. index'deki datalarin birlesimi olacak
            String value = workbook.getSheet("Table 1").getRow(i).getCell(1).toString()
                    + ", "
                    + workbook.getSheet("Table 1").getRow(i).getCell(2).toString()
                    +", "
                    +workbook.getSheet("Table 1").getRow(i).getCell(3).toString();

            ulkelerMap.put(key,value);


        }
        System.out.println(ulkelerMap);


    }
}
