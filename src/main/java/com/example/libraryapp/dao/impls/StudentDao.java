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
            String checkStudent = "SELECT COUNT(*) FROM students WHERE email like '"+item.getEmail()+"';";
            ResultSet rs = st.executeQuery(checkStudent);
            rs.next();
            boolean exists = rs.getInt("COUNT(*)")==0;
            if (exists){
                String req="INSERT INTO students(fullname,email,password,cin,description,priveleges,flagged) values('"+item.getUsername()+"','"+item.getEmail()+"','"+item.getPassword()+"','"+item.getCin()+"','"+item.getDescription()+"','"+item.getPrivileges()+"','"+item.getIsFlagged()+"');";
                st.executeUpdate(req);
                conDb.getCon().close();
                return true;
            }
            else {
                return false;
            }
        }catch (Exception ec){
            ec.printStackTrace();
            return false;
        }

    }

    public int checkLogin(Student item) {
        ConnectionDB conDb = new ConnectionDB();

        Statement st ;
        try {
            st = conDb.getCon().createStatement();
            String req = "SELECT priveleges FROM students WHERE email like '"+item.getEmail()+"' and password like '"+item.getPassword()+"'"+" UNION SELECT priveleges FROM admins WHERE email like '"+item.getEmail()+"' and password like '"+item.getPassword()+"'"+" UNION SELECT priveleges FROM superadmins WHERE email like '"+item.getEmail()+"' and password like '"+item.getPassword()+"';";
            ResultSet rs = st.executeQuery(req);
            rs.next();
            int exists = rs.getInt("priveleges");
            st.close();
            conDb.getCon().close();
            return exists;
        }catch (Exception ec){
            return 0;
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
