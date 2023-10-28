package androidx.core.package_10;

import android.app.Notification;
import android.app.NotificationChannel;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import v7.v7.util.Log;

public class Switch
{
  CharSequence a;
  AudioAttributes b;
  boolean c = true;
  boolean d;
  final String e;
  int f;
  int g = 0;
  String h;
  Uri i = Settings.System.DEFAULT_NOTIFICATION_URI;
  boolean k;
  long[] l;
  String m;
  private boolean p;
  private int r;
  private boolean s;
  private boolean t;
  String v;
  String w;
  
  Switch(NotificationChannel paramNotificationChannel)
  {
    this(paramNotificationChannel.getId(), paramNotificationChannel.getImportance());
    a = paramNotificationChannel.getName();
    w = paramNotificationChannel.getDescription();
    v = paramNotificationChannel.getGroup();
    b = paramNotificationChannel.getAudioAttributes();
    d = paramNotificationChannel.shouldShowLights();
    k = paramNotificationChannel.shouldVibrate();
    l = paramNotificationChannel.getVibrationPattern();
    int j = Build.VERSION.SDK_INT;
    if (j >= 30)
    {
      m = paramNotificationChannel.getParentChannelId();
      h = paramNotificationChannel.getConversationId();
    }
    t = paramNotificationChannel.canBypassDnd();
    r = paramNotificationChannel.getLockscreenVisibility();
    if (j >= 29) {
      s = paramNotificationChannel.canBubble();
    }
    if (j >= 30) {
      p = paramNotificationChannel.isImportantConversation();
    }
  }
  
  Switch(String paramString, int paramInt)
  {
    e = ((String)Log.valueOf(paramString));
    f = paramInt;
    if (Build.VERSION.SDK_INT >= 21) {
      b = Notification.AUDIO_ATTRIBUTES_DEFAULT;
    }
  }
  
  NotificationChannel a()
  {
    int j = Build.VERSION.SDK_INT;
    if (j < 26) {
      return null;
    }
    NotificationChannel localNotificationChannel = new NotificationChannel(e, a, f);
    localNotificationChannel.setDescription(w);
    localNotificationChannel.setGroup(v);
    localNotificationChannel.setShowBadge(c);
    localNotificationChannel.setSound(i, b);
    localNotificationChannel.enableLights(d);
    localNotificationChannel.setLightColor(g);
    localNotificationChannel.setVibrationPattern(l);
    localNotificationChannel.enableVibration(k);
    if (j >= 30)
    {
      String str1 = m;
      if (str1 != null)
      {
        String str2 = h;
        if (str2 != null) {
          localNotificationChannel.setConversationId(str1, str2);
        }
      }
    }
    return localNotificationChannel;
  }
}
