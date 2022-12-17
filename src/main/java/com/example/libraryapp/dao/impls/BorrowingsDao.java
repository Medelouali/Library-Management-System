package com.example.libraryapp.dao.impls;

import com.example.libraryapp.dao.Dao;
import com.example.libraryapp.dao.db.ConnectionDB;
import com.example.libraryapp.models.Borrowings;
import com.example.libraryapp.models.Student;
import com.example.libraryapp.utils.AlertMessage;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class BorrowingsDao implements Dao<Borrowings> {

    @Override
    public boolean save(Borrowings item) {
        ConnectionDB conDb = new ConnectionDB();

        Statement st;
        //check
        try {
            st = conDb.getCon().createStatement();
            ///////////////////the number not inf a 0/////////////////
            String req2="select copyAmount from books where id='"+item.getCopyId()+"';";//le nomber de copie disponible de book
            System.out.println(req2);


            ResultSet result = st.executeQuery(req2);
            result.next();
            System.out.println("test");
            //System.out.println(st.getResultSet().getString(1));// to delete after
            System.out.println(result.getLong(1));


            System.out.println("test1");

            if( result.getLong(1) == 0 ){// the book not available
                AlertMessage alertMessage=new AlertMessage("sorry","","the book not available");
                alertMessage.displayConfirmation();
                return false;
            }
            System.out.println("5454545454");
            long temp= result.getLong(1) - 1;// décrémenter le nomber des copie

            ///////////////// the number not more than 10/////////////////
            String req4="select maxBorrowed from students where id = "+item.getStudentId()+";";
            System.out.println(req4);
            //st.executeQuery(req4);
            ResultSet result2 = st.executeQuery(req4);
            result2.next();
            System.out.println(result2.getLong(1));

            if( result2.getLong(1) == 10 ){// the book not available
                AlertMessage alertMessage=new AlertMessage("sorry","","u have already took 10 book");
                alertMessage.displayConfirmation();
                return false;
            }
            long temp2= result2.getLong(1) + 1;// incrémenter le nomber des copie



            String req="INSERT INTO `borrowings` (`student_id`, `copy_id`, `admin_id`, `borrowingDate`, `returnDate`)  VALUES('"+item.getStudentId()+"','"+item.getCopyId()+"','"+item.getAdminId()+"','"+item.getBorrowingDate()+"','"+item.getReturnDate()+"');";
            String req3="UPDATE books SET copyAmount = "+temp+"  WHERE id="+item.getCopyId()+";";
            String req5="UPDATE students SET maxBorrowed = "+temp2+"  WHERE id="+item.getStudentId()+";";


            System.out.println(req);
            System.out.println(req3);
            System.out.println(req5);

            //st.executeQuery(req);// pour select
            st.executeUpdate(req);//pour updet or insert or deletes
            st.executeUpdate(req3);//pour update the number of copy
            st.executeUpdate(req5);//pour update the number of books the students take

            AlertMessage alertMessage=new AlertMessage("Congratulation","","congratulation : info has been saved successfully");
            alertMessage.displayConfirmation();

            conDb.getCon().close();
            return false;
            // ------------------------------------------------------ //

        }catch (Exception ec){
            AlertMessage alertMessage=new AlertMessage("ops","","You put the wrong information !! make sure that the ISBN or CIN exists in database.");
            alertMessage.displayWarning();
            ec.printStackTrace();

            return true;
        }

        //insert the value




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
