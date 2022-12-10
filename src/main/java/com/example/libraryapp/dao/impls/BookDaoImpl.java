package com.example.libraryapp.dao.impls;

import com.example.libraryapp.dao.Dao;
import com.example.libraryapp.dao.db.ConnectionDB;
import com.example.libraryapp.models.Book;
import com.example.libraryapp.utils.AlertMessage;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class BookDaoImpl implements Dao<Book> {
    @Override
    public boolean save(Book b) {
        ConnectionDB conDb = new ConnectionDB();
        Statement st;


        try {
            st = conDb.getCon().createStatement();
            //test if the book already exists
            String statement="select * from books where title='"+
                    b.getTitle()+"' OR isbn='"+b.getIsbn()+"';";
            ResultSet rs=st.executeQuery(statement);
            if(rs.next()){
                AlertMessage alertMessage=new AlertMessage("Whoops:(", "", "Sorry! "+
                        b.getTitle()+" is already in the database, can't add a book twice.");
                alertMessage.displayWarning();
                return true;
            }
            String req="INSERT INTO books(title, author, genre, isbn, rating, language, copyAmount, datePub) " +
                    "values('"+b.getTitle()+"','"+b.getAuthorName()+"','"+b.getGenre()+"','"+
                    b.getIsbn()+"','"+b.getRating()+"','"+b.getLanguage()+"','"+b.getCopiesNumber()+"','"
                    +b.getDatePub()+"');";
            if(st.executeUpdate(req)>0){
                AlertMessage alertMessage=new AlertMessage("Congrats:)", "", "Congrats! "+
                        b.getTitle()+" was added successfully please add more people need to read:)");
                alertMessage.displayConfirmation();
            }else{
                AlertMessage alertMessage=new AlertMessage("Whoops:(", "", "Sorry! "+
                        b.getTitle()+" couldn't be added something went wrong please try again");
                alertMessage.displayWarning();
            }
            conDb.getCon().close();
        }catch (Exception ec){
            ec.printStackTrace();
            AlertMessage alertMessage=new AlertMessage("Whoops:(", "", "Congrats! "+
                    b.getTitle()+" couldn't be added something went wrong please try again");
            alertMessage.displayWarning();
        };
        return false;
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
