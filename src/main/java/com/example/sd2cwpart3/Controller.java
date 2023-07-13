package com.example.sd2cwpart3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{

    @FXML
    private Label count;

    @FXML
    private Label count1;

    @FXML
    private Label count2;

    @FXML
    private Label count3;

    @FXML
    private Label count4;

    @FXML
    private Label count5;

    @FXML
    private Label count6;

    @FXML
    private Label count7;

    @FXML
    private Label count8;

    @FXML
    private Label count9;

    @FXML
    private Label wQueue;

    @FXML
    private Label wQueue1;

    @FXML
    private Label wQueue2;

    @FXML
    private Label wQueue3;

    @FXML
    private Label wQueue4;

    @FXML
    private Label wQueue5;

    @FXML
    private Label wQueue6;

    @FXML
    private Label wQueue7;

    @FXML
    private Label wQueue8;

    @FXML
    private Label wQueue9;

    @FXML
    private Label fName;

    @FXML
    private Label fName1;

    @FXML
    private Label fName2;

    @FXML
    private Label fName3;

    @FXML
    private Label fName4;

    @FXML
    private Label fName5;

    @FXML
    private Label fName6;

    @FXML
    private Label fName7;

    @FXML
    private Label fName8;

    @FXML
    private Label fName9;

    @FXML
    private Label sName;

    @FXML
    private Label sName1;

    @FXML
    private Label sName2;

    @FXML
    private Label sName3;

    @FXML
    private Label sName4;

    @FXML
    private Label sName5;

    @FXML
    private Label sName6;

    @FXML
    private Label sName7;

    @FXML
    private Label sName8;

    @FXML
    private Label sName9;

    @FXML
    private Label emptySlotsCount;

    @FXML
    private Label queueIncome1;

    @FXML
    private Label queueIncome2;

    @FXML
    private Label queueIncome3;

    @FXML
    private Label remainingBurgerCount;

    @FXML
    private Label reservedBurgersCount;

    @FXML
    private Label servedCustomersCount;

    @FXML
    private Label soldBurgersCount;

    @FXML
    private Label waitingQueueCount;

    @FXML
    private TableColumn<Customer,Integer> burgersTab;

    @FXML
    private TableColumn<Customer, String> fNameTab;

    @FXML
    private TableColumn<Customer, String> sNameTab;

    @FXML
    private Button searchBtn;

    @FXML
    private TextField searchField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        int k = 0;
        // forming arrays for the same type of labels
        final Label[] fNameLabels = {fName, fName1, fName2, fName3, fName4, fName5, fName6, fName7, fName8, fName9};
        final Label[] sNameLabels = {sName, sName1, sName2, sName3, sName4, sName5, sName6, sName7, sName8, sName9};
        final Label[] countLabels = {count, count1, count2, count3, count4, count5, count6, count7, count8, count9};
        final Label[] queueLabels = {wQueue, wQueue1, wQueue2, wQueue3, wQueue4, wQueue5, wQueue6, wQueue7, wQueue8, wQueue9};
        final Label[] queueIncomes = {queueIncome1, queueIncome2, queueIncome3};

        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (i >= Main.cashier[j].getCustomerQueue().length) continue;
                // setting values for each set of labels
                if (Main.cashier[j].getCustomerQueue()[i] != null)
                {
                    String[] nameParts = Main.nameCapitalization(Main.cashier[j].getCustomerQueue()[i].getFullName().split(" "));
                    fNameLabels[k].setText(nameParts[0]);
                    sNameLabels[k].setText(nameParts[1]);
                    countLabels[k].setText(String.valueOf(Main.cashier[j].getCustomerQueue()[i].getBurgerCount()));
                    k++;
                }
                if (i == 0)  queueIncomes[j].setText("Rs. " + String.valueOf(FoodQueue.queueIncome[j]));
            }
        }
        // setting values for the other informative variables
        emptySlotsCount.setText(String.valueOf(FoodQueue.emptySlots));
        remainingBurgerCount.setText(String.valueOf(Main.burgerStock));
        soldBurgersCount.setText(String.valueOf(FoodQueue.soldBurgers));
        servedCustomersCount.setText(String.valueOf(FoodQueue.servedCustomerCount));
        waitingQueueCount.setText(String.valueOf(WaitingQueue.nItems));
        reservedBurgersCount.setText(String.valueOf(FoodQueue.reservedBurgers));

        WaitingQueue.getWaitingQueueCustomers(queueLabels);
    }

    @FXML
    void search(ActionEvent event)
    {
//        String searchText = searchField.getText();
//        if(!searchText.isBlank() && searchText != null && !searchText.isEmpty())
//        {
//            for(int i = 0; i < 10; i++)
//            {
//               if(searchText.equals(fNameLabels[]))
//            }
//        }
    }
}

