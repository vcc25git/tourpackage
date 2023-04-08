package com.mycompany.tourpackage.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.tourpackage.dao.TourPackageRepository;
import com.mycompany.tourpackage.entity.TourPackage;
import com.mycompany.tourpackage.exceptions.ResourceNotFoundException;

@RestController
@Service
public class TourService {
	@Autowired
	TourPackageRepository tourRepo;
	
	@GetMapping(value="/tours")
	List<TourPackage> getProductForCategory() {
		return tourRepo.findAll();
	}
	
	@GetMapping("/tours/{id}")
//	Optional<TourPackage> getProduct(@PathVariable("id") Long id) 
//		return tourRepo.findById(id);
	
	 public ResponseEntity< TourPackage > getTourById(@PathVariable(value = "id") Long tourId) throws ResourceNotFoundException {
        Optional<TourPackage> user = tourRepo.findById(tourId);
        if(user.isPresent())
            return ResponseEntity.ok().body(user.get());
        else
            throw new ResourceNotFoundException("User not found :: " + tourId);
    }

	
	@PostMapping(value = "/tours")
	ResponseEntity<TourPackage> insertTour(@RequestBody TourPackage tours) {
		TourPackage savedTour = tourRepo.save(tours);
		return new ResponseEntity<TourPackage>(savedTour, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/tours/{id}")
	ResponseEntity<TourPackage> deleteProduct(@PathVariable("id") Long id) {
		
		// First fetch an existing product and then delete it. 
		Optional<TourPackage> optionalProduct = tourRepo.findById(id); 
		TourPackage existingProduct=optionalProduct.get();
		// Return the deleted product 
		tourRepo.delete(existingProduct);
		return new ResponseEntity<TourPackage>(HttpStatus.NO_CONTENT) ;		
	}
	
	@PutMapping(value="/tours/{id}")
	ResponseEntity updateProduct(@PathVariable("id") Long id, @RequestBody TourPackage tours) {
		
		// First fetch an existing product and then modify it. 
		Optional<TourPackage> optionalProduct = tourRepo.findById(id); 
		TourPackage existingProduct=optionalProduct.get();
		// Now update it back 
		existingProduct.setCatId(tours.getCatId());
		existingProduct.setTourname(tours.getTourname());
		TourPackage savedProduct = tourRepo.save(existingProduct) ;
		// Return the updated product  
		return new ResponseEntity<TourPackage>(savedProduct, HttpStatus.OK) ;		
	}

}
