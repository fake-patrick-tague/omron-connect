package com.alivecor.mapsforge.record;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.package_11.Fragment;
import androidx.lifecycle.ClassReader;
import com.alivecor.alivecorkitlite.R.id;
import com.alivecor.alivecorkitlite.R.layout;

public abstract class RecordingError1ButtonFragment
  extends Fragment
{
  protected static final String ARG_HELP_URL = "help url";
  protected static final String ARG_VALUE = "arg_value";
  TextView actionBtn;
  TextView helpBtn;
  ImageView icon;
  TextView message;
  TextView title;
  
  public RecordingError1ButtonFragment() {}
  
  protected EcgMonitorViewModel getViewModel()
  {
    return (EcgMonitorViewModel)new ClassReader(requireActivity()).a(com.alivecor.ecg.record.EcgMonitorViewModel.class);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.fragment_recording_error_1_button, paramViewGroup, false);
    title = ((TextView)paramLayoutInflater.findViewById(R.id.recording_error_1_btn_title));
    message = ((TextView)paramLayoutInflater.findViewById(R.id.recording_error_1_btn_message));
    icon = ((ImageView)paramLayoutInflater.findViewById(R.id.recording_error_1_btn_icon));
    actionBtn = ((TextView)paramLayoutInflater.findViewById(R.id.recording_error_1_btn_button));
    paramViewGroup = (TextView)paramLayoutInflater.findViewById(R.id.recording_error_1_btn_help);
    helpBtn = paramViewGroup;
    paramViewGroup.setOnClickListener(new DashboardFragment.4(this));
    return paramLayoutInflater;
  }
  
  abstract void onHelp();
}
