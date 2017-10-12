package com.fdmt.bancomer.endpoints;

import com.fdmt.bancomer.resposnes.BaseResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by DaveMorales on 12/10/2017.
 *
 * This class was created for a Bancomer technical exam.
 *
 * This interface should contain all the request related to Movements.
 */

public interface Movements {

    @GET("status")
    Call<BaseResponse> getMovimientos(@Query("phoneNumber") String phoneNumber);

}
