package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "crime_records")
@Getter
@Setter
@NoArgsConstructor
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

    public CrimeRecord(String region) {
        this.region = region;
    }

    public void addExtremism(int v) { this.extremism += v; }
    public void addOsob(int v) { this.osob += v; }
    public void addTerrorism(int v) { this.terrorism += v; }
    public void addWeapon(int v) { this.weapon += v; }
}