package androidx.work.impl.ui.views;

import android.content.Context;
import androidx.work.impl.utils.asm.f;

public class h
{
  private static h g;
  private Task b;
  private LinearLayout d;
  private Item k;
  private Label o;
  
  private h(Context paramContext, f paramF)
  {
    paramContext = paramContext.getApplicationContext();
    b = new Task(paramContext, paramF);
    k = new Item(paramContext, paramF);
    o = new Label(paramContext, paramF);
    d = new LinearLayout(paramContext, paramF);
  }
  
  public static h a(Context paramContext, f paramF)
  {
    try
    {
      if (g == null) {
        g = new h(paramContext, paramF);
      }
      paramContext = g;
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public Item a()
  {
    return k;
  }
  
  public Task b()
  {
    return b;
  }
  
  public LinearLayout e()
  {
    return d;
  }
  
  public Label j()
  {
    return o;
  }
}
