package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQuery(name = "ExistsById4", query = "SELECT count(id) FROM ImportedcCountriesEntity WHERE id=?1")
@NamedQuery(name = "ExistsByName4", query = "SELECT count(n.name) FROM ImportedcCountriesEntity  n WHERE n.name=:name")
@NamedQuery(name = "CountImportedCountries", query = "SELECT count(id) FROM ImportedcCountriesEntity ")
@NamedQuery(name = "DeleteImportedCountries", query = "DELETE FROM ImportedcCountriesEntity WHERE id=?1")
@NamedQuery(name = "DeleteAllImportedCountries", query = "DELETE FROM ImportedcCountriesEntity ")
@NamedQuery(name = "DeleteByIdImportedCountries", query = "DELETE FROM ImportedcCountriesEntity WHERE id=?1")
@NamedQuery(name = "DeleteByNameImportedCountries", query = "DELETE FROM ImportedcCountriesEntity WHERE name=:name")
@NamedQuery(name = "FindByIdObject3", query = "SELECT obj from ImportedcCountriesEntity obj WHERE obj.id = ?1")
@NamedQuery(name = "FindByIdObjectName3", query = "SELECT obj from ImportedcCountriesEntity obj WHERE obj.name=:name")
@Table(name = "importedcountries", schema = "public", catalog = "cities")
public class ImportedcCountriesEntity implements Serializable {
    @Basic
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "capital")
    private String capital;
    @Basic
    @Column(name = "latitude")
    private String latitude;
    @Basic
    @Column(name = "longitude")
    private String longitude;
    @Basic
    @Column(name = "code")
    private String code;
    @Basic
    @Column(name = "continent")
    private String continent;

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

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImportedcCountriesEntity that = (ImportedcCountriesEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (capital != null ? !capital.equals(that.capital) : that.capital != null) return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (continent != null ? !continent.equals(that.continent) : that.continent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (capital != null ? capital.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (continent != null ? continent.hashCode() : 0);
        return result;
    }

}
