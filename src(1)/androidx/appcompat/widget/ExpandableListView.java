package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnHoverListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import v7.v7.package_13.Frame;
import v7.v7.package_13.ViewCompat;

class ExpandableListView
  implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener
{
  private static ExpandableListView mAdapter;
  private static ExpandableListView timer;
  private final Runnable a = new DayFragment.1(this);
  private Label c;
  private final Runnable e = new EventInfoFragment.1(this);
  private final CharSequence s;
  private final int t;
  private final View this$0;
  private boolean value;
  private boolean w;
  private int x;
  private int y;
  
  private ExpandableListView(View paramView, CharSequence paramCharSequence)
  {
    this$0 = paramView;
    s = paramCharSequence;
    t = Frame.a(ViewConfiguration.get(paramView.getContext()));
    setLimit();
    paramView.setOnLongClickListener(this);
    paramView.setOnHoverListener(this);
  }
  
  private void clear()
  {
    this$0.removeCallbacks(a);
  }
  
  public static void init(View paramView, CharSequence paramCharSequence)
  {
    ExpandableListView localExpandableListView = mAdapter;
    if ((localExpandableListView != null) && (this$0 == paramView)) {
      setAdapter(null);
    }
    if (TextUtils.isEmpty(paramCharSequence))
    {
      paramCharSequence = timer;
      if ((paramCharSequence != null) && (this$0 == paramView)) {
        paramCharSequence.init();
      }
      paramView.setOnLongClickListener(null);
      paramView.setLongClickable(false);
      paramView.setOnHoverListener(null);
      return;
    }
    new ExpandableListView(paramView, paramCharSequence);
  }
  
  private boolean init(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    if ((!value) && (Math.abs(i - x) <= t) && (Math.abs(j - y) <= t)) {
      return false;
    }
    x = i;
    y = j;
    value = false;
    return true;
  }
  
  private void onTouchEvent()
  {
    this$0.postDelayed(a, ViewConfiguration.getLongPressTimeout());
  }
  
  private static void setAdapter(ExpandableListView paramExpandableListView)
  {
    ExpandableListView localExpandableListView = mAdapter;
    if (localExpandableListView != null) {
      localExpandableListView.clear();
    }
    mAdapter = paramExpandableListView;
    if (paramExpandableListView != null) {
      paramExpandableListView.onTouchEvent();
    }
  }
  
  private void setLimit()
  {
    value = true;
  }
  
  void init()
  {
    if (timer == this)
    {
      timer = null;
      Label localLabel = c;
      if (localLabel != null)
      {
        localLabel.a();
        c = null;
        setLimit();
        this$0.removeOnAttachStateChangeListener(this);
      }
      else
      {
        Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
      }
    }
    if (mAdapter == this) {
      setAdapter(null);
    }
    this$0.removeCallbacks(e);
  }
  
  void init(boolean paramBoolean)
  {
    if (!ViewCompat.d(this$0)) {
      return;
    }
    setAdapter(null);
    Object localObject = timer;
    if (localObject != null) {
      ((ExpandableListView)localObject).init();
    }
    timer = this;
    w = paramBoolean;
    localObject = new Label(this$0.getContext());
    c = ((Label)localObject);
    ((Label)localObject).a(this$0, x, y, w, s);
    this$0.addOnAttachStateChangeListener(this);
    long l;
    if (w)
    {
      l = 2500L;
    }
    else
    {
      int i;
      if ((ViewCompat.setElevation(this$0) & 0x1) == 1)
      {
        l = 3000L;
        i = ViewConfiguration.getLongPressTimeout();
      }
      else
      {
        l = 15000L;
        i = ViewConfiguration.getLongPressTimeout();
      }
      l -= i;
    }
    this$0.removeCallbacks(e);
    this$0.postDelayed(e, l);
  }
  
  public boolean onHover(View paramView, MotionEvent paramMotionEvent)
  {
    if ((c != null) && (w)) {
      return false;
    }
    paramView = (AccessibilityManager)this$0.getContext().getSystemService("accessibility");
    if ((paramView.isEnabled()) && (paramView.isTouchExplorationEnabled())) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if (i != 7)
    {
      if (i != 10) {
        return false;
      }
      setLimit();
      init();
      return false;
    }
    if ((this$0.isEnabled()) && (c == null) && (init(paramMotionEvent))) {
      setAdapter(this);
    }
    return false;
  }
  
  public boolean onLongClick(View paramView)
  {
    x = (paramView.getWidth() / 2);
    y = (paramView.getHeight() / 2);
    init(true);
    return true;
  }
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    init();
  }
}
