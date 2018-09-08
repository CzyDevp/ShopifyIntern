package navczyDevp.com.cbcstoryfeed.activities;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;
import navczyDevp.com.cbcstoryfeed.getnetworkclient.RetrofitClient;
import navczyDevp.com.cbcstoryfeed.model.StoryFeed;
import navczyDevp.com.cbcstoryfeed.retrointerface.StoryApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class GetStoriesViewModel extends ViewModel {
    private static String TAG = "GetStoriesViewModel";
    private MutableLiveData<StoryFeed> storyFeed;
    public static MutableLiveData<String> storyUrl = new MutableLiveData<>();
    public LiveData<StoryFeed> getStoryItems() {
        if (storyFeed == null) {
            storyFeed = new MutableLiveData<>();
            getStoryFeeds();
        }
        return storyFeed;
    }
    private void getStoryFeeds() {
        Log.i(TAG,"****called data****");
        StoryApi storyApi = RetrofitClient.getRetrofitClient().create(StoryApi.class);
        Call<StoryFeed> storyFeedCall = storyApi.getStories();
        storyFeedCall.enqueue(
                new Callback<StoryFeed>() {
                    @Override
                    public void onResponse(Call<StoryFeed> call, Response<StoryFeed> response) {
                        storyFeed.setValue(response.body());
                    }
                    @Override
                    public void onFailure(Call<StoryFeed> call, Throwable t) {
                        t.printStackTrace();
                    }
                }
        );
    }
}
