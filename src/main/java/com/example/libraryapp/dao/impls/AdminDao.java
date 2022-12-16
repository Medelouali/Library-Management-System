package com.example.libraryapp.dao.impls;

import com.example.libraryapp.dao.Dao;
import com.example.libraryapp.dao.db.ConnectionDB;
import com.example.libraryapp.models.Admin;

import com.example.libraryapp.models.Student;


import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class AdminDao implements Dao<Admin> {

    @Override
    public boolean save(Admin item) {
        ConnectionDB conDb = new ConnectionDB();

        Statement st ;
        try {
            st = conDb.getCon().createStatement();

            String checkStudent = "SELECT COUNT(*) FROM admins WHERE email like '"+item.getEmail()+"';";
            ResultSet rs = st.executeQuery(checkStudent);
            rs.next();
            boolean exists = rs.getInt("COUNT(*)")==0;
            if (exists){
                String req="INSERT INTO admins(username,email,password,cin,description,flagged) values('"+item.getUsername()+"','"+item.getEmail()+"','"+item.getPassword()+"','"+item.getCin()+"','"+item.getDescription()+"','"+item.getIsFlagged()+"');";
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


    public Admin checkLogin(Student item) {
        ConnectionDB conDb = new ConnectionDB();

        Statement st;
        try {
            st = conDb.getCon().createStatement();
            String req = "SELECT id,username,privileges FROM students WHERE email like '"
                    +item.getEmail()+"' and password like '"+item.getPassword()+"'"+
                    " UNION SELECT id,username,privileges FROM admins WHERE email like '"+item.getEmail()+
                    "' and password like '"+item.getPassword()+"'"+" UNION SELECT id,username,privileges FROM superadmins WHERE email like '"+
                    item.getEmail()+"' and password like '"+item.getPassword()+"';";
            ResultSet rs = st.executeQuery(req);
            rs.next();
            Admin admin = new Admin(rs.getInt("id"),rs.getString("username"),rs.getInt("privileges"));
            st.close();
            conDb.getCon().close();
            return admin;
        }catch (Exception ec){
            return new Admin(0,"",0);
        }
    }

    @Override
    public Admin getById(long id) {
        return null;
    }

    @Override
    public List<Admin> getAll() {
        return null;
    }

    @Override
    public boolean updateById(long id, Admin newItem) {
        return false;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }
}
