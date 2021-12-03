package com.example.kvantproject;

import android.app.Application;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

public class App extends Application {
    private NetworkMonitor mNetworkMonitor;
    @Override
    public void onCreate() {
        super.onCreate();
        mNetworkMonitor = new NetworkMonitor();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(mNetworkMonitor,intentFilter);
    }
    @Override
    public void onTerminate() {
        unregisterReceiver(mNetworkMonitor);
        super.onTerminate();
    }
}
