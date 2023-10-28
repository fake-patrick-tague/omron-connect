package com.alivecor.mapsforge.record;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BaseBundle;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.asm.f;
import androidx.fragment.package_11.Fragment;
import com.alivecor.alivecorkitlite.R.drawable;
import com.alivecor.alivecorkitlite.R.id;
import com.alivecor.alivecorkitlite.R.string;
import com.alivecor.mapsforge.core.model.c;
import java.util.Objects;
import l.a.a;

public class BluetoothOffErrorFragment
  extends RecordingError1ButtonFragment
{
  private static final int REQUEST_CODE_ENABLE_BLUETOOTH = 8910;
  private BroadcastReceiver bluetoothStateReciever;
  androidx.activity.result.b<String[]> requestMultiplePermissions = registerForActivityResult(new f(), new CordovaInterfaceImpl(this));
  
  public BluetoothOffErrorFragment() {}
  
  public static BluetoothOffErrorFragment create(String paramString)
  {
    BluetoothOffErrorFragment localBluetoothOffErrorFragment = new BluetoothOffErrorFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("com.alivecor.ecg.record.ARG_OVERRIDE_DEVICE_NAME", paramString);
    localBluetoothOffErrorFragment.setArguments(localBundle);
    return localBluetoothOffErrorFragment;
  }
  
  private BroadcastReceiver createBluetoothStateReceiver()
  {
    return new BluetoothOffErrorFragment.1(this);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 8910) && (paramInt2 == -1)) {
      getViewModel().restart();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    title.setText(R.string.recording_error_bluetooth_off_title);
    paramViewGroup = requireArguments();
    paramBundle = getViewModel().getRecordingConfig();
    Objects.requireNonNull(paramBundle);
    paramViewGroup = paramViewGroup.getString("com.alivecor.ecg.record.ARG_OVERRIDE_DEVICE_NAME", selectedDevice.a());
    a.a("override name is %s", new Object[] { requireArguments().getString("com.alivecor.ecg.record.ARG_OVERRIDE_DEVICE_NAME", null) });
    a.a("Device name is %s", new Object[] { paramViewGroup });
    message.setText(getString(R.string.recording_error_bluetooth_off_message, new Object[] { paramViewGroup }));
    icon.setImageResource(R.drawable.bt_icon_large);
    actionBtn.setText(R.string.bluetooth_off_dialog_title);
    actionBtn.setOnClickListener(new b(this));
    paramViewGroup = (TextView)paramLayoutInflater.findViewById(R.id.recording_error_1_btn_help);
    return paramLayoutInflater;
  }
  
  void onHelp()
  {
    String str2 = Urls.getFullUrl("app-redirect/i-need-help-bluetooth-error");
    String str1 = str2;
    if (getArguments() != null)
    {
      str1 = str2;
      if (getArguments().containsKey("help url")) {
        str1 = getArguments().getString("help url");
      }
    }
    Util.openInBrowser(requireContext(), str1);
  }
  
  public void onStart()
  {
    super.onStart();
    bluetoothStateReciever = createBluetoothStateReceiver();
    getContext().registerReceiver(bluetoothStateReciever, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
  }
  
  public void onStop()
  {
    if (bluetoothStateReciever != null) {
      getContext().unregisterReceiver(bluetoothStateReciever);
    }
    super.onStop();
  }
}
