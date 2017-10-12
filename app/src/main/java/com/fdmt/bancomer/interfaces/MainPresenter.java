package com.fdmt.bancomer.interfaces;

import android.content.Context;

import com.fdmt.bancomer.resposnes.BaseResponse;

/**
 * Created by DaveMorales on 12/10/2017.
 *
 * This class was created for a Bancomer technical exam.
 *
 * This interface serves as a contract between the view, the presenter and the interactor.
 */

public interface MainPresenter {

    void getMovements(String number, Context context);

    void onSuccess(BaseResponse response);

    void onNoUserFound();

    void onNetworkError();

    void onServerError();

    void onError(String errorMsg);
}
