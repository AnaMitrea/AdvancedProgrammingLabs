package oopmodel;

public class Country extends TableClass{
    private String capital;
    private String latitude;
    private String longitude;
    private String code;
    private String continent;

    public Country(int id, String name, String capital, String latitude, String longitude, String code, String continent) {
        this.id = id;
        this.name = name;
        this.capital = capital;
        this.latitude = latitude;
        this.longitude = longitude;
        this.code = code;
        this.continent = continent;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getCode() {
        return code;
    }

    public String getContinent() {
        return continent;
    }

    @Override
    public String toString() {
        return  " (" + id +
                ", " + name +
                ", capital: " + capital +
                ", lat. '" + latitude + '\'' +
                ", long. '" + longitude + '\'' +
                ", code: " + code +
                ", continent: " + continent +
                ")\n";
    }
}
