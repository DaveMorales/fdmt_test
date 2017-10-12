package com.fdmt.bancomer.presenters;

import android.content.Context;

import com.fdmt.bancomer.interactors.MainInteractorImpl;
import com.fdmt.bancomer.interfaces.MainInteractor;
import com.fdmt.bancomer.interfaces.MainPresenter;
import com.fdmt.bancomer.interfaces.MainView;
import com.fdmt.bancomer.resposnes.BaseResponse;

/**
 * Created by DaveMorales on 12/10/2017.
 *
 * This class was created for a Bancomer technical exam.
 *
 * This is the bridge class between the view and the interactor, it doesn't contains logic, it only
 * serves as a way to communicate.
 */

public class MainPresenterImpl implements MainPresenter {

    private MainView mainView;
    private MainInteractor mainInteractor;

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
        this.mainInteractor = new MainInteractorImpl(this);
    }
    @Override
    public void getMovements(String number, Context context) {
        mainInteractor.getMovements(number, context);
    }

    @Override
    public void onSuccess(BaseResponse response) {
        mainView.onSuccess(response);

    }

    @Override
    public void onNoUserFound() {
        if(mainView!=null) {
            mainView.showLoading(false);
            mainView.showToast("El cliente no existe");
        }
    }

    @Override
    public void onNetworkError() {
        if(mainView!=null) {
            mainView.showLoading(false);
            mainView.showToast("Error de red");
        }
    }

    @Override
    public void onServerError() {
        if(mainView!=null) {
            mainView.showLoading(false);
            mainView.showToast("Error en el servidor");
        }
    }

    @Override
    public void onError(String errorMsg) {
        if(mainView!=null) {
            mainView.showLoading(false);
            mainView.showToast(errorMsg);
        }
    }
}
