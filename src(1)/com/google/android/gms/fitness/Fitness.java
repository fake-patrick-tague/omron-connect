package com.google.android.gms.fitness;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.auth.util.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.package_12.Scope;
import java.util.concurrent.TimeUnit;

public class Fitness
{
  @RecentlyNonNull
  public static final String ACTION_TRACK = "vnd.google.fitness.TRACK";
  @RecentlyNonNull
  public static final String ACTION_VIEW = "vnd.google.fitness.VIEW";
  @RecentlyNonNull
  public static final String ACTION_VIEW_GOAL = "vnd.google.fitness.VIEW_GOAL";
  @Deprecated
  @RecentlyNonNull
  public static final Api<Api.ApiOptions.NoOptions> BLE_API;
  @Deprecated
  @RecentlyNonNull
  public static final BleApi BleApi;
  @Deprecated
  @RecentlyNonNull
  public static final Api<Api.ApiOptions.NoOptions> CONFIG_API;
  @Deprecated
  @RecentlyNonNull
  public static final ConfigApi ConfigApi;
  @RecentlyNonNull
  public static final String EXTRA_END_TIME = "vnd.google.fitness.end_time";
  @RecentlyNonNull
  public static final String EXTRA_START_TIME = "vnd.google.fitness.start_time";
  @Deprecated
  @RecentlyNonNull
  public static final Api<Api.ApiOptions.NoOptions> GOALS_API;
  @Deprecated
  @RecentlyNonNull
  public static final GoalsApi GoalsApi;
  @Deprecated
  @RecentlyNonNull
  public static final Api<Api.ApiOptions.NoOptions> HISTORY_API;
  @Deprecated
  @RecentlyNonNull
  public static final HistoryApi HistoryApi;
  @Deprecated
  @RecentlyNonNull
  public static final Api<Api.ApiOptions.NoOptions> RECORDING_API;
  @Deprecated
  @RecentlyNonNull
  public static final RecordingApi RecordingApi;
  @RecentlyNonNull
  public static final Scope SCOPE_ACTIVITY_READ;
  @RecentlyNonNull
  public static final Scope SCOPE_ACTIVITY_READ_WRITE;
  @RecentlyNonNull
  public static final Scope SCOPE_BODY_READ;
  @RecentlyNonNull
  public static final Scope SCOPE_BODY_READ_WRITE;
  @RecentlyNonNull
  public static final Scope SCOPE_LOCATION_READ;
  @RecentlyNonNull
  public static final Scope SCOPE_LOCATION_READ_WRITE;
  @RecentlyNonNull
  public static final Scope SCOPE_NUTRITION_READ;
  @RecentlyNonNull
  public static final Scope SCOPE_NUTRITION_READ_WRITE;
  @Deprecated
  @RecentlyNonNull
  public static final Api<Api.ApiOptions.NoOptions> SENSORS_API;
  @Deprecated
  @RecentlyNonNull
  public static final Api<Api.ApiOptions.NoOptions> SESSIONS_API;
  @Deprecated
  @RecentlyNonNull
  public static final SensorsApi SensorsApi;
  @Deprecated
  @RecentlyNonNull
  public static final SessionsApi SessionsApi;
  @Deprecated
  @RecentlyNonNull
  public static final Void task;
  @ShowFirstParty
  private static final Scope zzkf;
  @ShowFirstParty
  private static final Scope zzkg;
  @ShowFirstParty
  private static final Scope zzkh;
  @ShowFirstParty
  private static final Scope zzki;
  @ShowFirstParty
  private static final Scope zzkj;
  @ShowFirstParty
  private static final Scope zzkk;
  
  static
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a1 = a0\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  private Fitness() {}
  
  public static BleClient getBleClient(Activity paramActivity, GoogleSignInAccount paramGoogleSignInAccount)
  {
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    return new BleClient(paramActivity, new DBObject(paramActivity, paramGoogleSignInAccount));
  }
  
