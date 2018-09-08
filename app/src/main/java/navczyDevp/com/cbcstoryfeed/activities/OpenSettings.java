package navczyDevp.com.cbcstoryfeed.activities;


import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;

import navczyDevp.com.cbcstoryfeed.R;

import static android.support.v4.content.ContextCompat.startActivity;


public class OpenSettings{
    public  static AlertDialog askUserToOpenSettings(Context context){
        AlertDialog.Builder wifiSettingsDialog = new AlertDialog.Builder(context, R.style.MyDialogTheme);
        wifiSettingsDialog.setMessage("use wifi to get stories?? ")
                .setIcon(R.mipmap.ic_info)
                .setNegativeButton(R.string.cancel, (dialog, which) ->dialog.dismiss())
                .setPositiveButton(R.string.ok, (dialog, which) -> startActivity(context,new Intent(Settings.ACTION_WIFI_SETTINGS),null));
        return wifiSettingsDialog.create();
    }
}
