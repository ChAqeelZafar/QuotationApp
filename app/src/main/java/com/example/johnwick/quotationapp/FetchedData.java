package com.example.johnwick.quotationapp;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FetchedData extends AsyncTask<Void, Void, Void> {

    String data = "" ;
    String title = "" ;
    String content = "" ;
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        MainActivity.content.setText(this.content);
        MainActivity.title.setText(this.title);
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://talaikis.com/api/quotes/random/");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line = "" ;
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line ;
            }


            JSONObject jsonObject = new JSONObject(data);
            title = "Author : " + jsonObject.get("author");
            content = jsonObject.get("quote") + "";



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}





