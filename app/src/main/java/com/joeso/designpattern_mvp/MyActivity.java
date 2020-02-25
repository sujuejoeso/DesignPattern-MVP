package com.joeso.designpattern_mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class MyActivity extends AppCompatActivity implements Iview {
    private Button button;
    private TextView tvNumber;
    private ProgressBar progressBar;
    private Ipresenter myPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        tvNumber =findViewById(R.id.data);
        myPresenter=new MyPresenter(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myPresenter.onGetNumber();
            }
        });

    }
    @Override
    public void showProgress() {
        progressBar.setVisibility(VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(GONE);
    }

    @Override
    public void updateNumber(int number){
        tvNumber.setText(String.valueOf(number));
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        myPresenter.onDestroy();
    }
}
