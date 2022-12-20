package com.example.libraryapp.dao.impls;


import com.example.libraryapp.utils.PasswordHash;
import com.example.libraryapp.dao.Dao;
import com.example.libraryapp.dao.db.ConnectionDB;
import com.example.libraryapp.models.Student;
import com.example.libraryapp.utils.AlertMessage;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentDaoImpl implements Dao<Student> {

    @Override
    public boolean save(Student e) {
        ConnectionDB conDb = new ConnectionDB();

        Statement st ;
        try {
            st = conDb.getCon().createStatement();
            //test if the student already exists in db first
            String statement="select * from students where username='"+
                    e.getUsername()+"' OR email='"+e.getEmail()+"';";
            ResultSet rs=st.executeQuery(statement);
            if(rs.next()){
                AlertMessage alertMessage=new AlertMessage("Whoops:(", "", "Sorry! "+
                        e.getUsername()+" is already in the database, can't add a student twice.");
                alertMessage.displayWarning();
                return true;
            }
            String req="INSERT INTO students(username, email, password, cin, description) values('"+
                    e.getUsername()+"','"+e.getEmail()+"','"+
                    PasswordHash.encrypte(e.getPassword())+
                    "','"+e.getCin()+"','"+e.getDescription()+"');";
            if(st.executeUpdate(req)>0){
                AlertMessage alertMessage=new AlertMessage("Congrats:)", "", "Congrats! "+
                        e.getUsername()+" was added successfully please add more people need to read:)");
                alertMessage.displayConfirmation();
            }else{
                AlertMessage alertMessage=new AlertMessage("Whoops:(", "", "Sorry! "+
                        e.getUsername()+" couldn't be added something went wrong please try again");
                alertMessage.displayWarning();
            }
            conDb.getCon().close();
        }catch (Exception ec){
            ec.printStackTrace();
            AlertMessage alertMessage=new AlertMessage("Whoops:(", "", "Sorry! "+
                    e.getUsername()+" couldn't be added something went wrong please try again");
            alertMessage.displayWarning();
        };
        return true;
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

    public boolean validateEmail(Student s){
        var p = Pattern.compile("[a-zA-z0-9][a-zA-z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher m =  p.matcher(s.getEmail());
        if (m.find() && m.group().equals(s.getEmail())){
            return true ;}
        else {
            return false ;
        }

    }
    //usernames are unique in the app, before we regsiter a student we make a test
    //if the student with that username is already exists
    public void deleteByUsername(String username){
        ConnectionDB conDb = new ConnectionDB();
        Statement st ;
        try {
            st = conDb.getCon().createStatement();
            // no need to delete from borrowings...because we are using on Cascade in db on
            // deleting records in those tables, check tables plz for more info
            String statement="delete from students where username='"+ username +"';";
            int rs=st.executeUpdate(statement);
            if(rs<1){
                AlertMessage alertMessage=new AlertMessage("Whoops:(", "", "Sorry! "+
                        username+" couldn't be deleted try later please!");
                alertMessage.displayWarning();
                return;
            }

            AlertMessage alertMessage=new AlertMessage("Congrats:)", "", "Yoo! "+
                        username+" has been deleted successfully");
                alertMessage.displayWarning();
            conDb.getCon().close();
        }catch (Exception ec){
            ec.printStackTrace();
            AlertMessage alertMessage=new AlertMessage("Whoops:(", "", "Sorry! "+
                    username+" couldn't be deleted try later please!");
            alertMessage.displayWarning();
        };
    }




}
