package androidx.core.package_10;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.app.m.a;
import androidx.core.app.r;
import java.util.ArrayList;
import v7.v7.R.dimen;

public class ClassWriter
{
  ByteVector A;
  boolean E;
  boolean H;
  CharSequence[] I;
  RemoteViews J;
  boolean K;
  boolean L;
  boolean M;
  boolean N;
  @Deprecated
  public ArrayList<String> a;
  String b;
  int c;
  CharSequence d;
  Notification data;
  Icon e;
  String f;
  int flags;
  RemoteViews g;
  int h = 0;
  boolean i = true;
  Bitmap icon;
  CharSequence id;
  int index;
  CharSequence info;
  boolean items;
  ArrayList<m.a> j = new ArrayList();
  int k = 0;
  androidx.core.content.Context l;
  public ArrayList<m.a> m = new ArrayList();
  public android.content.Context mContext;
  Bundle mExtras;
  RemoteViews mTickerView;
  String n;
  String name;
  MethodInfo o;
  int p = 0;
  public ArrayList<r> q = new ArrayList();
  int r = 0;
  boolean running;
  boolean s = false;
  long t;
  CharSequence text;
  Notification this$0;
  CharSequence title;
  PendingIntent u;
  RemoteViews v;
  PendingIntent version;
  int w = 0;
  int x;
  String z;
  
  public ClassWriter(android.content.Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ClassWriter(android.content.Context paramContext, String paramString)
  {
    Notification localNotification = new Notification();
    this$0 = localNotification;
    mContext = paramContext;
    name = paramString;
    when = System.currentTimeMillis();
    this$0.audioStreamType = -1;
    x = 0;
    a = new ArrayList();
    M = true;
  }
  
  private void add(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localNotification = this$0;
      flags = (paramInt | flags);
      return;
    }
    Notification localNotification = this$0;
    flags = (paramInt & flags);
  }
  
