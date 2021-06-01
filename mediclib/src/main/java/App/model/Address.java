package App.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adr_id")
    private int id;

    @Column(name = "adr_street", length = 200, nullable = false)
    @NotBlank
    @Size(max = 200)
    private String street;

    @Column(name = "adr_street_number", length = 11, nullable = false)
    @NotBlank
    @Size(max = 11)
    private String streetNumber;

    @Column(name = "adr_postcode", length = 100, nullable = false)
    @NotBlank
    @Size(max = 100)
    private String postcode;

    @Column(name = "adr_city", length = 150, nullable = false)
    private String city;

    @Column(name = "adr_line_1", length = 300)
    private String line1;

    @Column(name = "adr_line_2", length = 300)
    private String line2;

    @Column(name = "adr_country", length = 100, nullable = false)
    @NotBlank
    @Size(max = 100)
    private String crountry = "France";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCrountry() {
        return crountry;
    }

    public void setCrountry(String crountry) {
        this.crountry = crountry;
    }
}
