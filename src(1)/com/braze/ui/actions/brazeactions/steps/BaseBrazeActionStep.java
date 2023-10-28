package com.braze.ui.actions.brazeactions.steps;

import com.braze.Braze;
import com.braze.BrazeUser;
import com.braze.events.IValueCallback;
import com.braze.support.BrazeLogger;
import kotlin.x.c.a;
import kotlin.x.c.l;
import kotlin.x.d.i;
import kotlin.x.d.j;

public abstract class BaseBrazeActionStep
  implements IBrazeActionStep
{
  public static final Companion Companion = new Companion(null);
  
  private BaseBrazeActionStep() {}
  
  public static final class Companion
  {
    private Companion() {}
    
    public final void runOnUser$android_sdk_ui_release(Braze paramBraze, l paramL)
    {
      i.e(paramBraze, "<this>");
      i.e(paramL, "block");
      paramBraze.getCurrentUser(new IValueCallback()
      {
        public void onError()
        {
          BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, onError.1.INSTANCE, 3, null);
        }
        
        public void onSuccess(BrazeUser paramAnonymousBrazeUser)
        {
          i.e(paramAnonymousBrazeUser, "value");
          invoke(paramAnonymousBrazeUser);
        }
      });
    }
  }
}
