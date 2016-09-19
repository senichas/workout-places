package ua.com.findcoach.workoutplaces.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "places")
public class Place {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "places_seq_gen")
    @SequenceGenerator(name = "places_seq_gen", sequenceName = "places_places_id_seq", allocationSize = 1)
    private Integer id;

    @Column
    private String name;

    @Column
    private String country;

    @Column
    private String city;

    @Column
    private String phone;

    @Column
    private String address;

    @Column
    @Length(max = 60)
    @Pattern(regexp = "[a-zA-Z0-9._-]")
    private String alias;

    @Column
    @Length(max = 500)
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
