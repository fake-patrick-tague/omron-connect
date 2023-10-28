package com.braze.support;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import kotlin.x.c.a;
import kotlin.x.d.i;
import kotlin.x.d.j;

public final class PermissionUtils
{
  private static final String STARTED = BrazeLogger.INSTANCE.getBrazeLogTag("PermissionUtils");
  
  public static final int getPermissionRequestCount(Context paramContext, String paramString)
  {
    i.e(paramContext, "context");
    i.e(paramString, "permission");
    return paramContext.getSharedPreferences("com.braze.support.permission_util.requested_perms", 0).getInt(paramString, 0);
  }
  
  public static final boolean hasPermission(Context paramContext, String paramString)
  {
    i.e(paramString, "permission");
    if (paramContext != null) {
      try
      {
        int i = paramContext.checkCallingOrSelfPermission(paramString);
        if (i == 0) {
          return true;
        }
      }
      catch (Throwable paramContext)
      {
        BrazeLogger.INSTANCE.brazelog(STARTED, BrazeLogger.Priority.this$0, paramContext, new a(paramString));
      }
    }
    return false;
  }
  
  public static final void incrementPermissionRequestCount(Context paramContext, String paramString)
  {
    i.e(paramContext, "context");
    i.e(paramString, "permission");
    paramContext = paramContext.getSharedPreferences("com.braze.support.permission_util.requested_perms", 0);
    int i = paramContext.getInt(paramString, 0) + 1;
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, STARTED, null, null, new b(i), 6, null);
    paramContext.edit().putInt(paramString, i).apply();
  }
  
  public static final void requestPushPermissionPrompt(Activity paramActivity)
  {
    BrazeLogger localBrazeLogger = BrazeLogger.INSTANCE;
    String str = STARTED;
    BrazeLogger.Priority localPriority = BrazeLogger.Priority.$EnumSwitchMapping$0;
    BrazeLogger.brazelog$default(localBrazeLogger, str, localPriority, null, c.PREPARED, 4, null);
    if (paramActivity == null)
    {
      BrazeLogger.brazelog$default(localBrazeLogger, str, null, null, d.STARTED, 6, null);
      return;
    }
    if ((wouldPushPermissionPromptDisplay(paramActivity)) && (Build.VERSION.SDK_INT >= 33))
    {
      incrementPermissionRequestCount(paramActivity, "android.permission.POST_NOTIFICATIONS");
      BrazeLogger.brazelog$default(localBrazeLogger, str, localPriority, null, f.COLOR_SCHEMES, 4, null);
      int i = IntentUtils.getRequestCode();
      paramActivity.requestPermissions(new String[] { "android.permission.POST_NOTIFICATIONS" }, i);
      return;
    }
    BrazeLogger.brazelog$default(localBrazeLogger, str, null, null, e.COLOR_SCHEMES, 6, null);
  }
  
  public static final boolean wouldPushPermissionPromptDisplay(Activity paramActivity)
  {
    if (paramActivity == null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, STARTED, null, null, g.READY, 6, null);
      return false;
    }
    if (Build.VERSION.SDK_INT < 33)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, STARTED, BrazeLogger.Priority.g, null, h.components, 4, null);
      return false;
    }
    int i = getApplicationInfotargetSdkVersion;
    if (i < 33)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, STARTED, BrazeLogger.Priority.g, null, new i(i), 4, null);
      return false;
    }
    if (hasPermission(paramActivity, "android.permission.POST_NOTIFICATIONS"))
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, STARTED, BrazeLogger.Priority.g, null, j.components, 4, null);
      return false;
    }
    i = getPermissionRequestCount(paramActivity, "android.permission.POST_NOTIFICATIONS");
    if (i >= 2)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, STARTED, BrazeLogger.Priority.g, null, new k(i), 4, null);
      return paramActivity.shouldShowRequestPermissionRationale("android.permission.POST_NOTIFICATIONS");
    }
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, STARTED, BrazeLogger.Priority.$EnumSwitchMapping$0, null, l.SINGLE_FILE, 4, null);
    return true;
  }
  
  static final class a
    extends j
    implements a<String>
  {
    a(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failure checking permission ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class b
    extends j
    implements a<String>
  {
    b(int paramInt)
    {
      super();
    }
    
    public final String get()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Incrementing permission request counter to ");
      localStringBuilder.append(mRow);
      localStringBuilder.append('.');
      return localStringBuilder.toString();
    }
  }
  
  static final class c
    extends j
    implements a<String>
  {
    public static final c PREPARED = new c();
    
    c()
    {
      super();
    }
    
    public final String getText()
    {
      return "Attempting to execute requestPushPermissionPrompt()";
    }
  }
  
  static final class d
    extends j
    implements a<String>
  {
    public static final d STARTED = new d();
    
    d()
    {
      super();
    }
    
    public final String getText()
    {
      return "Cannot request push permission with null Activity.";
    }
  }
  
  static final class e
    extends j
    implements a<String>
  {
    public static final e COLOR_SCHEMES = new e();
    
    e()
    {
      super();
    }
    
    public final String getText()
    {
      return "Permission prompt would not display, not attempting to request push permission prompt.";
    }
  }
  
  static final class f
    extends j
    implements a<String>
  {
    public static final f COLOR_SCHEMES = new f();
    
    f()
    {
      super();
    }
    
    public final String getText()
    {
      return "Requesting push permission from system.";
    }
  }
  
  static final class g
    extends j
    implements a<String>
  {
    public static final g READY = new g();
    
    g()
    {
      super();
    }
    
    public final String getText()
    {
      return "Cannot request push permission with null Activity.";
    }
  }
  
  static final class h
    extends j
    implements a<String>
  {
    public static final h components = new h();
    
    h()
    {
      super();
    }
    
    public final String get()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Device API version of ");
      localStringBuilder.append(Build.VERSION.SDK_INT);
      localStringBuilder.append(" is too low to display push permission prompt.");
      return localStringBuilder.toString();
    }
  }
  
  static final class i
    extends j
    implements a<String>
  {
    i(int paramInt)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("App Target API version of ");
      localStringBuilder.append(src);
      localStringBuilder.append(" is too low to display push permission prompt.");
      return localStringBuilder.toString();
    }
  }
  
  static final class j
    extends j
    implements a<String>
  {
    public static final j components = new j();
    
    j()
    {
      super();
    }
    
    public final String getText()
    {
      return "Notification permission already granted, doing nothing.";
    }
  }
  
  static final class k
    extends j
    implements a<String>
  {
    k(int paramInt)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Notification permission request count is ");
      localStringBuilder.append(src);
      localStringBuilder.append(". Returning value of 'shouldShowRequestPermissionRationale(NOTIFICATION_PERMISSION)'");
      return localStringBuilder.toString();
    }
  }
  
  static final class l
    extends j
    implements a<String>
  {
    public static final l SINGLE_FILE = new l();
    
    l()
    {
      super();
    }
    
    public final String getText()
    {
      return "Push Prompt can be shown on this device, within a reasonable confidence.";
    }
  }
}
