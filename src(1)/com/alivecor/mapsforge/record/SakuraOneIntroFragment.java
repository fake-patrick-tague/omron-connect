package com.alivecor.mapsforge.record;

import android.content.Context;
import android.net.Uri;
import android.os.BaseBundle;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.fragment.package_11.Fragment;
import androidx.lifecycle.ClassReader;
import androidx.lifecycle.LiveData;
import com.alivecor.alivecorkitlite.R.id;
import com.alivecor.alivecorkitlite.R.layout;
import com.alivecor.alivecorkitlite.R.raw;
import com.alivecor.alivecorkitlite.R.string;
import com.alivecor.mapsforge.core.model.c;

public class SakuraOneIntroFragment
  extends Fragment
{
  TextView helpTxt;
  TextView keepFingersTxt;
  View recordingProgressPanel;
  View recordingProgressView;
  VideoView videoTexture;
  
  public SakuraOneIntroFragment() {}
  
  public static SakuraOneIntroFragment create(String paramString, RecordUiConfig paramRecordUiConfig)
  {
    SakuraOneIntroFragment localSakuraOneIntroFragment = new SakuraOneIntroFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("com.alivecor.ecg.record.ARG_OVERRIDE_DEVICE_NAME", paramString);
    localBundle.putSerializable("com.alivecor.ecg.record.ARG_UI_CONFIG", paramRecordUiConfig);
    localSakuraOneIntroFragment.setArguments(localBundle);
    return localSakuraOneIntroFragment;
  }
  
  private Uri getVideoUri()
  {
    String str = requireContext().getPackageName();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("android.resource://");
    localStringBuilder.append(str);
    localStringBuilder.append("/");
    localStringBuilder.append(R.raw.complete_instruction);
    return Uri.parse(localStringBuilder.toString());
  }
  
  private EcgMonitorViewModel getViewModel()
  {
    return (EcgMonitorViewModel)new ClassReader(requireActivity()).a(com.alivecor.ecg.record.EcgMonitorViewModel.class);
  }
  
  private void handleRecordState(EcgMonitorViewModel.State paramState)
  {
    if (paramState == null) {
      return;
    }
    int i = 2.$SwitchMap$com$alivecor$ecg$record$EcgMonitorViewModel$State[paramState.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      paramState = recordingProgressPanel;
      i = 8;
    }
    else
    {
      recordingProgressPanel.setAlpha(0.0F);
      recordingProgressPanel.animate().alpha(1.0F).start();
      paramState = recordingProgressPanel;
      i = 0;
    }
    paramState.setVisibility(i);
  }
  
  private void setUpVideoTextrue()
  {
    videoTexture.setVideoURI(getVideoUri());
    videoTexture.setOnCompletionListener(new DownloadServiceImpl.2(this));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramBundle = paramLayoutInflater.inflate(R.layout.fragment_sakura_intro_hud, paramViewGroup, false);
    recordingProgressPanel = paramBundle.findViewById(R.id.sakura_intro_first_ecg_panel);
    recordingProgressView = paramBundle.findViewById(R.id.sakura_intro_first_ecg_progress);
    helpTxt = ((TextView)paramBundle.findViewById(R.id.sakura_intro_instructions));
    keepFingersTxt = ((TextView)paramBundle.findViewById(R.id.sakura_intro_first_ecg_keep_fingers));
    videoTexture = ((VideoView)paramBundle.findViewById(R.id.sakura_intro_texture));
    RecordUiConfig localRecordUiConfig = (RecordUiConfig)requireArguments().getSerializable("com.alivecor.ecg.record.ARG_UI_CONFIG");
    paramViewGroup = getArguments().getString("com.alivecor.ecg.record.ARG_OVERRIDE_DEVICE_NAME", null);
    paramLayoutInflater = paramViewGroup;
    if (paramViewGroup == null) {
      paramLayoutInflater = c.J.a();
    }
    if ((localRecordUiConfig != null) && (localRecordUiConfig.isOmronCompleteVideo()))
    {
      helpTxt.setText(getString(R.string.ecg_realtime_help_sakura_new, new Object[] { paramLayoutInflater }));
      setUpVideoTextrue();
    }
    else
    {
      helpTxt.setText(getString(R.string.ecg_realtime_help_sakura_3, new Object[] { paramLayoutInflater }));
      videoTexture.setVisibility(8);
    }
    recordingProgressView.setBackground(new SakuraOneIntroFragment.1(this));
    keepFingersTxt.setText(getString(R.string.ecg_realtime_first_ecg_keep_fingers_sakura, new Object[] { paramLayoutInflater }));
    getViewModel().state().observe(getViewLifecycleOwner(), new MessageListFragment.1(this));
    return paramBundle;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  public void onStart()
  {
    super.onStart();
    videoTexture.start();
  }
  
  public void onStop()
  {
    videoTexture.stopPlayback();
    super.onStop();
  }
}
