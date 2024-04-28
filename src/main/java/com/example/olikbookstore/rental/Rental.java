package com.example.olikbookstore.rental;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.crypto.Data;
import java.util.Date;

@Document(collection = "rentals")
public class Rental {
    @Id
    @NotEmpty
    private String id;
    @NotEmpty
    private String bookId;
    @NotEmpty
    private String renterName;
    @NotNull
    private Date rentalDate;
    private Date returnDate;

    public Rental(String id, String bookId, String renterName, Date rentalDate, Date returnDate) {
        this.id = id;
        this.bookId = bookId;
        this.renterName = renterName;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getRenterName() {
        return renterName;
    }

    public void setRenterName(String renterName) {
        this.renterName = renterName;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
