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

        Statement st;
        //check
        try {
            st = conDb.getCon().createStatement();
            String doesStudentExist="select * from students where cin='"+item.getStudentCin()+"'";
            String doesBookExist="select * from books where isbn='"+item.getBookIsbn()+"'";
            ResultSet stdSet=st.executeQuery(doesStudentExist);
            ResultSet bookSet=st.executeQuery(doesBookExist);
            if(!stdSet.next() || !bookSet.next()){
                AlertMessage alertMessage=new AlertMessage("Whooops","","Either the book isbn is wrong the you misspelled the student cin, please check again:(");
                alertMessage.displayWarning();
                return true;
            }

            // check if a copy of that book is not available
            String isCopyAvailabe="select * from bookcopies where book_id='"+
                    bookSet.getLong("id")+
                    "' and state='good' and availability='available'";
            ResultSet availabilitySet=st.executeQuery(isCopyAvailabe);
            if(!availabilitySet.next()){
                AlertMessage alertMessage=new AlertMessage("Whooops","","This book can't borrowed either because is not in good state or it's not available right now or there are no more copies of this book in the stock, please choose another book:(");
                alertMessage.displayWarning();
                return true;
            }

            // checking if that student has exceeded the booksMax=10
            String maxBorrowings="select count(*) as counter from students, borrowings where borrowings.student_id='"+
                    stdSet.getLong("id")
                    +"'";
            ResultSet maxBorrowingsSet=st.executeQuery(maxBorrowings);
            if(maxBorrowingsSet.next()){
                if(maxBorrowingsSet.getLong("counter")>10){
                    AlertMessage alertMessage=new AlertMessage("ops","","Students are allowed to borrow up to 10 books, this student exceeded the range, plz return one book to get a new one");
                    alertMessage.displayWarning();
                    return true;
                }
            }

            System.out.println("Cin: "+Main.getUser().getCin());

            conDb.getCon().close();
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
