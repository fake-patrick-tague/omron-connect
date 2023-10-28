package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

final class zzle
{
  final Object data;
  final String header;
  final long offset;
  final String size;
  final String type;
  
  zzle(String paramString1, String paramString2, String paramString3, long paramLong, Object paramObject)
  {
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty(paramString3);
    Preconditions.checkNotNull(paramObject);
    header = paramString1;
    type = paramString2;
    size = paramString3;
    offset = paramLong;
    data = paramObject;
  }
}
