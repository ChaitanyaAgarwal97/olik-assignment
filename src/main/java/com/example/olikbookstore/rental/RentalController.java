package com.example.olikbookstore.rental;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {
    RentalService rentalService;

    @Autowired
    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("")
    public List<Rental> findAll() {
        return rentalService.findAllRentals();
    }

    @GetMapping("/{id}")
    public Optional<Rental> findById(@PathVariable String id) {
        return rentalService.findRentalById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Rental create(@Valid @RequestBody Rental rental) {
        return rentalService.createRental(rental);
    }

    @PutMapping("/returnBook")
    public Rental returnBook(@RequestParam(name = "bookId", required = true) String bookId) {
        return rentalService.updateReturnDate(bookId);
    }
}
