package com.netcracker.crud.service;

import com.netcracker.crud.model.Buyer;
import com.netcracker.crud.repository.BuyerRepository;
import com.netcracker.crud.status.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BuyerService {
    @Autowired
    private BuyerRepository buyerRepository;

    @GetMapping("/buyer")
    public List<Buyer> getBuyers(){
        return buyerRepository.findAll();
    }

    @GetMapping("/buyer/{buyerId}")
    public Buyer getBuyerById(@PathVariable Integer buyerId){
        return buyerRepository.findById(buyerId).get();
    }

    @PostMapping("/buyer")
    public Buyer createBuyer(@RequestBody Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    @DeleteMapping("/buyer")
    public Status deleteAllBuyers() {
        buyerRepository.deleteAll();
        return new Status("All buyers deleted");
    }

    @DeleteMapping("/buyer/{buyerId}")
    public Status deleteBuyer(@PathVariable Integer buyerId) {
        try {
            buyerRepository.deleteById(buyerId);
        } catch (EmptyResultDataAccessException e){
            return new Status("There isn't buyer with id " + buyerId);
        }
        return new Status("Buyer with id " + buyerId + " successfully deleted");
    }
}
