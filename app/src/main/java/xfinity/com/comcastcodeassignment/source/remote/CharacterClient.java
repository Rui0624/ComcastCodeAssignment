package xfinity.com.comcastcodeassignment.source.remote;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xfinity.com.comcastcodeassignment.BuildConfig;

/**
 * CharacterClient is used to define the network client
 */
class CharacterClient {
    private static Retrofit retrofit;

    /**
     * create or return the retrofit instance which is singleton in the project
     *
     * @return retrofit instance
     */
    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl( BuildConfig.BASE_URL )
                    .addConverterFactory( GsonConverterFactory.create() )
                    .addCallAdapterFactory( RxJava2CallAdapterFactory.create() )
                    .build();
        }

        return retrofit;
    }
}
