package com.alivecor.mapsforge.record;

import android.content.Context;
import android.net.Uri;
import android.text.SpannableString;
import android.text.SpannableStringInternal;
import android.text.Spanned;
import android.text.style.URLSpan;
import android.view.View;
import androidx.fragment.package_11.FragmentActivity;

public class FragmentUrlSpan
  extends MediumTextUrlSpan
{
  Context context;
  private final FragmentActivity fragmentHost;
  
  public FragmentUrlSpan(FragmentActivity paramFragmentActivity, String paramString)
  {
    super(paramString);
    fragmentHost = paramFragmentActivity;
  }
  
  public static Spanned replaceURLSpans(FragmentActivity paramFragmentActivity, Spanned paramSpanned)
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
        paramSpanned.setSpan(new FragmentUrlSpan(paramFragmentActivity, localURLSpan.getURL()), k, m, 17);
        i += 1;
      }
    }
    return paramSpanned;
  }
  
  public void onClick(View paramView)
  {
    Util.openInBrowser(context, Uri.parse(getURL()).toString());
  }
}
