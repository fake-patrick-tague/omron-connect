package com.braze.enums;

import com.braze.models.IPutIntoJson;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.a0;
import kotlin.x.d.i;
import kotlin.z.d;

public enum NotificationSubscriptionType
  implements IPutIntoJson<String>
{
  public static final Companion Companion;
  private static final Map<String, NotificationSubscriptionType> pluginMap;
  private final String key;
  
  static
  {
    int i = 0;
    OPTED_IN = new NotificationSubscriptionType("OPTED_IN", 0, "opted_in");
    SUBSCRIBED = new NotificationSubscriptionType("SUBSCRIBED", 1, "subscribed");
    UNSUBSCRIBED = new NotificationSubscriptionType("UNSUBSCRIBED", 2, "unsubscribed");
    $VALUES = $values();
    Companion = new Companion(null);
    NotificationSubscriptionType[] arrayOfNotificationSubscriptionType = values();
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(d.a(a0.a(arrayOfNotificationSubscriptionType.length), 16));
    int j = arrayOfNotificationSubscriptionType.length;
    while (i < j)
    {
      NotificationSubscriptionType localNotificationSubscriptionType = arrayOfNotificationSubscriptionType[i];
      i += 1;
      localLinkedHashMap.put(key, localNotificationSubscriptionType);
    }
    pluginMap = localLinkedHashMap;
  }
  
  private NotificationSubscriptionType(String paramString)
  {
    key = paramString;
  }
  
  public String forJsonPut()
  {
    return key;
  }
  
  public static final class Companion
  {
    private Companion() {}
    
    public final NotificationSubscriptionType fromValue(String paramString)
    {
      Map localMap = NotificationSubscriptionType.access$getMap$cp();
      Object localObject2 = null;
      if (paramString != null)
      {
        localObject1 = Locale.US;
        i.d(localObject1, "US");
        localObject1 = paramString.toLowerCase((Locale)localObject1);
        paramString = (String)localObject1;
        i.d(localObject1, "this as java.lang.String).toLowerCase(locale)");
      }
      else
      {
        paramString = null;
      }
      Object localObject1 = paramString;
      if (paramString == null) {
        localObject1 = "";
      }
      paramString = localMap.get(localObject1);
      if (paramString == null) {
        paramString = localObject2;
      }
      return (NotificationSubscriptionType)paramString;
    }
  }
}
