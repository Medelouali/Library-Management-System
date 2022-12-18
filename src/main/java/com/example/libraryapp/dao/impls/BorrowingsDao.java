package com.example.libraryapp.dao.impls;

import com.example.libraryapp.Main;
import com.example.libraryapp.dao.Dao;
import com.example.libraryapp.dao.db.ConnectionDB;
import com.example.libraryapp.models.Borrowings;

import com.example.libraryapp.utils.AlertMessage;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class BorrowingsDao implements Dao<Borrowings> {

    @Override
    public boolean save(Borrowings item) {
        ConnectionDB conDb = new ConnectionDB();

        Statement st, st2, st3, st4, st5, st6, st7, st8;
        //check
        try {
            st = conDb.getCon().createStatement();
            String doesStudentExist="select * from students where cin='"+item.getStudentCin()+"'";
            String doesBookExist="select * from books where isbn='"+item.getBookIsbn()+"'";
            ResultSet stdSet=st.executeQuery(doesStudentExist);
            st2 = conDb.getCon().createStatement();
            ResultSet bookSet=st2.executeQuery(doesBookExist);
            if(!stdSet.next() || !bookSet.next()){
                AlertMessage alertMessage=new AlertMessage("Whooops","","Either the book isbn is wrong the you misspelled the student cin, please check again:(");
                alertMessage.displayWarning();
                conDb.getCon().close();
                return true;
            }

            // check if a copy of that book is not available
            String isCopyAvailabe="select * from bookcopies where book_id='"+
                    bookSet.getLong("id")+
                    "' and state='good' and availability='available'";
            st3 = conDb.getCon().createStatement();
            ResultSet availabilitySet=st3.executeQuery(isCopyAvailabe);
            if(!availabilitySet.next()){
                AlertMessage alertMessage=new AlertMessage("Whooops","","This book can't borrowed either because is not in good state or it's not available right now or there are no more copies of this book in the stock, please choose another book:(");
                alertMessage.displayWarning();
                conDb.getCon().close();
                return true;
            }

            // checking if that student has exceeded the booksMax=10
            String maxBorrowings="select count(*) as counter from students, borrowings where borrowings.student_id='"+
                    stdSet.getLong("id")
                    +"'";
            st4 = conDb.getCon().createStatement();
            ResultSet maxBorrowingsSet=st4.executeQuery(maxBorrowings);
            if(maxBorrowingsSet.next()){
                if(maxBorrowingsSet.getLong("counter")>10){
                    AlertMessage alertMessage=new AlertMessage("ops","","Students are allowed to borrow up to 10 books, this student exceeded the range, plz return one book to get a new one");
                    alertMessage.displayWarning();
                    conDb.getCon().close();
                    return true;
                }
            }
            String reqAmount="select copyAmount from books where id='"+
                    bookSet.getLong("id")+"'";
            st5 = conDb.getCon().createStatement();
            ResultSet reqAmountSet=st5.executeQuery(reqAmount);
            String req="INSERT INTO `borrowings` (`student_id`, `copy_id`, `admin_id`, `borrowingDate`, `returnDate`)  VALUES('"+
                    stdSet.getLong("id")+"','"+availabilitySet.getLong("id")+
                    "','"+1+"','"+item.getBorrowingDate()+"','"+item.getReturnDate()+"');";
            st8 = conDb.getCon().createStatement();
            int req2Set=st8.executeUpdate(req);

            String req3="UPDATE books SET copyAmount = "+(reqAmountSet.getLong("copyAmount")-1)+
                    " WHERE id="+bookSet.getLong("id")+";";
            st6 = conDb.getCon().createStatement();
            int req3Set=st6.executeUpdate(req3);

            String req4="UPDATE bookcopies SET availability = 'unavailable' where id='"+
                    availabilitySet.getLong("id")+";";
            st7 = conDb.getCon().createStatement();
            int req4Set=st7.executeUpdate(req4);

            if(req2Set>0 && req3Set>0 && req4Set>0){
                AlertMessage alertMessage=new AlertMessage("Congrats","","The book has been issued successfully:)");
                alertMessage.displayConfirmation();
                conDb.getCon().close();
                return false;
            }
            System.out.println("Cin: "+Main.getUser().getEmail());


            conDb.getCon().close();
            AlertMessage alertMessage=new AlertMessage("Whoops","","The book couldn't get issued something went wrong, plz try later:(");
            alertMessage.displayWarning();
            return false;
            // ------------------------------------------------------ //

        }catch (Exception ec){
            AlertMessage alertMessage=new AlertMessage("Whooops","","You put the wrong information !! make sure that the ISBN or CIN exists in database.");

            alertMessage.displayWarning();
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
