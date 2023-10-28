package com.braze.ui.support;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.ComponentInfoFlags;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.braze.IBrazeDeeplinkHandler;
import com.braze.IBrazeDeeplinkHandler.IntentFlagPurpose;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import com.braze.ui.BrazeDeeplinkHandler;
import com.braze.ui.BrazeDeeplinkHandler.Companion;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.a0;
import kotlin.x.c.a;
import kotlin.x.d.i;
import kotlin.x.d.j;
import kotlin.x.d.s;

public final class UriUtils
{
  private static final String STARTED = BrazeLogger.INSTANCE.getBrazeLogTag("UriUtils");
  
  public static final Intent getMainActivityIntent(Context paramContext, Bundle paramBundle)
  {
    i.e(paramContext, "context");
    paramContext = paramContext.getPackageManager().getLaunchIntentForPackage(paramContext.getPackageName());
    if (paramContext != null) {
      paramContext.setFlags(BrazeDeeplinkHandler.Companion.getInstance().getIntentFlags(IBrazeDeeplinkHandler.IntentFlagPurpose.URI_UTILS_GET_MAIN_ACTIVITY_INTENT));
    }
    if ((paramBundle != null) && (paramContext != null)) {
      paramContext.putExtras(paramBundle);
    }
    return paramContext;
  }
  
  public static final Map getQueryParameters(Uri paramUri)
  {
    i.e(paramUri, "<this>");
    s localS = new s();
    b = paramUri;
    Object localObject1 = ((Uri)paramUri).getEncodedQuery();
    if (localObject1 == null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, STARTED, BrazeLogger.Priority.$EnumSwitchMapping$0, null, new j(localS)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Encoded query is null for Uri: ");
          localStringBuilder.append(b);
          localStringBuilder.append(" Returning empty map for query parameters");
          return localStringBuilder.toString();
        }
      }, 4, null);
      return a0.d();
    }
    paramUri = new LinkedHashMap();
    Object localObject2 = (Uri)b;
    try
    {
      boolean bool = ((Uri)localObject2).isOpaque();
      if (bool)
      {
        localObject1 = Uri.parse("://").buildUpon().encodedQuery((String)localObject1).build();
        i.d(localObject1, "parse(\"://\")\n           ?\n                .build()");
        b = localObject1;
      }
      localObject1 = (Uri)b;
      localObject2 = ((Uri)localObject1).getQueryParameterNames();
      i.d(localObject2, "uri.queryParameterNames");
      localObject1 = new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      int i;
      Object localObject3;
      for (;;)
      {
        bool = ((Iterator)localObject2).hasNext();
        i = 0;
        if (!bool) {
          break;
        }
        localObject3 = ((Iterator)localObject2).next();
        String str = (String)localObject3;
        if (str != null)
        {
          int j = str.length();
          if (j != 0) {}
        }
        else
        {
          i = 1;
        }
        if ((i ^ 0x1) != 0) {
          ((Collection)localObject1).add(localObject3);
        }
      }
      localObject1 = ((List)localObject1).iterator();
      for (;;)
      {
        bool = ((Iterator)localObject1).hasNext();
        if (!bool) {
          break;
        }
        localObject2 = ((Iterator)localObject1).next();
        localObject2 = (String)localObject2;
        localObject3 = (Uri)b;
        localObject3 = ((Uri)localObject3).getQueryParameter((String)localObject2);
        if (localObject3 != null)
        {
          i = ((CharSequence)localObject3).length();
          if (i != 0)
          {
            i = 0;
            break label316;
          }
        }
        i = 1;
        label316:
        if (i == 0)
        {
          i.d(localObject2, "queryParameterKey");
          paramUri.put(localObject2, localObject3);
        }
      }
      return paramUri;
    }
    catch (Exception localException)
    {
      BrazeLogger.INSTANCE.brazelog(STARTED, BrazeLogger.Priority.this$0, localException, new j(localS)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Failed to map the query parameters of Uri: ");
          localStringBuilder.append(b);
          return localStringBuilder.toString();
        }
      });
    }
  }
  
  public static final boolean isActivityRegisteredInManifest(Context paramContext, String paramString)
  {
    i.e(paramContext, "context");
    i.e(paramString, "className");
    if (Build.VERSION.SDK_INT >= 33) {}
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      localPackageManager.getActivityInfo(new ComponentName(paramContext, paramString), PackageManager.ComponentInfoFlags.of(0L));
      break label66;
      localPackageManager = paramContext.getPackageManager();
      localPackageManager.getActivityInfo(new ComponentName(paramContext, paramString), 0);
      label66:
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      BrazeLogger.INSTANCE.brazelog(STARTED, BrazeLogger.Priority.PREPARED, paramContext, new j(paramString)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Could not find activity info for class with name: ");
          localStringBuilder.append(UriUtils.this);
          return localStringBuilder.toString();
        }
      });
    }
    return false;
  }
}