  protected static CharSequence format(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return paramCharSequence;
    }
    CharSequence localCharSequence = paramCharSequence;
    if (paramCharSequence.length() > 5120) {
      localCharSequence = paramCharSequence.subSequence(0, 5120);
    }
    return localCharSequence;
  }
  
  private Bitmap load(Bitmap paramBitmap)
  {
    Object localObject = paramBitmap;
    if (paramBitmap != null)
    {
      if (Build.VERSION.SDK_INT >= 27) {
        return paramBitmap;
      }
      localObject = mContext.getResources();
      int i1 = ((Resources)localObject).getDimensionPixelSize(R.dimen.Iconics_ico_offset_y);
      int i2 = ((Resources)localObject).getDimensionPixelSize(R.dimen.Iconics_ico_padding);
      if ((paramBitmap.getWidth() <= i1) && (paramBitmap.getHeight() <= i2)) {
        return paramBitmap;
      }
      double d1 = Math.min(i1 / Math.max(1, paramBitmap.getWidth()), i2 / Math.max(1, paramBitmap.getHeight()));
      localObject = Bitmap.createScaledBitmap(paramBitmap, (int)Math.ceil(paramBitmap.getWidth() * d1), (int)Math.ceil(paramBitmap.getHeight() * d1), true);
    }
    return localObject;
  }
  
  public int a()
  {
    return r;
  }
  
  public ClassWriter a(int paramInt)
  {
    flags = paramInt;
    return this;
  }
  
  public ClassWriter a(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
  {
    m.add(new f(paramInt, paramCharSequence, paramPendingIntent));
    return this;
  }
  
  public ClassWriter a(RemoteViews paramRemoteViews)
  {
    J = paramRemoteViews;
    return this;
  }
  
  public ClassWriter a(ByteVector paramByteVector)
  {
    if (A != paramByteVector)
    {
      A = paramByteVector;
      if (paramByteVector != null) {
        paramByteVector.setBuilder(this);
      }
    }
    return this;
  }
  
  public ClassWriter a(f paramF)
  {
    if (paramF != null) {
      m.add(paramF);
    }
    return this;
  }
  
  public ClassWriter a(CharSequence paramCharSequence)
  {
    text = format(paramCharSequence);
    return this;
  }
  
  public ClassWriter a(String paramString)
  {
    name = paramString;
    return this;
  }
  
  public ClassWriter a(boolean paramBoolean)
  {
    add(16, paramBoolean);
    return this;
  }
  
  public long add()
  {
    if (i) {
      return this$0.when;
    }
    return 0L;
  }
  
  public ClassWriter add(int paramInt)
  {
    Notification localNotification = this$0;
    defaults = paramInt;
    if ((paramInt & 0x4) != 0) {
      flags |= 0x1;
    }
    return this;
  }
  
  public RemoteViews b()
  {
    return g;
  }
  
  public ClassWriter b(int paramInt)
  {
    r = paramInt;
    return this;
  }
  
  public ClassWriter b(PendingIntent paramPendingIntent)
  {
    u = paramPendingIntent;
    return this;
  }
  
  public ClassWriter b(CharSequence paramCharSequence)
  {
    title = format(paramCharSequence);
    return this;
  }
  
  public ClassWriter b(String paramString)
  {
    z = paramString;
    return this;
  }
  
  public ClassWriter b(boolean paramBoolean)
  {
    s = paramBoolean;
    return this;
  }
  
  public int c()
  {
    return x;
  }
  
  public ClassWriter c(int paramInt)
  {
    p = paramInt;
    return this;
  }
  
  public Notification get()
  {
    return new i(this).get();
  }
  
  public ClassWriter get(int paramInt)
  {
    this$0.icon = paramInt;
    return this;
  }
  
  public ClassWriter get(long paramLong)
  {
    this$0.when = paramLong;
    return this;
  }
  
  public ClassWriter get(Uri paramUri)
  {
    Notification localNotification = this$0;
    sound = paramUri;
    audioStreamType = -1;
    if (Build.VERSION.SDK_INT >= 21) {
      audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
    }
    return this;
  }
  
  public ClassWriter get(CharSequence paramCharSequence)
  {
    this$0.tickerText = format(paramCharSequence);
    return this;
  }
  
  public Bundle getExtras()
  {
    if (mExtras == null) {
      mExtras = new Bundle();
    }
    return mExtras;
  }
  
  public ClassWriter put(int paramInt)
  {
    x = paramInt;
    return this;
  }
  
  public ClassWriter put(Notification paramNotification)
  {
    data = paramNotification;
    return this;
  }
  
  public ClassWriter put(PendingIntent paramPendingIntent)
  {
    this$0.deleteIntent = paramPendingIntent;
    return this;
  }
  
  public ClassWriter put(Bitmap paramBitmap)
  {
    icon = load(paramBitmap);
    return this;
  }
  
  public ClassWriter put(CharSequence paramCharSequence)
  {
    id = format(paramCharSequence);
    return this;
  }
  
  public ClassWriter put(boolean paramBoolean)
  {
    add(8, paramBoolean);
    return this;
  }
  
  public ClassWriter put(long[] paramArrayOfLong)
  {
    this$0.vibrate = paramArrayOfLong;
    return this;
  }
  
  public ClassWriter setLights(int paramInt1, int paramInt2, int paramInt3)
  {
    Notification localNotification = this$0;
    ledARGB = paramInt1;
    ledOnMS = paramInt2;
    ledOffMS = paramInt3;
    if ((paramInt2 != 0) && (paramInt3 != 0)) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    flags = (paramInt1 | flags & 0xFFFFFFFE);
    return this;
  }
  
  public RemoteViews visitAnnotation()
  {
    return v;
  }
  
  public ClassWriter visitAnnotation(RemoteViews paramRemoteViews)
  {
    v = paramRemoteViews;
    return this;
  }
  
  public ClassWriter visitAnnotation(String paramString)
  {
    n = paramString;
    return this;
  }
  
  public ClassWriter visitAnnotation(boolean paramBoolean)
  {
    i = paramBoolean;
    return this;
  }
  
  public RemoteViews visitAttribute()
  {
    return J;
  }
}
