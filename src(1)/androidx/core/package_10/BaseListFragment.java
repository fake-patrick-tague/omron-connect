package androidx.core.package_10;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.core.app.g.a;
import androidx.lifecycle.BaseFragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.d;
import androidx.lifecycle.f;
import v7.util.SimpleArrayMap;
import v7.v7.menu.Context;
import v7.v7.package_13.k;

public class BaseListFragment
  extends Activity
  implements d, k
{
  private c.e.g<Class<? extends g.a>, g.a> mExtraDataMap = new SimpleArrayMap();
  private f mLifecycleRegistry = new f(this);
  
  public BaseListFragment() {}
  
  private static boolean shouldSkipDump(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      paramArrayOfString = paramArrayOfString[0];
      paramArrayOfString.hashCode();
      int i = -1;
      switch (paramArrayOfString.hashCode())
      {
      default: 
        break;
      case 1455016274: 
        if (paramArrayOfString.equals("--autofill")) {
          i = 4;
        }
        break;
      case 1159329357: 
        if (paramArrayOfString.equals("--contentcapture")) {
          i = 3;
        }
        break;
      case 472614934: 
        if (paramArrayOfString.equals("--list-dumpables")) {
          i = 2;
        }
        break;
      case 100470631: 
        if (paramArrayOfString.equals("--dump-dumpable")) {
          i = 1;
        }
        break;
      case -645125871: 
        if (paramArrayOfString.equals("--translation")) {
          i = 0;
        }
        break;
      }
      switch (i)
      {
      default: 
        return false;
      case 4: 
        if (Build.VERSION.SDK_INT >= 26) {
          return true;
        }
        break;
      case 3: 
        if (Build.VERSION.SDK_INT >= 29) {
          return true;
        }
        break;
      case 1: 
      case 2: 
        return Context.get();
      case 0: 
        if (Build.VERSION.SDK_INT >= 31) {
          return true;
        }
        break;
      }
    }
    return false;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    View localView = getWindow().getDecorView();
    if ((localView != null) && (v7.v7.package_13.g.a(localView, paramKeyEvent))) {
      return true;
    }
    return v7.v7.package_13.g.a(this, localView, this, paramKeyEvent);
  }
  
  public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
  {
    View localView = getWindow().getDecorView();
    if ((localView != null) && (v7.v7.package_13.g.a(localView, paramKeyEvent))) {
      return true;
    }
    return super.dispatchKeyShortcutEvent(paramKeyEvent);
  }
  
  public AbstractNode getExtraData(Class paramClass)
  {
    return (AbstractNode)mExtraDataMap.get(paramClass);
  }
  
  public Lifecycle getLifecycle()
  {
    return mLifecycleRegistry;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    BaseFragment.showDialog(this);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    mLifecycleRegistry.a(Lifecycle.State.d);
    super.onSaveInstanceState(paramBundle);
  }
  
  public void putExtraData(AbstractNode paramAbstractNode)
  {
    mExtraDataMap.put(paramAbstractNode.getClass(), paramAbstractNode);
  }
  
  protected final boolean shouldDumpInternalState(String[] paramArrayOfString)
  {
    return shouldSkipDump(paramArrayOfString) ^ true;
  }
  
  public boolean superDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return super.dispatchKeyEvent(paramKeyEvent);
  }
}
