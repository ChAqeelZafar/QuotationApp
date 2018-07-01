package com.example.johnwick.quotationapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static TextView content, title ;
    Button next, exit ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        content = findViewById(R.id.main_text_content);
        next = findViewById(R.id.main_btn_next);
        title = findViewById(R.id.main_text_title);
        exit = findViewById(R.id.main_btn_exit);

        FetchedData fetchedData = new FetchedData();
        fetchedData.execute();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FetchedData fetchedData = new FetchedData();
                fetchedData.execute();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });



    }
}
