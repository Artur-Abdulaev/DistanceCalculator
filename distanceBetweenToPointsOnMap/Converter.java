package distanceBetweenToPointsOnMap;

import java.util.ArrayList;

public class Converter {

    public static Object[][] convertTo2DArray(ArrayList<DistanceData> list) {
        Object[][] obj = new Object[list.size() + 1][5];
        obj[0][0] = "����� ������������� �������";
        obj[0][1] = "���������� �� ���������� ���, � ������";
        obj[0][2] = "����� ���������� ���";
        obj[0][3] = "��������";
        obj[0][4] = "������ ���������� ���";

        for (int i = 0; i < list.size(); i++) {
            obj[i + 1][0] = list.get(i).Potential.Address;
            obj[i + 1][1] = list.get(i).Distance;
            obj[i + 1][2] = list.get(i).Actual.Address;
            obj[i + 1][3] = list.get(i).Solution;
            obj[i + 1][4] = Double.parseDouble(list.get(i).Actual.postCode);
        }

        return obj;
    }
}
