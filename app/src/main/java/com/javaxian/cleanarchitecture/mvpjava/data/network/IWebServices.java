package com.javaxian.cleanarchitecture.mvpjava.data.network;

import com.javaxian.cleanarchitecture.mvpjava.data.network.request.RequestQuery;
import com.javaxian.cleanarchitecture.mvpjava.data.network.response.ResponseQuery;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface IWebServices {

    @GET(EndPointConf.QUERY)
    Observable<ResponseQuery> queryGET(@Query("format") String format, @Query("starttime") String starttime,
                                    @Query("endtime") String endtime, @Query("limit") int limit);


    @POST(EndPointConf.QUERY)
    Observable<ResponseQuery> queryPOST(@Body RequestQuery request);
}
