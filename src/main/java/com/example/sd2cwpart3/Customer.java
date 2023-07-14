package com.example.sd2cwpart3;
public class Customer
{
    private String firstName;
    private String secondName;
    private int burgerAmount;

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public void setSecondName(String secondName)
    {
        this.secondName = secondName;
    }
    public void setBurgerAmount(int burgerAmount)
    {
        this.burgerAmount = burgerAmount;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getFullName()
    {
        if(firstName != null && secondName != null) return firstName + " " + secondName;
        else return null;
    }
    public int getBurgerAmount()
    {
        return burgerAmount;
    }

    // creating a customer object from each detail set and returning the customer
    public static Customer setLoadedCustomer(String[] customerAttributes)
    {
        Customer customer = new Customer();
        customer.setFirstName(customerAttributes[0].toLowerCase());
        customer.setSecondName(customerAttributes[1].toLowerCase());
        customer.setBurgerAmount(Integer.parseInt(customerAttributes[3]));

        return customer;
    }
}
