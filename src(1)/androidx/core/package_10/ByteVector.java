package androidx.core.package_10;

import android.app.Notification;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.BaseBundle;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.text.NumberFormat;
import v7.v7.R.dimen;
import v7.v7.R.id;
import v7.v7.R.integer;
import v7.v7.R.string;

public abstract class ByteVector
{
  CharSequence mBigContentTitle;
  protected ClassWriter mBuilder;
  CharSequence mSummaryText;
  boolean mSummaryTextSet = false;
  
  public ByteVector() {}
  
  private int calculateTopPadding()
  {
    Resources localResources = mBuilder.mContext.getResources();
    int i = localResources.getDimensionPixelSize(R.dimen.sb__min_width);
    int j = localResources.getDimensionPixelSize(R.dimen.sb__max_width);
    float f = (constrain(getConfigurationfontScale, 1.0F, 1.3F) - 1.0F) / 0.29999995F;
    return Math.round((1.0F - f) * i + f * j);
  }
  
  private static float constrain(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 < paramFloat2) {
      return paramFloat2;
    }
    if (paramFloat1 > paramFloat3) {
      return paramFloat3;
    }
    return paramFloat1;
  }
  
  private Bitmap createColoredBitmap(int paramInt1, int paramInt2, int paramInt3)
  {
    return createColoredBitmap(IconCompat.a(mBuilder.mContext, paramInt1), paramInt2, paramInt3);
  }
  
  private Bitmap createColoredBitmap(IconCompat paramIconCompat, int paramInt1, int paramInt2)
  {
    paramIconCompat = paramIconCompat.getDrawable(mBuilder.mContext);
    int i;
    if (paramInt2 == 0) {
      i = paramIconCompat.getIntrinsicWidth();
    } else {
      i = paramInt2;
    }
    int j = paramInt2;
    if (paramInt2 == 0) {
      j = paramIconCompat.getIntrinsicHeight();
    }
    Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    paramIconCompat.setBounds(0, 0, i, j);
    if (paramInt1 != 0) {
      paramIconCompat.mutate().setColorFilter(new PorterDuffColorFilter(paramInt1, PorterDuff.Mode.SRC_IN));
    }
    paramIconCompat.draw(new Canvas(localBitmap));
    return localBitmap;
  }
  
  private Bitmap createIconWithBackground(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = R.string.items;
    int i = paramInt4;
    if (paramInt4 == 0) {
      i = 0;
    }
    Bitmap localBitmap = createColoredBitmap(j, i, paramInt2);
    Canvas localCanvas = new Canvas(localBitmap);
    Drawable localDrawable = mBuilder.mContext.getResources().getDrawable(paramInt1).mutate();
    localDrawable.setFilterBitmap(true);
    paramInt1 = (paramInt2 - paramInt3) / 2;
    paramInt2 = paramInt3 + paramInt1;
    localDrawable.setBounds(paramInt1, paramInt1, paramInt2, paramInt2);
    localDrawable.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
    localDrawable.draw(localCanvas);
    return localBitmap;
  }
  
  private void hideNormalContent(RemoteViews paramRemoteViews)
  {
    paramRemoteViews.setViewVisibility(R.id.title, 8);
    paramRemoteViews.setViewVisibility(R.id.text2, 8);
    paramRemoteViews.setViewVisibility(R.id.text, 8);
  }
  
  public void addCompatExtras(Bundle paramBundle)
  {
    if (mSummaryTextSet) {
      paramBundle.putCharSequence("android.summaryText", mSummaryText);
    }
    Object localObject = mBigContentTitle;
    if (localObject != null) {
      paramBundle.putCharSequence("android.title.big", (CharSequence)localObject);
    }
    localObject = getClassName();
    if (localObject != null) {
      paramBundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", (String)localObject);
    }
  }
  
  public void apply(Duration paramDuration) {}
  
  public RemoteViews applyStandardTemplate(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    Resources localResources = mBuilder.mContext.getResources();
    RemoteViews localRemoteViews = new RemoteViews(mBuilder.mContext.getPackageName(), paramInt);
    paramInt = mBuilder.c();
    int m = 1;
    int k = 0;
    if (paramInt < -1) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    int n = android.os.Build.VERSION.SDK_INT;
    if ((n >= 16) && (n < 21)) {
      if (paramInt != 0)
      {
        localRemoteViews.setInt(R.id.id, "setBackgroundResource", R.string.text);
        localRemoteViews.setInt(R.id.icon, "setBackgroundResource", R.string.time);
      }
      else
      {
        localRemoteViews.setInt(R.id.id, "setBackgroundResource", R.string.icon);
        localRemoteViews.setInt(R.id.icon, "setBackgroundResource", R.string.title);
      }
    }
    Object localObject = mBuilder;
    if (icon != null)
    {
      if (n >= 16)
      {
        paramInt = R.id.icon;
        localRemoteViews.setViewVisibility(paramInt, 0);
        localRemoteViews.setImageViewBitmap(paramInt, mBuilder.icon);
      }
      else
      {
        localRemoteViews.setViewVisibility(R.id.icon, 8);
      }
      if ((paramBoolean1) && (mBuilder.this$0.icon != 0))
      {
        paramInt = localResources.getDimensionPixelSize(R.dimen.icon);
        i = localResources.getDimensionPixelSize(R.dimen.title);
        if (n >= 21)
        {
          localObject = mBuilder;
          localObject = createIconWithBackground(this$0.icon, paramInt, paramInt - i * 2, ((ClassWriter)localObject).a());
          localRemoteViews.setImageViewBitmap(R.id.time, (Bitmap)localObject);
        }
        else
        {
          localRemoteViews.setImageViewBitmap(R.id.time, createColoredBitmap(mBuilder.this$0.icon, -1));
        }
        localRemoteViews.setViewVisibility(R.id.time, 0);
      }
    }
    else if ((paramBoolean1) && (this$0.icon != 0))
    {
      paramInt = R.id.icon;
      localRemoteViews.setViewVisibility(paramInt, 0);
      if (n >= 21)
      {
        i = localResources.getDimensionPixelSize(R.dimen.notification_subtext_size);
        j = localResources.getDimensionPixelSize(R.dimen.chronometer);
        int i1 = localResources.getDimensionPixelSize(R.dimen.line3);
        localObject = mBuilder;
        localRemoteViews.setImageViewBitmap(paramInt, createIconWithBackground(this$0.icon, i - j, i1, ((ClassWriter)localObject).a()));
      }
      else
      {
        localRemoteViews.setImageViewBitmap(paramInt, createColoredBitmap(mBuilder.this$0.icon, -1));
      }
    }
    localObject = mBuilder.title;
    if (localObject != null) {
      localRemoteViews.setTextViewText(R.id.title, (CharSequence)localObject);
    }
    localObject = mBuilder.text;
    if (localObject != null)
    {
      localRemoteViews.setTextViewText(R.id.text, (CharSequence)localObject);
      paramInt = 1;
    }
    else
    {
      paramInt = 0;
    }
    if ((n < 21) && (mBuilder.icon != null)) {
      i = 1;
    } else {
      i = 0;
    }
    localObject = mBuilder;
    CharSequence localCharSequence = info;
    if (localCharSequence != null)
    {
      paramInt = R.id.info;
      localRemoteViews.setTextViewText(paramInt, localCharSequence);
      localRemoteViews.setViewVisibility(paramInt, 0);
    }
    for (;;)
    {
      j = 1;
      paramInt = 1;
      break label667;
      if (flags <= 0) {
        break;
      }
      paramInt = localResources.getInteger(R.integer.title);
      if (mBuilder.flags > paramInt)
      {
        localRemoteViews.setTextViewText(R.id.info, localResources.getString(v7.v7.Build.VERSION.status_bar_notification_info_overflow));
      }
      else
      {
        localObject = NumberFormat.getIntegerInstance();
        localRemoteViews.setTextViewText(R.id.info, ((NumberFormat)localObject).format(mBuilder.flags));
      }
      localRemoteViews.setViewVisibility(R.id.info, 0);
    }
    localRemoteViews.setViewVisibility(R.id.info, 8);
    int j = paramInt;
    paramInt = i;
    label667:
    localObject = mBuilder.id;
    if ((localObject != null) && (n >= 16))
    {
      localRemoteViews.setTextViewText(R.id.text, (CharSequence)localObject);
      localObject = mBuilder.text;
      if (localObject != null)
      {
        i = R.id.text2;
        localRemoteViews.setTextViewText(i, (CharSequence)localObject);
        localRemoteViews.setViewVisibility(i, 0);
        i = 1;
      }
      else
      {
        localRemoteViews.setViewVisibility(R.id.text2, 8);
      }
    }
    else
    {
      i = 0;
    }
    if ((i != 0) && (n >= 16))
    {
      if (paramBoolean2)
      {
        float f = localResources.getDimensionPixelSize(R.dimen.text2);
        localRemoteViews.setTextViewTextSize(R.id.text, 0, f);
      }
      localRemoteViews.setViewPadding(R.id.line1, 0, 0, 0, 0);
    }
    if (mBuilder.add() != 0L) {
      if ((mBuilder.items) && (n >= 16))
      {
        i = R.id.chronometer;
        localRemoteViews.setViewVisibility(i, 0);
        localRemoteViews.setLong(i, "setBase", mBuilder.add() + (SystemClock.elapsedRealtime() - System.currentTimeMillis()));
        localRemoteViews.setBoolean(i, "setStarted", true);
        paramBoolean1 = mBuilder.running;
        paramInt = m;
        if (paramBoolean1)
        {
          paramInt = m;
          if (n >= 24)
          {
            localRemoteViews.setChronometerCountDown(i, paramBoolean1);
            paramInt = m;
          }
        }
      }
      else
      {
        paramInt = R.id.end_padder;
        localRemoteViews.setViewVisibility(paramInt, 0);
        localRemoteViews.setLong(paramInt, "setTime", mBuilder.add());
        paramInt = m;
      }
    }
    int i = R.id.cancel_action;
    if (paramInt != 0) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    localRemoteViews.setViewVisibility(i, paramInt);
    i = R.id.line3;
    if (j != 0) {
      paramInt = k;
    } else {
      paramInt = 8;
    }
    localRemoteViews.setViewVisibility(i, paramInt);
    return localRemoteViews;
  }
  
  public void buildIntoRemoteViews(RemoteViews paramRemoteViews1, RemoteViews paramRemoteViews2)
  {
    hideNormalContent(paramRemoteViews1);
    int i = R.id.media_actions;
    paramRemoteViews1.removeAllViews(i);
    paramRemoteViews1.addView(i, paramRemoteViews2.clone());
    paramRemoteViews1.setViewVisibility(i, 0);
    if (android.os.Build.VERSION.SDK_INT >= 21) {
      paramRemoteViews1.setViewPadding(R.id.videoview, 0, calculateTopPadding(), 0, 0);
    }
  }
  
  public Bitmap createColoredBitmap(int paramInt1, int paramInt2)
  {
    return createColoredBitmap(paramInt1, paramInt2, 0);
  }
  
  Bitmap createColoredBitmap(IconCompat paramIconCompat, int paramInt)
  {
    return createColoredBitmap(paramIconCompat, paramInt, 0);
  }
  
  protected String getClassName()
  {
    return null;
  }
  
  public RemoteViews makeBigContentView(Duration paramDuration)
  {
    return null;
  }
  
  public RemoteViews makeContentView(Duration paramDuration)
  {
    return null;
  }
  
  public RemoteViews makeHeadsUpContentView(Duration paramDuration)
  {
    return null;
  }
  
  public void setBuilder(ClassWriter paramClassWriter)
  {
    if (mBuilder != paramClassWriter)
    {
      mBuilder = paramClassWriter;
      if (paramClassWriter != null) {
        paramClassWriter.a(this);
      }
    }
  }
}
