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
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;

@Deprecated
public abstract interface SessionsApi
{
  public abstract PendingResult insertSession(GoogleApiClient paramGoogleApiClient, SessionInsertRequest paramSessionInsertRequest);
  
  public abstract PendingResult readSession(GoogleApiClient paramGoogleApiClient, SessionReadRequest paramSessionReadRequest);
  
  public abstract PendingResult registerForSessions(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent);
  
  public abstract PendingResult startSession(GoogleApiClient paramGoogleApiClient, Session paramSession);
  
  public abstract PendingResult stopSession(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract PendingResult unregisterForSessions(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent);
  
  public static class ViewIntentBuilder
  {
    private final Context zzko;
    private String zzkt;
    private Session zzky;
    private boolean zzkz = false;
    
    public ViewIntentBuilder(Context paramContext)
    {
      zzko = paramContext;
    }
    
    public Intent build()
    {
      boolean bool;
      if (zzky != null) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkState(bool, "Session must be set");
      Intent localIntent1 = new Intent("vnd.google.fitness.VIEW");
      localIntent1.setType(Session.getMimeType(zzky.getActivity()));
      SafeParcelableSerializer.serializeToIntentExtra(zzky, localIntent1, "vnd.google.fitness.session");
      if (!zzkz) {
        zzkt = zzky.getAppPackageName();
      }
      String str = zzkt;
      if (str != null)
      {
        Intent localIntent2 = new Intent(localIntent1).setPackage(str);
        ResolveInfo localResolveInfo = zzko.getPackageManager().resolveActivity(localIntent2, 0);
        if (localResolveInfo != null)
        {
          localIntent2.setComponent(new ComponentName(str, activityInfo.name));
          return localIntent2;
        }
      }
      return localIntent1;
    }
    
    public ViewIntentBuilder setPreferredApplication(String paramString)
    {
      zzkt = paramString;
      zzkz = true;
      return this;
    }
    
    public ViewIntentBuilder setSession(Session paramSession)
    {
      zzky = paramSession;
      return this;
    }
  }
}
