package com.google.android.gms.common.package_12.internal;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.common.Util;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import v7.util.ArrayMap;

public final class Main
  extends Fragment
  implements LifecycleFragment
{
  private static final WeakHashMap listeners = new WeakHashMap();
  private Bundle result;
  private final Map settings = Collections.synchronizedMap(new ArrayMap());
  private int state = 0;
  
  public Main() {}
  
  public static Main run(Activity paramActivity)
  {
    WeakHashMap localWeakHashMap = listeners;
    Object localObject = (WeakReference)localWeakHashMap.get(paramActivity);
    if (localObject != null)
    {
      localObject = (Main)((WeakReference)localObject).get();
      if (localObject != null) {
        return localObject;
      }
    }
    try
    {
      Main localMain = (Main)paramActivity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
      if (localMain != null)
      {
        localObject = localMain;
        if (!localMain.isRemoving()) {}
      }
      else
      {
        localObject = new Main();
        paramActivity.getFragmentManager().beginTransaction().add((Fragment)localObject, "LifecycleFragmentImpl").commitAllowingStateLoss();
      }
      localWeakHashMap.put(paramActivity, new WeakReference(localObject));
      return localObject;
    }
    catch (ClassCastException paramActivity)
    {
      throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", paramActivity);
    }
  }
  
  public final void addCallback(String paramString, LifecycleCallback paramLifecycleCallback)
  {
    if (!settings.containsKey(paramString))
    {
      settings.put(paramString, paramLifecycleCallback);
      if (state > 0) {
        new Util(Looper.getMainLooper()).post(new b(this, paramLifecycleCallback, paramString));
      }
    }
    else
    {
      paramLifecycleCallback = new StringBuilder();
      paramLifecycleCallback.append("LifecycleCallback with tag ");
      paramLifecycleCallback.append(paramString);
      paramLifecycleCallback.append(" already added to this fragment.");
      throw new IllegalArgumentException(paramLifecycleCallback.toString());
    }
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    Iterator localIterator = settings.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  public final LifecycleCallback getCallbackOrNull(String paramString, Class paramClass)
  {
    return (LifecycleCallback)paramClass.cast(settings.get(paramString));
  }
  
  public final Activity getLifecycleActivity()
  {
    return getActivity();
  }
  
  public final boolean isCreated()
  {
    return state > 0;
  }
  
  public final boolean isStarted()
  {
    return state >= 2;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Iterator localIterator = settings.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    state = 1;
    result = paramBundle;
    Iterator localIterator = settings.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      LifecycleCallback localLifecycleCallback = (LifecycleCallback)((Map.Entry)localObject).getValue();
      if (paramBundle != null) {
        localObject = paramBundle.getBundle((String)((Map.Entry)localObject).getKey());
      } else {
        localObject = null;
      }
      localLifecycleCallback.onCreate((Bundle)localObject);
    }
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    state = 5;
    Iterator localIterator = settings.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).onDestroy();
    }
  }
  
  public final void onResume()
  {
    super.onResume();
    state = 3;
    Iterator localIterator = settings.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).onResume();
    }
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (paramBundle == null) {
      return;
    }
    Iterator localIterator = settings.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Bundle localBundle = new Bundle();
      ((LifecycleCallback)localEntry.getValue()).onSaveInstanceState(localBundle);
      paramBundle.putBundle((String)localEntry.getKey(), localBundle);
    }
  }
  
  public final void onStart()
  {
    super.onStart();
    state = 2;
    Iterator localIterator = settings.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).onStart();
    }
  }
  
  public final void onStop()
  {
    super.onStop();
    state = 4;
    Iterator localIterator = settings.values().iterator();
    while (localIterator.hasNext()) {
      ((LifecycleCallback)localIterator.next()).onStop();
    }
  }
}
