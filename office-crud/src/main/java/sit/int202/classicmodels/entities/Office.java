package sit.int202.classicmodels.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Offices")
@Getter
@Setter
@NoArgsConstructor
@NamedQueries(
        {
                @NamedQuery(name = "OFFICE.FIND_ALL", query = "select o from Office o"),
                @NamedQuery(name = "OFFICE.FIND_BY_COUNTRY",
                        query = "select o from Office o where o.country like :country"),
                @NamedQuery(name = "OFFICE.FIND_BY_CITY_OR_COUNTRY",
                        query = "select o from Office o where lower(o.city) like :city or lower(o.country) like :country")
        }
)
public class Office {
    public Office(String officeCode,String city, String phone, String addressLine1, String country, String postalCode, String territory) {
        this.officeCode = officeCode;
        this.city = city;
        this.phone = phone;
        this.addressLine1 = addressLine1;
        this.country = country;
        this.postalCode = postalCode;
        this.territory = territory;
    }

    @Id
    private String officeCode;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    @Column(name = "phone")
    private String phone;
    private String territory;
    @OneToMany(mappedBy = "officeCode")
    private List<Employee> employeeList;
}
