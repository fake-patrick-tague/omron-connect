package androidx.activity.result.asm;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.d.a;
import kotlin.x.d.i;

public final class g
  extends a<Intent, ActivityResult>
{
  public static final Target a = new Target(null);
  
  public g() {}
  
  public Intent a(Context paramContext, Intent paramIntent)
  {
    i.e(paramContext, "context");
    i.e(paramIntent, "input");
    return paramIntent;
  }
  
  public ActivityResult a(int paramInt, Intent paramIntent)
  {
    return new ActivityResult(paramInt, paramIntent);
  }
}
