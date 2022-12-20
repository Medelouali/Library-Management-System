package com.example.libraryapp.dao.impls;

import com.example.libraryapp.dao.Dao;
import com.example.libraryapp.dao.db.ConnectionDB;
import com.example.libraryapp.models.Admin;

import com.example.libraryapp.models.Student;
import com.example.libraryapp.utils.AlertMessage;


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

            String checkStudent = "SELECT * FROM admins WHERE email='"+item.getEmail()+"' or cin='"+
                    item.getCin()+"' or username='"+item.getUsername()+"';";
            ResultSet rs = st.executeQuery(checkStudent);
            if (!rs.next()){
                String req="INSERT INTO admins(username,email,password,cin,description,flagged) values('"+item.getUsername()+"','"+item.getEmail()+"','"+item.getPassword()+"','"+item.getCin()+"','"+item.getDescription()+"','"+item.getIsFlagged()+"');";
                int res=st.executeUpdate(req);
                if(res<=0){
                    AlertMessage alertMessage=new AlertMessage("Whoops!!", "", "Something went wrong could not register!!, plz try again");
                    alertMessage.displayWarning();
                    conDb.getCon().close();
                    return false;
                }
                conDb.getCon().close();
                return true;
            };
            AlertMessage alertMessage=new AlertMessage("Whoops!!", "", "The username, cin or the email you entered is already in use");
            alertMessage.displayWarning();
            return false;
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
