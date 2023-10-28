package androidx.fragment.package_11;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater.Factory2;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.r;
import v7.v7.util.Log;

public class FragmentController
{
  private final r<?> mHost;
  
  private FragmentController(FragmentHostCallback paramFragmentHostCallback)
  {
    mHost = paramFragmentHostCallback;
  }
  
  public static FragmentController createController(FragmentHostCallback paramFragmentHostCallback)
  {
    return new FragmentController((FragmentHostCallback)Log.get(paramFragmentHostCallback, "callbacks == null"));
  }
  
  public void dispatchActivityCreated()
  {
    mHost.mFragmentManager.onActivityCreated();
  }
  
  public boolean dispatchContextItemSelected(MenuItem paramMenuItem)
  {
    return mHost.mFragmentManager.update(paramMenuItem);
  }
  
  public void dispatchDestroy()
  {
    mHost.mFragmentManager.onCreateView();
  }
  
  public void dispatchPause()
  {
    mHost.mFragmentManager.dispatchPause();
  }
  
  public void dispatchResume()
  {
    mHost.mFragmentManager.init();
  }
  
  public void dispatchStart()
  {
    mHost.mFragmentManager.read();
  }
  
  public void dispatchStop()
  {
    mHost.mFragmentManager.write();
  }
  
  public boolean execPendingActions()
  {
    return mHost.mFragmentManager.add(true);
  }
  
  public FragmentManager getSupportFragmentManager()
  {
    return mHost.mFragmentManager;
  }
  
  public void noteStateNotSaved()
  {
    mHost.mFragmentManager.onStart();
  }
  
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return mHost.mFragmentManager.findFragmentByTag().onCreateView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  public void onCreateView(Fragment paramFragment)
  {
    FragmentHostCallback localFragmentHostCallback = mHost;
    mFragmentManager.onCreate(localFragmentHostCallback, localFragmentHostCallback, paramFragment);
  }
  
  public void restoreAllState()
  {
    mHost.mFragmentManager.restoreState();
  }
}
