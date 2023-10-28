package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build.VERSION;
import android.os.Bundle;

public class BaseFragment
  extends Fragment
{
  private Context context;
  
  public BaseFragment() {}
  
  static BaseFragment onActivityCreated(Activity paramActivity)
  {
    return (BaseFragment)paramActivity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
  }
  
  static void onCreateOptionsMenu(Activity paramActivity, Lifecycle.Event paramEvent)
  {
    if ((paramActivity instanceof IOverlayMenuProvider))
    {
      ((IOverlayMenuProvider)paramActivity).getLifecycle().append(paramEvent);
      return;
    }
    if ((paramActivity instanceof d))
    {
      paramActivity = ((d)paramActivity).getLifecycle();
      if ((paramActivity instanceof f)) {
        ((f)paramActivity).append(paramEvent);
      }
    }
  }
  
  private void onPause(Lifecycle.Event paramEvent)
  {
    if (Build.VERSION.SDK_INT < 29) {
      onCreateOptionsMenu(getActivity(), paramEvent);
    }
  }
  
  public static void showDialog(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 29) {
      LifecycleHandler.registerIn(paramActivity);
    }
    paramActivity = paramActivity.getFragmentManager();
    if (paramActivity.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null)
    {
      paramActivity.beginTransaction().add(new BaseFragment(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
      paramActivity.executePendingTransactions();
    }
  }
  
  private void showDialog(Context paramContext)
  {
    if (paramContext != null) {
      paramContext.onResume();
    }
  }
  
  private void showInfo(Context paramContext)
  {
    if (paramContext != null) {
      paramContext.setOptimizationLevel();
    }
  }
  
  private void start(Context paramContext)
  {
    if (paramContext != null) {
      paramContext.onStart();
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    showInfo(context);
    onPause(Lifecycle.Event.ON_CREATE);
  }
  
  void onActivityCreated(Context paramContext)
  {
    context = paramContext;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    onPause(Lifecycle.Event.ON_DESTROY);
    context = null;
  }
  
  public void onPause()
  {
    super.onPause();
    onPause(Lifecycle.Event.ON_PAUSE);
  }
  
  public void onResume()
  {
    super.onResume();
    showDialog(context);
    onPause(Lifecycle.Event.ON_RESUME);
  }
  
  public void onStart()
  {
    super.onStart();
    start(context);
    onPause(Lifecycle.Event.ON_START);
  }
  
  public void onStop()
  {
    super.onStop();
    onPause(Lifecycle.Event.ON_STOP);
  }
}
