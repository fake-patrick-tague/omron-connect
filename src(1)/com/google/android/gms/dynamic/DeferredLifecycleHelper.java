package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Label;
import java.util.LinkedList;

@KeepForSdk
public abstract class DeferredLifecycleHelper<T extends LifecycleDelegate>
{
  private final OnDelegateCreatedListener<T> format = new DownloadsFragment.1(this);
  private T mapView;
  private Bundle parameters;
  private LinkedList<zah> stack;
  
  public DeferredLifecycleHelper() {}
  
  private final void next(int paramInt)
  {
    while ((!stack.isEmpty()) && (((Object)stack.getLast()).type() >= paramInt)) {
      stack.removeLast();
    }
  }
  
  private final void set(Bundle paramBundle, Object paramObject)
  {
    LifecycleDelegate localLifecycleDelegate = mapView;
    if (localLifecycleDelegate != null)
    {
      paramObject.onCreateView(localLifecycleDelegate);
      return;
    }
    if (stack == null) {
      stack = new LinkedList();
    }
    stack.add(paramObject);
    if (paramBundle != null)
    {
      paramObject = parameters;
      if (paramObject == null) {
        parameters = ((Bundle)paramBundle.clone());
      } else {
        paramObject.putAll(paramBundle);
      }
    }
    createDelegate(format);
  }
  
  public static void showGooglePlayUnavailableMessage(FrameLayout paramFrameLayout)
  {
    java.lang.Object localObject = GoogleApiAvailability.getInstance();
    Context localContext = paramFrameLayout.getContext();
    int i = ((GoogleApiAvailability)localObject).isGooglePlayServicesAvailable(localContext);
    String str2 = Label.getText(localContext, i);
    String str1 = Label.getValue(localContext, i);
    LinearLayout localLinearLayout = new LinearLayout(paramFrameLayout.getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    paramFrameLayout.addView(localLinearLayout);
    paramFrameLayout = new TextView(paramFrameLayout.getContext());
    paramFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    paramFrameLayout.setText(str2);
    localLinearLayout.addView(paramFrameLayout);
    paramFrameLayout = ((GoogleApiAvailability)localObject).getErrorResolutionIntent(localContext, i, null);
    if (paramFrameLayout != null)
    {
      localObject = new Button(localContext);
      ((View)localObject).setId(16908313);
      ((View)localObject).setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
      ((TextView)localObject).setText(str1);
      localLinearLayout.addView((View)localObject);
      ((View)localObject).setOnClickListener(new Utilities.1(localContext, paramFrameLayout));
    }
  }
  
  protected abstract void createDelegate(OnDelegateCreatedListener paramOnDelegateCreatedListener);
  
  public LifecycleDelegate getDelegate()
  {
    return mapView;
  }
  
  protected void handleGooglePlayUnavailable(FrameLayout paramFrameLayout)
  {
    showGooglePlayUnavailableMessage(paramFrameLayout);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    set(paramBundle, new Fragment(this, paramBundle));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    FrameLayout localFrameLayout = new FrameLayout(paramLayoutInflater.getContext());
    set(paramBundle, new LogViewerFragment(this, localFrameLayout, paramLayoutInflater, paramViewGroup, paramBundle));
    if (mapView == null) {
      handleGooglePlayUnavailable(localFrameLayout);
    }
    return localFrameLayout;
  }
  
  public void onDestroy()
  {
    LifecycleDelegate localLifecycleDelegate = mapView;
    if (localLifecycleDelegate != null)
    {
      localLifecycleDelegate.onDestroy();
      return;
    }
    next(1);
  }
  
  public void onDestroyView()
  {
    LifecycleDelegate localLifecycleDelegate = mapView;
    if (localLifecycleDelegate != null)
    {
      localLifecycleDelegate.onDestroyView();
      return;
    }
    next(2);
  }
  
  public void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
  {
    set(paramBundle2, new Preference(this, paramActivity, paramBundle1, paramBundle2));
  }
  
  public void onLowMemory()
  {
    LifecycleDelegate localLifecycleDelegate = mapView;
    if (localLifecycleDelegate != null) {
      localLifecycleDelegate.onLowMemory();
    }
  }
  
  public void onPause()
  {
    LifecycleDelegate localLifecycleDelegate = mapView;
    if (localLifecycleDelegate != null)
    {
      localLifecycleDelegate.onPause();
      return;
    }
    next(5);
  }
  
  public void onResume()
  {
    set(null, new BatteryInfo(this));
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    java.lang.Object localObject = mapView;
    if (localObject != null)
    {
      ((LifecycleDelegate)localObject).onSaveInstanceState(paramBundle);
      return;
    }
    localObject = parameters;
    if (localObject != null) {
      paramBundle.putAll((Bundle)localObject);
    }
  }
  
  public void onStart()
  {
    set(null, new FragmentManagerImpl(this));
  }
  
  public void onStop()
  {
    LifecycleDelegate localLifecycleDelegate = mapView;
    if (localLifecycleDelegate != null)
    {
      localLifecycleDelegate.onStop();
      return;
    }
    next(4);
  }
}
