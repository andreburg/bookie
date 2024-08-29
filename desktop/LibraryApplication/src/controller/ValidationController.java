/*
 * Controls all data concerning Borrowers
 */
package controller;

import java.util.Date;
import model.Author;
import model.Book;
import model.Borrower;

public class ValidationController {

    // Pattern examples for validation
    /*
        NAME_PATTERN: 
        - Valid Examples: "John Doe", "Marie-Claire", "José García"
        EMAIL_PATTERN: 
        - Valid Examples: "example.email@domain.com", "user.name+tag@domain.co.uk", "username@sub.domain.org"
        PHONE_PATTERN: 
        - Valid Examples: "1234567890", "0987654321", "5555555555"
        ADDRESS_PATTERN: 
        - Valid Examples: "123 Main St.", "4567 Elm Road, Apt 2B", "78 King's Cross"
        DATE_PATTERN: 
        - Valid Examples: "2024-08-29", "1999-12-31", "2000-01-01"
        TITLE_PATTERN: 
        - Valid Examples: "The Great Gatsby!", "War & Peace: Volume 1", "How to Win Friends & Influence People?"
        GENRE_PATTERN: 
        - Valid Examples: "Science Fiction", "Romance", "Historical Fiction"
        ISBN_PATTERN: 
        - Valid Examples: "9783161484100", "0306406152", "978123456789X"
        INTEGER_PATTERN: 
        - Valid Examples: "123", "456789", "0"
    */
    
    // Constants for regex patterns
    private static final String NAME_PATTERN = "^[a-zA-Zà-ÿÀ-ß]+(?:[ '-][a-zA-Zà-ÿÀ-ß]+)*$";
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final String PHONE_PATTERN = "^\\d{10}$";
    private static final String ADDRESS_PATTERN = "^\\d+\\s[A-Za-z0-9\\s,.'-]+$";
    private static final String DATE_PATTERN = "^\\d{4}-\\d{2}-\\d{2}$"; // Date format is YYYY-MM-DD
    private static final String TITLE_PATTERN = "^[A-Za-z0-9\\s,.'\\-!@#$%^&*()_+=<>?{}\\[\\]~`|:;\"\\\\]+$";
    private static final String GENRE_PATTERN = "^[A-Za-z\\s]+$";
    private static final String ISBN_PATTERN = "^(97(8|9))?\\d{9}(\\d|X)$";
    private static final String INTEGER_PATTERN = "^\\d+$";

    // Inner class
    public class ValidationResult {
        private boolean isValid;
        private String identifier;

        public ValidationResult(boolean isValid, String identifier) {
            this.isValid = isValid;
            this.identifier = identifier;
        }

        public boolean isValid() {
            return isValid;
        }

        public String getIdentifier() {
            return identifier;
        }
    }

    // Method to validate Author
    public ValidationResult validateAuthor(Author author) {
        StringBuilder identifiers = new StringBuilder();
        boolean isValid = true;

        ValidationResult nameResult = validateName(author.getName());
        if (!nameResult.isValid()) {
            isValid = false;
            identifiers.append(nameResult.getIdentifier()).append(" ");
        }

        ValidationResult surnameResult = validateName(author.getSurname());
        if (!surnameResult.isValid()) {
            isValid = false;
            identifiers.append(surnameResult.getIdentifier()).append(" ");
        }

        return new ValidationResult(isValid, identifiers.toString().trim());
    }

