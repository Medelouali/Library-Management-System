package com.example.libraryapp.dao.impls;


import com.example.libraryapp.dao.Dao;
import com.example.libraryapp.dao.db.ConnectionDB;
import com.example.libraryapp.models.SuperAdmin;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class SuperAdminDao implements Dao<SuperAdmin> {

    @Override
    public boolean save(SuperAdmin item) {
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

    @Override
    public SuperAdmin getById(long id) {
        return null;
    }

    @Override
    public List<SuperAdmin> getAll() {
        return null;
    }

    @Override
    public boolean updateById(long id, SuperAdmin newItem) {
        return false;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }
}
