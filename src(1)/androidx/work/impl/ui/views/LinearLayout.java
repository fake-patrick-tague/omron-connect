package androidx.work.impl.ui.views;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.Log;
import androidx.work.impl.m.f.c;
import androidx.work.impl.utils.asm.f;

public class LinearLayout
  extends c<Boolean>
{
  private static final String m = Log.getInstance("StorageNotLowTracker");
  
  public LinearLayout(Context paramContext, f paramF)
  {
    super(paramContext, paramF);
  }
  
  public Boolean call()
  {
    Object localObject = context.registerReceiver(null, init());
    if ((localObject != null) && (((Intent)localObject).getAction() != null))
    {
      localObject = ((Intent)localObject).getAction();
      ((String)localObject).hashCode();
      if (!((String)localObject).equals("android.intent.action.DEVICE_STORAGE_LOW"))
      {
        if (!((String)localObject).equals("android.intent.action.DEVICE_STORAGE_OK")) {
          return null;
        }
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    return Boolean.TRUE;
  }
  
  public IntentFilter init()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
    localIntentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
    return localIntentFilter;
  }
  
  public void init(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction() == null) {
      return;
    }
    Log.get().append(m, String.format("Received %s", new Object[] { paramIntent.getAction() }), new Throwable[0]);
    paramContext = paramIntent.getAction();
    paramContext.hashCode();
    if (!paramContext.equals("android.intent.action.DEVICE_STORAGE_LOW"))
    {
      if (!paramContext.equals("android.intent.action.DEVICE_STORAGE_OK")) {
        return;
      }
      add(Boolean.TRUE);
      return;
    }
    add(Boolean.FALSE);
  }
}
