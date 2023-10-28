package com.google.android.gms.fitness;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.common.package_12.GoogleApiClient;
import com.google.android.gms.common.package_12.PendingResult;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.DataUpdateListenerRegistrationRequest;
import com.google.android.gms.fitness.request.DataUpdateRequest;
import java.util.concurrent.TimeUnit;

@Deprecated
public abstract interface HistoryApi
{
  public abstract PendingResult deleteData(GoogleApiClient paramGoogleApiClient, DataDeleteRequest paramDataDeleteRequest);
  
  public abstract PendingResult insertData(GoogleApiClient paramGoogleApiClient, DataSet paramDataSet);
  
  public abstract PendingResult readDailyTotal(GoogleApiClient paramGoogleApiClient, DataType paramDataType);
  
  public abstract PendingResult readDailyTotalFromLocalDevice(GoogleApiClient paramGoogleApiClient, DataType paramDataType);
  
  public abstract PendingResult readData(GoogleApiClient paramGoogleApiClient, DataReadRequest paramDataReadRequest);
  
  public abstract PendingResult registerDataUpdateListener(GoogleApiClient paramGoogleApiClient, DataUpdateListenerRegistrationRequest paramDataUpdateListenerRegistrationRequest);
  
  public abstract PendingResult unregisterDataUpdateListener(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent);
  
  public abstract PendingResult updateData(GoogleApiClient paramGoogleApiClient, DataUpdateRequest paramDataUpdateRequest);
  
  public static class ViewIntentBuilder
  {
    private final Context zzko;
    private final DataType zzkp;
    private DataSource zzkq;
    private long zzkr;
    private long zzks;
    private String zzkt;
    
    public ViewIntentBuilder(Context paramContext, DataType paramDataType)
    {
      zzko = paramContext;
      zzkp = paramDataType;
    }
    
    public Intent build()
    {
      long l = zzkr;
      boolean bool2 = true;
      boolean bool1;
      if (l > 0L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      Preconditions.checkState(bool1, "Start time must be set");
      if (zzks > zzkr) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      Preconditions.checkState(bool1, "End time must be set and after start time");
      Object localObject = new Intent("vnd.google.fitness.VIEW");
      ((Intent)localObject).setType(DataType.getMimeType(zzkq.getDataType()));
      ((Intent)localObject).putExtra("vnd.google.fitness.start_time", zzkr);
      ((Intent)localObject).putExtra("vnd.google.fitness.end_time", zzks);
      SafeParcelableSerializer.serializeToIntentExtra(zzkq, (Intent)localObject, "vnd.google.fitness.data_source");
      if (zzkt != null)
      {
        Intent localIntent = new Intent((Intent)localObject).setPackage(zzkt);
        ResolveInfo localResolveInfo = zzko.getPackageManager().resolveActivity(localIntent, 0);
        if (localResolveInfo != null)
        {
          localObject = activityInfo.name;
          localIntent.setComponent(new ComponentName(zzkt, (String)localObject));
          return localIntent;
        }
      }
      return localObject;
    }
    
    public ViewIntentBuilder setDataSource(DataSource paramDataSource)
    {
      Preconditions.checkArgument(paramDataSource.getDataType().equals(zzkp), "Data source %s is not for the data type %s", new Object[] { paramDataSource, zzkp });
      zzkq = paramDataSource;
      return this;
    }
    
    public ViewIntentBuilder setPreferredApplication(String paramString)
    {
      zzkt = paramString;
      return this;
    }
    
    public ViewIntentBuilder setTimeInterval(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
    {
      zzkr = paramTimeUnit.toMillis(paramLong1);
      zzks = paramTimeUnit.toMillis(paramLong2);
      return this;
    }
  }
}
