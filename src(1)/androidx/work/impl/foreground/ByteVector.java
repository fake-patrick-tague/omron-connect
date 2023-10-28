package androidx.work.impl.foreground;

import android.app.Notification;

abstract interface ByteVector
{
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt1, int paramInt2, Notification paramNotification);
  
  public abstract void a(int paramInt, Notification paramNotification);
  
  public abstract void stop();
}
