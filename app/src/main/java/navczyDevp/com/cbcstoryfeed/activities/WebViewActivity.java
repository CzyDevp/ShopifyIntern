package navczyDevp.com.cbcstoryfeed.activities;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import butterknife.BindView;
import butterknife.ButterKnife;
import navczyDevp.com.cbcstoryfeed.R;
import static navczyDevp.com.cbcstoryfeed.activities.OpenSettings.askUserToOpenSettings;
public class WebViewActivity extends AppCompatActivity implements LifecycleObserver{
    private static  final String TAG ="WebViewActivity";
    private BroadcastReceiver wifiStateReceiver;
    @BindView(R.id.openWeb) WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        getLifecycle().addObserver(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        Intent intent = getIntent(); // get Intent used to get url from story
        Log.i(TAG,"Story opened");
        String url = intent.getStringExtra("url");
        wifiStateReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                boolean netInfo = networkInfo !=null && networkInfo.isConnected();
                if(netInfo) webView.loadUrl(url);
                else askUserToOpenSettings(context).show();
            }
        };
        registerReceiver(wifiStateReceiver,new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        return super.registerReceiver(receiver, filter);
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    protected void destroy() {
        unregisterReceiver(wifiStateReceiver);
    }
  }
