package com.fdmt.bancomer.interactors;

import android.content.Context;
import android.util.Log;

import com.fdmt.bancomer.interfaces.MainInteractor;
import com.fdmt.bancomer.interfaces.MainPresenter;
import com.fdmt.bancomer.resposnes.BaseResponse;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by DaveMorales on 12/10/2017.
 *
 * This class was created for a Bancomer technical exam.
 *
 * This class should contain all the business logic to keep everything separated.
 *
 * The commented code would be used to get the data from the REST API.
 */
public class MainInteractorImpl implements MainInteractor {

    private MainPresenter mainPresenter;

    public MainInteractorImpl(MainPresenter mainPresenter) {
        this.mainPresenter = mainPresenter;
    }

    /*@Override
    public void getMovements(String number) {
        if (number.length() == 10) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BancomerValues.BASE_URL)
                    .build();

            Movements service = retrofit.create(Movements.class);

            Call<BaseResponse> call = service.getMovimientos(number);
            call.enqueue(new Callback<BaseResponse>() {
                @Override
                public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {

                    try {
                        if (response.body().getStatus().equals("NA")) {
                            mainPresenter.onNoUserFound();
                        } else if (response.body().getStatus().equals("OK")) {
                            mainPresenter.onSuccess(response.body());
                        } else {
                            mainPresenter.onServerError();
                        }
                    } catch(NullPointerException ex){
                        mainPresenter.onError("Error desconocido");
                        Log.e("NullPointer", ex.toString());
                    }
                }

                @Override
                public void onFailure(Call<BaseResponse> call, Throwable t) {
                    mainPresenter.onNetworkError();
                }
            });

        } else {
            mainPresenter.onError("El numero debe ser de 10 digitos");
        }

    }*/

    @Override
    public void getMovements(String number, Context context) {

        String json = loadJSONFromAsset(number, context);

        Gson gson = new Gson();
        BaseResponse response = gson.fromJson(json, BaseResponse.class);

        try {
            if (response.getStatus().equals("NA")) {
                mainPresenter.onNoUserFound();
            } else if (response.getStatus().equals("OK")) {
                mainPresenter.onSuccess(response);
            } else {
                mainPresenter.onServerError();
            }
        } catch (NullPointerException ex) {
            mainPresenter.onError("Error desconocido");
            Log.e("NullPointer", ex.toString());
        }

    }

    public String loadJSONFromAsset(String number, Context context) {
        String json = null;
        InputStream is;
        try {

            if (number.equals("5533171303") || number.equals("5533171302") || number.equals("5555555555")
                    || number.equals("5529479155"))
                is = context.getAssets().open("ok_response.json");
            else
                is = context.getAssets().open("na_response.json");

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }

}
