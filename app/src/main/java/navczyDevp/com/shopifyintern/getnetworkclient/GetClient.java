package navczyDevp.com.shopifyintern.getnetworkclient;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetClient {
    private static String BASE_URL = "https://shopicruit.myshopify.com/";
    private static final String TAG ="RetrofitClient";
    static Retrofit retrofit;
    public static Retrofit getRetrofitClient(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder().
                    baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        Log.i(TAG,"***Retrofit Client created***");
        return retrofit;
    }
}