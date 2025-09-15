package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "crime_records")
public class CrimeRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String region;

    private int extremism;
    private int osob;
    private int terrorism;
    private int weapon;
    private int total;

    public CrimeRecord() {}
    public CrimeRecord(String region) { this.region = region; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }
    public int getExtremism() { return extremism; }
    public void setExtremism(int extremism) { this.extremism = extremism; }
    public int getOsob() { return osob; }
    public void setOsob(int osob) { this.osob = osob; }
    public int getTerrorism() { return terrorism; }
    public void setTerrorism(int terrorism) { this.terrorism = terrorism; }
    public int getWeapon() { return weapon; }
    public void setWeapon(int weapon) { this.weapon = weapon; }
    public int getTotal() { return total; }
    public void setTotal(int total) { this.total = total; }

    public void addExtremism(int v) { this.extremism += v; }
    public void addOsob(int v) { this.osob += v; }
    public void addTerrorism(int v) { this.terrorism += v; }
    public void addWeapon(int v) { this.weapon += v; }
}
