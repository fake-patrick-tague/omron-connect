package androidx.work;

import android.app.Notification;

public final class Handle
{
  private final int a;
  private final Notification b;
  private final int c;
  
  public Handle(int paramInt1, Notification paramNotification, int paramInt2)
  {
    a = paramInt1;
    b = paramNotification;
    c = paramInt2;
  }
  
  public Notification a()
  {
    return b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (e.class != paramObject.getClass()) {
        return false;
      }
      paramObject = (Handle)paramObject;
      if (a != a) {
        return false;
      }
      if (c != c) {
        return false;
      }
      return b.equals(b);
    }
    return false;
  }
  
  public int getName()
  {
    return c;
  }
  
  public int getValue()
  {
    return a;
  }
  
  public int hashCode()
  {
    return (a * 31 + c) * 31 + b.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ForegroundInfo{");
    localStringBuilder.append("mNotificationId=");
    localStringBuilder.append(a);
    localStringBuilder.append(", mForegroundServiceType=");
    localStringBuilder.append(c);
    localStringBuilder.append(", mNotification=");
    localStringBuilder.append(b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
