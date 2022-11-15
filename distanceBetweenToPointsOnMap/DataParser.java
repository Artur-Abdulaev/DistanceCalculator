package distanceBetweenToPointsOnMap;

import java.util.ArrayList;

class DataParser {
    public static ArrayList<OfficeAddress> parseDataActual(StringBuilder data) {
        ArrayList<OfficeAddress> result = new ArrayList<>();
        for (String s : data.toString().split("\n")) {
            String[] officeSplitedData = s.split("\t");
            result.add(new OfficeAddress(
                    officeSplitedData[0],
                    Double.parseDouble(officeSplitedData[1]),
                    Double.parseDouble(officeSplitedData[2]),
                    officeSplitedData[3]
            ));
        }
        return result;
    }

    public static ArrayList<OfficeAddress> parseDataPotential(StringBuilder data) {
        ArrayList<OfficeAddress> result = new ArrayList<>();
        for (String s : data.toString().split("\n")) {
            String[] officeSplitedData = s.split("\t");
            result.add(new OfficeAddress(
                    officeSplitedData[0],
                    Double.parseDouble(officeSplitedData[1]),
                    Double.parseDouble(officeSplitedData[2])
            ));
        }
        return result;
    }
}