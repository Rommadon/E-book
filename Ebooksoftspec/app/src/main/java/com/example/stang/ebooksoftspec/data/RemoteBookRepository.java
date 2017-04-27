package com.example.stang.ebooksoftspec.data;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by Stang on 4/27/2017.
 */

public class RemoteBookRepository extends Observable implements Repository {

    public ArrayList<Book> list = new ArrayList<Book>();
    private static RemoteBookRepository instance = null;


    public static RemoteBookRepository getInstance() {
        if (instance == null) {
            instance = new RemoteBookRepository();
        }
        return instance;
    }

    @Override
    public void loadData() {
        BookFetcherTask task = new BookFetcherTask();
        task.execute();
    }

    public ArrayList<Book> getAllBook(){
        return list;
    }


    public class BookFetcherTask extends AsyncTask<Void, Void, ArrayList<Book>> {

        @Override
        protected ArrayList<Book> doInBackground(Void... params) {
            String bookListJsonStr = loadTopicJson();
            if (bookListJsonStr == null) {
                return null;
            }
            ArrayList<Book> results = new ArrayList<>();
            try {
                JSONArray dataArray = new JSONArray(bookListJsonStr);

                for (int i = 0; i < dataArray.length(); i++) {
                    JSONObject bookJson = dataArray.getJSONObject(i);
                    Book book = new Book(bookJson.getDouble("price"), bookJson.getString("img_url"), bookJson.getInt("id"), bookJson.getString("title"));
                    results.add(book);
                }
            } catch (JSONException e) {
                return null;
            }
            return results;
        }

        private String loadTopicJson() {
            String result = "";
            try {
                URL dataUrl = new URL("https://theory.cpe.ku.ac.th/~jittat/courses/sw-spec/ebooks/books.json");
                URLConnection conn = dataUrl.openConnection();
                BufferedReader in = new BufferedReader(new InputStreamReader((
                        conn.getInputStream()
                )));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    result += inputLine;
                }
                return result;
            } catch (IOException e) {
                return result;
            }
        }

        @Override
        protected void onPostExecute(ArrayList<Book> results) {
            if (results != null) {
                list.clear();
                for (Book t : results) {
                    list.add(t);
                }
                setChanged();
                notifyObservers();
            }
        }
    }
}
