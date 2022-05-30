package oopmodel;

public class City extends TableClass{

    private final boolean capital;
    private final String latitude;
    private final String longitude;

    public City(int id, String name, boolean capital, String latitude, String longitude) {
        this.id = id;
        this.name = name;
        this.capital = capital;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean getCapital() {
        return capital;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return  " (" + id +
                ", " + name +
                ", capital? " + capital +
                ", lat. '" + latitude + '\'' +
                ", long. '" + longitude + '\'' +
                ")\n";
    }

    /**
     * Method used to compute the distance between two cities using Haversine Formula and their latitude and longitude values.
     * @param city2 Second city
     * @return      The distance in kilometers
     */
    public double distanceBetween(City city2) {
        System.out.print("Computing distance between '" + this.name + "' and '" + city2.getName() + "' : ");

        double latitudeRadians1 = Math.toRadians(Double.parseDouble(this.latitude));
        double longitudeRadians1 = Math.toRadians(Double.parseDouble(this.longitude));

        double latitudeRadians2 = Math.toRadians(Double.parseDouble(city2.getLatitude()));
        double longitudeRadians2 = Math.toRadians(Double.parseDouble(city2.getLongitude()));

        double dlon = longitudeRadians2 - longitudeRadians1;
        double dlat = latitudeRadians2 - latitudeRadians1;
        double a = Math.pow( Math.sin(dlat / 2), 2)
                + Math.cos(latitudeRadians1) * Math.cos(latitudeRadians2)
                * Math.pow(Math.sin(dlon / 2),2);
        double c = 2 * Math.asin(Math.sqrt(a));
        double earthRadius = 6371;
        return c * earthRadius;
    }
}
