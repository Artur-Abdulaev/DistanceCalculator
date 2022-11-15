package distanceBetweenToPointsOnMap;

import distanceBetweenToPointsOnMap.apachePOI.WritingExcel;

import java.io.IOException;
import java.util.ArrayList;

import static distanceBetweenToPointsOnMap.Converter.convertTo2DArray;

public class MainEntryPoint {
    public static void main(String[] args) {
        ArrayList<OfficeAddress> actual = DataParser.parseDataActual(TestData.ActualOfficesRawData);
        ArrayList<OfficeAddress> potential = DataParser.parseDataPotential(TestData.PotentialOfficesRawData);

        ArrayList<DistanceData> calculatedData = new ArrayList<>();
        for (int i = 0; i < actual.size(); i++) {
            for (int j = 0; j < potential.size(); j++) {
                calculatedData.add(new DistanceData(actual.get(i), potential.get(j)));
            }
        }

        ArrayList<DistanceData> finalData = new ArrayList<>();

        for (int i = 0; i < potential.size(); i++) {
            double min = Integer.MAX_VALUE;
            int minElementIndex = -1;
            String potentialOfficesAddress = potential.get(i).Address;

            for (int j = 0; j < calculatedData.size(); j++) {
                if (!calculatedData.get(j).Potential.Address.equals(potentialOfficesAddress))
                    continue;

                if (calculatedData.get(j).Distance < min) {
                    min = calculatedData.get(j).Distance;
                    minElementIndex = j;
                }
            }

            finalData.add(calculatedData.get(minElementIndex));
        }

//        DistanceData[] arr = new DistanceData[10];
//        System.out.println(actual.size());
//        for (int i = 0; i < actual.size(); i++) {
//            String potentialOfficesAddress = actual.get(i).Address;
//
//            finalData = (ArrayList<DistanceData>) calculatedData.stream().
//                    filter(a -> a.Actual.Address.equals(potentialOfficesAddress)).sorted().collect(Collectors.toList());
//        }


        Object[][] dataForWrite = convertTo2DArray(finalData);

        try {
            WritingExcel.excelWriter(dataForWrite, "C:/Users/À/Desktop/ExcelForPOI/Results.xlsx");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}


