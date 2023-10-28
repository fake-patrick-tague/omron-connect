package androidx.activity.result.asm;

import android.content.Intent;
import kotlin.x.d.i;

public final class h
{
  private h() {}
  
  public final Intent a(String[] paramArrayOfString)
  {
    i.e(paramArrayOfString, "input");
    paramArrayOfString = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", paramArrayOfString);
    i.d(paramArrayOfString, "Intent(ACTION_REQUEST_PE?EXTRA_PERMISSIONS, input)");
    return paramArrayOfString;
  }
}
