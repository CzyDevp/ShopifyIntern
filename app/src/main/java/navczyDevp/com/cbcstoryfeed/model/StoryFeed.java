package navczyDevp.com.cbcstoryfeed.model;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import java.util.List;
@Root(name="rss", strict=false)
public class StoryFeed {
    @ElementList(name="item", inline=true)
    @Path("channel")
    private List<StoryItem> storyItemList;
    public List<StoryItem> getStoryItemList() {
        return storyItemList;
    }
    public void setStoryItemList(List<StoryItem> storyItemList) {
        this.storyItemList = storyItemList;
    }
}