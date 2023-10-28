package androidx.emoji2.text;

import android.content.Context;
import java.util.concurrent.Executor;
import v7.v7.asm.h;

public class ExtensionData
  extends Item
{
  private static final c d = new c();
  
  public ExtensionData(Context paramContext, h paramH)
  {
    super(new b(paramContext, paramH, d));
  }
  
  public ExtensionData a(Executor paramExecutor)
  {
    ((b)a()).a(paramExecutor);
    return this;
  }
}
