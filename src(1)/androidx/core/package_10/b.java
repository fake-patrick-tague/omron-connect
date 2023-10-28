package androidx.core.package_10;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.os.Build.VERSION;
import androidx.core.app.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import v7.v7.util.Log;

public class b
{
  CharSequence a;
  private boolean b;
  final String c;
  private List<k> e = Collections.emptyList();
  String f;
  
  b(NotificationChannelGroup paramNotificationChannelGroup)
  {
    this(paramNotificationChannelGroup, Collections.emptyList());
  }
  
  b(NotificationChannelGroup paramNotificationChannelGroup, List paramList)
  {
    this(paramNotificationChannelGroup.getId());
    a = paramNotificationChannelGroup.getName();
    int i = Build.VERSION.SDK_INT;
    if (i >= 28) {
      f = paramNotificationChannelGroup.getDescription();
    }
    if (i >= 28)
    {
      b = paramNotificationChannelGroup.isBlocked();
      e = a(paramNotificationChannelGroup.getChannels());
      return;
    }
  }
  
  b(String paramString)
  {
    c = ((String)Log.valueOf(paramString));
  }
  
  private List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      NotificationChannel localNotificationChannel = (NotificationChannel)paramList.next();
      if (c.equals(localNotificationChannel.getGroup())) {
        localArrayList.add(new Switch(localNotificationChannel));
      }
    }
    return localArrayList;
  }
  
  NotificationChannelGroup a()
  {
    int i = Build.VERSION.SDK_INT;
    if (i < 26) {
      return null;
    }
    NotificationChannelGroup localNotificationChannelGroup = new NotificationChannelGroup(c, a);
    if (i >= 28) {
      localNotificationChannelGroup.setDescription(f);
    }
    return localNotificationChannelGroup;
  }
}
