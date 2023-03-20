package com.rocker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rocker.model.Seed;
import com.rocker.services.SeedService;

@RestController
public class SeedController {

    @Autowired
    private SeedService seedService;

    @PostMapping("/seed")
    public ResponseEntity<Seed> addSeedHandler(@RequestBody Seed seed) {
        return new ResponseEntity<>(seedService.addSeed(seed), HttpStatus.ACCEPTED);
    }

    @PutMapping("/seed")
    public ResponseEntity<Seed> updateSeedHandler(@RequestBody Seed seed) {
        return new ResponseEntity<>(seedService.updateSeed(seed), HttpStatus.OK);
    }

    @DeleteMapping("/seed")
    public ResponseEntity<Seed> deleteSeedHandler(@RequestParam Integer seedId) {
        return new ResponseEntity<>(seedService.deleteSeed(seedId), HttpStatus.OK);
    }

    @GetMapping("/seedById")
    public ResponseEntity<Seed> viewSeedByIdHandler(@RequestParam Integer seedId) {
        return new ResponseEntity<>(seedService.viewSeedById(seedId), HttpStatus.OK);
    }

    @GetMapping("/seeds")
    public ResponseEntity<List<Seed>> viewAllSeedsHandler() {
        return new ResponseEntity<>(seedService.viewAllSeeds(), HttpStatus.OK);
    }

    @GetMapping("/seedsByName")
    public ResponseEntity<List<Seed>> viewseedsByNameHandler(@RequestParam String name) {
        return new ResponseEntity<>(seedService.viewSeedByCommonName(name), HttpStatus.OK);
    }

    @GetMapping("/seedsByType")
    public ResponseEntity<List<Seed>> viewPlantsBySeedTypeHandler(@RequestParam String type) {
        return new ResponseEntity<>(seedService.viewAllSeedsByType(type), HttpStatus.OK);
    }

    @GetMapping("/seedsByTemperature")
    public ResponseEntity<List<Seed>> viewSeedsByTemperatureHandler(@RequestParam Double min,
            @RequestParam Double max) {
        return new ResponseEntity<>(seedService.viewAllSeedsByTemperature(min, max), HttpStatus.OK);
    }

    @GetMapping("/seedsByCost")
    public ResponseEntity<List<Seed>> viewSeedsByCostHandler(@RequestParam Double min, @RequestParam Double max) {
        return new ResponseEntity<>(seedService.viewAllSeedsByCost(min, max), HttpStatus.OK);
    }

    @GetMapping("/seedsPerPacket")
    public ResponseEntity<List<Seed>> viewSeedsPerPacketHandler(@RequestParam Integer min, @RequestParam Integer max) {
        return new ResponseEntity<>(seedService.viewAllSeedsByPerPacket(min, max), HttpStatus.OK);
    }
}
