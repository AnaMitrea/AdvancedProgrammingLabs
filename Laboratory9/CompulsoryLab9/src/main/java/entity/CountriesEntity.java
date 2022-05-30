package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQuery(name = "ExistsById2", query = "SELECT count(id) FROM CountriesEntity WHERE id=?1")
@NamedQuery(name = "ExistsByName2", query = "SELECT count(n.name) FROM CountriesEntity  n WHERE n.name=:name")
@NamedQuery(name = "CountCountries", query = "SELECT count(id) FROM CountriesEntity ")
@NamedQuery(name = "DeleteCountries", query = "DELETE FROM CountriesEntity WHERE id=?1")
@NamedQuery(name = "DeleteAllCountries", query = "DELETE FROM CountriesEntity ")
@NamedQuery(name = "DeleteByIdCountries", query = "DELETE FROM CountriesEntity WHERE id=?1")
@NamedQuery(name = "DeleteByNameCountries", query = "DELETE FROM CountriesEntity WHERE name=:name")
@NamedQuery(name = "FindByIdObject2", query = "SELECT obj from CountriesEntity obj WHERE obj.id = ?1")
@NamedQuery(name = "FindByIdObjectName2", query = "SELECT obj from CountriesEntity obj WHERE obj.name=:name")
@Table(name = "countries", schema = "public", catalog = "cities")
public class CountriesEntity implements Serializable {
    @Basic
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "code")
    private String code;
    @Basic
    @Column(name = "idcontinent")
    private Integer idcontinent;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getIdcontinent() {
        return idcontinent;
    }

    public void setIdcontinent(Integer idcontinent) {
        this.idcontinent = idcontinent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountriesEntity countries = (CountriesEntity) o;

        if (id != countries.id) return false;
        if (name != null ? !name.equals(countries.name) : countries.name != null) return false;
        if (code != null ? !code.equals(countries.code) : countries.code != null) return false;
        if (idcontinent != null ? !idcontinent.equals(countries.idcontinent) : countries.idcontinent != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (idcontinent != null ? idcontinent.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Country(" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", idcontinent=" + idcontinent +
                ')';
    }
}
