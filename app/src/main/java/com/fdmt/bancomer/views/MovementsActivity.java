package com.fdmt.bancomer.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.fdmt.bancomer.R;
import com.fdmt.bancomer.adapters.MovementsAdapter;
import com.fdmt.bancomer.resposnes.BaseResponse;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DaveMorales on 12/10/2017.
 *
 * This class was created for a Bancomer technical exam.
 *
 */

public class MovementsActivity extends AppCompatActivity {

    private MovementsAdapter mAdapter;

    @BindView(R.id.mvmnt_rv)
    RecyclerView mRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movements);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        BaseResponse response= (BaseResponse)getIntent().getSerializableExtra("response");

        mAdapter = new MovementsAdapter(getApplicationContext(), response.getResponse().getListMov());
        mRV.setAdapter(mAdapter);
        mRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

}
