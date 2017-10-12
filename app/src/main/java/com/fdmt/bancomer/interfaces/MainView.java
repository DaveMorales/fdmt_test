package com.fdmt.bancomer.interfaces;

import com.fdmt.bancomer.resposnes.BaseResponse;

/**
 * Created by DaveMorales on 12/10/2017.
 *
 * This class was created for a Bancomer technical exam.
 *
 * This interface serves as a contract between the view and the presenter.
 */

public interface MainView {

    void showLoading(boolean status);

    void onSuccess(BaseResponse response);

    void showToast(String message);

}
