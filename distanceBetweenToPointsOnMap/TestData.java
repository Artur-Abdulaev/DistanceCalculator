package distanceBetweenToPointsOnMap;

import java.io.IOException;

import static distanceBetweenToPointsOnMap.ReaderFromExcel.excelReaderActualOffices;
import static distanceBetweenToPointsOnMap.ReaderFromExcel.excelReaderPotentialOffices;


class TestData {

    static StringBuilder actualOffice;
    static StringBuilder potentialOffice;
    static {
        try {
            potentialOffice = excelReaderPotentialOffices("C:/Users/�/Desktop/ExcelForPOI/PotentialOffices.xlsx");
            actualOffice = excelReaderActualOffices("C:/Users/�/Desktop/ExcelForPOI/ActualOffices.xlsx");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static StringBuilder ActualOfficesRawData = actualOffice;
    public static StringBuilder PotentialOfficesRawData = potentialOffice;


}
