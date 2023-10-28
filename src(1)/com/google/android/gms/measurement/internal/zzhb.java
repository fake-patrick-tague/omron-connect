package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.BaseBundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzcl;

@VisibleForTesting
public final class zzhb
{
  final Context context;
  boolean data = true;
  String date;
  long id;
  String limit;
  final Long mDate;
  String offset;
  String queue;
  zzcl this$0;
  Boolean version;
  
  public zzhb(Context paramContext, zzcl paramZzcl, Long paramLong)
  {
    Preconditions.checkNotNull(paramContext);
    paramContext = paramContext.getApplicationContext();
    Preconditions.checkNotNull(paramContext);
    context = paramContext;
    mDate = paramLong;
    if (paramZzcl != null)
    {
      this$0 = paramZzcl;
      queue = value;
      limit = type;
      offset = offset;
      data = data;
      id = id;
      date = date;
      paramContext = this$0;
      if (paramContext != null) {
        version = Boolean.valueOf(paramContext.getBoolean("dataCollectionDefaultEnabled", true));
      }
    }
  }
}
