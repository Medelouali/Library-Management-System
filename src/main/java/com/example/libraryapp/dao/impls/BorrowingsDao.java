package com.example.libraryapp.dao.impls;

import com.example.libraryapp.dao.Dao;
import com.example.libraryapp.dao.db.ConnectionDB;
import com.example.libraryapp.models.Borrowings;
import com.example.libraryapp.models.Student;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class BorrowingsDao implements Dao<Borrowings> {

    @Override
    public boolean save(Borrowings item) {
        ConnectionDB conDb = new ConnectionDB();

        Statement st;
        try {
            st = conDb.getCon().createStatement();
            //String req="show databases;";
            String req="INSERT INTO borrowings VALUES('"+item.getId()+"','"+item.getCopyId()+"','"+item.getStudentId()+"',"+item.getAdminId()+","+item.getBorrowingDate()+","+item.getReturnDate()+")";
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



    @Override
    public Borrowings getById(long id) {
        return null;
    }

    @Override
    public List<Borrowings> getAll() {
        return null;
    }

    @Override
    public boolean updateById(long id, Borrowings newItem) {
        return false;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }
}