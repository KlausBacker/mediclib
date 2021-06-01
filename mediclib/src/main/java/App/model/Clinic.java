package App.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "clinic")
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "cli_id")
    private int cliID;

    @Column(name = "cli_name", length = 100, nullable = false)
    @NotBlank
    @Size(max = 100)
    private String name;

    public int getCliID() {
        return cliID;
    }

    public void setCliID(int cliID) {
        this.cliID = cliID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Address getCliAddress() {
        return cliAddress;
    }

    public void setCliAddress(Address cliAddress) {
        this.cliAddress = cliAddress;
    }

    @Column(name = "cli_phone_number", length = 100, nullable = false)
    @NotBlank
    @Size(max = 100)
    private String tel;


    @OneToOne
    @JoinColumn(name = "cli_address_id")
    private Address cliAddress;
}
