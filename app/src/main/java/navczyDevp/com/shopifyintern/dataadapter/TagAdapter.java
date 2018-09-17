package navczyDevp.com.shopifyintern.dataadapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import navczyDevp.com.shopifyintern.R;
import navczyDevp.com.shopifyintern.activities.Shopify;

public class TagAdapter extends RecyclerView.Adapter<TagAdapter.TagViewHolder> {
    List<String> tags;
    Context ctx;
    public TagAdapter(Context context, List<String> tags){
                this.tags = tags;
                this.ctx = context;
    }
    @NonNull
    @Override
    public TagAdapter.TagViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.taglist,parent,false);
        TagViewHolder tagViewHolder = new TagViewHolder(v); // pass the view to View Holder
        return tagViewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull TagViewHolder holder, int position) {
           holder.tag.setText(tags.get(position));
           holder.itemView.setOnClickListener(view->{
                       Intent intent = new Intent(ctx, Shopify.class);
                       intent.putExtra("Tag",tags.get(position));
                       ctx.startActivity(intent);
           });
    }


    @Override
    public int getItemCount() {
        return tags.size();
    }
    public class TagViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView tag;
        public TagViewHolder(View itemView) {
            super(itemView);
            tag = itemView.findViewById(R.id.tv_tag);
        }
    }
}
