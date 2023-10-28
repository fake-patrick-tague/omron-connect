package androidx.core.package_10;

import android.app.Notification;
import android.app.Notification.Builder;
import android.os.BaseBundle;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class NotificationCompatJellybean
{
  private static final Object sActionsLock = new Object();
  private static Field sExtrasField;
  private static boolean sExtrasFieldAccessFailed;
  private static final Object sExtrasLock = new Object();
  
  public static Bundle a(Notification.Builder paramBuilder, f paramF)
  {
    IconCompat localIconCompat = paramF.c();
    int i;
    if (localIconCompat != null) {
      i = localIconCompat.a();
    } else {
      i = 0;
    }
    paramBuilder.addAction(i, paramF.getTitle(), paramF.p());
    paramBuilder = new Bundle(paramF.d());
    if (paramF.e() != null) {
      paramBuilder.putParcelableArray("android.support.remoteInputs", from(paramF.e()));
    }
    if (paramF.f() != null) {
      paramBuilder.putParcelableArray("android.support.dataRemoteInputs", from(paramF.f()));
    }
    paramBuilder.putBoolean("android.support.allowGeneratedReplies", paramF.n());
    return paramBuilder;
  }
  
  static Bundle a(f paramF)
  {
    Bundle localBundle = new Bundle();
    Object localObject = paramF.c();
    int i;
    if (localObject != null) {
      i = ((IconCompat)localObject).a();
    } else {
      i = 0;
    }
    localBundle.putInt("icon", i);
    localBundle.putCharSequence("title", paramF.getTitle());
    localBundle.putParcelable("actionIntent", paramF.p());
    if (paramF.d() != null) {
      localObject = new Bundle(paramF.d());
    } else {
      localObject = new Bundle();
    }
    ((BaseBundle)localObject).putBoolean("android.support.allowGeneratedReplies", paramF.n());
    localBundle.putBundle("extras", (Bundle)localObject);
    localBundle.putParcelableArray("remoteInputs", from(paramF.e()));
    localBundle.putBoolean("showsUserInterface", paramF.b());
    localBundle.putInt("semanticAction", paramF.a());
    return localBundle;
  }
  
  public static SparseArray buildActionExtrasMap(List paramList)
  {
    int j = paramList.size();
    Object localObject1 = null;
    int i = 0;
    while (i < j)
    {
      Bundle localBundle = (Bundle)paramList.get(i);
      Object localObject2 = localObject1;
      if (localBundle != null)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new SparseArray();
        }
        ((SparseArray)localObject2).put(i, localBundle);
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  private static Bundle[] from(RemoteInput[] paramArrayOfRemoteInput)
  {
    if (paramArrayOfRemoteInput == null) {
      return null;
    }
    Bundle[] arrayOfBundle = new Bundle[paramArrayOfRemoteInput.length];
    int i = 0;
    while (i < paramArrayOfRemoteInput.length)
    {
      arrayOfBundle[i] = toBundleArray(paramArrayOfRemoteInput[i]);
      i += 1;
    }
    return arrayOfBundle;
  }
  
  public static Bundle getExtras(Notification paramNotification)
  {
    Object localObject3 = sExtrasLock;
    try
    {
      if (sExtrasFieldAccessFailed) {
        return null;
      }
      if (sExtrasField == null) {}
      try
      {
        Object localObject1 = Notification.class.getDeclaredField("extras");
        boolean bool = Bundle.class.isAssignableFrom(((Field)localObject1).getType());
        if (!bool)
        {
          Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
          sExtrasFieldAccessFailed = true;
          return null;
        }
        ((Field)localObject1).setAccessible(true);
        sExtrasField = (Field)localObject1;
        localObject1 = sExtrasField;
        localObject1 = ((Field)localObject1).get(paramNotification);
        Object localObject2 = (Bundle)localObject1;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new Bundle();
          localObject2 = sExtrasField;
          ((Field)localObject2).set(paramNotification, localObject1);
        }
        return localObject1;
      }
      catch (NoSuchFieldException paramNotification)
      {
        Log.e("NotificationCompat", "Unable to access notification extras", paramNotification);
      }
      catch (IllegalAccessException paramNotification)
      {
        Log.e("NotificationCompat", "Unable to access notification extras", paramNotification);
      }
      sExtrasFieldAccessFailed = true;
      return null;
    }
    catch (Throwable paramNotification)
    {
      throw paramNotification;
    }
  }
  
  private static Bundle toBundleArray(RemoteInput paramRemoteInput)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("resultKey", paramRemoteInput.getResultKey());
    localBundle.putCharSequence("label", paramRemoteInput.getLabel());
    localBundle.putCharSequenceArray("choices", paramRemoteInput.getChoices());
    localBundle.putBoolean("allowFreeFormInput", paramRemoteInput.getAllowFreeFormInput());
    localBundle.putBundle("extras", paramRemoteInput.getExtras());
    Object localObject = paramRemoteInput.getKey();
    if ((localObject != null) && (!((Set)localObject).isEmpty()))
    {
      paramRemoteInput = new ArrayList(((Set)localObject).size());
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramRemoteInput.add((String)((Iterator)localObject).next());
      }
      localBundle.putStringArrayList("allowedDataTypes", paramRemoteInput);
    }
    return localBundle;
  }
}
