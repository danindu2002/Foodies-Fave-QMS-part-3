package com.example.sd2cwpart3;

import javafx.scene.control.Label;

public class WaitingQueue
{
    private static Customer[] waitingListQueue;
    // defining pointers for the circular queue names front & rear
    public static int front;
    public static int rear;
    public static int nItems;
    // maximum size for the waiting queue is 10
    private static int size;

    public WaitingQueue()
    {
        size = 10;
        waitingListQueue = new Customer[size];
        front = 0;
        rear = -1;
        nItems = 0;
    }
    // inserting customers into waiting queue
    public static void insert(Customer customer)
    {
        if(nItems == size) System.out.println("Waiting Queue is full");
        else
        {
            if(rear == size - 1) rear = -1;

            waitingListQueue[++rear] = customer;
            nItems++;
        }
    }
    // removing customers from the waiting queue
    public static Customer remove()
    {
        if(nItems == 0)
        {
            System.out.println("Waiting Queue is empty");
            return null;
        }
        else
        {
            Customer temp = waitingListQueue[front];
            waitingListQueue[front] = null;
            front++;

            if(front == size) front = 0;
            nItems--;
            return temp;
        }
    }
    // printing customer attributes to the console or the file
    public static void getWaitingQueueCustomers(boolean printToFile)
    {
        if (printToFile)  Main.fileInput.print("Customers in Waiting Queue     : ");
        else  System.out.print("Customers in Waiting Queue     : ");

        for (int i = 0; i < (nItems + front) ; i++)
        {
            if (waitingListQueue[i] != null)
            {
                String[] nameParts = Main.nameCapitalization(waitingListQueue[i].getFullName().split(" "));
                String customerInfo = nameParts[0] + " " + nameParts[1] + " - " + waitingListQueue[i].getBurgerAmount();

                if (printToFile)  Main.fileInput.print(customerInfo);
                else  System.out.print(customerInfo);

                if (i + 1 != (nItems + front) && waitingListQueue[i + 1] != null)
                {
                    if  (printToFile) Main.fileInput.print(", ");
                    else  System.out.print(", ");
                }
            }
        }
        if (printToFile)  Main.fileInput.println("\n");
        else  System.out.println("\n");
    }

    // overloaded method to set customer details for the GUI
    public static void getWaitingQueueCustomers(Label[] queueLabels)
    {
        if(nItems != 0)
        {
            int j = 0;
            // copying data to a new waiting queue array to keep the circular queue unchanged
            Customer[] waitingListQueueForGUI = waitingListQueue.clone();

            // repositioning customers in the new waiting list if 1 or more customers get added to the cashier queue
            if (waitingListQueueForGUI[0] == null)
            {
                for (int k = 1; k < 10; k++)
                {
                    if (waitingListQueueForGUI[k] != null)
                    {
                        waitingListQueueForGUI[j] = waitingListQueueForGUI[k];
                        waitingListQueueForGUI[k] = null;
                        j++;
                    }
                }
            }
            // setting remaining customer details to the labels
            for (int i = 0; i < nItems ; i++)
            {
                String[] nameParts = Main.nameCapitalization(waitingListQueueForGUI[i].getFullName().split(" "));
                String waitingCustomer = String.format("%s. %s %s  -  %s", (i+1), nameParts[0], nameParts[1], waitingListQueueForGUI[i].getBurgerAmount());
                queueLabels[i].setText(waitingCustomer);
            }
        }
    }
}