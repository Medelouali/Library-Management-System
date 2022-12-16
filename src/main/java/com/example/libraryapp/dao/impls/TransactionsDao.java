package com.example.libraryapp.dao.impls;

import com.example.libraryapp.dao.Dao;
import com.example.libraryapp.dao.db.ConnectionDB;
import com.example.libraryapp.models.Transaction;
import com.example.libraryapp.utils.AlertMessage;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TransactionsDao implements Dao<Transaction> {

    @Override
    public boolean save(Transaction item) {
        return false;
    }

    @Override
    public Transaction getById(long id) {
        return null;
    }

    @Override
    public ArrayList<Transaction> getAll() {
        ArrayList<Transaction> transactions=new ArrayList<>();
        //testing
        ConnectionDB conDb = new ConnectionDB();
        Statement st;

        try {
            st = conDb.getCon().createStatement();

            String req="select students.username as studentUsername, books.picture, students.cin, admins.username as adminUsername, books.title, borrowingDate from borrowings, students, bookcopies, admins, books where borrowings.student_id=students.id and borrowings.admin_id=admins.id and books.id=bookcopies.book_id and copy_id=bookcopies.id;";
            ResultSet rs= st.executeQuery(req);
            while(rs.next()){
                String adminUsername=rs.getString("adminUsername").length()<20?rs.getString("adminUsername"): rs.getString("adminUsername").substring(0, 8)+"...";
                String title=rs.getString("title").length()<20?rs.getString("title"): rs.getString("title").substring(0, 8)+"...";
                String borrowingDate=rs.getString("borrowingDate").length()<20?rs.getString("borrowingDate"): rs.getString("title").substring(0, 8)+"...";
                String studentUsername=rs.getString("studentUsername").length()<20?rs.getString("studentUsername"): rs.getString("studentUsername").substring(0, 8)+"...";
                String cin=rs.getString("cin").length()<8?rs.getString("cin"): rs.getString("cin").substring(0, 8)+"...";


                transactions.add(new Transaction(
                        adminUsername,
                        title,
                        borrowingDate,
                        studentUsername,
                        cin,
                        rs.getString("picture")
                ));
            };
            conDb.getCon().close();

        }catch (Exception ec){
            ec.printStackTrace();
            AlertMessage alertMessage=new AlertMessage("Whoops!", "", "Something went wrong");
            alertMessage.displayWarning();
        }

        return transactions;
    }

    @Override
    public boolean updateById(long id, Transaction newItem) {
        return false;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }
}
