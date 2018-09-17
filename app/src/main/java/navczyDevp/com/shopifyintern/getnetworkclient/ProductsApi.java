package navczyDevp.com.shopifyintern.getnetworkclient;


import navczyDevp.com.shopifyintern.model.MainModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
public interface ProductsApi {
   @GET("admin/products.json")
   Call<MainModel> getStories(@Query("page") int page,
                              @Query("access_token") String access_token);
}
