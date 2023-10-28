package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.BaseBundle;
import android.os.Build.VERSION;
import android.os.PersistableBundle;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzbs;
import com.google.android.gms.internal.measurement.zzbt;

public final class zzkl
  extends zzkn
{
  private final AlarmManager alarmManager = (AlarmManager)this$0.zzau().getSystemService("alarm");
  private Integer id;
  private zzap mDelegate;
  
  protected zzkl(zzkz paramZzkz)
  {
    super(paramZzkz);
  }
  
  private final PendingIntent getAlarmIntent()
  {
    Context localContext = this$0.zzau();
    return PendingIntent.getBroadcast(localContext, 0, new Intent().setClassName(localContext, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), zzbs.id);
  }
  
  private final zzap getDelegate()
  {
    if (mDelegate == null) {
      mDelegate = new zzkk(this, this$0.context());
    }
    return mDelegate;
  }
  
  private final int getId()
  {
    if (id == null) {
      id = Integer.valueOf("measurement".concat(String.valueOf(this$0.zzau().getPackageName())).hashCode());
    }
    return id.intValue();
  }
  
  private final void updateImage()
  {
    JobScheduler localJobScheduler = (JobScheduler)this$0.zzau().getSystemService("jobscheduler");
    if (localJobScheduler != null) {
      localJobScheduler.cancel(getId());
    }
  }
  
  protected final boolean registerAlarm()
  {
    AlarmManager localAlarmManager = alarmManager;
    if (localAlarmManager != null) {
      localAlarmManager.cancel(getAlarmIntent());
    }
    if (Build.VERSION.SDK_INT >= 24) {
      updateImage();
    }
    return false;
  }
  
  public final void update()
  {
    size();
    this$0.zzay().next().append("Unscheduling upload");
    AlarmManager localAlarmManager = alarmManager;
    if (localAlarmManager != null) {
      localAlarmManager.cancel(getAlarmIntent());
    }
    getDelegate().close();
    if (Build.VERSION.SDK_INT >= 24) {
      updateImage();
    }
  }
  
  public final void update(long paramLong)
  {
    size();
    this$0.zzaw();
    Object localObject = this$0.zzau();
    if (!zzlh.zzaj((Context)localObject)) {
      this$0.zzay().e().append("Receiver not registered/enabled");
    }
    if (!zzlh.zzak((Context)localObject, false)) {
      this$0.zzay().e().append("Service not registered/enabled");
    }
    update();
    this$0.zzay().next().append("Scheduling upload, millis", Long.valueOf(paramLong));
    long l = this$0.zzav().elapsedRealtime();
    this$0.append();
    if ((paramLong < Math.max(0L, ((Long)zzeb.pool.get(null)).longValue())) && (!getDelegate().equals())) {
      getDelegate().close(paramLong);
    }
    this$0.zzaw();
    if (Build.VERSION.SDK_INT >= 24)
    {
      localObject = this$0.zzau();
      ComponentName localComponentName = new ComponentName((Context)localObject, "com.google.android.gms.measurement.AppMeasurementJobService");
      int i = getId();
      PersistableBundle localPersistableBundle = new PersistableBundle();
      localPersistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
      zzbt.get((Context)localObject, new JobInfo.Builder(i, localComponentName).setMinimumLatency(paramLong).setOverrideDeadline(paramLong + paramLong).setExtras(localPersistableBundle).build(), "com.google.android.gms", "UploadAlarm");
      return;
    }
    localObject = alarmManager;
    if (localObject != null)
    {
      this$0.append();
      ((AlarmManager)localObject).setInexactRepeating(2, l + paramLong, Math.max(((Long)zzeb.items.get(null)).longValue(), paramLong), getAlarmIntent());
    }
  }
}
