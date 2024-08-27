/*
 * Controls all data concerning Borrowers
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Borrower;
import view.BorrowerManager;

public class BorrowerController {
    private BorrowerManager view;
    private DataController db;
    private List<Borrower> borrowers;

    public BorrowerController(BorrowerManager view, DataController db) {
        this.view = view;
        this.db = db;
        // At Main start connect to DB, read all borrowers into List<Borrower>
        borrowers = new ArrayList<>();
    }

    public void addBorrower(Borrower borrower) {
        borrowers.add(borrower);
        dbQuery("borr", 1, borrower);
    }

    /*
    public SomeList<Borrower> getAllBorrowers() {
        // Code to get all Borrower objects
    }
    */

    public void updateBorrower(Borrower borrower) {
        dbQuery("borr", 2, borrower, Integer.toString(borrower.getId()));
    }

    public void deleteBorrower(Borrower borrower) {
        dbQuery("borr", 2, borrower, Integer.toString(borrower.getId()));
    }

    // Other methods related to borrower operations
    public void dbQuery(String table, int action, Borrower obj) {
        dbQuery(table, action, obj, "");
    }
    // Overloaded dbQuery accepts whereClause
    public void dbQuery(String table, int action, Borrower obj, String whereClause) {
        db.queryExecutor(table, action, obj, whereClause);
    }
}
