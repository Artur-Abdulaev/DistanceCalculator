package distanceBetweenToPointsOnMap;

public class DistanceData implements Comparable<DistanceData> {
    public final OfficeAddress Actual;
    public final OfficeAddress Potential;
    public final double Distance;
    public final String Solution;


    @Override
    public String toString() {
        return Distance + " ( " + Actual.toString() + " : " + Potential.toString() + " )\n";
    }

    public DistanceData(OfficeAddress actual, OfficeAddress potential) {
        this.Actual = actual;
        this.Potential = potential;
        this.Distance = getDistanceBetween(actual, potential);

        if (this.Distance > 450) {
            Solution = "Да";
        } else Solution = "Нет";


    }

    public static double getDistanceBetween(OfficeAddress a1, OfficeAddress a2) {
        double theta = a1.Longitude - a2.Longitude;
        double lat1 = a1.Latitude;
        double lat2 = a2.Latitude;

        double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));

        dist = Math.acos(dist);
        dist = Math.toDegrees(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344 * 1000;

        return dist;
    }

    @Override
    public int compareTo(DistanceData o) {
        return this.Distance > o.Distance ? 1 : -1;
    }
}
