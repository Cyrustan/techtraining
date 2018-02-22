package db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Moe on 2/10/18.
 */
@Entity
@Table(name = "INVESTORS", schema = "FinTech_Training")
public class Investor {
    @Id
    @Column(name = "INVESTOR_ID")
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SSN")
    private String ssn;
    @Column(name = "ADDRESS")
    private String address;

    public Investor() {
        // default no-arg constructor for hibernate
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSsn() {
        return ssn;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
