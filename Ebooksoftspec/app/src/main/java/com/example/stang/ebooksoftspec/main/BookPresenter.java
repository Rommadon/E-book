package com.example.stang.ebooksoftspec.main;

import com.example.stang.ebooksoftspec.data.Book;
import com.example.stang.ebooksoftspec.data.Repository;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Stang on 4/20/2017.
 */

public class BookPresenter implements Observer {

    public BookView view;
    private Repository bookList;

    public BookPresenter(Repository b , BookView v){
        bookList = b;
        view = v;
    }

    public void displayList(ArrayList<Book> b){
        view.displayListView(b);
    }

    /**
     * This method is called whenever the observed object is changed. An
     * application calls an <tt>Observable</tt> object's
     * <code>notifyObservers</code> method to have all the object's
     * observers notified of the change.
     *
     * @param o   the observable object.
     * @param arg an argument passed to the <code>notifyObservers</code>
     */
    @Override
    public void update(Observable o, Object arg) {
        displayList(bookList.getAllBook());
    }

//    public String showBookList(){
//        ArrayList<Book> list = bookList.getAllBook();
//        String s = "";
//        for ( Book book : list){
//            s += book.toString();
//        }
//        return s;
//
//    }




}
