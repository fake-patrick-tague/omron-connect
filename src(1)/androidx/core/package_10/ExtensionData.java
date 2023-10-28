package androidx.core.package_10;

import android.app.Notification.BigPictureStyle;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import androidx.core.graphics.drawable.IconCompat;

public class ExtensionData
  extends ByteVector
{
  private IconCompat b;
  private CharSequence c;
  private boolean e;
  private IconCompat f;
  private boolean g;
  
  public ExtensionData() {}
  
  public ExtensionData a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      paramBitmap = null;
    } else {
      paramBitmap = IconCompat.a(paramBitmap);
    }
    f = paramBitmap;
    return this;
  }
  
  public ExtensionData a(CharSequence paramCharSequence)
  {
    mBigContentTitle = ClassWriter.format(paramCharSequence);
    return this;
  }
  
  public void apply(Duration paramDuration)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 16)
    {
      Notification.BigPictureStyle localBigPictureStyle = new Notification.BigPictureStyle(paramDuration.getValue()).setBigContentTitle(mBigContentTitle);
      Object localObject1 = localBigPictureStyle;
      IconCompat localIconCompat = f;
      Object localObject3 = null;
      Object localObject2 = localObject1;
      if (localIconCompat != null) {
        if (i >= 31)
        {
          if ((paramDuration instanceof i)) {
            localObject2 = ((i)paramDuration).add();
          } else {
            localObject2 = null;
          }
          m.b.c.print(localBigPictureStyle, f.get((Context)localObject2));
          localObject2 = localObject1;
        }
        else
        {
          localObject2 = localObject1;
          if (localIconCompat.b() == 1) {
            localObject2 = localBigPictureStyle.bigPicture(f.get());
          }
        }
      }
      if (e)
      {
        localObject1 = b;
        if (localObject1 == null)
        {
          m.b.a.set((Notification.BigPictureStyle)localObject2, null);
        }
        else if (i >= 23)
        {
          localObject1 = localObject3;
          if ((paramDuration instanceof i)) {
            localObject1 = ((i)paramDuration).add();
          }
          m.b.b.print((Notification.BigPictureStyle)localObject2, b.get((Context)localObject1));
        }
        else if (((IconCompat)localObject1).b() == 1)
        {
          m.b.a.set((Notification.BigPictureStyle)localObject2, b.get());
        }
        else
        {
          m.b.a.set((Notification.BigPictureStyle)localObject2, null);
        }
      }
      if (mSummaryTextSet) {
        m.b.a.addBigPictureStyle((Notification.BigPictureStyle)localObject2, mSummaryText);
      }
      if (i >= 31)
      {
        m.b.c.setEGLConfigChooser((Notification.BigPictureStyle)localObject2, g);
        m.b.c.setContentDescription((Notification.BigPictureStyle)localObject2, c);
      }
    }
  }
  
  public ExtensionData b(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      paramBitmap = null;
    } else {
      paramBitmap = IconCompat.a(paramBitmap);
    }
    b = paramBitmap;
    e = true;
    return this;
  }
  
  public ExtensionData b(CharSequence paramCharSequence)
  {
    mSummaryText = ClassWriter.format(paramCharSequence);
    mSummaryTextSet = true;
    return this;
  }
  
  protected String getClassName()
  {
    return "androidx.core.app.NotificationCompat$BigPictureStyle";
  }
}
