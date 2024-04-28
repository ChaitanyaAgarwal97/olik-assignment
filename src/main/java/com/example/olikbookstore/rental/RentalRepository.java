package com.example.olikbookstore.rental;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RentalRepository extends MongoRepository<Rental, String> {
    @Query("{returnDate: null}")
    List<Rental> findByReturnDate();

    @Query("{returnDate: null, bookId: ?0}")
    List<Rental> findByReturnDateAndBookId(String bookId);
}
