package navczyDevp.com.cbcstoryfeed.dataadapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import navczyDevp.com.cbcstoryfeed.R;
import navczyDevp.com.cbcstoryfeed.activities.ProcessDescription;
import navczyDevp.com.cbcstoryfeed.activities.WebViewActivity;
import navczyDevp.com.cbcstoryfeed.model.StoryItem;
public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryViewHolder> {
     List<StoryItem> items;
     Context context;
     public StoryAdapter(Context context, List<StoryItem> items) {
        this.context = context;
         this.items = items;
     }
    @Override
    public StoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.story_item, parent, false);
        StoryViewHolder storyViewHolder = new StoryViewHolder(v); // pass the view to View Holder
        return storyViewHolder;
    }
    @Override
    public void onBindViewHolder(StoryViewHolder storyViewHolder, final int position) {
        // set the data in items
        storyViewHolder.title.setText(items.get(position).getTitle());
        storyViewHolder.author.setText(items.get(position).getAuthor());
        storyViewHolder.pub_date.setText(items.get(position).getPubDate());
        Glide.with(context)
             .load(ProcessDescription.getImageUrl(items.get(position)))
             .placeholder(R.drawable.ic_action_name ).centerCrop().override(100,100)
             .into(storyViewHolder.story_image);
        storyViewHolder.itemView.setOnClickListener(view -> {
            // open webView activity on item click
            Intent intent = new Intent(context, WebViewActivity.class);
            intent.putExtra("url", items.get(position).getLink()); // put story url in Intent
            context.startActivity(intent); // start Intent
        });
    }
    @Override
    public int getItemCount() {
        return items.size();
    }
    public class StoryViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        @BindView(R.id.title) TextView title;
        @BindView(R.id.author) TextView author;
        @BindView(R.id.pub_date)TextView pub_date;
        @BindView(R.id.image) ImageView story_image;
        public StoryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
