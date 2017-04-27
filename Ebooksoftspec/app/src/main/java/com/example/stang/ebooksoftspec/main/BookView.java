package com.example.stang.ebooksoftspec.main;

import com.example.stang.ebooksoftspec.data.Book;

import java.util.ArrayList;

/**
 * Created by Stang on 4/20/2017.
 */

public interface BookView {

    void showBookList();

    void displayListView(ArrayList<Book> b);
}
