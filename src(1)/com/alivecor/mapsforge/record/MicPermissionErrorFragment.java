package com.alivecor.mapsforge.record;

import android.os.BaseBundle;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.package_11.Fragment;
import com.alivecor.alivecorkitlite.R.drawable;
import com.alivecor.alivecorkitlite.R.string;
import com.alivecor.mapsforge.core.model.c;
import java.util.Arrays;
import java.util.Objects;
import l.a.a;
import l.a.a.c;

public class MicPermissionErrorFragment
  extends RecordingError1ButtonFragment
{
  private static int PERMISSIONS_REQUEST_AUDIO;
  private static boolean PERMISSION_DENIED;
  AppPreferences appPreferences;
  
  public MicPermissionErrorFragment() {}
  
  public static MicPermissionErrorFragment create(String paramString)
  {
    MicPermissionErrorFragment localMicPermissionErrorFragment = new MicPermissionErrorFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("com.alivecor.ecg.record.ARG_OVERRIDE_DEVICE_NAME", paramString);
    localMicPermissionErrorFragment.setArguments(localBundle);
    return localMicPermissionErrorFragment;
  }
  
  private void requestPermission()
  {
    a.f("EEEE").a("actionBtn setOnClickListener MicPermissionErrorFragment", new Object[0]);
    if (PERMISSION_DENIED)
    {
      Util.startMyAppSettings(getActivity());
      return;
    }
    int i = PERMISSIONS_REQUEST_AUDIO;
    requestPermissions(new String[] { "android.permission.RECORD_AUDIO" }, i);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramBundle = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    RecordEkgConfig.getDB().getRecordDependencyComponent().inject(this);
    title.setText(R.string.recording_error_mic_title);
    paramLayoutInflater = getViewModel().getRecordingConfig();
    Objects.requireNonNull(paramLayoutInflater);
    c localC = selectedDevice;
    paramViewGroup = requireArguments().getString("com.alivecor.ecg.record.ARG_OVERRIDE_DEVICE_NAME", null);
    paramLayoutInflater = paramViewGroup;
    TextView localTextView = message;
    int i = R.string.recording_error_mic_message;
    if (paramViewGroup == null) {
      paramLayoutInflater = localC.a();
    }
    localTextView.setText(getString(i, new Object[] { paramLayoutInflater }));
    icon.setImageResource(R.drawable.mic_icon_large);
    actionBtn.setText(R.string.allow_access);
    actionBtn.setOnClickListener(new FileDownloadFragment.1(this));
    helpBtn.setText(R.string.learn_more);
    return paramBundle;
  }
  
  void onHelp()
  {
    String str2 = Urls.getFullUrl("app-redirect/i-need-help-mic-error-android");
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
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    a.g("onRequestPermissionsResult: %d:\n%s\n%s", new Object[] { Integer.valueOf(paramInt), Arrays.toString(paramArrayOfString), Arrays.toString(paramArrayOfInt) });
    if ((paramInt == PERMISSIONS_REQUEST_AUDIO) && (paramArrayOfInt.length > 0))
    {
      paramInt = paramArrayOfInt[0];
      if (paramInt == 0)
      {
        getViewModel().restart();
        return;
      }
      if (paramInt == -1) {
        PERMISSION_DENIED = true;
      }
    }
  }
}
