package com.example.liveasy.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.example.liveasy.Model.TruckModel;
import com.example.liveasy.Service.TruckService;

@RestController
@RequestMapping("truck")
public class truckController {

    @Autowired 
    TruckService service;
    
@PostMapping("/load")
public String payload( TruckModel model){

    return service.payload(model);

}
@GetMapping("/getLoad/{shipperId}")
public TruckModel getList(@PathVariable int shipperId){
    return service.getList(shipperId);
}

@DeleteMapping("/deleteLoad")
public String deleteLoad(int shipperId){
    return service.deleteLoad(shipperId);
}

@GetMapping("/getAll")
public List<TruckModel> getAll(){
    return service.getAll();
}



@PutMapping("/edit/{shipperId}")
public String editLoad(@PathVariable int shipperId,TruckModel model){
    return service.editLoad(shipperId, model);
}
}
