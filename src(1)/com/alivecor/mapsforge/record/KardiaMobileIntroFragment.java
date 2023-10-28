package com.alivecor.mapsforge.record;

import android.os.Bundle;
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
import com.alivecor.universal_monitor.LeadState;
import l.a.a;
import v7.v7.util.Position;

public class KardiaMobileIntroFragment
  extends Fragment
{
  ImageView deviceImg;
  
  public KardiaMobileIntroFragment() {}
  
  void goToHelp()
  {
    Util.openInBrowser(requireContext(), Urls.getFullUrl("app-redirect/i-need-help-recording-km"));
  }
  
  public void leadStateUpdated(Position paramPosition)
  {
    a.d("leadStateUpdated: %s", new Object[] { paramPosition });
    Position localPosition = paramPosition;
    if (paramPosition == null)
    {
      paramPosition = LeadState.SUBSCRIBED;
      localPosition = new Position(paramPosition, paramPosition);
    }
    if (deviceImg != null)
    {
      if (!isAdded()) {
        return;
      }
      int i;
      if (a != LeadState.SUBSCRIBED)
      {
        paramPosition = deviceImg;
        i = R.drawable.kmobile_active_hud;
      }
      else
      {
        paramPosition = deviceImg;
        i = R.drawable.kmobile_hud;
      }
      paramPosition.setImageResource(i);
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    ((EcgMonitorViewModel)new ClassReader(requireActivity()).a(com.alivecor.ecg.record.EcgMonitorViewModel.class)).leadState().observe(requireActivity(), new SingleFieldBuilder(this));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.fragment_km_intro_hud, paramViewGroup, false);
    deviceImg = ((ImageView)paramLayoutInflater.findViewById(R.id.km_intro_hud_device_top));
    ((TextView)paramLayoutInflater.findViewById(R.id.km_intro_hud_help)).setOnClickListener(new RadialTimePickerDialog.4(this));
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
}
