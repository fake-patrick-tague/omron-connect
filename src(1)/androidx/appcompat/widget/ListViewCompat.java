package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.AutoScrollHelper;
import androidx.core.widget.ListViewAutoScrollHelper;
import v7.internal.R.attr;
import v7.internal.text.drawable.DrawableWrapper;
import v7.v7.package_13.ViewPropertyAnimatorCompat;

class ListViewCompat
  extends ListView
{
  NumberPicker a;
  private ViewPropertyAnimatorCompat mClickAnimation;
  private boolean mDrawsInPressedState;
  private boolean mHijackFocus;
  private boolean mListSelectionHidden;
  private int mMotionPosition;
  private ListViewAutoScrollHelper mScrollHelper;
  private int mSelectionBottomPadding = 0;
  private int mSelectionLeftPadding = 0;
  private int mSelectionRightPadding = 0;
  private int mSelectionTopPadding = 0;
  private GateKeeperDrawable mSelector;
  private final Rect mSelectorRect = new Rect();
  
  ListViewCompat(android.content.Context paramContext, boolean paramBoolean)
  {
    super(paramContext, null, R.attr.switchPreferenceStyle);
    mHijackFocus = paramBoolean;
    setCacheColorHint(0);
  }
  
  private void b(boolean paramBoolean)
  {
    if (v7.v7.menu.Context.get())
    {
      d.c(this, paramBoolean);
      return;
    }
    l.a(this, paramBoolean);
  }
  
  private boolean b()
  {
    if (v7.v7.menu.Context.get()) {
      return d.c(this);
    }
    return l.a(this);
  }
  
  private void clearPressedItem()
  {
    mDrawsInPressedState = false;
    setPressed(false);
    drawableStateChanged();
    Object localObject = getChildAt(mMotionPosition - getFirstVisiblePosition());
    if (localObject != null) {
      ((View)localObject).setPressed(false);
    }
    localObject = mClickAnimation;
    if (localObject != null)
    {
      ((ViewPropertyAnimatorCompat)localObject).cancel();
      mClickAnimation = null;
    }
  }
  
  private void clickPressedItem(View paramView, int paramInt)
  {
    performItemClick(paramView, paramInt, getItemIdAtPosition(paramInt));
  }
  
  private void drawSelectorCompat(Canvas paramCanvas)
  {
    if (!mSelectorRect.isEmpty())
    {
      Drawable localDrawable = getSelector();
      if (localDrawable != null)
      {
        localDrawable.setBounds(mSelectorRect);
        localDrawable.draw(paramCanvas);
      }
    }
  }
  
  private void positionSelectorCompat(int paramInt, View paramView)
  {
    Rect localRect = mSelectorRect;
    localRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
    left -= mSelectionLeftPadding;
    top -= mSelectionTopPadding;
    right += mSelectionRightPadding;
    bottom += mSelectionBottomPadding;
    boolean bool = b();
    if (paramView.isEnabled() != bool)
    {
      b(bool ^ true);
      if (paramInt != -1) {
        refreshDrawableState();
      }
    }
  }
  
  private void positionSelectorLikeFocusCompat(int paramInt, View paramView)
  {
    Drawable localDrawable = getSelector();
    boolean bool = true;
    int i;
    if ((localDrawable != null) && (paramInt != -1)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      localDrawable.setVisible(false, false);
    }
    positionSelectorCompat(paramInt, paramView);
    if (i != 0)
    {
      paramView = mSelectorRect;
      float f1 = paramView.exactCenterX();
      float f2 = paramView.exactCenterY();
      if (getVisibility() != 0) {
        bool = false;
      }
      localDrawable.setVisible(bool, false);
      DrawableCompat.setHotspot(localDrawable, f1, f2);
    }
  }
  
  private void positionSelectorLikeTouchCompat(int paramInt, View paramView, float paramFloat1, float paramFloat2)
  {
    positionSelectorLikeFocusCompat(paramInt, paramView);
    paramView = getSelector();
    if ((paramView != null) && (paramInt != -1)) {
      DrawableCompat.setHotspot(paramView, paramFloat1, paramFloat2);
    }
  }
  
  private void setPressedItem(View paramView, int paramInt, float paramFloat1, float paramFloat2)
  {
    mDrawsInPressedState = true;
    int i = Build.VERSION.SDK_INT;
    if (i >= 21) {
      Handler.a(this, paramFloat1, paramFloat2);
    }
    if (!isPressed()) {
      setPressed(true);
    }
    layoutChildren();
    int j = mMotionPosition;
    if (j != -1)
    {
      View localView = getChildAt(j - getFirstVisiblePosition());
      if ((localView != null) && (localView != paramView) && (localView.isPressed())) {
        localView.setPressed(false);
      }
    }
    mMotionPosition = paramInt;
    float f1 = paramView.getLeft();
    float f2 = paramView.getTop();
    if (i >= 21) {
      Handler.a(paramView, paramFloat1 - f1, paramFloat2 - f2);
    }
    if (!paramView.isPressed()) {
      paramView.setPressed(true);
    }
    positionSelectorLikeTouchCompat(paramInt, paramView, paramFloat1, paramFloat2);
    setSelectorEnabled(false);
    refreshDrawableState();
  }
  
  private void setSelectorEnabled(boolean paramBoolean)
  {
    GateKeeperDrawable localGateKeeperDrawable = mSelector;
    if (localGateKeeperDrawable != null) {
      localGateKeeperDrawable.setEnabled(paramBoolean);
    }
  }
  
  private boolean touchModeDrawsInPressedStateCompat()
  {
    return mDrawsInPressedState;
  }
  
  private void updateSelectorStateCompat()
  {
    Drawable localDrawable = getSelector();
    if ((localDrawable != null) && (touchModeDrawsInPressedStateCompat()) && (isPressed())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    drawSelectorCompat(paramCanvas);
    super.dispatchDraw(paramCanvas);
  }
  
  protected void drawableStateChanged()
  {
    if (a != null) {
      return;
    }
    super.drawableStateChanged();
    setSelectorEnabled(true);
    updateSelectorStateCompat();
  }
  
  public boolean hasFocus()
  {
    return (mHijackFocus) || (super.hasFocus());
  }
  
  public boolean hasWindowFocus()
  {
    return (mHijackFocus) || (super.hasWindowFocus());
  }
  
  public boolean isFocused()
  {
    return (mHijackFocus) || (super.isFocused());
  }
  
  public boolean isInTouchMode()
  {
    return ((mHijackFocus) && (mListSelectionHidden)) || (super.isInTouchMode());
  }
  
  public int measureHeightOfChildrenCompat(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    paramInt2 = getListPaddingTop();
    int j = getListPaddingBottom();
    int i = getDividerHeight();
    paramInt3 = i;
    Object localObject = getDivider();
    ListAdapter localListAdapter = getAdapter();
    if (localListAdapter == null) {
      return paramInt2 + j;
    }
    paramInt2 += j;
    if ((i <= 0) || (localObject == null)) {
      paramInt3 = 0;
    }
    int i1 = localListAdapter.getCount();
    j = 0;
    int m = 0;
    i = 0;
    localObject = null;
    while (j < i1)
    {
      int n = localListAdapter.getItemViewType(j);
      int k = m;
      if (n != m)
      {
        localObject = null;
        k = n;
      }
      View localView = localListAdapter.getView(j, (View)localObject, this);
      localObject = localView;
      ViewGroup.LayoutParams localLayoutParams2 = localView.getLayoutParams();
      ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
      if (localLayoutParams2 == null)
      {
        localLayoutParams2 = generateDefaultLayoutParams();
        localLayoutParams1 = localLayoutParams2;
        localView.setLayoutParams(localLayoutParams2);
      }
      m = height;
      if (m > 0) {
        m = View.MeasureSpec.makeMeasureSpec(m, 1073741824);
      } else {
        m = View.MeasureSpec.makeMeasureSpec(0, 0);
      }
      localView.measure(paramInt1, m);
      localView.forceLayout();
      m = paramInt2;
      if (j > 0) {
        m = paramInt2 + paramInt3;
      }
      m += localView.getMeasuredHeight();
      paramInt2 = m;
      if (m >= paramInt4)
      {
        if ((paramInt5 < 0) || (j <= paramInt5) || (i <= 0) || (paramInt2 == paramInt4)) {
          break label316;
        }
        return i;
      }
      n = i;
      if (paramInt5 >= 0)
      {
        n = i;
        if (j >= paramInt5) {
          n = paramInt2;
        }
      }
      j += 1;
      m = k;
      i = n;
    }
    return paramInt2;
    label316:
    return paramInt4;
  }
  
  protected void onDetachedFromWindow()
  {
    a = null;
    super.onDetachedFromWindow();
  }
  
  public boolean onForwardedEvent(MotionEvent paramMotionEvent, int paramInt)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i != 1) {
      if (i != 2) {
        if (i == 3) {}
      }
    }
    boolean bool;
    for (;;)
    {
      paramInt = 0;
      bool = true;
      break;
      label45:
      do
      {
        paramInt = 0;
        bool = false;
        break;
        bool = true;
        break label45;
        bool = false;
        j = paramMotionEvent.findPointerIndex(paramInt);
      } while (j < 0);
      paramInt = (int)paramMotionEvent.getX(j);
      int j = (int)paramMotionEvent.getY(j);
      int k = pointToPosition(paramInt, j);
      if (k == -1)
      {
        paramInt = 1;
        break;
      }
      View localView = getChildAt(k - getFirstVisiblePosition());
      setPressedItem(localView, k, paramInt, j);
      if (i == 1) {
        clickPressedItem(localView, k);
      }
    }
    if ((!bool) || (paramInt != 0)) {
      clearPressedItem();
    }
    if (bool)
    {
      if (mScrollHelper == null) {
        mScrollHelper = new ListViewAutoScrollHelper(this);
      }
      mScrollHelper.setEnabled(true);
      mScrollHelper.onTouch(this, paramMotionEvent);
      return bool;
    }
    paramMotionEvent = mScrollHelper;
    if (paramMotionEvent != null) {
      paramMotionEvent.setEnabled(false);
    }
    return bool;
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i = Build.VERSION.SDK_INT;
    if (i < 26) {
      return super.onHoverEvent(paramMotionEvent);
    }
    int j = paramMotionEvent.getActionMasked();
    if ((j == 10) && (a == null))
    {
      NumberPicker localNumberPicker = new NumberPicker(this);
      a = localNumberPicker;
      localNumberPicker.postChangeCurrentByOneFromLongPress();
    }
    boolean bool = super.onHoverEvent(paramMotionEvent);
    if ((j != 9) && (j != 7))
    {
      setSelection(-1);
      return bool;
    }
    j = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    if ((j != -1) && (j != getSelectedItemPosition()))
    {
      paramMotionEvent = getChildAt(j - getFirstVisiblePosition());
      if (paramMotionEvent.isEnabled())
      {
        requestFocus();
        if ((i >= 30) && (Frame.c())) {
          Frame.a(this, j, paramMotionEvent);
        } else {
          setSelectionFromTop(j, paramMotionEvent.getTop() - getTop());
        }
      }
      updateSelectorStateCompat();
    }
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      mMotionPosition = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
    NumberPicker localNumberPicker = a;
    if (localNumberPicker != null) {
      localNumberPicker.onTouchEvent();
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  void setListSelectionHidden(boolean paramBoolean)
  {
    mListSelectionHidden = paramBoolean;
  }
  
  public void setSelector(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      localObject = new GateKeeperDrawable(paramDrawable);
    } else {
      localObject = null;
    }
    mSelector = ((GateKeeperDrawable)localObject);
    super.setSelector((Drawable)localObject);
    Object localObject = new Rect();
    if (paramDrawable != null) {
      paramDrawable.getPadding((Rect)localObject);
    }
    mSelectionLeftPadding = left;
    mSelectionTopPadding = top;
    mSelectionRightPadding = right;
    mSelectionBottomPadding = bottom;
  }
  
  class GateKeeperDrawable
    extends DrawableWrapper
  {
    private boolean mEnabled = true;
    
    GateKeeperDrawable()
    {
      super();
    }
    
    public void draw(Canvas paramCanvas)
    {
      if (mEnabled) {
        super.draw(paramCanvas);
      }
    }
    
    void setEnabled(boolean paramBoolean)
    {
      mEnabled = paramBoolean;
    }
    
    public void setHotspot(float paramFloat1, float paramFloat2)
    {
      if (mEnabled) {
        super.setHotspot(paramFloat1, paramFloat2);
      }
    }
    
    public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (mEnabled) {
        super.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
      }
    }
    
    public boolean setState(int[] paramArrayOfInt)
    {
      if (mEnabled) {
        return super.setState(paramArrayOfInt);
      }
      return false;
    }
    
    public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
    {
      if (mEnabled) {
        return super.setVisible(paramBoolean1, paramBoolean2);
      }
      return false;
    }
  }
}
