package com.alivecor.mapsforge.record;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.package_11.Fragment;
import androidx.lifecycle.ClassReader;
import androidx.lifecycle.LiveData;
import com.alivecor.alivecorkitlite.R.drawable;
import com.alivecor.alivecorkitlite.R.id;
import com.alivecor.alivecorkitlite.R.layout;
import com.alivecor.alivecorkitlite.R.string;
import com.alivecor.mapsforge.core.model.Direction;
import com.alivecor.universal_monitor.LeadState;
import l.a.a;
import v7.v7.util.Position;

public class TriangleIntroFragment
  extends Fragment
{
  AppPreferences appPreferences;
  View bottomLabel;
  ImageView deviceBottomImg;
  ImageView deviceTopImg;
  private RecordingHelpUrls helpUrls;
  private Direction leadsConfig;
  TextView recordingHUDDesc;
  private RecordUiConfig uiConfig;
  
  public TriangleIntroFragment() {}
  
  private void leadStateUpdated(LeadState paramLeadState1, LeadState paramLeadState2)
  {
    if (deviceTopImg != null)
    {
      if (!isAdded()) {
        return;
      }
      LeadState localLeadState = LeadState.SUBSCRIBED;
      if (paramLeadState1 != localLeadState)
      {
        localRecordUiConfig = uiConfig;
        if (localRecordUiConfig != null)
        {
          paramLeadState1 = deviceTopImg;
          i = localRecordUiConfig.getTriangleTopLeadsOn();
        }
        else
        {
          paramLeadState1 = deviceTopImg;
          i = R.drawable.triangle_hud_top_view_active;
          break label102;
        }
      }
      else
      {
        localRecordUiConfig = uiConfig;
        if (localRecordUiConfig == null) {
          break label93;
        }
        paramLeadState1 = deviceTopImg;
        i = localRecordUiConfig.getTriangleTopLeadsOff();
      }
      paramLeadState1.setImageResource(i);
      break label107;
      label93:
      paramLeadState1 = deviceTopImg;
      int i = R.drawable.triangle_hud_top_view;
      label102:
      paramLeadState1.setImageResource(i);
      label107:
      RecordUiConfig localRecordUiConfig = uiConfig;
      if (paramLeadState2 != localLeadState)
      {
        if (localRecordUiConfig != null)
        {
          paramLeadState1 = deviceBottomImg;
          i = localRecordUiConfig.getGetTriangleBottomLeadsOn();
          break label181;
        }
        paramLeadState1 = deviceBottomImg;
        i = R.drawable.triangle_hud_bottom_view_active;
      }
      else
      {
        if (localRecordUiConfig != null) {
          break label170;
        }
        paramLeadState1 = deviceBottomImg;
        i = R.drawable.triangle_hud_bottom_view;
      }
      paramLeadState1.setImageResource(i);
      return;
      label170:
      paramLeadState1 = deviceBottomImg;
      i = localRecordUiConfig.getTriangleBottomLeadsOff();
      label181:
      paramLeadState1.setImageResource(i);
    }
  }
  
  private void leadStateUpdated(Position paramPosition)
  {
    a.d("leadStateUpdated: %s", new Object[] { paramPosition });
    Position localPosition = paramPosition;
    if (paramPosition == null)
    {
      paramPosition = LeadState.SUBSCRIBED;
      localPosition = new Position(paramPosition, paramPosition);
    }
    leadStateUpdated((LeadState)a, (LeadState)x);
  }
  
  void goToHelp()
  {
    Object localObject = appPreferences;
    if (((AppPreferences)localObject).getDeviceLead(((AppPreferences)localObject).getSelectedEkgDeviceDebug()) == Direction.S)
    {
      localObject = helpUrls;
      if ((localObject != null) && (!TextUtils.isEmpty(recordingHudHelp1L)))
      {
        localObject = helpUrls.recordingHudHelp1L;
        break label93;
      }
      localObject = "app-redirect/i-need-help-recording-6l-single-lead";
    }
    else
    {
      localObject = helpUrls;
      if ((localObject != null) && (!TextUtils.isEmpty(recordingHudHelp6L)))
      {
        localObject = helpUrls.recordingHudHelp6L;
        break label93;
      }
      localObject = "app-redirect/i-need-help-recording-6l-six-lead";
    }
    localObject = Urls.getFullUrl((String)localObject);
    label93:
    Util.openInBrowser(requireContext(), (String)localObject);
  }
  
  public void leadConfigUpdated(Direction paramDirection)
  {
    leadsConfig = paramDirection;
    if (deviceBottomImg != null)
    {
      float f;
      if (paramDirection == Direction.S)
      {
        recordingHUDDesc.setText(R.string.recording_intro_tr1lead_body);
        deviceBottomImg.setAlpha(0.3F);
        paramDirection = bottomLabel;
        f = 0.0F;
      }
      else
      {
        recordingHUDDesc.setText(R.string.recording_intro_tr6lead_body);
        paramDirection = deviceBottomImg;
        f = 1.0F;
        paramDirection.setAlpha(1.0F);
        paramDirection = bottomLabel;
      }
      paramDirection.setAlpha(f);
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    RecordEkgConfig.getDB().getRecordDependencyComponent().inject(this);
    paramBundle = appPreferences;
    leadsConfig = paramBundle.getDeviceLead(paramBundle.getSelectedEkgDeviceDebug());
    ((EcgMonitorViewModel)new ClassReader(requireActivity()).a(com.alivecor.ecg.record.EcgMonitorViewModel.class)).leadState().observe(requireActivity(), new ArticleListFragment.1(this));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.fragment_triangle_intro_hud, paramViewGroup, false);
    deviceTopImg = ((ImageView)paramLayoutInflater.findViewById(R.id.triangle_intro_hud_device_top));
    deviceBottomImg = ((ImageView)paramLayoutInflater.findViewById(R.id.triangle_intro_hud_device_bottom));
    bottomLabel = paramLayoutInflater.findViewById(R.id.triangle_intro_hud_bottom_label);
    recordingHUDDesc = ((TextView)paramLayoutInflater.findViewById(R.id.recording_hud_desc));
    paramViewGroup = leadsConfig;
    if (paramViewGroup != null) {
      leadConfigUpdated(paramViewGroup);
    }
    helpUrls = ((RecordingHelpUrls)requireArguments().getSerializable("com.alivecor.ecg.record.HELP_URLS"));
    ((TextView)paramLayoutInflater.findViewById(R.id.triangle_intro_hud_help)).setOnClickListener(new CalendarDatePickerDialog.1(this));
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
}
