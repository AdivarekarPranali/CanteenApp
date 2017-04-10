package com.vjti.canteenapp;

/**
 * Created by DBS19 on 01-04-2017.
 */
public class Menu {
    int id;
    String dishname;
    int price;

    Menu(){
    }

    Menu(String name,int p)
    {
        dishname=name;
        price=p;
    }

    void setPrice(int price)
    {
        this.price=price;
    }
    void setDishname(String dishname)
    {
        this.dishname=dishname;
    }
    String getDishname()
    {
        return  dishname;
    }

    int getPrice()
    {
        return price;
    }
}
