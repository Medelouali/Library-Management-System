
package com.example.libraryapp.controllers;

import com.example.libraryapp.dao.impls.TransactionsDao;
import com.example.libraryapp.models.Transaction;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TransactionsController extends HomeController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Transaction> transactions= (new TransactionsDao()).getAll();
        try {
            for(int i =0 ;i<transactions.size();i++){
                FXMLLoader fxmlLoader= new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com/example/libraryapp/views/transaction-view.fxml"));
//                fxmlLoader.setLocation(getClass().getResource("views/CardBook.fxml"));
                HBox cardboard =fxmlLoader.load();
                TransactionController transactionController = fxmlLoader.getController();
                transactionController.setData(transactions.get(i));
                TransactionsLayout.getChildren().add(cardboard);
            }
        }catch (IOException e){
            e.printStackTrace();

        }

    }


}
