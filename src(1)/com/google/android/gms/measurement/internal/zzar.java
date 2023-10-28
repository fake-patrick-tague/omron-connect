package com.google.android.gms.measurement.internal;

import android.os.BaseBundle;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.Set;

public final class zzar
{
  final long count;
  final String id;
  final String name;
  final zzau path;
  final long progress;
  final String text;
  
  zzar(zzfy paramZzfy, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, Bundle paramBundle)
  {
    Preconditions.checkNotEmpty(paramString2);
    Preconditions.checkNotEmpty(paramString3);
    name = paramString2;
    id = paramString3;
    paramString3 = paramString1;
    if (true == TextUtils.isEmpty(paramString1)) {
      paramString3 = null;
    }
    text = paramString3;
    count = paramLong1;
    progress = paramLong2;
    if ((paramLong2 != 0L) && (paramLong2 > paramLong1)) {
      paramZzfy.zzay().hasNext().append("Event created with reverse previous/current timestamps. appId", zzeo.get(paramString2));
    }
    if ((paramBundle != null) && (!paramBundle.isEmpty()))
    {
      paramString1 = new Bundle(paramBundle);
      paramString2 = paramString1.keySet().iterator();
      while (paramString2.hasNext())
      {
        paramString3 = (String)paramString2.next();
        if (paramString3 == null)
        {
          paramZzfy.zzay().iterator().append("Param name can't be null");
          paramString2.remove();
        }
        else
        {
          paramBundle = paramZzfy.get().execute(paramString3, paramString1.get(paramString3));
          if (paramBundle == null)
          {
            paramZzfy.zzay().hasNext().append("Param value can't be null", paramZzfy.next().next(paramString3));
            paramString2.remove();
          }
          else
          {
            paramZzfy.get().add(paramString1, paramString3, paramBundle);
          }
        }
      }
      paramZzfy = new zzau(paramString1);
    }
    else
    {
      paramZzfy = new zzau(new Bundle());
    }
    path = paramZzfy;
  }
  
  private zzar(zzfy paramZzfy, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, zzau paramZzau)
  {
    Preconditions.checkNotEmpty(paramString2);
    Preconditions.checkNotEmpty(paramString3);
    Preconditions.checkNotNull(paramZzau);
    name = paramString2;
    id = paramString3;
    String str = paramString1;
    if (true == TextUtils.isEmpty(paramString1)) {
      str = null;
    }
    text = str;
    count = paramLong1;
    progress = paramLong2;
    if ((paramLong2 != 0L) && (paramLong2 > paramLong1)) {
      paramZzfy.zzay().hasNext().append("Event created with reverse previous/current timestamps. appId, name", zzeo.get(paramString2), zzeo.get(paramString3));
    }
    path = paramZzau;
  }
  
  public final String toString()
  {
    String str1 = name;
    String str2 = id;
    String str3 = path.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Event{appId='");
    localStringBuilder.append(str1);
    localStringBuilder.append("', name='");
    localStringBuilder.append(str2);
    localStringBuilder.append("', params=");
    localStringBuilder.append(str3);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  final zzar update(zzfy paramZzfy, long paramLong)
  {
    return new zzar(paramZzfy, text, name, id, count, paramLong, path);
  }
}
