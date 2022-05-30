package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQuery(name = "ExistsById", query = "SELECT count(id) FROM CitiesEntity WHERE id=?1")
@NamedQuery(name = "ExistsByName", query = "SELECT count(n.name) FROM CitiesEntity  n WHERE n.name=:name")
@NamedQuery(name = "CountCities", query = "SELECT count(id) FROM CitiesEntity")
@NamedQuery(name = "DeleteCities", query = "DELETE FROM CitiesEntity WHERE id=?1")
@NamedQuery(name = "DeleteAllCities", query = "DELETE FROM CitiesEntity ")
@NamedQuery(name = "DeleteByIdCities", query = "DELETE FROM CitiesEntity WHERE id=?1")
@NamedQuery(name = "DeleteByNameCities", query = "DELETE FROM CitiesEntity WHERE name=:name")
@NamedQuery(name = "FindByIdObject", query = "SELECT obj from CitiesEntity obj WHERE obj.id = ?1")
@NamedQuery(name = "FindByIdObjectName", query = "SELECT obj from CitiesEntity obj WHERE obj.name=:name")
@Table(name = "cities", schema = "public", catalog = "cities")
public class CitiesEntity implements Serializable {

    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "latitude")
    private String latitude;
    @Basic
    @Column(name = "longitude")
    private String longitude;
    @Basic
    @Column(name = "idCountry")
    private Integer idCountry;
    @Basic
    @Column(name = "population")
    private String population;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Integer getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Integer idCountry) {
        this.idCountry = idCountry;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CitiesEntity that = (CitiesEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;
        if (idCountry != null ? !idCountry.equals(that.idCountry) : that.idCountry != null) return false;
        if (population != null ? !population.equals(that.population) : that.population != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (idCountry != null ? idCountry.hashCode() : 0);
        result = 31 * result + (population != null ? population.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "City(" +
                id +
                ", \'" + name + '\'' +
                ", " + latitude +
                ", " + longitude +
                ", idCountry=" + idCountry +
                ", " + population +
                ')';
    }
}
