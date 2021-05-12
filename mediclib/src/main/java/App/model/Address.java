package App.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Address")
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
}
