package com.example.liveasy.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import com.example.liveasy.DAO.dao;
import com.example.liveasy.Model.TruckModel;

@Service
public class TruckService {

    @Autowired
    dao dao;

    public String payload(TruckModel model) {
        

        Optional<TruckModel> optionalTruck = dao.findByProductChemicals(model.getProductChemicals());
        
        if(optionalTruck.isPresent()){
            return "Data Already Present";
        }
        TruckModel daoModel = new TruckModel();
        daoModel.setDate(model.getDate());
        daoModel.setLoadingPoint(model.getLoadingPoint());
        daoModel.setNoOfTrucks(model.getNoOfTrucks());
        daoModel.setProductChemicals(model.getProductChemicals());
        daoModel.setTruckType(model.getTruckType());
        daoModel.setUnloadingPoint(model.getUnloadingPoint());
        daoModel.setWeight(model.getWeight());
        dao.save(daoModel);
        return "Data Saved Successfully";

        
    }

    public TruckModel getList(int shipperId) {
        Optional<TruckModel> optionalTruck = dao.findByShipperId(shipperId);
        if(optionalTruck.isPresent()){
            TruckModel result = optionalTruck.get();
            return result;
        }
        return null;


        
    }

    public String deleteLoad(int shipperId) {
        Optional<TruckModel> optionalTruck = dao.findByShipperId(shipperId);
        if(optionalTruck.isPresent()){
            TruckModel dModel = optionalTruck.get();
            dao.delete(dModel);
            return "Deleted Successfully";
        }
        return "No such order found.";
    }

    public String editLoad(int shipperId, TruckModel model) {

        Optional<TruckModel> optionalTruck = dao.findByShipperId(shipperId);
        if(optionalTruck.isPresent()){
            TruckModel dModel = model;
            dModel.setShipperId(shipperId);
            dao.save(dModel);
            return "Data Updated Successfully";
        }
        return "ID Not found";


    }

    public List<TruckModel> getAll() {
        return dao.findAll();
    }
    
}
