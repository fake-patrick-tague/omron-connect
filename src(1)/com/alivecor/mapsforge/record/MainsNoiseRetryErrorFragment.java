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

public class MainsNoiseRetryErrorFragment
  extends RecordingError1ButtonFragment
{
  public MainsNoiseRetryErrorFragment() {}
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    title.setText(R.string.recording_error_mains_title);
    message.setText(R.string.recording_error_mains_message);
    icon.setImageResource(R.drawable.electrical_interference);
    actionBtn.setText(R.string.got_it);
    actionBtn.setOnClickListener(new RadialTimePickerDialog.2(this));
    helpBtn.setText(R.string.learn_more);
    return paramLayoutInflater;
  }
  
  void onHelp()
  {
    String str2 = Urls.getFullUrl("app-redirect/i-need-help-electrical-interference");
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
