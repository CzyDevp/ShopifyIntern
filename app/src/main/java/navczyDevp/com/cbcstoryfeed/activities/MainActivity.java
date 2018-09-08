package navczyDevp.com.cbcstoryfeed.activities;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.lifecycle.ViewModelProviders;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import butterknife.BindView;
import butterknife.ButterKnife;
import navczyDevp.com.cbcstoryfeed.R;
import navczyDevp.com.cbcstoryfeed.dataadapter.StoryAdapter;
import static navczyDevp.com.cbcstoryfeed.activities.OpenSettings.askUserToOpenSettings;
public class MainActivity extends AppCompatActivity implements LifecycleObserver{
    private static final String TAG = "MyActivity";
    private BroadcastReceiver wifiStateReceiver;
    StoryAdapter storyAdapter;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getLifecycle().addObserver(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext())); // set LayoutManager to RecyclerView
        Log.i(TAG,"onCreateCalled");
        wifiStateReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                boolean netInfo = networkInfo !=null && networkInfo.isConnected();
                if(netInfo) getStories();
                else askUserToOpenSettings(context).show();
            }
        };
        registerReceiver(wifiStateReceiver,new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
     }
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        return super.registerReceiver(receiver, filter);
    }
    private void getStories(){
        GetStoriesViewModel model = ViewModelProviders.of(this).get(GetStoriesViewModel.class);
        model.getStoryItems().observe(this, storyFeed -> {
            Log.i(TAG,"**Model changed**");
            storyAdapter = new StoryAdapter(MainActivity.this,storyFeed.getStoryItemList());
            recyclerView.setAdapter(storyAdapter);
        });
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    protected void destroy() {
        unregisterReceiver(wifiStateReceiver);
    }
}
