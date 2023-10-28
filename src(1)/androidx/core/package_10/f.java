package androidx.core.package_10;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;

public class f
{
  private boolean a;
  @Deprecated
  public int b;
  private final boolean c;
  private final RemoteInput[] e;
  private final RemoteInput[] f;
  private boolean i;
  private IconCompat m;
  boolean p = true;
  private final int r;
  final Bundle s;
  public CharSequence title;
  public PendingIntent v;
  
  public f(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
  {
    this(localIconCompat, paramCharSequence, paramPendingIntent);
  }
  
  public f(IconCompat paramIconCompat, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
  {
    this(paramIconCompat, paramCharSequence, paramPendingIntent, new Bundle(), null, null, true, 0, true, false, false);
  }
  
  f(IconCompat paramIconCompat, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle, RemoteInput[] paramArrayOfRemoteInput1, RemoteInput[] paramArrayOfRemoteInput2, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    m = paramIconCompat;
    if ((paramIconCompat != null) && (paramIconCompat.b() == 2)) {
      b = paramIconCompat.a();
    }
    title = ClassWriter.format(paramCharSequence);
    v = paramPendingIntent;
    if (paramBundle == null) {
      paramBundle = new Bundle();
    }
    s = paramBundle;
    e = paramArrayOfRemoteInput1;
    f = paramArrayOfRemoteInput2;
    a = paramBoolean1;
    r = paramInt;
    p = paramBoolean2;
    c = paramBoolean3;
    i = paramBoolean4;
  }
  
  public int a()
  {
    return r;
  }
  
  public boolean b()
  {
    return p;
  }
  
  public IconCompat c()
  {
    if (m == null)
    {
      int j = b;
      if (j != 0) {
        m = IconCompat.a(null, "", j);
      }
    }
    return m;
  }
  
  public Bundle d()
  {
    return s;
  }
  
  public RemoteInput[] e()
  {
    return e;
  }
  
  public RemoteInput[] f()
  {
    return f;
  }
  
  public CharSequence getTitle()
  {
    return title;
  }
  
  public boolean i()
  {
    return i;
  }
  
  public boolean n()
  {
    return a;
  }
  
  public PendingIntent p()
  {
    return v;
  }
  
  public boolean q()
  {
    return c;
  }
}
