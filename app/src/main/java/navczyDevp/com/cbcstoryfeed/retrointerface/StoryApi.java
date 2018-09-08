package navczyDevp.com.cbcstoryfeed.retrointerface;

import navczyDevp.com.cbcstoryfeed.model.StoryFeed;
import retrofit2.Call;
import retrofit2.http.GET;

public interface StoryApi {
    @GET("/cmlink/rss-topstories")
    Call<StoryFeed> getStories();
}
