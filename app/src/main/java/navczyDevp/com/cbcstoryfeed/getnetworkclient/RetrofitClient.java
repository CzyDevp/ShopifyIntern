package navczyDevp.com.cbcstoryfeed.getnetworkclient;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class RetrofitClient {
      private static String BASE_URL = "https://www.cbc.ca";
      private static final String TAG ="RetrofitClient";
     static Retrofit retrofit;
     public static Retrofit getRetrofitClient(){
         if(retrofit==null){
             retrofit = new retrofit2.Retrofit.Builder().
                      baseUrl(BASE_URL)
                     .addConverterFactory(SimpleXmlConverterFactory.create())
                     .build();
         }
         Log.i(TAG,"***Retrofit Client created***");
         return retrofit;
     }
}
