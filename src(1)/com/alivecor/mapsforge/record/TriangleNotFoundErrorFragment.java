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

public class TriangleNotFoundErrorFragment
  extends RecordingError1ButtonFragment
{
  public TriangleNotFoundErrorFragment() {}
  
  public static TriangleNotFoundErrorFragment create(String paramString)
  {
    TriangleNotFoundErrorFragment localTriangleNotFoundErrorFragment = new TriangleNotFoundErrorFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("com.alivecor.ecg.record.ARG_OVERRIDE_DEVICE_NAME", paramString);
    localTriangleNotFoundErrorFragment.setArguments(localBundle);
    return localTriangleNotFoundErrorFragment;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    int i;
    if (getViewModel().getRecordingConfig() != null) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (getViewModelgetRecordingConfigselectedDevice != null) {
      j = 1;
    } else {
      j = 0;
    }
    if ((i & j) != 0) {
      paramLayoutInflater = requireArguments().getString("com.alivecor.ecg.record.ARG_OVERRIDE_DEVICE_NAME", getViewModelgetRecordingConfigselectedDevice.a());
    } else {
      paramLayoutInflater = "";
    }
    title.setText(getString(R.string.recording_error_triangle_not_found_title, new Object[] { paramLayoutInflater }));
    message.setText(getString(R.string.recording_error_triangle_not_found_message, new Object[] { paramLayoutInflater }));
    actionBtn.setText(R.string.recording_error_triangle_not_found_cta);
    actionBtn.setOnClickListener(new AudioPlayer(this));
    icon.setImageResource(R.drawable.not_found_icon);
    return paramViewGroup;
  }
  
  void onHelp()
  {
    String str2 = Urls.getFullUrl("app-redirect/i-need-help-pre-recording-error-device-not-found");
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
}
