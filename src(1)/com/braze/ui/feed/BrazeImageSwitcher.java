package com.braze.ui.feed;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageSwitcher;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import com.braze.ui.R.styleable;
import kotlin.x.c.a;
import kotlin.x.d.i;
import kotlin.x.d.j;

public final class BrazeImageSwitcher
  extends ImageSwitcher
{
  private Drawable readIcon;
  private Drawable unReadIcon;
  
  public BrazeImageSwitcher(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int[] arrayOfInt = R.styleable.com_braze_ui_feed_BrazeImageSwitcher;
    try
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, arrayOfInt);
      i.d(paramContext, "context.obtainStyledAttr?_feed_BrazeImageSwitcher)");
      int i = 0;
      int j = paramContext.getIndexCount();
      while (i < j)
      {
        int k = paramContext.getIndex(i);
        if (k == R.styleable.com_braze_ui_feed_BrazeImageSwitcher_brazeFeedCustomReadIcon)
        {
          paramAttributeSet = paramContext.getDrawable(k);
          if (paramAttributeSet != null) {
            readIcon = paramAttributeSet;
          }
        }
        else
        {
          int m = paramContext.getIndex(i);
          if (m == R.styleable.com_braze_ui_feed_BrazeImageSwitcher_brazeFeedCustomUnReadIcon)
          {
            paramAttributeSet = paramContext.getDrawable(k);
            if (paramAttributeSet != null) {
              unReadIcon = paramAttributeSet;
            }
          }
        }
        i += 1;
      }
      paramContext.recycle();
      return;
    }
    catch (Exception paramContext)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, paramContext, 1.INSTANCE);
    }
  }
  
  public final Drawable getReadIcon()
  {
    return readIcon;
  }
  
  public final Drawable getUnReadIcon()
  {
    return unReadIcon;
  }
  
  public final void setReadIcon(Drawable paramDrawable)
  {
    readIcon = paramDrawable;
  }
  
  public final void setUnReadIcon(Drawable paramDrawable)
  {
    unReadIcon = paramDrawable;
  }
}
