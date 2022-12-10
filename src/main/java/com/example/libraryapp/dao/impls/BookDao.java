package com.example.libraryapp.dao.impls;

import com.example.libraryapp.dao.Dao;
import com.example.libraryapp.dao.db.ConnectionDB;
import com.example.libraryapp.models.Book;
import com.example.libraryapp.utils.AlertMessage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDao implements Dao<Book> {

    @Override
    public boolean save(Book item) {
        ConnectionDB conDb = new ConnectionDB();

        Statement st ;
        try {
            st = conDb.getCon().createStatement();
            String req="show databases;";
            ResultSet rs= st.executeQuery(req);
            while(rs.next()){
                System.out.println("It's working");
                System.out.println(rs);
            }
            conDb.getCon().close();
            return false;
        }catch (Exception ec){
            ec.printStackTrace();
            return true;
        }

    }

    public boolean addCopies(Book book){
        ConnectionDB conDb = new ConnectionDB();

        try {
            String req="select * from lib.books where title = ? ;";
            PreparedStatement ps = conDb.getCon().prepareStatement(req);
            ps.setString(1, book.getTitle());
            ResultSet rs= ps.executeQuery();

            boolean isThereCords=false;
            long bookId=1;

            while(rs.next()){
                bookId=rs.getLong("id");
                isThereCords=true;
                String reqUpdate="update lib.books set copyAmount = ? where title = ? ;";
                PreparedStatement psUpdate = conDb.getCon().prepareStatement(reqUpdate);
                psUpdate.setLong(1, rs.getLong("copyAmount")+book.getCopiesNumber());
                psUpdate.setString(2, book.getTitle());
                int updateRecords= psUpdate.executeUpdate();
                if(updateRecords>0){
                    AlertMessage alert=new AlertMessage("", "", "The copies have been added successfully");
                    alert.displayConfirmation();
                }else{
                    AlertMessage alert=new AlertMessage("", "", "Couldn't add these copies you may misspelled the name of the book");
                    alert.displayError();
                }
            }
            if(!isThereCords){
                AlertMessage alert=new AlertMessage("", "", "Couldn't add these copies you may misspelled the name of the book");
                alert.displayError();
            }else{
                for(int i=0; i<book.getCopiesNumber(); i++){
                    String reqInsert="insert into lib.bookcopies(book_id) values(?);";
                    PreparedStatement psInsert = conDb.getCon().prepareStatement(reqInsert);
                    psInsert.setLong(1, bookId);
                    int rsInsert= psInsert.executeUpdate();
                    System.out.println("Updates:\t"+rsInsert);
                }
            }
            conDb.getCon().close();
            return false;
        }catch (Exception ec){
            ec.printStackTrace();
            return true;
        }
    }
    public List<List<String>> getBooks() {
        ConnectionDB conDb = new ConnectionDB();
        Statement st ;
        try {
            st = conDb.getCon().createStatement();
            String req="SELECT * FROM books;";
            ResultSet rs= st.executeQuery(req);
            List<List<String>> row = new ArrayList<>();

            while(rs.next()){
                List<String> col = new ArrayList<>();
                col.add(rs.getString("title"));
                col.add(rs.getString("author"));
                col.add(rs.getString("picture"));
                col.add(rs.getString("datePub"));

                row.add(col);
            }
            for(List<String> s : row)
            {
                System.out.println(s);
            }
            conDb.getCon().close();
            return row;
        }catch (Exception ec){
            ec.printStackTrace();
            return null;
        }

    }



    @Override
    public Book getById(long id) {
        return null;
    }

    @Override
    public List<Book> getAll() {
        return null;
    }

    @Override
    public boolean updateById(long id, Book newItem) {
        return false;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }
}
