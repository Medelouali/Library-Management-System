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
            String req="INSERT INTO students(fullname,email,password,cin,description,priveleges,flagged) values('"+item.getUsername()+"','"+item.getEmail()+"','"+item.getPassword()+"','"+item.getCin()+"','"+item.getDescription()+"','"+item.getPrivileges()+"','"+item.getIsFlagged()+"');";
            st.executeUpdate(req);
            conDb.getCon().close();
            return true;
        }catch (Exception ec){
            ec.printStackTrace();
            return false;
        }

    }

    public boolean check(Student item) {
        ConnectionDB conDb = new ConnectionDB();

        Statement st ;
        try {
            st = conDb.getCon().createStatement();
            String req = "SELECT COUNT(*) FROM students WHERE email like '"+item.getEmail()+"' and password like '"+item.getPassword()+"';";
            ResultSet rs = st.executeQuery(req);
            rs.next();
            boolean exists = rs.getInt("COUNT(*)") > 0;
            st.close();
            conDb.getCon().close();
            return exists;
        }catch (Exception ec){
            ec.printStackTrace();
            return false;
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
