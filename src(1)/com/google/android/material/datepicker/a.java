package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import org.org.org.ui.R.styleable;
import org.org.org.ui.menu.Label;

final class a
{
  final f a;
  final f b;
  final f c;
  final f d;
  final f j;
  final Paint k;
  final f l;
  final f o;
  
  a(Context paramContext)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(Label.a(paramContext, org.org.org.ui.ClassWriter.d, MaterialCalendar.class.getCanonicalName()), R.styleable.ShowcaseView);
    a = f.a(paramContext, localTypedArray.getResourceId(R.styleable.Preference_android_layout, 0));
    b = f.a(paramContext, localTypedArray.getResourceId(R.styleable.TabItem_android_layout, 0));
    d = f.a(paramContext, localTypedArray.getResourceId(R.styleable.Preference_layout, 0));
    c = f.a(paramContext, localTypedArray.getResourceId(R.styleable.FloatingActionMenu_menu_labels_hideAnimation, 0));
    ColorStateList localColorStateList = org.org.org.ui.menu.ClassWriter.getString(paramContext, localTypedArray, R.styleable.DragSortListView_drag_handle_id);
    l = f.a(paramContext, localTypedArray.getResourceId(R.styleable.DragSortListView_fling_handle_id, 0));
    o = f.a(paramContext, localTypedArray.getResourceId(R.styleable.Preference_android_widgetLayout, 0));
    j = f.a(paramContext, localTypedArray.getResourceId(R.styleable.PagerSlidingTabStrip_pstsTabBackground, 0));
    paramContext = new Paint();
    k = paramContext;
    paramContext.setColor(localColorStateList.getDefaultColor());
    localTypedArray.recycle();
  }
}
