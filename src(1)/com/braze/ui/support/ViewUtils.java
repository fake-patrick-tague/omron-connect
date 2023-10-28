package com.braze.ui.support;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.core.graphics.Item;
import com.braze.enums.inappmessage.Orientation;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import java.util.Objects;
import kotlin.x.c.a;
import kotlin.x.d.i;
import kotlin.x.d.j;
import v7.v7.package_13.Label;
import v7.v7.package_13.f;
import v7.v7.package_13.n0.m;

public final class ViewUtils
{
  private static final String PLAYING = BrazeLogger.INSTANCE.getBrazeLogTag("ViewUtils");
  
  public static final double convertDpToPixels(Context paramContext, double paramDouble)
  {
    i.e(paramContext, "context");
    return paramDouble * getResourcesgetDisplayMetricsdensity;
  }
  
  public static final int getMaxSafeBottomInset(f paramF)
  {
    i.e(paramF, "windowInsets");
    Label localLabel = paramF.b();
    int i;
    if (localLabel != null) {
      i = localLabel.b();
    } else {
      i = 0;
    }
    return Math.max(i, atypeCoderight);
  }
  
  public static final int getMaxSafeLeftInset(f paramF)
  {
    i.e(paramF, "windowInsets");
    Label localLabel = paramF.b();
    int i;
    if (localLabel != null) {
      i = localLabel.c();
    } else {
      i = 0;
    }
    return Math.max(i, atypeCodey);
  }
  
  public static final int getMaxSafeRightInset(f paramF)
  {
    i.e(paramF, "windowInsets");
    Label localLabel = paramF.b();
    int i;
    if (localLabel != null) {
      i = localLabel.a();
    } else {
      i = 0;
    }
    return Math.max(i, atypeCodeleft);
  }
  
  public static final int getMaxSafeTopInset(f paramF)
  {
    i.e(paramF, "windowInsets");
    Label localLabel = paramF.b();
    int i;
    if (localLabel != null) {
      i = localLabel.getIcon();
    } else {
      i = 0;
    }
    return Math.max(i, atypeCodeb);
  }
  
  public static final boolean isCurrentOrientationValid(int paramInt, final Orientation paramOrientation)
  {
    i.e(paramOrientation, "preferredOrientation");
    if ((paramInt == 2) && (paramOrientation == Orientation.LANDSCAPE))
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, PLAYING, BrazeLogger.Priority.BEGIN, null, isCurrentOrientationValid.1.INSTANCE, 4, null);
      return true;
    }
    if ((paramInt == 1) && (paramOrientation == Orientation.PORTRAIT))
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, PLAYING, BrazeLogger.Priority.BEGIN, null, isCurrentOrientationValid.2.INSTANCE, 4, null);
      return true;
    }
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, PLAYING, BrazeLogger.Priority.BEGIN, null, new j(paramInt)
    {
      public final String invoke()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Current orientation ");
        localStringBuilder.append($currentScreenOrientation);
        localStringBuilder.append(" and preferred orientation ");
        localStringBuilder.append(paramOrientation);
        localStringBuilder.append(" don't match");
        return localStringBuilder.toString();
      }
    }, 4, null);
    return false;
  }
  
  public static final boolean isDeviceInNightMode(Context paramContext)
  {
    i.e(paramContext, "context");
    return (getResourcesgetConfigurationuiMode & 0x30) == 32;
  }
  
  public static final boolean isDeviceNotInTouchMode(View paramView)
  {
    i.e(paramView, "view");
    return paramView.isInTouchMode() ^ true;
  }
  
  public static final boolean isRunningOnTablet(Activity paramActivity)
  {
    i.e(paramActivity, "<this>");
    return getResourcesgetConfigurationsmallestScreenWidthDp >= 600;
  }
  
  public static final void removeViewFromParent(View paramView)
  {
    if (paramView == null) {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, PLAYING, BrazeLogger.Priority.BEGIN, null, removeViewFromParent.1.INSTANCE, 4, null);
    }
    Object localObject;
    if (paramView != null) {
      localObject = paramView.getParent();
    } else {
      localObject = null;
    }
    if ((localObject instanceof ViewGroup))
    {
      localObject = paramView.getParent();
      Objects.requireNonNull(localObject, "null cannot be cast to non-null type android.view.ViewGroup");
      localObject = (ViewGroup)localObject;
      ((ViewGroup)localObject).removeView(paramView);
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, PLAYING, BrazeLogger.Priority.BEGIN, null, new j(paramView)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Removed view: ");
          localStringBuilder.append(ViewUtils.this);
          localStringBuilder.append("\nfrom parent: ");
          localStringBuilder.append($parent);
          return localStringBuilder.toString();
        }
      }, 4, null);
    }
  }
  
  public static final void setActivityRequestedOrientation(final Activity paramActivity, int paramInt)
  {
    i.e(paramActivity, "<this>");
    try
    {
      paramActivity.setRequestedOrientation(paramInt);
      return;
    }
    catch (Exception localException)
    {
      BrazeLogger.INSTANCE.brazelog(PLAYING, BrazeLogger.Priority.this$0, localException, new j(paramInt)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Failed to set requested orientation ");
          localStringBuilder.append($requestedOrientation);
          localStringBuilder.append(" for activity class: ");
          localStringBuilder.append(paramActivity.getLocalClassName());
          return localStringBuilder.toString();
        }
      });
    }
  }
  
  public static final void setFocusableInTouchModeAndRequestFocus(View paramView)
  {
    i.e(paramView, "<this>");
    try
    {
      paramView.setFocusableInTouchMode(true);
      paramView.requestFocus();
      return;
    }
    catch (Exception paramView)
    {
      BrazeLogger.INSTANCE.brazelog(PLAYING, BrazeLogger.Priority.this$0, paramView, setFocusableInTouchModeAndRequestFocus.1.INSTANCE);
    }
  }
  
  public static final void setHeightOnViewLayoutParams(View paramView, int paramInt)
  {
    i.e(paramView, "view");
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    height = paramInt;
    paramView.setLayoutParams(localLayoutParams);
  }
}
