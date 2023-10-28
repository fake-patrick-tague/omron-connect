package androidx.core.package_10;

import android.app.Notification;
import android.app.Notification.Action.Builder;
import android.app.Notification.Builder;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.BaseBundle;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import v7.util.TLongArrayList;

class i
  implements Duration
{
  private final ClassWriter a;
  private final Notification.Builder b;
  private final Bundle c;
  private RemoteViews g;
  private int h;
  private final Context i;
  private RemoteViews l;
  private RemoteViews m;
  private final List<Bundle> x;
  
  i(ClassWriter paramClassWriter) {}
  
  private static List a(List paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(((h)paramList.next()).a());
    }
    return localArrayList;
  }
  
  private void a(f paramF)
  {
    int j = Build.VERSION.SDK_INT;
    if (j >= 20)
    {
      Object localObject1 = paramF.c();
      int k = 0;
      if (j >= 23)
      {
        if (localObject1 != null) {
          localObject1 = ((IconCompat)localObject1).getIcon();
        } else {
          localObject1 = null;
        }
        localObject1 = new Notification.Action.Builder((Icon)localObject1, paramF.getTitle(), paramF.p());
      }
      else
      {
        if (localObject1 != null) {
          j = ((IconCompat)localObject1).a();
        } else {
          j = 0;
        }
        localObject1 = new Notification.Action.Builder(j, paramF.getTitle(), paramF.p());
      }
      Object localObject2;
      if (paramF.e() != null)
      {
        localObject2 = RemoteInput.build(paramF.e());
        int n = localObject2.length;
        j = k;
        while (j < n)
        {
          ((Notification.Action.Builder)localObject1).addRemoteInput(localObject2[j]);
          j += 1;
        }
      }
      if (paramF.d() != null) {
        localObject2 = new Bundle(paramF.d());
      } else {
        localObject2 = new Bundle();
      }
      ((BaseBundle)localObject2).putBoolean("android.support.allowGeneratedReplies", paramF.n());
      j = Build.VERSION.SDK_INT;
      if (j >= 24) {
        ((Notification.Action.Builder)localObject1).setAllowGeneratedReplies(paramF.n());
      }
      ((BaseBundle)localObject2).putInt("android.support.action.semanticAction", paramF.a());
      if (j >= 28) {
        ((Notification.Action.Builder)localObject1).setSemanticAction(paramF.a());
      }
      if (j >= 29) {
        ((Notification.Action.Builder)localObject1).setContextual(paramF.q());
      }
      if (j >= 31) {
        ((Notification.Action.Builder)localObject1).setAuthenticationRequired(paramF.i());
      }
      ((BaseBundle)localObject2).putBoolean("android.support.action.showsUserInterface", paramF.b());
      ((Notification.Action.Builder)localObject1).addExtras((Bundle)localObject2);
      b.addAction(((Notification.Action.Builder)localObject1).build());
      return;
    }
    if (j >= 16) {
      x.add(NotificationCompatJellybean.a(b, paramF));
    }
  }
  
  private void add(Notification paramNotification)
  {
    sound = null;
    vibrate = null;
    int j = defaults & 0xFFFFFFFE;
    defaults = j;
    defaults = (j & 0xFFFFFFFD);
  }
  
  private static List get(List paramList1, List paramList2)
  {
    if (paramList1 == null) {
      return paramList2;
    }
    if (paramList2 == null) {
      return paramList1;
    }
    TLongArrayList localTLongArrayList = new TLongArrayList(paramList1.size() + paramList2.size());
    localTLongArrayList.addAll(paramList1);
    localTLongArrayList.addAll(paramList2);
    return new ArrayList(localTLongArrayList);
  }
  
  Context add()
  {
    return i;
  }
  
  protected Notification build()
  {
    int j = Build.VERSION.SDK_INT;
    if (j >= 26) {
      return b.build();
    }
    Notification localNotification;
    Object localObject2;
    Object localObject1;
    if (j >= 24)
    {
      localNotification = b.build();
      j = h;
      localObject2 = this;
      localObject1 = localNotification;
      if (j != 0)
      {
        if ((localNotification.getGroup() != null) && ((flags & 0x200) != 0) && (h == 2)) {
          ((i)localObject2).add(localNotification);
        }
        localObject2 = this;
        localObject1 = localNotification;
        if (localNotification.getGroup() != null)
        {
          localObject1 = localNotification;
          if ((flags & 0x200) == 0)
          {
            localObject1 = localNotification;
            if (h == 1)
            {
              ((i)localObject2).add(localNotification);
              return localNotification;
            }
          }
        }
      }
    }
    else if (j >= 21)
    {
      b.setExtras(c);
      localNotification = b.build();
      localObject1 = l;
      if (localObject1 != null) {
        contentView = ((RemoteViews)localObject1);
      }
      localObject1 = m;
      if (localObject1 != null) {
        bigContentView = ((RemoteViews)localObject1);
      }
      localObject1 = g;
      if (localObject1 != null) {
        headsUpContentView = ((RemoteViews)localObject1);
      }
      j = h;
      localObject2 = this;
      localObject1 = localNotification;
      if (j != 0)
      {
        if ((localNotification.getGroup() != null) && ((flags & 0x200) != 0) && (h == 2)) {
          ((i)localObject2).add(localNotification);
        }
        localObject2 = this;
        localObject1 = localNotification;
        if (localNotification.getGroup() != null)
        {
          localObject1 = localNotification;
          if ((flags & 0x200) == 0)
          {
            localObject1 = localNotification;
            if (h == 1)
            {
              ((i)localObject2).add(localNotification);
              return localNotification;
            }
          }
        }
      }
    }
    else if (j >= 20)
    {
      b.setExtras(c);
      localNotification = b.build();
      localObject1 = l;
      if (localObject1 != null) {
        contentView = ((RemoteViews)localObject1);
      }
      localObject1 = m;
      if (localObject1 != null) {
        bigContentView = ((RemoteViews)localObject1);
      }
      j = h;
      localObject2 = this;
      localObject1 = localNotification;
      if (j != 0)
      {
        if ((localNotification.getGroup() != null) && ((flags & 0x200) != 0) && (h == 2)) {
          ((i)localObject2).add(localNotification);
        }
        localObject2 = this;
        localObject1 = localNotification;
        if (localNotification.getGroup() != null)
        {
          localObject1 = localNotification;
          if ((flags & 0x200) == 0)
          {
            localObject1 = localNotification;
            if (h == 1)
            {
              ((i)localObject2).add(localNotification);
              return localNotification;
            }
          }
        }
      }
    }
    else if (j >= 19)
    {
      localObject1 = NotificationCompatJellybean.buildActionExtrasMap(x);
      if (localObject1 != null) {
        c.putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject1);
      }
      b.setExtras(c);
      localNotification = b.build();
      localObject1 = l;
      if (localObject1 != null) {
        contentView = ((RemoteViews)localObject1);
      }
      localObject2 = m;
      localObject1 = localNotification;
      if (localObject2 != null)
      {
        bigContentView = ((RemoteViews)localObject2);
        return localNotification;
      }
    }
    else if (j >= 16)
    {
      localNotification = b.build();
      localObject1 = NotificationCompat.getExtras(localNotification);
      localObject2 = new Bundle(c);
      Iterator localIterator = c.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (((BaseBundle)localObject1).containsKey(str)) {
          ((BaseBundle)localObject2).remove(str);
        }
      }
      ((Bundle)localObject1).putAll((Bundle)localObject2);
      localObject1 = NotificationCompatJellybean.buildActionExtrasMap(x);
      if (localObject1 != null) {
        NotificationCompat.getExtras(localNotification).putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject1);
      }
      localObject1 = l;
      if (localObject1 != null) {
        contentView = ((RemoteViews)localObject1);
      }
      localObject2 = m;
      localObject1 = localNotification;
      if (localObject2 != null)
      {
        bigContentView = ((RemoteViews)localObject2);
        return localNotification;
      }
    }
    else
    {
      localObject1 = b.getNotification();
    }
    return localObject1;
  }
  
  public Notification get()
  {
    ByteVector localByteVector = a.A;
    if (localByteVector != null) {
      localByteVector.apply(this);
    }
    Object localObject;
    if (localByteVector != null) {
      localObject = localByteVector.makeContentView(this);
    } else {
      localObject = null;
    }
    Notification localNotification = build();
    if (localObject != null)
    {
      contentView = ((RemoteViews)localObject);
    }
    else
    {
      localObject = a.v;
      if (localObject != null) {
        contentView = ((RemoteViews)localObject);
      }
    }
    int j = Build.VERSION.SDK_INT;
    if ((j >= 16) && (localByteVector != null))
    {
      localObject = localByteVector.makeBigContentView(this);
      if (localObject != null) {
        bigContentView = ((RemoteViews)localObject);
      }
    }
    if ((j >= 21) && (localByteVector != null))
    {
      localObject = a.A.makeHeadsUpContentView(this);
      if (localObject != null) {
        headsUpContentView = ((RemoteViews)localObject);
      }
    }
    if ((j >= 16) && (localByteVector != null))
    {
      localObject = NotificationCompat.getExtras(localNotification);
      if (localObject != null) {
        localByteVector.addCompatExtras((Bundle)localObject);
      }
    }
    return localNotification;
  }
  
  public Notification.Builder getValue()
  {
    return b;
  }
}
