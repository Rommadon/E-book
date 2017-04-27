package com.example.stang.ebooksoftspec.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.stang.ebooksoftspec.R;
import com.example.stang.ebooksoftspec.data.Book;
import com.example.stang.ebooksoftspec.data.RemoteBookRepository;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BookView {

    private ArrayList<Book> books;
    private ArrayAdapter<Book> bookAdapter;

    TextView showBookTextView;
    RemoteBookRepository b;
    BookPresenter presenter = null;



    String strUrl = "https://theory.cpe.ku.ac.th/~jittat/courses/sw-spec/ebooks/books.json";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b = RemoteBookRepository.getInstance();

        if ( presenter == null ){
           presenter = new BookPresenter(b, this);
        }




    }



    public void displayListView(ArrayList<Book> temp){
        bookAdapter = new ArrayAdapter<Book>(this,android.R.layout.simple_list_item_1,temp);
        ListView listView = (ListView) findViewById(R.id.listview_book);
        listView.setAdapter(bookAdapter);
    }


    public void showBookList(){

    }



}
