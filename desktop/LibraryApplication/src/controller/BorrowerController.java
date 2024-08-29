// Borrower Controller for all related operations
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Borrower;

public class BorrowerController {
    private DataController dc;
    private List<Borrower> borrowers;
    private Borrower placeholder = new Borrower(0, "Name", "Surname", "Phone", "Email", "Address");

    public BorrowerController() {
        dc = new DataController();
        borrowers = new ArrayList<>();
    }

    public void addBorrower(Borrower borrower) {
        borrowers.add(borrower);
        dbQuery("borr", 1, borrower);
    }

    public void viewAllBorrowers(String whereClause) {
        dc.queryExecutor("borr", 4, placeholder, whereClause); // SELECT * for borrowers
        this.borrowers = dc.getBorrowerTableData(); // Retrieve the data
    }

    public void updateBorrower(Borrower borrower) {
        dbQuery("borr", 2, borrower, Integer.toString(borrower.getId()));
    }

    public void deleteBorrower(Borrower borrower) {
        dbQuery("borr", 3, borrower, Integer.toString(borrower.getId()));
    }

    // Database methods related to borrower operations
    public void dbQuery(String table, int action, Borrower obj) {
        dbQuery(table, action, obj, "");
    }

    // Overloaded dbQuery accepts whereClause
    public void dbQuery(String table, int action, Borrower obj, String whereClause) {
        if (dc == null) {
            System.out.println("DataController is not initialized.");
            return;
        }
        dc.queryExecutor(table, action, obj, whereClause);
    }

    public List<Borrower> getBorrowers() {
        return borrowers;
    }
}
