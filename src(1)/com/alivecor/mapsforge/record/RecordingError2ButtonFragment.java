package com.alivecor.mapsforge.record;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.package_11.Fragment;
import androidx.lifecycle.ClassReader;
import com.alivecor.alivecorkitlite.R.id;
import com.alivecor.alivecorkitlite.R.layout;

public abstract class RecordingError2ButtonFragment
  extends Fragment
{
  TextView helpBtn;
  TextView message;
  TextView negativeButton;
  TextView positiveButton;
  TextView title;
  
  public RecordingError2ButtonFragment() {}
  
  protected EcgMonitorViewModel getViewModel()
  {
    return (EcgMonitorViewModel)new ClassReader(requireActivity()).a(com.alivecor.ecg.record.EcgMonitorViewModel.class);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.fragment_recording_error_2_button, paramViewGroup, false);
    title = ((TextView)paramLayoutInflater.findViewById(R.id.recording_error_2_btn_title));
    message = ((TextView)paramLayoutInflater.findViewById(R.id.recording_error_2_btn_message));
    helpBtn = ((TextView)paramLayoutInflater.findViewById(R.id.recording_error_2_btn_help));
    positiveButton = ((TextView)paramLayoutInflater.findViewById(R.id.recording_error_2_btn_button_positive));
    negativeButton = ((TextView)paramLayoutInflater.findViewById(R.id.recording_error_2_btn_button_negative));
    return paramLayoutInflater;
  }
}
