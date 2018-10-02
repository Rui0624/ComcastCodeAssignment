package xfinity.com.comcastcodeassignment.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xfinity.com.comcastcodeassignment.BuildConfig;

public class NetworkClient {
    public static Retrofit retrofit;

    public static Retrofit getRetrofit() {
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl( BuildConfig.BASE_URL)
                    .addConverterFactory( GsonConverterFactory.create())
                    .addCallAdapterFactory( RxJava2CallAdapterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