  public static BleClient getBleClient(Context paramContext, GoogleSignInAccount paramGoogleSignInAccount)
  {
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    return new BleClient(paramContext, new DBObject(paramContext, paramGoogleSignInAccount));
  }
  
  public static ConfigClient getConfigClient(Activity paramActivity, GoogleSignInAccount paramGoogleSignInAccount)
  {
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    return new ConfigClient(paramActivity, new DBObject(paramActivity, paramGoogleSignInAccount));
  }
  
  public static ConfigClient getConfigClient(Context paramContext, GoogleSignInAccount paramGoogleSignInAccount)
  {
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    return new ConfigClient(paramContext, new DBObject(paramContext, paramGoogleSignInAccount));
  }
  
  public static long getEndTime(Intent paramIntent, TimeUnit paramTimeUnit)
  {
    long l = paramIntent.getLongExtra("vnd.google.fitness.end_time", -1L);
    if (l == -1L) {
      return -1L;
    }
    return paramTimeUnit.convert(l, TimeUnit.MILLISECONDS);
  }
  
  public static GoalsClient getGoalsClient(Activity paramActivity, GoogleSignInAccount paramGoogleSignInAccount)
  {
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    return new GoalsClient(paramActivity, new DBObject(paramActivity, paramGoogleSignInAccount));
  }
  
  public static GoalsClient getGoalsClient(Context paramContext, GoogleSignInAccount paramGoogleSignInAccount)
  {
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    return new GoalsClient(paramContext, new DBObject(paramContext, paramGoogleSignInAccount));
  }
  
  public static HistoryClient getHistoryClient(Activity paramActivity, GoogleSignInAccount paramGoogleSignInAccount)
  {
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    return new HistoryClient(paramActivity, new DBObject(paramActivity, paramGoogleSignInAccount));
  }
  
  public static HistoryClient getHistoryClient(Context paramContext, GoogleSignInAccount paramGoogleSignInAccount)
  {
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    return new HistoryClient(paramContext, new DBObject(paramContext, paramGoogleSignInAccount));
  }
  
  public static RecordingClient getRecordingClient(Activity paramActivity, GoogleSignInAccount paramGoogleSignInAccount)
  {
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    return new RecordingClient(paramActivity, new DBObject(paramActivity, paramGoogleSignInAccount));
  }
  
  public static RecordingClient getRecordingClient(Context paramContext, GoogleSignInAccount paramGoogleSignInAccount)
  {
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    return new RecordingClient(paramContext, new DBObject(paramContext, paramGoogleSignInAccount));
  }
  
  public static SensorsClient getSensorsClient(Activity paramActivity, GoogleSignInAccount paramGoogleSignInAccount)
  {
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    return new SensorsClient(paramActivity, new DBObject(paramActivity, paramGoogleSignInAccount));
  }
  
  public static SensorsClient getSensorsClient(Context paramContext, GoogleSignInAccount paramGoogleSignInAccount)
  {
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    return new SensorsClient(paramContext, new DBObject(paramContext, paramGoogleSignInAccount));
  }
  
  public static SessionsClient getSessionsClient(Activity paramActivity, GoogleSignInAccount paramGoogleSignInAccount)
  {
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    return new SessionsClient(paramActivity, new DBObject(paramActivity, paramGoogleSignInAccount));
  }
  
  public static SessionsClient getSessionsClient(Context paramContext, GoogleSignInAccount paramGoogleSignInAccount)
  {
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    return new SessionsClient(paramContext, new DBObject(paramContext, paramGoogleSignInAccount));
  }
  
  public static long getStartTime(Intent paramIntent, TimeUnit paramTimeUnit)
  {
    long l = paramIntent.getLongExtra("vnd.google.fitness.start_time", -1L);
    if (l == -1L) {
      return -1L;
    }
    return paramTimeUnit.convert(l, TimeUnit.MILLISECONDS);
  }
}
