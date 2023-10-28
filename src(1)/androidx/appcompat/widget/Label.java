package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewManager;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import v7.internal.R.dimen;
import v7.internal.R.id;
import v7.internal.R.layout;
import v7.internal.R.style;

class Label
{
  private final Rect a;
  private final int[] b;
  private final Context c;
  private final int[] e;
  private final WindowManager.LayoutParams f;
  private final TextView g;
  private final View h;
  
  Label(Context paramContext)
  {
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    f = localLayoutParams;
    a = new Rect();
    e = new int[2];
    b = new int[2];
    c = paramContext;
    View localView = LayoutInflater.from(paramContext).inflate(R.layout.dialog, null);
    h = localView;
    g = ((TextView)localView.findViewById(R.id.list));
    localLayoutParams.setTitle(r0.class.getSimpleName());
    packageName = paramContext.getPackageName();
    type = 1002;
    width = -2;
    height = -2;
    format = -3;
    windowAnimations = R.style.checkbox;
    flags = 24;
  }
  
  private static View a(View paramView)
  {
    View localView = paramView.getRootView();
    ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
    if (((localLayoutParams instanceof WindowManager.LayoutParams)) && (type == 2)) {
      return localView;
    }
    for (paramView = paramView.getContext(); (paramView instanceof ContextWrapper); paramView = ((ContextWrapper)paramView).getBaseContext()) {
      if ((paramView instanceof Activity)) {
        return ((Activity)paramView).getWindow().getDecorView();
      }
    }
    return localView;
  }
  
  private void show(View paramView, int paramInt1, int paramInt2, boolean paramBoolean, WindowManager.LayoutParams paramLayoutParams)
  {
    token = paramView.getApplicationWindowToken();
    int i = c.getResources().getDimensionPixelOffset(R.dimen.h);
    if (paramView.getWidth() < i) {
      paramInt1 = paramView.getWidth() / 2;
    }
    if (paramView.getHeight() >= i)
    {
      j = c.getResources().getDimensionPixelOffset(R.dimen.second);
      i = paramInt2 + j;
      j = paramInt2 - j;
      paramInt2 = i;
      i = j;
    }
    else
    {
      paramInt2 = paramView.getHeight();
      i = 0;
    }
    gravity = 49;
    Object localObject1 = c.getResources();
    if (paramBoolean) {
      j = R.dimen.navigation_padding_top_default;
    } else {
      j = R.dimen.navigation_separator_vertical_padding;
    }
    int k = ((Resources)localObject1).getDimensionPixelOffset(j);
    localObject1 = a(paramView);
    if (localObject1 == null)
    {
      Log.e("TooltipPopup", "Cannot find app view");
      return;
    }
    ((View)localObject1).getWindowVisibleDisplayFrame(a);
    Object localObject2 = a;
    if ((left < 0) && (top < 0))
    {
      localObject2 = c.getResources();
      j = ((Resources)localObject2).getIdentifier("status_bar_height", "dimen", "android");
      if (j != 0) {
        j = ((Resources)localObject2).getDimensionPixelSize(j);
      } else {
        j = 0;
      }
      localObject2 = ((Resources)localObject2).getDisplayMetrics();
      a.set(0, j, widthPixels, heightPixels);
    }
    ((View)localObject1).getLocationOnScreen(b);
    paramView.getLocationOnScreen(e);
    paramView = e;
    int j = paramView[0];
    localObject2 = b;
    paramView[0] = (j - localObject2[0]);
    paramView[1] -= localObject2[1];
    x = (paramView[0] + paramInt1 - ((View)localObject1).getWidth() / 2);
    paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    h.measure(paramInt1, paramInt1);
    paramInt1 = h.getMeasuredHeight();
    paramView = e;
    i = paramView[1] + i - k - paramInt1;
    paramInt2 = paramView[1] + paramInt2 + k;
    if (paramBoolean)
    {
      if (i >= 0)
      {
        y = i;
        return;
      }
      y = paramInt2;
      return;
    }
    if (paramInt1 + paramInt2 <= a.height())
    {
      y = paramInt2;
      return;
    }
    y = i;
  }
  
  void a()
  {
    if (!b()) {
      return;
    }
    ((WindowManager)c.getSystemService("window")).removeView(h);
  }
  
  void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean, CharSequence paramCharSequence)
  {
    if (b()) {
      a();
    }
    g.setText(paramCharSequence);
    show(paramView, paramInt1, paramInt2, paramBoolean, f);
    ((WindowManager)c.getSystemService("window")).addView(h, f);
  }
  
  boolean b()
  {
    return h.getParent() != null;
  }
}
