package com.example.stang.ebooksoftspec.data;

/**
 * Created by Stang on 4/20/2017.
 */

public class Book {

    public double price;
    public String url,title;
    public int id;


    public Book(double p , String u , int i , String t){
        price = p;
        url = u;
        id = i;
        title = t;
    }

    public double getPrice(){
        return price;
    }


    public String getUrl(){
        return url;
    }

    public String getTitle(){
        return title;
    }

    public int getId(){
        return id;
    }

    public String toString(){
        return title + " " + id ;
    }

}
