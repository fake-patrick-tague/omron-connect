package com.alivecor.mapsforge.record;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringInternal;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.URLSpan;
import l.a.a;

public class MediumTextUrlSpan
  extends URLSpan
{
  private static final String FLOAT = com.alivecor.ecg.record.MediumTextUrlSpan.class.getSimpleName();
  private static Typeface typeface;
  
  public MediumTextUrlSpan(Parcel paramParcel)
  {
    super(paramParcel);
    initTypeface();
  }
  
  public MediumTextUrlSpan(String paramString)
  {
    super(paramString);
    initTypeface();
  }
  
  public static Spanned applyToStringRes(Context paramContext, int paramInt)
  {
    return replaceURLSpans(Html.fromHtml(paramContext.getString(paramInt)));
  }
  
  private Typeface createTypeface()
  {
    return Typeface.create(null, 1);
  }
  
  private Typeface createTypefaceApi21()
  {
    return Typeface.create("sans-serif-medium", 0);
  }
  
  private void initTypeface()
  {
    try
    {
      Typeface localTypeface = typeface;
      if (localTypeface != null) {
        return;
      }
      if (Build.VERSION.SDK_INT >= 21)
      {
        localTypeface = createTypefaceApi21();
        typeface = localTypeface;
        if (localTypeface == null) {
          a.h("No medium-bold typeface found.  Falling back to bold", new Object[0]);
        }
      }
      else
      {
        for (localTypeface = createTypeface();; localTypeface = createTypeface())
        {
          typeface = localTypeface;
          break;
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public static Spanned replaceURLSpans(Spanned paramSpanned)
  {
    paramSpanned = new SpannableString(paramSpanned);
    int j = paramSpanned.length();
    int i = 0;
    URLSpan[] arrayOfURLSpan = (URLSpan[])paramSpanned.getSpans(0, j, URLSpan.class);
    if (arrayOfURLSpan != null)
    {
      j = arrayOfURLSpan.length;
      while (i < j)
      {
        URLSpan localURLSpan = arrayOfURLSpan[i];
        int k = paramSpanned.getSpanStart(localURLSpan);
        int m = paramSpanned.getSpanEnd(localURLSpan);
        paramSpanned.removeSpan(localURLSpan);
        paramSpanned.setSpan(new MediumTextUrlSpan(localURLSpan.getURL()), k, m, 17);
        i += 1;
      }
    }
    return paramSpanned;
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(linkColor);
    paramTextPaint.setTypeface(typeface);
  }
}
