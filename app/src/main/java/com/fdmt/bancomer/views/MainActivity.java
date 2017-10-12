package com.fdmt.bancomer.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.fdmt.bancomer.R;
import com.fdmt.bancomer.interfaces.MainPresenter;
import com.fdmt.bancomer.interfaces.MainView;
import com.fdmt.bancomer.presenters.MainPresenterImpl;
import com.fdmt.bancomer.resposnes.BaseResponse;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by DaveMorales on 12/10/2017.
 *
 * This class was created for a Bancomer technical exam.
 *
 *  MainActivity is the class representing the View and only interacts with logic thru interfaces,
 *  separating the logic from the graphic elements.
 */

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.main_txt_number)
    EditText mainTxtNumber;

    @BindView(R.id.main_progress)
    ProgressBar mainProgress;

    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainPresenter = new MainPresenterImpl(this);
    }

    @OnClick(R.id.main_btn_verify)
    public void verifyNumber() {
        String number = mainTxtNumber.getText().toString();
        mainPresenter.getMovements(number, getApplicationContext());
    }

    @Override
    public void showLoading(boolean status) {
        if (status)
            mainProgress.setVisibility(View.VISIBLE);
        else
            mainProgress.setVisibility(View.GONE);
    }

    @Override
    public void onSuccess(BaseResponse response) {
        Intent intent = new Intent(this, MovementsActivity.class);
        intent.putExtra("response", response);
        startActivity(intent);
    }


    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
