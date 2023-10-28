package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.gms.base.R.color;
import com.google.android.gms.base.R.drawable;
import com.google.android.gms.base.R.string;
import com.google.android.gms.common.util.DeviceProperties;

public final class zaaa
  extends Button
{
  public zaaa(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, null, 16842824);
  }
  
  private static final int getPath(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 == 2) {
          return paramInt4;
        }
        StringBuilder localStringBuilder = new StringBuilder(33);
        localStringBuilder.append("Unknown color scheme: ");
        localStringBuilder.append(paramInt1);
        throw new IllegalStateException(localStringBuilder.toString());
      }
    }
    else {
      return paramInt2;
    }
    return paramInt3;
  }
  
  public final void init(Resources paramResources, int paramInt1, int paramInt2)
  {
    setTypeface(Typeface.DEFAULT_BOLD);
    setTextSize(14.0F);
    int i = (int)(getDisplayMetricsdensity * 48.0F + 0.5F);
    setMinHeight(i);
    setMinWidth(i);
    i = R.drawable.common_google_signin_btn_icon_dark;
    int j = R.drawable.common_google_signin_btn_icon_light;
    i = getPath(paramInt2, i, j, j);
    j = R.drawable.common_google_signin_btn_text_dark;
    int k = R.drawable.common_google_signin_btn_text_light;
    j = getPath(paramInt2, j, k, k);
    if ((paramInt1 != 0) && (paramInt1 != 1))
    {
      if (paramInt1 != 2)
      {
        paramResources = new StringBuilder(32);
        paramResources.append("Unknown button size: ");
        paramResources.append(paramInt1);
        throw new IllegalStateException(paramResources.toString());
      }
    }
    else {
      i = j;
    }
    Drawable localDrawable = DrawableCompat.getDrawable(paramResources.getDrawable(i));
    DrawableCompat.append(localDrawable, paramResources.getColorStateList(R.color.common_google_signin_btn_tint));
    DrawableCompat.setTintMode(localDrawable, PorterDuff.Mode.SRC_ATOP);
    setBackgroundDrawable(localDrawable);
    i = R.color.common_google_signin_btn_text_dark;
    j = R.color.common_google_signin_btn_text_light;
    setTextColor((ColorStateList)Preconditions.checkNotNull(paramResources.getColorStateList(getPath(paramInt2, i, j, j))));
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 == 2)
        {
          setText(null);
        }
        else
        {
          paramResources = new StringBuilder(32);
          paramResources.append("Unknown button size: ");
          paramResources.append(paramInt1);
          throw new IllegalStateException(paramResources.toString());
        }
      }
      else {
        setText(paramResources.getString(R.string.common_signin_button_text_long));
      }
    }
    else {
      setText(paramResources.getString(R.string.common_signin_button_text));
    }
    setTransformationMethod(null);
    if (DeviceProperties.isWearable(getContext())) {
      setGravity(19);
    }
  }
}
