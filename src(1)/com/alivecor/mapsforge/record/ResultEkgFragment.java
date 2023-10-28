package com.alivecor.mapsforge.record;

import android.os.BaseBundle;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.package_11.Fragment;
import androidx.lifecycle.ClassReader;
import androidx.lifecycle.LiveData;
import com.alivecor.upgrade.AliveCorEcg;
import l.a.a;

public final class ResultEkgFragment
  extends FragEcgResults
{
  private static final String PAGE_KEY = "com.alivecor.ecg.record.ResultEKGFragment";
  private ResultDetail recordResult;
  private ResultEkgListener resultCallback;
  private ResultEKGViewModel viewModel;
  
  public ResultEkgFragment() {}
  
  protected static ResultEkgFragment newInstance(ResultDetail paramResultDetail, boolean paramBoolean, RecordingHelpUrls paramRecordingHelpUrls)
    throws InvalidArgumentException
  {
    ResultEkgFragment localResultEkgFragment = new ResultEkgFragment();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("com.alivecor.ecg.result", paramResultDetail);
    localBundle.putBoolean("com.alivecor.ecg.showTopBar", paramBoolean);
    localBundle.putSerializable("com.alivecor.ecg.record.HELP_URLS", paramRecordingHelpUrls);
    a.a("RecordingHelpUrls %s", new Object[] { paramRecordingHelpUrls });
    localResultEkgFragment.setArguments(localBundle);
    return localResultEkgFragment;
  }
  
  public static ResultEkgFragment newInstance(AliveCorEcg paramAliveCorEcg)
    throws InvalidArgumentException
  {
    return newInstance(paramAliveCorEcg, true, null);
  }
  
  public static ResultEkgFragment newInstance(AliveCorEcg paramAliveCorEcg, RecordingHelpUrls paramRecordingHelpUrls)
    throws InvalidArgumentException
  {
    return newInstance(paramAliveCorEcg, true, paramRecordingHelpUrls);
  }
  
  public static ResultEkgFragment newInstance(AliveCorEcg paramAliveCorEcg, boolean paramBoolean, RecordingHelpUrls paramRecordingHelpUrls)
    throws InvalidArgumentException
  {
    return newInstance(new RecordSdkHelper(RecordEkgConfig.getDB()).resultDetailFromEcg(paramAliveCorEcg), paramBoolean, paramRecordingHelpUrls);
  }
  
  public void addListener(ResultEkgListener paramResultEkgListener)
  {
    resultCallback = paramResultEkgListener;
  }
  
  protected ResultEKGViewModel getResultViewModel()
  {
    return (ResultEKGViewModel)new ClassReader(requireActivity()).a(com.alivecor.ecg.record.ResultEKGViewModel.class);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((getArguments() != null) && (getArguments().containsKey("com.alivecor.ecg.result")))
    {
      recordResult = ((ResultDetail)getArguments().getSerializable("com.alivecor.ecg.result"));
      return;
    }
    throw new IllegalArgumentException("Missing required parameters.  Use #newInstance to obtain a new instance of this object.");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup = (ResultEKGViewModel)new ClassReader(requireActivity()).a(com.alivecor.ecg.record.ResultEKGViewModel.class);
    viewModel = paramViewGroup;
    resultTaskMutableLiveData.observe(getViewLifecycleOwner(), new RecyclerView(this));
    viewModel.setRecordResult(recordResult);
    return paramLayoutInflater;
  }
  
  public void removeListener(ResultEkgListener paramResultEkgListener)
  {
    resultCallback = null;
  }
}
