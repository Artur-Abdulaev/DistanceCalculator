package distanceBetweenToPointsOnMap.apachePOI;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class WritingExcel {

    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Emp Info");

        Object empdata[][] = {
                {"EmpID", "Name", "Job"},
                {101, "Name", "Job"},
                {102, "Name", "Job"},
                {103, "Name", "Job"}
        };

        /*//Using for loop
        int rows = empdata.length;
        int cols = empdata[0].length;

        System.out.println(rows); // 4
        System.out.println(cols); // 3

        for (int r = 0; r < rows; r++)
        {
            XSSFRow row = sheet.createRow(r);

            for(int c = 0; c < cols; c++)
            {
                XSSFCell cell = row.createCell(c);
                Object value = empdata[r][c];

                if(value instanceof String)
                    cell.setCellValue((String)value);
                if(value instanceof Integer)
                    cell.setCellValue((Integer)value);
                if(value instanceof Boolean)
                    cell.setCellValue((Boolean)value);

            }
        }*/

        //using for ... each loop
        int rowCount = 0;

        for (Object emp[] : empdata) {
            XSSFRow row = sheet.createRow(rowCount++);
            int columnCount = 0;
            for (Object value : emp) {
                XSSFCell cell = row.createCell(columnCount++);

                if (value instanceof String)
                    cell.setCellValue((String) value);
                if (value instanceof Integer)
                    cell.setCellValue((Integer) value);
                if (value instanceof Boolean)
                    cell.setCellValue((Boolean) value);
            }
        }

        String filePath = "C:/Users/А/Desktop/ExcelForPOI/DataFor.xlsx";
        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);

        outputStream.close();

        System.out.println("DataFor.xlsx file written successfully");

    }

    public static void excelWriter(Object[][] dataWorWrite, String linkFileToWrite) throws IOException {
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
