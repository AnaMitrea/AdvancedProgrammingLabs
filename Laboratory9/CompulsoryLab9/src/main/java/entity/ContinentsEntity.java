package entity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@NamedQuery(name = "ExistsById1", query = "SELECT count(idcontinent) FROM ContinentsEntity WHERE idcontinent=?1")
@NamedQuery(name = "ExistsByName1", query = "SELECT count(n.name) FROM ContinentsEntity  n WHERE n.name=:name")
@NamedQuery(name = "CountContinents", query = "SELECT count(idcontinent) FROM ContinentsEntity")
@NamedQuery(name = "DeleteContinents", query = "DELETE FROM ContinentsEntity WHERE idcontinent=?1")
@NamedQuery(name = "DeleteAllContinents", query = "DELETE FROM ContinentsEntity ")
@NamedQuery(name = "DeleteByIdContinents", query = "DELETE FROM ContinentsEntity WHERE idcontinent=?1")
@NamedQuery(name = "DeleteByNameContinents", query = "DELETE FROM ContinentsEntity WHERE name=:name")
@NamedQuery(name = "FindByIdObject1", query = "SELECT obj from ContinentsEntity obj WHERE obj.idcontinent = ?1")
@NamedQuery(name = "FindByIdObjectName1", query = "SELECT obj from ContinentsEntity obj WHERE obj.name=:name")
@Table(name = "continents", schema = "public", catalog = "cities")
public class ContinentsEntity {
    @Basic
    @Id
    @Column(name = "idcontinent")
    private int idcontinent;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcontinent")
    @OrderBy("id")
    private List<CountriesEntity> countriesEntities = new LinkedList<>();

    public int getIdcontinent() {
        return idcontinent;
    }

    public void setIdcontinent(int idcontinent) {
        this.idcontinent = idcontinent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContinentsEntity that = (ContinentsEntity) o;

        if (idcontinent != that.idcontinent) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = idcontinent;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public void setCountriesEntities(List<CountriesEntity> countriesEntities) {

        this.countriesEntities = countriesEntities;
    }

    public List<CountriesEntity> getCountriesEntities() {
        return countriesEntities;
    }
}
