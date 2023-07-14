package com.example.sd2cwpart3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    @FXML
    private RadioButton Both;

    @FXML
    private RadioButton FQ;

    @FXML
    private RadioButton WQ;

    @FXML
    private ToggleGroup selection;

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
    private TableColumn<Customer,String> burgersTab;

    @FXML
    private TableColumn<Customer, String> fNameTab;

    @FXML
    private TableColumn<Customer, String> sNameTab;

    @FXML
    private Button searchBtn;

    @FXML
    private TextField searchField;

    @FXML
    private TableView<Customer> tableView;
    private ObservableList<Customer> searchData;
    private Label[] fNameLabels;
    private Label[] sNameLabels;
    private Label[] countLabels;
    private Label[] queueLabels;
    private Label[] queueIncomes;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        int k = 0;
        // forming arrays for the same type of labels
        fNameLabels = new Label[]{fName, fName1, fName2, fName3, fName4, fName5, fName6, fName7, fName8, fName9};
        sNameLabels = new Label[]{sName, sName1, sName2, sName3, sName4, sName5, sName6, sName7, sName8, sName9};
        countLabels = new Label[]{count, count1, count2, count3, count4, count5, count6, count7, count8, count9};
        queueLabels = new Label[]{wQueue, wQueue1, wQueue2, wQueue3, wQueue4, wQueue5, wQueue6, wQueue7, wQueue8, wQueue9};
        queueIncomes = new Label[]{queueIncome1, queueIncome2, queueIncome3};

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
                    countLabels[k].setText(String.valueOf(Main.cashier[j].getCustomerQueue()[i].getBurgerAmount()));
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

        // setting values for the waiting queue
        WaitingQueue.getWaitingQueueCustomers(queueLabels);

        // storing data related to the search in the observable list
        searchData = FXCollections.observableArrayList();

        // setting up data binding between table columns and the objects
        fNameTab.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        sNameTab.setCellValueFactory(new PropertyValueFactory<>("secondName"));
        burgersTab.setCellValueFactory(new PropertyValueFactory<>("burgerAmount"));
        tableView.setItems(searchData);
    }

    @FXML
    void search(ActionEvent event)
    {
        String searchText = searchField.getText();
        searchData.clear();

        // checking if the search text is empty or not
        if (!searchText.isBlank() && searchText != null && !searchText.isEmpty())
        {
            for (int i = 0; i < 10; i++)
            {
                Customer customer = new Customer();
                // searching data related to the area selected (FQ- Food Queue, WQ- Waiting Queue)
                if (FQ.isSelected()) searchFoodQueue(i,customer);

                else if (WQ.isSelected()) searchWaitingQueue(i,customer);

                else if (Both.isSelected())
                {
                    searchFoodQueue(i,customer);
                    searchWaitingQueue(i,customer);
                }
                else
                {
                    // displaying an error type alert if no radio button is selected
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Missing Details");
                    alert.setContentText("Please select an option to search");
                    alert.showAndWait();
                    break;
                }
            }
        }
    }

    // searching for the exact phrase in the Food Queue
    void searchFoodQueue(int i, Customer customer)
    {
        String searchText = searchField.getText();
        if(!fNameLabels[i].getText().isBlank() && fNameLabels[i].getText() != null && !fNameLabels[i].getText().isEmpty())
        {
            // setting details if there is an exact match (case-insensitive) of first name or second name or burger count
            if (searchText.equalsIgnoreCase(fNameLabels[i].getText()) || searchText.equalsIgnoreCase(sNameLabels[i].getText()) || searchText.equalsIgnoreCase(countLabels[i].getText()))
            {
                customer.setFirstName(fNameLabels[i].getText());
                customer.setSecondName(sNameLabels[i].getText());
                customer.setBurgerAmount(Integer.parseInt(countLabels[i].getText()));
                searchData.add(customer); /* adding to the table */
            }
        }
    }
    // searching for the exact phrase in the Waiting Queue
    void searchWaitingQueue(int i, Customer customer)
    {
        String searchText = searchField.getText();
        if(WaitingQueue.nItems != 0 && i < WaitingQueue.nItems)
        {
            String[] waitingCustomers = queueLabels[i].getText().trim().split(" ");
            // setting details if there is an exact match (case-insensitive) of first name or second name or burger count
            if (searchText.equalsIgnoreCase(waitingCustomers[1].trim()) || searchText.equalsIgnoreCase(waitingCustomers[2].trim()) || searchText.equalsIgnoreCase(waitingCustomers[6].trim()))
            {
                customer.setFirstName(waitingCustomers[1].trim());
                customer.setSecondName(waitingCustomers[2].trim());
                customer.setBurgerAmount(Integer.parseInt(waitingCustomers[6].trim()));
                searchData.add(customer);
            }
        }
    }
}

