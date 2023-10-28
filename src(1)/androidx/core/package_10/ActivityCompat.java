package androidx.core.package_10;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import v7.v7.menu.Context;

public class ActivityCompat
  extends ContextCompat
{
  private static Ref target;
  
  public static void execute(Activity paramActivity, String[] paramArrayOfString, int paramInt)
  {
    Object localObject = target;
    if ((localObject != null) && (((Ref)localObject).set(paramActivity, paramArrayOfString, paramInt))) {
      return;
    }
    HashSet localHashSet = new HashSet();
    int k = 0;
    int i = 0;
    while (i < paramArrayOfString.length) {
      if (!TextUtils.isEmpty(paramArrayOfString[i]))
      {
        if ((!Context.get()) && (TextUtils.equals(paramArrayOfString[i], "android.permission.POST_NOTIFICATIONS"))) {
          localHashSet.add(Integer.valueOf(i));
        }
        i += 1;
      }
      else
      {
        paramActivity = new StringBuilder();
        paramActivity.append("Permission request for permissions ");
        paramActivity.append(Arrays.toString(paramArrayOfString));
        paramActivity.append(" must not contain null or empty values");
        throw new IllegalArgumentException(paramActivity.toString());
      }
    }
    i = localHashSet.size();
    if (i > 0) {
      localObject = new String[paramArrayOfString.length - i];
    } else {
      localObject = paramArrayOfString;
    }
    if (i > 0)
    {
      if (i == paramArrayOfString.length) {
        return;
      }
      int j = 0;
      i = k;
      while (i < paramArrayOfString.length)
      {
        k = j;
        if (!localHashSet.contains(Integer.valueOf(i)))
        {
          localObject[j] = paramArrayOfString[i];
          k = j + 1;
        }
        i += 1;
        j = k;
      }
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      if ((paramActivity instanceof HttpHost)) {
        ((HttpHost)paramActivity).validateRequestPermissionsRequestCode(paramInt);
      }
      ActivityCompatApi23.requestPermissions(paramActivity, paramArrayOfString, paramInt);
      return;
    }
    if ((paramActivity instanceof OnRequestPermissionsResultCallback)) {
      new Handler(Looper.getMainLooper()).post(new ActivityCompat.1((String[])localObject, paramActivity, paramInt));
    }
  }
  
  public static void finishAffinity(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      ActivityCompatJB.finishAffinity(paramActivity);
      return;
    }
    paramActivity.finish();
  }
  
  public static void finishAfterTransition(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      ActivityCompat21.finishAfterTransition(paramActivity);
      return;
    }
    paramActivity.finish();
  }
  
  public static void postponeEnterTransition(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      ActivityCompat21.postponeEnterTransition(paramActivity);
    }
  }
  
  public static void requestPermissions(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      paramActivity.recreate();
      return;
    }
    new Handler(paramActivity.getMainLooper()).post(new Download(paramActivity));
  }
  
  public static void setEnterSharedElementCallback(Activity paramActivity, SharedElementCallback paramSharedElementCallback)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (paramSharedElementCallback != null) {
        paramSharedElementCallback = new ActivityCompat21.SharedElementCallbackImpl(paramSharedElementCallback);
      } else {
        paramSharedElementCallback = null;
      }
      ActivityCompat21.setEnterSharedElementCallback(paramActivity, paramSharedElementCallback);
    }
  }
  
  public static void setExitSharedElementCallback(Activity paramActivity, SharedElementCallback paramSharedElementCallback)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (paramSharedElementCallback != null) {
        paramSharedElementCallback = new ActivityCompat21.SharedElementCallbackImpl(paramSharedElementCallback);
      } else {
        paramSharedElementCallback = null;
      }
      ActivityCompat21.setExitSharedElementCallback(paramActivity, paramSharedElementCallback);
    }
  }
  
  public static boolean shouldShowRequestPermissionRationale(Activity paramActivity, String paramString)
  {
    if ((!Context.get()) && (TextUtils.equals("android.permission.POST_NOTIFICATIONS", paramString))) {
      return false;
    }
    if (Build.VERSION.SDK_INT >= 23) {
      return ActivityCompatApi23.shouldShowRequestPermissionRationale(paramActivity, paramString);
    }
    return false;
  }
  
  public static void startActivity(Activity paramActivity, IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
    throws IntentSender.SendIntentException
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      ActivityCompatJB.startActivity(paramActivity, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
      return;
    }
    paramActivity.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4);
  }
  
  public static void startActivityForResult(Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      ActivityCompatJB.startActivityForResult(paramActivity, paramIntent, paramInt, paramBundle);
      return;
    }
    paramActivity.startActivityForResult(paramIntent, paramInt);
  }
  
  public static void startPostponedEnterTransition(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      ActivityCompat21.startPostponedEnterTransition(paramActivity);
    }
  }
  
  public abstract interface OnRequestPermissionsResultCallback
  {
    public abstract void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
  }
}
