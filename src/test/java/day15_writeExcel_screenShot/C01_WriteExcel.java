package day15_writeExcel_screenShot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C01_WriteExcel {

    @Test
    public void test01() throws IOException {

        //1- adimlari takip ederek 1. satira kadar gidelim
        String dosyaYolu = "src/resources/baskentler-listesi.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        //2- 5. hucreye yeni bir cell olusturalim
        //3- olusturdugumuz hucreye "Nufus" yazdiralim
        workbook.
                getSheet("Table 1")
                .getRow(0)
                .createCell(4)
                .setCellValue("Nufus");

        //4- 2. satir nufus kolonunan 1500000 yazdiralim
        workbook.
                getSheet("Table 1")
                .getRow(1)
                .createCell(4)
                .setCellValue("1.500.000");

        //5- 10. satir nufus kolonuna 250000 yazdiralim
        workbook.
                getSheet("Table 1")
                .getRow(9)
                .createCell(4)
                .setCellValue(250000);

        //6- 15. satir kolonuna 54000 yazdiralim
        workbook.
                getSheet("Table 1")
                .getRow(14)
                .createCell(4)
                .setCellValue(54000);

        //7- dosyayi kaydedelim
        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        workbook.write(fos);

        //8- dosyayi kapatalim
        workbook.close();
        fis.close();
        fos.close();

    }
}
