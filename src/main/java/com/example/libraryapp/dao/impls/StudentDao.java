package com.example.libraryapp.dao.impls;

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
            String req="show databases;";
            ResultSet rs= st.executeQuery(req);
            while(rs.next()){
                System.out.println("It's working");
                System.out.println(rs);
            }
            conDb.getCon().close();
        }catch (Exception ec){
            ec.printStackTrace();
        }
        return false;
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
