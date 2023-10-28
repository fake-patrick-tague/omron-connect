package androidx.core.package_10;

import android.app.Notification.BigTextStyle;
import android.os.Build.VERSION;
import android.os.Bundle;

public class Frame
  extends ByteVector
{
  private CharSequence s;
  
  public Frame() {}
  
  public Frame a(CharSequence paramCharSequence)
  {
    s = ClassWriter.format(paramCharSequence);
    return this;
  }
  
  public void addCompatExtras(Bundle paramBundle)
  {
    super.addCompatExtras(paramBundle);
    if (Build.VERSION.SDK_INT < 21) {
      paramBundle.putCharSequence("android.bigText", s);
    }
  }
  
  public void apply(Duration paramDuration)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramDuration = new Notification.BigTextStyle(paramDuration.getValue()).setBigContentTitle(mBigContentTitle).bigText(s);
      if (mSummaryTextSet) {
        paramDuration.setSummaryText(mSummaryText);
      }
    }
  }
  
  public Frame b(CharSequence paramCharSequence)
  {
    mBigContentTitle = ClassWriter.format(paramCharSequence);
    return this;
  }
  
  protected String getClassName()
  {
    return "androidx.core.app.NotificationCompat$BigTextStyle";
  }
  
  public Frame init(CharSequence paramCharSequence)
  {
    mSummaryText = ClassWriter.format(paramCharSequence);
    mSummaryTextSet = true;
    return this;
  }
}
