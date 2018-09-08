package navczyDevp.com.cbcstoryfeed.model;
import org.simpleframework.xml.Default;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
@Default(required = false)
@Root(name = "item", strict = false)
public class StoryItem {
    @Element(name = "title",data = true)
    private String title;

    @Element(name = "link")
    private String link;

    @Element(name="description",data = true)
    private String description;

    @Element(name="pubDate")
    private String pubDate;

    @Element(name="author",required = false)
    private String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
