package navczyDevp.com.shopifyintern.activities;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import navczyDevp.com.shopifyintern.getnetworkclient.GetClient;
import navczyDevp.com.shopifyintern.getnetworkclient.ProductsApi;
import navczyDevp.com.shopifyintern.model.MainModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetStoriesViewModel extends ViewModel {
    private static String TAG = "GetStoriesViewModel";
    private MutableLiveData<MainModel> mainModel;
    public LiveData<MainModel> getStoryItems() {
        if (mainModel == null) {
            mainModel = new MutableLiveData<>();
            getProducts();
        }
        return mainModel;
    }
    private void getProducts() {
        Log.i(TAG,"****called data****");
        ProductsApi storyApi = GetClient.getRetrofitClient().create(ProductsApi.class);
        Call<MainModel> mainModelCall = storyApi.getStories(1,"c32313df0d0ef512ca64d5b336a0d7c6");
        mainModelCall.enqueue(
                new Callback<MainModel>() {
                    @Override
                    public void onResponse(Call<MainModel> call, Response<MainModel> response) {
                        mainModel.setValue(response.body());
                    }
                    @Override
                    public void onFailure(Call<MainModel> call, Throwable t) {
                        t.printStackTrace();
                    }
                }
        );
    }
}
