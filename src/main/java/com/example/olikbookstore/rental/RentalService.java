package com.example.olikbookstore.rental;

import com.example.olikbookstore.errors.WrongArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RentalService {
    RentalRepository rentalRepository;

    @Autowired
    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public List<Rental> findAllRentals() {
        return rentalRepository.findAll();
    }

    public Optional<Rental> findRentalById(String id) {
        return rentalRepository.findById(id);
    }

    public Rental createRental(Rental rental) throws WrongArgumentException {
        List<Rental> nonReturnedRentals = findNonReturnedRentals();
        List<String> nonReturnedBooksId = nonReturnedRentals.stream().map(Rental::getBookId).toList();
        if (nonReturnedBooksId.contains(rental.getBookId())) throw new WrongArgumentException("Book is already rented");
        return rentalRepository.save(rental);
    }

    public List<Rental> findNonReturnedRentals() {
        return rentalRepository.findByReturnDate();
    }

    public Rental updateReturnDate(String bookId) throws WrongArgumentException {
        List<Rental> rentals = rentalRepository.findByReturnDateAndBookId(bookId);

        if (rentals == null || rentals.isEmpty()) throw new WrongArgumentException("Book is not rented");

        Rental rental = rentals.get(0);
        rental.setReturnDate(new Date());
        return rentalRepository.save(rental);
    }

//    Method to check overdue rentals
    public boolean overdueRentals(Date rentalDate) {
        final int OVERDUE_RENTAL_DAYS = 14;
        long difference = Math.abs(rentalDate.getTime() - new Date().getTime());
        difference /= (24*60*60*1000);

        return difference >= OVERDUE_RENTAL_DAYS;
    }
}
