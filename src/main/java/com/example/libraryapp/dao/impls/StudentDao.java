package com.example.libraryapp.dao.impls;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.example.libraryapp.dao.Dao;
import com.example.libraryapp.dao.db.ConnectionDB;
import com.example.libraryapp.models.*;
public class StudentDao implements Dao<Student> {

    @Override
    public boolean save(Student item) {
        ConnectionDB conDb = new ConnectionDB();

        Statement st ;
        try {
            st = conDb.getCon().createStatement();
            String req="select * from lib.books;";
            ResultSet rs= st.executeQuery(req);
            while(rs.next()){
                System.out.println(rs.getString(1));
                System.out.println(rs);
            }
            conDb.getCon().close();
            return false;
        }catch (Exception ec){
            ec.printStackTrace();
            return true;
        }

    }

    //it returns a string because we need the msg in popup box if there's a problem
    public String hasAlreadyBorrowedBook(Student student, String title, String author, String isbn, boolean state, String returnDate){
        ConnectionDB conDb = new ConnectionDB();

        try{
            String req="select * from lib.students where username = \""
                    +student.getUsername()+"\" and cin=\""+student.getCin()+"\"";

            PreparedStatement psSelect = conDb.getCon().prepareStatement(req);
            ResultSet rs=psSelect.executeQuery(req);

            if(rs.next()){
                ResultSet rsTemp=psSelect.executeQuery(req);
                if(rsTemp.next()){
                    String reqBorrowed="select * lib.borrowings where student_id = ? ;";
                    PreparedStatement psSelect2 = conDb.getCon().prepareStatement(reqBorrowed);
                    psSelect2.setLong(1, rsTemp.getLong(1));
                    ResultSet rs2=psSelect2.executeQuery(reqBorrowed);
                    if(rs2.next()){
                        String reqDelete="delete from lib.borrowings where student_id = ? ;";
                        PreparedStatement psSelect3 = conDb.getCon().prepareStatement(reqDelete);
                        psSelect3.setLong(1, rsTemp.getLong(1));
                        int deletedBorrowings=psSelect2.executeUpdate(reqDelete);
                        if(deletedBorrowings>0){
                            String reqUpdate="update lib.bookcopies set availability=\"available\", state=\""
                                    +(state ? "good": "bad")+ "\";";
                            PreparedStatement psSelect4 = conDb.getCon().prepareStatement(reqUpdate);
                            psSelect4.setLong(1, rsTemp.getLong(1));
                            int updateBorrowings=psSelect2.executeUpdate(reqUpdate);
                            if(updateBorrowings>0){
                                return "";
                            }
                            return "Something went wrong please make sure of the info and try later";
                        }
                        return "Could not register this action, plz verify the entered info and try again";

                    };
                    return student.getUsername()+" didn't borrow a book before plz verify the entered info and try again";
                }
                return student.getUsername()+" doesn't exist on our database, he/she is not registered plz sign him up first and try again";
            }
            return student.getUsername()+" doesn't exist on our database, he/she is not registered plz sign him up first and try again";
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }

    }
    @Override
    public Student getById(long id) {
        return null;
    }

    @Override
    public List<Student> getAll() {
        return null;
    }

    @Override
    public boolean updateById(long id, Student newItem) {
        return false;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }
}
