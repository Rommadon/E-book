package com.example.stang.ebooksoftspec.data;

import java.util.ArrayList;

/**
 * Created by Stang on 4/20/2017.
 */

public class BookRepository implements Repository {


    public ArrayList<Book> list = new ArrayList<Book>();
    private static BookRepository instance = null;

    public static BookRepository getInstance(){
        if ( instance == null ){
            instance = new BookRepository();
        }
        return instance;
    }

    public BookRepository(){
        Book a = new Book(10,"abc",12,"Book1");
        Book b = new Book(20,"def",13,"Book2");
        Book c = new Book(30,"ghi",14,"Book3");
        list.add(a);
        list.add(b);
        list.add(c);
    }

    public void add(Book b) {
        list.add(b);
    }

    public ArrayList<Book> getAllBook(){
        return list;
    }


    @Override
    public void loadData() {

    }
}
