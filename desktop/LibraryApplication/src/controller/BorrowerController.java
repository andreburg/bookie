/*
 * Controls all data concerning Borrowers
 */
package controller;

import model.Borrower;
import model.LibraryDB;
import view.BorrowerManager;

public class BorrowerController {
    private BorrowerManager view;
    private LibraryDB db;

    public BorrowerController(BorrowerManager view, LibraryDB db) {
        this.view = view;
        this.db = db;
        // Add event listeners to the view
    }

    public void addBorrower(Borrower borrower) {
        // Code to add a borrower to the database
    }

    /*
    public SomeList<Borrower> getAllBorrowers() {
        // Code to get all borrowers from the database
    }
    */

    public void updateBorrower(Borrower borrower) {
        // Code to update a borrower in the database
    }

    public void deleteBorrower(int borrowerId) {
        // Code to delete a borrower from the database
    }

    // Other methods related to borrower operations
}
