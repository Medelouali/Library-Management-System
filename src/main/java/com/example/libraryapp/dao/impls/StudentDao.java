package com.example.libraryapp.dao.impls;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
            return false;
        }catch (Exception ec){
            ec.printStackTrace();
            return true;
        }

    }
    public List<List<String>> getStudents() {
        ConnectionDB conDb = new ConnectionDB();

        Statement st ;
        try {
            st = conDb.getCon().createStatement();
            String req="SELECT * FROM students;";
            ResultSet rs= st.executeQuery(req);
            List<List<String>> row = new ArrayList<>();
            while(rs.next()){
                List<String> col = new ArrayList<>();
                col.add(rs.getString("fullname"));
                col.add(rs.getString("description"));
                col.add(rs.getString("picture"));

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
