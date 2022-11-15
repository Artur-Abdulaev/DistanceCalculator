package distanceBetweenToPointsOnMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;


public class ReaderFromExcel {

    public static StringBuilder excelReaderPotentialOffices(String link) throws IOException {
        String excelFilePath = link;
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        Iterator iterator = sheet.iterator();

        StringBuilder sb = new StringBuilder("");

        boolean isNum = false;
        while (iterator.hasNext()) {
            XSSFRow row = (XSSFRow) iterator.next();
            Iterator cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                XSSFCell cell = (XSSFCell) cellIterator.next();
                switch (cell.getCellType()) {
                    case STRING:

                        sb.append(cell.getStringCellValue()).append("\t");

                        break;
                    case NUMERIC:
                        if (!isNum) {
                            sb.append(cell.getNumericCellValue()).append("\t");
                            isNum = true;
                        } else {
                            sb.append(cell.getNumericCellValue()).append("\n");
                            isNum = false;
                        }
                        break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                        break;
                }
            }
        }

        inputStream.close();
        return sb;
    }

    public static StringBuilder excelReaderActualOffices(String link) throws IOException {
        String excelFilePath = link;
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        Iterator iterator = sheet.iterator();

        StringBuilder sb = new StringBuilder("");
        int count = 0;
        while (iterator.hasNext()) {
            XSSFRow row = (XSSFRow) iterator.next();
            Iterator cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                XSSFCell cell = (XSSFCell) cellIterator.next();
                switch (cell.getCellType()) {
                    case STRING:
                        sb.append(cell.getStringCellValue()).append("\t");
                        break;
                    case NUMERIC:
                        if (count < 2) {
                            sb.append(cell.getNumericCellValue()).append("\t");
                            count++;
                        } else {
                            sb.append(cell.getNumericCellValue()).append("\n");
                            count = 0;
                        }
                        break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                        break;
                }
            }
        }

        return sb;
    }
}

