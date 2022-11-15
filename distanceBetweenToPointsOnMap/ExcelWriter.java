package distanceBetweenToPointsOnMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWriter {

    public static void writer(Object[][] dataWorWrite, String linkFileToWrite) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Emp Info");

        int rowCount = 0;

        for (Object emp[] : dataWorWrite) {
            XSSFRow row = sheet.createRow(rowCount++);
            int columnCount = 0;

            for (Object value : emp) {
                XSSFCell cell = row.createCell(columnCount++);

                if (value instanceof String)
                    cell.setCellValue((String) value);
                if (value instanceof Number)
                    cell.setCellValue((Double) value);
                if (value instanceof Boolean)
                    cell.setCellValue((Boolean) value);
            }
        }

        String filePath = linkFileToWrite;
        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);

        outputStream.close();

        System.out.println("Вычисление дистанций до ближайших ОПС успешно проведено");

    }
}