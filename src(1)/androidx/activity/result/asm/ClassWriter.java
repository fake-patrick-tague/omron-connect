package androidx.activity.result.asm;

import android.content.Context;
import android.content.Intent;
import kotlin.x.d.i;

public abstract class ClassWriter<I, O>
{
  public ClassWriter() {}
  
  public Label a(Context paramContext, Object paramObject)
  {
    i.e(paramContext, "context");
    return null;
  }
  
  public abstract Intent b(Context paramContext, Object paramObject);
  
  public abstract Object b(int paramInt, Intent paramIntent);
}
