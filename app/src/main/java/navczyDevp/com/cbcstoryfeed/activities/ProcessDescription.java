package navczyDevp.com.cbcstoryfeed.activities;

import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import navczyDevp.com.cbcstoryfeed.model.StoryItem;
public class ProcessDescription {
    private static String TAG = "ProcessDescription ";
    public static String getImageUrl(StoryItem storyItem){
        String url=null;
        Pattern pattern = Pattern.compile("(http|https):\\/\\/([^\\']+)");
        Matcher matcher = pattern.matcher(storyItem.getDescription());
        Log.i(TAG,"Image url fetched");
        if(matcher.find())
            url = matcher.group();
        return url;

    }

}
