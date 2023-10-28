package androidx.core.content;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import androidx.core.content.asm.Label;
import androidx.core.package_10.NotificationManagerCompat;
import java.io.File;

public class ContextCompat
{
  private static final Object c = new Object();
  private static final Object d = new Object();
  private static TypedValue mTypedValue;
  
  public static android.content.Context a(android.content.Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return ClassReader.b(paramContext);
    }
    return null;
  }
  
  public static ColorStateList b(android.content.Context paramContext, int paramInt)
  {
    return Label.a(paramContext.getResources(), paramInt, paramContext.getTheme());
  }
  
  public static int checkSelfPermission(android.content.Context paramContext, String paramString)
  {
    v7.v7.util.Context.get(paramString, "permission must be non-null");
    if ((!v7.v7.menu.Context.get()) && (TextUtils.equals("android.permission.POST_NOTIFICATIONS", paramString)))
    {
      if (NotificationManagerCompat.from(paramContext).areNotificationsEnabled()) {
        return 0;
      }
      return -1;
    }
    return paramContext.checkPermission(paramString, Process.myPid(), Process.myUid());
  }
  
  private static File createFilesDir(File paramFile)
  {
    Object localObject = d;
    try
    {
      if (!paramFile.exists())
      {
        if (paramFile.mkdirs()) {
          return paramFile;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unable to create files subdir ");
        localStringBuilder.append(paramFile.getPath());
        Log.w("ContextCompat", localStringBuilder.toString());
      }
      return paramFile;
    }
    catch (Throwable paramFile)
    {
      throw paramFile;
    }
  }
  
  static String get(android.content.Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext.getPackageName());
    ((StringBuilder)localObject).append(".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION");
    localObject = ((StringBuilder)localObject).toString();
    if (PermissionChecker.checkSelfPermission(paramContext, (String)localObject) == 0) {
      return localObject;
    }
    paramContext = new StringBuilder();
    paramContext.append("Permission ");
    paramContext.append((String)localObject);
    paramContext.append(" is required by your application to receive broadcasts, please add it to your manifest");
    throw new RuntimeException(paramContext.toString());
  }
  
  public static int getColor(android.content.Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return ContextCompatApi23.getColor(paramContext, paramInt);
    }
    return paramContext.getResources().getColor(paramInt);
  }
  
  public static Drawable getDrawable(android.content.Context paramContext, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21) {
      return ContextCompatApi21.getDrawable(paramContext, paramInt);
    }
    if (i >= 16) {
      return paramContext.getResources().getDrawable(paramInt);
    }
    Object localObject = c;
    try
    {
      if (mTypedValue == null) {
        mTypedValue = new TypedValue();
      }
      paramContext.getResources().getValue(paramInt, mTypedValue, true);
      paramInt = mTypedValueresourceId;
      return paramContext.getResources().getDrawable(paramInt);
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public static File[] getExternalCacheDirs(android.content.Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return ContextCompatKitKat.getExternalCacheDirs(paramContext);
    }
    return new File[] { paramContext.getExternalCacheDir() };
  }
  
  public static File[] getExternalFilesDirs(android.content.Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return ContextCompatKitKat.getExternalFilesDirs(paramContext, paramString);
    }
    return new File[] { paramContext.getExternalFilesDir(paramString) };
  }
  
  public static File getNoBackupFilesDir(android.content.Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ContextCompatApi21.getNoBackupFilesDir(paramContext);
    }
    return createFilesDir(new File(getApplicationInfodataDir, "no_backup"));
  }
  
  public static void init(android.content.Context paramContext, Intent paramIntent)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      ConnectionManager.start(paramContext, paramIntent);
      return;
    }
    paramContext.startService(paramIntent);
  }
  
  public static boolean startActivities(android.content.Context paramContext, Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      ActivityCompat.startActivities(paramContext, paramArrayOfIntent, paramBundle);
    } else {
      paramContext.startActivities(paramArrayOfIntent);
    }
    return true;
  }
  
  public static void startActivity(android.content.Context paramContext, Intent paramIntent, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      ActivityCompat.startActivity(paramContext, paramIntent, paramBundle);
      return;
    }
    paramContext.startActivity(paramIntent);
  }
}
