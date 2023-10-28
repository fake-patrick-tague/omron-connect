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

public class TriangleBatteryErrorFragment
  extends RecordingError1ButtonFragment
{
  public TriangleBatteryErrorFragment() {}
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    title.setText(R.string.recording_error_triangle_battery_low_title);
    message.setText(R.string.recording_error_triangle_battery_low_message);
    paramViewGroup = (RecordUiConfig)requireArguments().getSerializable("ui_config");
    if ((paramViewGroup != null) && (paramViewGroup.getBatteryDepleted() != 0)) {
      icon.setImageResource(paramViewGroup.getBatteryDepleted());
    } else {
      icon.setImageResource(R.drawable.bat_icon_large);
    }
    actionBtn.setText(R.string.got_it);
    actionBtn.setOnClickListener(new DashboardFragment.3(this));
    return paramLayoutInflater;
  }
  
  void onHelp()
  {
    String str2 = Urls.getFullUrl("app-redirect/i-need-help-battery-critical");
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