    // Method to validate Book
    public ValidationResult validateBook(Book book) {
        StringBuilder identifiers = new StringBuilder();
        boolean isValid = true;

        ValidationResult titleResult = validateTitle(book.getTitle());
        if (!titleResult.isValid()) {
            isValid = false;
            identifiers.append(titleResult.getIdentifier()).append(" ");
        }

        ValidationResult genreResult = validateGenre(book.getGenre());
        if (!genreResult.isValid()) {
            isValid = false;
            identifiers.append(genreResult.getIdentifier()).append(" ");
        }

        ValidationResult isbnResult = validateISBN(book.getIsbn());
        if (!isbnResult.isValid()) {
            isValid = false;
            identifiers.append(isbnResult.getIdentifier()).append(" ");
        }

        ValidationResult lastBorrowedResult = validateDate(book.getLastBorrowed());
        if (!lastBorrowedResult.isValid()) {
            isValid = false;
            identifiers.append(lastBorrowedResult.getIdentifier()).append(" ");
        }

        ValidationResult dateReturnedResult = validateDate(book.getDateReturned());
        if (!dateReturnedResult.isValid()) {
            isValid = false;
            identifiers.append(dateReturnedResult.getIdentifier()).append(" ");
        }

        if (book.getBorrowerID() != 0) {
            ValidationResult borrowerIDResult = validateInteger(String.valueOf(book.getBorrowerID()));
            if (!borrowerIDResult.isValid()) {
                isValid = false;
                identifiers.append(borrowerIDResult.getIdentifier()).append(" ");
            }
        }

        return new ValidationResult(isValid, identifiers.toString().trim());
    }

    // Method to validate Borrower
    public ValidationResult validateBorrower(Borrower borrower) {
        StringBuilder identifiers = new StringBuilder();
        boolean isValid = true;

        ValidationResult nameResult = validateName(borrower.getName());
        if (!nameResult.isValid()) {
            isValid = false;
            identifiers.append(nameResult.getIdentifier()).append(" ");
        }

        ValidationResult surnameResult = validateName(borrower.getSurname());
        if (!surnameResult.isValid()) {
            isValid = false;
            identifiers.append(surnameResult.getIdentifier()).append(" ");
        }

        ValidationResult emailResult = validateEmail(borrower.getEmail());
        if (!emailResult.isValid()) {
            isValid = false;
            identifiers.append(emailResult.getIdentifier()).append(" ");
        }

        ValidationResult phoneResult = validatePhone(borrower.getPhone());
        if (!phoneResult.isValid()) {
            isValid = false;
            identifiers.append(phoneResult.getIdentifier()).append(" ");
        }

        ValidationResult addressResult = validateAddress(borrower.getAddress());
        if (!addressResult.isValid()) {
            isValid = false;
            identifiers.append(addressResult.getIdentifier()).append(" ");
        }

        return new ValidationResult(isValid, identifiers.toString().trim());
    }

    // Helper methods for validation
    private ValidationResult validateName(String name) {
        boolean isValid = name.matches(NAME_PATTERN);
        return new ValidationResult(isValid, isValid ? "" : "Invalid Name");
    }

    private ValidationResult validateEmail(String email) {
        boolean isValid = email.matches(EMAIL_PATTERN);
        return new ValidationResult(isValid, isValid ? "" : "Invalid Email");
    }

    private ValidationResult validatePhone(String phone) {
        boolean isValid = phone.matches(PHONE_PATTERN);
        return new ValidationResult(isValid, isValid ? "" : "Invalid Phone");
    }

    private ValidationResult validateAddress(String address) {
        boolean isValid = address.matches(ADDRESS_PATTERN);
        return new ValidationResult(isValid, isValid ? "" : "Invalid Address");
    }

    private ValidationResult validateTitle(String title) {
        boolean isValid = title.matches(TITLE_PATTERN);
        return new ValidationResult(isValid, isValid ? "" : "Invalid Title");
    }

    private ValidationResult validateGenre(String genre) {
        boolean isValid = genre.matches(GENRE_PATTERN);
        return new ValidationResult(isValid, isValid ? "" : "Invalid Genre");
    }

    private ValidationResult validateISBN(String isbn) {
        boolean isValid = isbn.matches(ISBN_PATTERN);
        return new ValidationResult(isValid, isValid ? "" : "Invalid ISBN");
    }

    private ValidationResult validateDate(Date date) {
        boolean isValid = date == null || date.toString().matches(DATE_PATTERN);
        return new ValidationResult(isValid, isValid ? "" : "Invalid Date");
    }

    private ValidationResult validateInteger(String integer) {
        boolean isValid = integer.matches(INTEGER_PATTERN);
        return new ValidationResult(isValid, isValid ? "" : "Invalid Integer");
    }
}

