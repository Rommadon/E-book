package com.example.stang.ebooksoftspec.data;

import java.util.ArrayList;

/**
 * Created by Stang on 4/27/2017.
 */

public interface Repository {
    void loadData();
    ArrayList<Book> getAllBook();
}
