package com.example.liveasy.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.liveasy.Model.TruckModel;
import java.util.Optional;


public interface dao extends JpaRepository<TruckModel, Integer>{
   Optional<TruckModel> findByShipperId(int shipperId);
   Optional<TruckModel> findByProductChemicals(String productChemicals);


}
