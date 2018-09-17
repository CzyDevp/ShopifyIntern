package navczyDevp.com.shopifyintern.activities;

import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import butterknife.BindView;
import butterknife.ButterKnife;
import navczyDevp.com.shopifyintern.R;
import navczyDevp.com.shopifyintern.dataadapter.TagAdapter;

public class MainActivity extends AppCompatActivity implements LifecycleObserver{
    private static final String TAG = "MyActivity";
    TagAdapter tagAdapter;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getLifecycle().addObserver(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext())); // set LayoutManager to RecyclerView
        getStories();
     }
    private void getStories(){
        GetStoriesViewModel model = ViewModelProviders.of(this).get(GetStoriesViewModel.class);
        model.getStoryItems().observe(this, mainModel -> {
            Log.i(TAG,"**Model changed**");
            tagAdapter = new TagAdapter(MainActivity.this,UniqueTagProcess.Companion.tags(mainModel));
            recyclerView.setAdapter(tagAdapter);
        });
    }
}
