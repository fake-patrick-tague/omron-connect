package com.google.android.gms.cloudmessaging;

import android.content.Intent;
import android.os.BaseBundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import v7.util.ArrayMap;
import v7.util.SimpleArrayMap;

@SafeParcelable.Class(creator="CloudMessageCreator")
public final class CloudMessage
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<CloudMessage> CREATOR = new Server.1();
  public static final int PRIORITY_HIGH = 1;
  public static final int PRIORITY_NORMAL = 2;
  public static final int PRIORITY_UNKNOWN = 0;
  private Map<String, String> data;
  @SafeParcelable.Field(id=1)
  Intent intent;
  
  public CloudMessage(Intent paramIntent)
  {
    intent = paramIntent;
  }
  
  private static int set(String paramString)
  {
    if ("high".equals(paramString)) {
      return 1;
    }
    if ("normal".equals(paramString)) {
      return 2;
    }
    return 0;
  }
  
  public String getCollapseKey()
  {
    return intent.getStringExtra("collapse_key");
  }
  
  public Map getData()
  {
    try
    {
      if (data == null)
      {
        localObject1 = intent.getExtras();
        ArrayMap localArrayMap = new ArrayMap();
        if (localObject1 != null)
        {
          Iterator localIterator = ((BaseBundle)localObject1).keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            Object localObject2 = ((BaseBundle)localObject1).get(str);
            if ((localObject2 instanceof String))
            {
              localObject2 = (String)localObject2;
              if ((!str.startsWith("google.")) && (!str.equals("from")) && (!str.equals("message_type")) && (!str.equals("collapse_key"))) {
                localArrayMap.put(str, localObject2);
              }
            }
          }
        }
        data = localArrayMap;
      }
      Object localObject1 = data;
      return localObject1;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public String getFrom()
  {
    return intent.getStringExtra("from");
  }
  
  public Intent getIntent()
  {
    return intent;
  }
  
  public String getMessageId()
  {
    String str2 = intent.getStringExtra("google.message_id");
    String str1 = str2;
    if (str2 == null) {
      str1 = intent.getStringExtra("message_id");
    }
    return str1;
  }
  
  public String getMessageType()
  {
    return intent.getStringExtra("message_type");
  }
  
  public int getOriginalPriority()
  {
    String str2 = intent.getStringExtra("google.original_priority");
    String str1 = str2;
    if (str2 == null) {
      str1 = intent.getStringExtra("google.priority");
    }
    return set(str1);
  }
  
  public int getPriority()
  {
    String str2 = intent.getStringExtra("google.delivered_priority");
    String str1 = str2;
    if (str2 == null)
    {
      if ("1".equals(intent.getStringExtra("google.priority_reduced"))) {
        return 2;
      }
      str1 = intent.getStringExtra("google.priority");
    }
    return set(str1);
  }
  
  public byte[] getRawData()
  {
    return intent.getByteArrayExtra("rawData");
  }
  
  public String getSenderId()
  {
    return intent.getStringExtra("google.c.sender.id");
  }
  
  public long getSentTime()
  {
    Object localObject1 = intent.getExtras();
    if (localObject1 != null) {
      localObject1 = ((BaseBundle)localObject1).get("google.sent_time");
    } else {
      localObject1 = null;
    }
    if ((localObject1 instanceof Long)) {
      return ((Long)localObject1).longValue();
    }
    if ((localObject1 instanceof String)) {
      localObject2 = (String)localObject1;
    }
    try
    {
      long l = Long.parseLong((String)localObject2);
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;) {}
    }
    localObject1 = String.valueOf(localObject1);
    Object localObject2 = new StringBuilder(((String)localObject1).length() + 19);
    ((StringBuilder)localObject2).append("Invalid sent time: ");
    ((StringBuilder)localObject2).append((String)localObject1);
    Log.w("CloudMessage", ((StringBuilder)localObject2).toString());
    return 0L;
  }
  
  public String getTo()
  {
    return intent.getStringExtra("google.to");
  }
  
  public int getTtl()
  {
    Object localObject1 = intent.getExtras();
    if (localObject1 != null) {
      localObject1 = ((BaseBundle)localObject1).get("google.ttl");
    } else {
      localObject1 = null;
    }
    if ((localObject1 instanceof Integer)) {
      return ((Integer)localObject1).intValue();
    }
    if ((localObject1 instanceof String)) {
      localObject2 = (String)localObject1;
    }
    try
    {
      int i = Integer.parseInt((String)localObject2);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;) {}
    }
    localObject1 = String.valueOf(localObject1);
    Object localObject2 = new StringBuilder(((String)localObject1).length() + 13);
    ((StringBuilder)localObject2).append("Invalid TTL: ");
    ((StringBuilder)localObject2).append((String)localObject1);
    Log.w("CloudMessage", ((StringBuilder)localObject2).toString());
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, intent, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @Target({java.lang.annotation.ElementType.TYPE_PARAMETER, java.lang.annotation.ElementType.TYPE_USE})
  public static @interface MessagePriority {}
}
