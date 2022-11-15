package distanceBetweenToPointsOnMap;

class OfficeAddress {
    public final String Address;
    public final double Latitude;
    public final double Longitude;
    public String postCode = null;

    public OfficeAddress(String address, double latitude, double longitude, String postCode) {
        this.Address = address;
        this.Latitude = latitude;
        this.Longitude = longitude;
        this.postCode = postCode;
    }

    public OfficeAddress(String address, double latitude, double longitude) {
        this.Address = address;
        this.Latitude = latitude;
        this.Longitude = longitude;

    }

    @Override
    public String toString() {
        return Address + " [ " + Latitude + " , " + Longitude + " ]";
    }
}
