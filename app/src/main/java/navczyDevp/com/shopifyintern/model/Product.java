package navczyDevp.com.shopifyintern.model;

import java.util.ArrayList;

public class Product{
    private String tags;
    private Image image;
    private String title;
    private ArrayList<Variants> variants;
    public String getTags () {
        return tags;
    }
    public void setTags (String tags) {
        this.tags = tags;
    }
    public Image getImage ()  {
        return image;
    }
    public void setImage (Image image) {
        this.image = image;
    }
    public String getTitle ()  {
        return title;
    }
    public void setTitle (String title)   {
        this.title = title;
    }
    public ArrayList<Variants> getVariants () {
        return variants;
    }
    public void setVariants (ArrayList<Variants> variants) {
        this.variants = variants;
    }
}