package com.example.liveasy.Model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="truck")
public class TruckModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="shipperId")
    int shipperId;
    @Column(name="loadingPoint")
    String loadingPoint;
    @Column(name="unloadingPoint")
    String unloadingPoint;
    @Column(name="productChemicals")
    String productChemicals;
    @Column(name="truckType")
    String truckType;
    @Column(name="noOfTrucks")
    int noOfTrucks;
    @Column(name="weight")
    int weight;
    @Column(name="date")
    String date;
    
}