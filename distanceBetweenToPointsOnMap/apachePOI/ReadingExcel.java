package distanceBetweenToPointsOnMap.apachePOI;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ReadingExcel {


    public static void main(String[] args) throws IOException {

        String excelFilePath = "C:/Users/À/Desktop/ExcelForPOI/DataForRead.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        // USING FOR LOOP

        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(1).getLastCellNum();

        for (int r = 0; r <= rows; r++)
        {
            XSSFRow row = sheet.getRow(r);

            for (int c = 0; c < cols; c++)
            {
                    XSSFCell cell = row.getCell(c);

                    switch (cell.getCellType())
                    {
                        case STRING : System.out.print(cell.getStringCellValue()); break;
                        case NUMERIC: System.out.print(cell.getNumericCellValue()); break;
                        case BOOLEAN: System.out.print(cell.getBooleanCellValue()); break;
                }
                System.out.println(" ");
            }

        }

        /////////Iterator/////////

        Iterator iterator = sheet.iterator();

        String s = "";

        boolean isNum = false;
        while (iterator.hasNext()) {
            XSSFRow row = (XSSFRow) iterator.next();
            Iterator cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                XSSFCell cell = (XSSFCell) cellIterator.next();
                switch (cell.getCellType()) {
                    case STRING:
                        s += cell.getStringCellValue() + "\t";

                        break;
                    case NUMERIC:
                        if (!isNum) {
                            s += String.valueOf(cell.getNumericCellValue()) + "\t";
                            isNum = true;
                        } else {
                            s += String.valueOf(cell.getNumericCellValue()) + "\n";
                            isNum = false;
                        }
                        break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                        break;
                }
            }
        }
        System.out.println(s);

        inputStream.close();
    }






}




