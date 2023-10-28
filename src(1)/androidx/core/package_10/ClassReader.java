package androidx.core.package_10;

import android.app.Notification.Builder;
import android.app.Notification.DecoratedCustomViewStyle;
import android.app.Notification.Style;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import v7.v7.R.id;
import v7.v7.TypePath;

public class ClassReader
  extends ByteVector
{
  public ClassReader() {}
  
  private RemoteViews a(RemoteViews paramRemoteViews, boolean paramBoolean)
  {
    int i = v7.v7.ClassReader.d;
    int m = 1;
    int k = 0;
    RemoteViews localRemoteViews1 = applyStandardTemplate(true, i, false);
    localRemoteViews1.removeAllViews(R.id.c);
    List localList = a(mBuilder.m);
    if ((paramBoolean) && (localList != null))
    {
      int n = Math.min(localList.size(), 3);
      if (n > 0)
      {
        i = 0;
        for (;;)
        {
          j = m;
          if (i >= n) {
            break;
          }
          RemoteViews localRemoteViews2 = a((f)localList.get(i));
          localRemoteViews1.addView(R.id.c, localRemoteViews2);
          i += 1;
        }
      }
    }
    int j = 0;
    if (j != 0) {
      i = k;
    } else {
      i = 8;
    }
    localRemoteViews1.setViewVisibility(R.id.c, i);
    localRemoteViews1.setViewVisibility(R.id.i, i);
    buildIntoRemoteViews(localRemoteViews1, paramRemoteViews);
    return localRemoteViews1;
  }
  
  private RemoteViews a(f paramF)
  {
    int i;
    if (v == null) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject = mBuilder.mContext.getPackageName();
    int j;
    if (i != 0) {
      j = v7.v7.ClassReader.a;
    } else {
      j = v7.v7.ClassReader.c;
    }
    localObject = new RemoteViews((String)localObject, j);
    IconCompat localIconCompat = paramF.c();
    if (localIconCompat != null) {
      ((RemoteViews)localObject).setImageViewBitmap(R.id.listView, createColoredBitmap(localIconCompat, mBuilder.mContext.getResources().getColor(TypePath.b)));
    }
    ((RemoteViews)localObject).setTextViewText(R.id.E, title);
    if (i == 0) {
      ((RemoteViews)localObject).setOnClickPendingIntent(R.id.a, v);
    }
    if (Build.VERSION.SDK_INT >= 15) {
      ((RemoteViews)localObject).setContentDescription(R.id.a, title);
    }
    return localObject;
  }
  
  private static List a(List paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      f localF = (f)paramList.next();
      if (!localF.q()) {
        localArrayList.add(localF);
      }
    }
    return localArrayList;
  }
  
  public void apply(Duration paramDuration)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      paramDuration.getValue().setStyle((Notification.Style)new Notification.DecoratedCustomViewStyle());
    }
  }
  
  protected String getClassName()
  {
    return "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";
  }
  
  public RemoteViews makeBigContentView(Duration paramDuration)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return null;
    }
    RemoteViews localRemoteViews = mBuilder.visitAttribute();
    paramDuration = localRemoteViews;
    if (localRemoteViews == null) {
      paramDuration = mBuilder.visitAnnotation();
    }
    if (paramDuration == null) {
      return null;
    }
    return a(paramDuration, true);
  }
  
  public RemoteViews makeContentView(Duration paramDuration)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return null;
    }
    if (mBuilder.visitAnnotation() == null) {
      return null;
    }
    return a(mBuilder.visitAnnotation(), false);
  }
  
  public RemoteViews makeHeadsUpContentView(Duration paramDuration)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return null;
    }
    RemoteViews localRemoteViews = mBuilder.b();
    if (localRemoteViews != null) {
      paramDuration = localRemoteViews;
    } else {
      paramDuration = mBuilder.visitAnnotation();
    }
    if (localRemoteViews == null) {
      return null;
    }
    return a(paramDuration, true);
  }
}
