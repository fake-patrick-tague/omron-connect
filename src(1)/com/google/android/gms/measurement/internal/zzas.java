package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

final class zzas
{
  final String code;
  final long date;
  final Long height;
  final long index;
  final Long left;
  final String length;
  final long name;
  final long nodeId;
  final Boolean top;
  final long type;
  final Long width;
  
  zzas(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, Long paramLong6, Long paramLong7, Long paramLong8, Boolean paramBoolean)
  {
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty(paramString2);
    boolean bool2 = true;
    boolean bool1;
    if (paramLong1 >= 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    if (paramLong2 >= 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    if (paramLong3 >= 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    if (paramLong5 >= 0L) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    code = paramString1;
    length = paramString2;
    type = paramLong1;
    nodeId = paramLong2;
    name = paramLong3;
    index = paramLong4;
    date = paramLong5;
    left = paramLong6;
    width = paramLong7;
    height = paramLong8;
    top = paramBoolean;
  }
  
  final zzas toString(long paramLong)
  {
    return new zzas(code, length, type, nodeId, name, paramLong, date, left, width, height, top);
  }
  
  final zzas toString(long paramLong1, long paramLong2)
  {
    return new zzas(code, length, type, nodeId, name, index, paramLong1, Long.valueOf(paramLong2), width, height, top);
  }
  
  final zzas write(Long paramLong1, Long paramLong2, Boolean paramBoolean)
  {
    Boolean localBoolean = paramBoolean;
    if (paramBoolean != null)
    {
      localBoolean = paramBoolean;
      if (!paramBoolean.booleanValue()) {
        localBoolean = null;
      }
    }
    return new zzas(code, length, type, nodeId, name, index, date, left, paramLong1, paramLong2, localBoolean);
  }
}
