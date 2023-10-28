package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import androidx.core.widget.PopupWindowCompat;
import java.lang.reflect.Method;
import v7.internal.R.attr;
import v7.internal.R.styleable;
import v7.v7.package_13.ViewCompat;

public class ListPopupWindow
  implements androidx.appcompat.view.menu.ListPopupWindow
{
  private static Method sClipToWindowEnabledMethod;
  private static Method sComputeFitSystemWindowsMethod;
  private static Method sGetMaxAvailableHeightMethod;
  private boolean info;
  private ListAdapter mAdapter;
  private Rect mAnchorView;
  private Context mContext;
  private boolean mDropDownAlwaysVisible = false;
  private View mDropDownAnchorView;
  private int mDropDownGravity = 0;
  private int mDropDownHeight = -2;
  private int mDropDownHorizontalOffset;
  ListViewCompat mDropDownList;
  private Drawable mDropDownListHighlight;
  private int mDropDownVerticalOffset;
  private boolean mDropDownVerticalOffsetSet;
  private int mDropDownWidth = -2;
  private int mDropDownWindowLayoutType = 1002;
  private boolean mForceIgnoreOutsideTouch = false;
  final Handler mHandler;
  private final e mHideSelector = new e();
  private AdapterView.OnItemClickListener mItemClickListener;
  private AdapterView.OnItemSelectedListener mItemSelectedListener;
  int mListItemExpandMaximum = Integer.MAX_VALUE;
  private boolean mModal;
  private DataSetObserver mObserver;
  PopupWindow mPopup;
  private boolean mPostedShow;
  private int mPromptPosition = 0;
  private View mPromptView;
  final i mRunnable = new i();
  private final g mScrollListener = new g();
  private Runnable mShowDropDownRunnable;
  private final Rect mTempRect = new Rect();
  private final h mTouchInterceptor = new h();
  
  static
  {
    Object localObject;
    if (Build.VERSION.SDK_INT <= 28) {
      localObject = Boolean.TYPE;
    }
    try
    {
      localObject = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[] { localObject });
      sClipToWindowEnabledMethod = (Method)localObject;
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      for (;;) {}
    }
    Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
    try
    {
      localObject = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[] { Rect.class });
      sGetMaxAvailableHeightMethod = (Method)localObject;
    }
    catch (NoSuchMethodException localNoSuchMethodException2)
    {
      Class localClass;
      for (;;) {}
    }
    Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
    if (Build.VERSION.SDK_INT <= 23)
    {
      localObject = Integer.TYPE;
      localClass = Boolean.TYPE;
      try
      {
        localObject = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[] { View.class, localObject, localClass });
        sComputeFitSystemWindowsMethod = (Method)localObject;
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException3)
      {
        for (;;) {}
      }
      Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
      return;
    }
  }
  
  public ListPopupWindow(Context paramContext)
  {
    this(paramContext, null, R.attr.F);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    mContext = paramContext;
    mHandler = new Handler(paramContext.getMainLooper());
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SherlockActivityChooserView, paramInt1, paramInt2);
    mDropDownHorizontalOffset = localTypedArray.getDimensionPixelOffset(R.styleable.SherlockActivityChooserView_initialActivityCount, 0);
    int i = localTypedArray.getDimensionPixelOffset(R.styleable.SherlockActivityChooserView_expandActivityOverflowButtonDrawable, 0);
    mDropDownVerticalOffset = i;
    if (i != 0) {
      mDropDownVerticalOffsetSet = true;
    }
    localTypedArray.recycle();
    paramContext = new AppCompatPopupWindow(paramContext, paramAttributeSet, paramInt1, paramInt2);
    mPopup = paramContext;
    paramContext.setInputMethodMode(1);
  }
  
  private int buildDropDown()
  {
    Object localObject1 = mDropDownList;
    boolean bool = true;
    Object localObject2;
    int i;
    int j;
    if (localObject1 == null)
    {
      localObject1 = mContext;
      mShowDropDownRunnable = new a();
      localObject2 = show((Context)localObject1, mModal ^ true);
      mDropDownList = ((ListViewCompat)localObject2);
      Object localObject3 = mDropDownListHighlight;
      if (localObject3 != null) {
        ((ListViewCompat)localObject2).setSelector((Drawable)localObject3);
      }
      mDropDownList.setAdapter(mAdapter);
      mDropDownList.setOnItemClickListener(mItemClickListener);
      mDropDownList.setFocusable(true);
      mDropDownList.setFocusableInTouchMode(true);
      mDropDownList.setOnItemSelectedListener(new b());
      mDropDownList.setOnScrollListener(mScrollListener);
      localObject2 = mItemSelectedListener;
      if (localObject2 != null) {
        mDropDownList.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)localObject2);
      }
      localObject2 = mDropDownList;
      localObject3 = mPromptView;
      if (localObject3 != null)
      {
        localObject1 = new LinearLayout((Context)localObject1);
        ((LinearLayout)localObject1).setOrientation(1);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0F);
        i = mPromptPosition;
        if (i != 0)
        {
          if (i != 1)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("Invalid hint position ");
            ((StringBuilder)localObject2).append(mPromptPosition);
            Log.e("ListPopupWindow", ((StringBuilder)localObject2).toString());
          }
          else
          {
            ((ViewGroup)localObject1).addView((View)localObject2, localLayoutParams);
            ((ViewGroup)localObject1).addView((View)localObject3);
          }
        }
        else
        {
          ((ViewGroup)localObject1).addView((View)localObject3);
          ((ViewGroup)localObject1).addView((View)localObject2, localLayoutParams);
        }
        i = mDropDownWidth;
        if (i >= 0)
        {
          j = Integer.MIN_VALUE;
        }
        else
        {
          i = 0;
          j = 0;
        }
        ((View)localObject3).measure(View.MeasureSpec.makeMeasureSpec(i, j), 0);
        localObject2 = (LinearLayout.LayoutParams)((View)localObject3).getLayoutParams();
        i = ((View)localObject3).getMeasuredHeight() + topMargin + bottomMargin;
      }
      else
      {
        i = 0;
        localObject1 = localObject2;
      }
      mPopup.setContentView((View)localObject1);
    }
    else
    {
      localObject1 = (ViewGroup)mPopup.getContentView();
      localObject1 = mPromptView;
      if (localObject1 != null)
      {
        localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
        i = ((View)localObject1).getMeasuredHeight() + topMargin + bottomMargin;
      }
      else
      {
        i = 0;
      }
    }
    localObject1 = mPopup.getBackground();
    int k;
    if (localObject1 != null)
    {
      ((Drawable)localObject1).getPadding(mTempRect);
      localObject1 = mTempRect;
      m = top;
      j = bottom + m;
      k = j;
      if (!mDropDownVerticalOffsetSet)
      {
        mDropDownVerticalOffset = (-m);
        k = j;
      }
    }
    else
    {
      mTempRect.setEmpty();
      k = 0;
    }
    if (mPopup.getInputMethodMode() != 2) {
      bool = false;
    }
    int m = getMaxAvailableHeight(getAnchorView(), mDropDownVerticalOffset, bool);
    if ((!mDropDownAlwaysVisible) && (mDropDownHeight != -1))
    {
      j = mDropDownWidth;
      if (j != -2)
      {
        if (j != -1)
        {
          j = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
        }
        else
        {
          j = mContext.getResources().getDisplayMetrics().widthPixels;
          localObject1 = mTempRect;
          j = View.MeasureSpec.makeMeasureSpec(j - (left + right), 1073741824);
        }
      }
      else
      {
        j = mContext.getResources().getDisplayMetrics().widthPixels;
        localObject1 = mTempRect;
        j = View.MeasureSpec.makeMeasureSpec(j - (left + right), Integer.MIN_VALUE);
      }
      m = mDropDownList.measureHeightOfChildrenCompat(j, 0, -1, m - i, -1);
      j = i;
      if (m > 0) {
        j = i + (k + (mDropDownList.getPaddingTop() + mDropDownList.getPaddingBottom()));
      }
      return m + j;
    }
    return m + k;
  }
  
  private int getMaxAvailableHeight(View paramView, int paramInt, boolean paramBoolean)
  {
    Object localObject;
    PopupWindow localPopupWindow;
    if (Build.VERSION.SDK_INT <= 23)
    {
      localObject = sComputeFitSystemWindowsMethod;
      if (localObject != null) {
        localPopupWindow = mPopup;
      }
    }
    try
    {
      localObject = ((Method)localObject).invoke(localPopupWindow, new Object[] { paramView, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
      localObject = (Integer)localObject;
      int i = ((Integer)localObject).intValue();
      return i;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
    return mPopup.getMaxAvailableHeight(paramView, paramInt);
    return c.getMaxAvailableHeight(mPopup, paramView, paramInt, paramBoolean);
  }
  
  private void removePromptView()
  {
    Object localObject = mPromptView;
    if (localObject != null)
    {
      localObject = ((View)localObject).getParent();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).removeView(mPromptView);
      }
    }
  }
  
  private void setPopupClipToScreenEnabled(boolean paramBoolean)
  {
    Method localMethod;
    PopupWindow localPopupWindow;
    if (Build.VERSION.SDK_INT <= 28)
    {
      localMethod = sClipToWindowEnabledMethod;
      if (localMethod != null) {
        localPopupWindow = mPopup;
      }
    }
    else
    {
      try
      {
        localMethod.invoke(localPopupWindow, new Object[] { Boolean.valueOf(paramBoolean) });
        return;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
      Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
      return;
      d.showAsDropDown(mPopup, paramBoolean);
      return;
    }
  }
  
  public void clearListSelection()
  {
    ListViewCompat localListViewCompat = mDropDownList;
    if (localListViewCompat != null)
    {
      localListViewCompat.setListSelectionHidden(true);
      localListViewCompat.requestLayout();
    }
  }
  
  public void dismiss()
  {
    mPopup.dismiss();
    removePromptView();
    mPopup.setContentView(null);
    mDropDownList = null;
    mHandler.removeCallbacks(mRunnable);
  }
  
  public void dismiss(int paramInt)
  {
    mDropDownGravity = paramInt;
  }
  
  public View getAnchorView()
  {
    return mDropDownAnchorView;
  }
  
  public Drawable getBackground()
  {
    return mPopup.getBackground();
  }
  
  public int getHorizontalOffset()
  {
    return mDropDownHorizontalOffset;
  }
  
  public ListView getListView()
  {
    return mDropDownList;
  }
  
  public Object getSelectedItem()
  {
    if (!isShowing()) {
      return null;
    }
    return mDropDownList.getSelectedItem();
  }
  
  public long getSelectedItemId()
  {
    if (!isShowing()) {
      return Long.MIN_VALUE;
    }
    return mDropDownList.getSelectedItemId();
  }
  
  public int getSelectedItemPosition()
  {
    if (!isShowing()) {
      return -1;
    }
    return mDropDownList.getSelectedItemPosition();
  }
  
  public View getSelectedView()
  {
    if (!isShowing()) {
      return null;
    }
    return mDropDownList.getSelectedView();
  }
  
  public int getVerticalOffset()
  {
    if (!mDropDownVerticalOffsetSet) {
      return 0;
    }
    return mDropDownVerticalOffset;
  }
  
  public int getWidth()
  {
    return mDropDownWidth;
  }
  
  public boolean isInputMethodNotNeeded()
  {
    return mPopup.getInputMethodMode() == 2;
  }
  
  public boolean isModal()
  {
    return mModal;
  }
  
  public boolean isShowing()
  {
    return mPopup.isShowing();
  }
  
  public void setAdapter(View paramView)
  {
    mDropDownAnchorView = paramView;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    DataSetObserver localDataSetObserver = mObserver;
    if (localDataSetObserver == null)
    {
      mObserver = new f();
    }
    else
    {
      ListAdapter localListAdapter = mAdapter;
      if (localListAdapter != null) {
        localListAdapter.unregisterDataSetObserver(localDataSetObserver);
      }
    }
    mAdapter = paramListAdapter;
    if (paramListAdapter != null) {
      paramListAdapter.registerDataSetObserver(mObserver);
    }
    paramListAdapter = mDropDownList;
    if (paramListAdapter != null) {
      paramListAdapter.setAdapter(mAdapter);
    }
  }
  
  public void setAnimationStyle(int paramInt)
  {
    mPopup.setAnimationStyle(paramInt);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    mPopup.setBackgroundDrawable(paramDrawable);
  }
  
  public void setContentWidth(int paramInt)
  {
    Object localObject = mPopup.getBackground();
    if (localObject != null)
    {
      ((Drawable)localObject).getPadding(mTempRect);
      localObject = mTempRect;
      mDropDownWidth = (left + right + paramInt);
      return;
    }
    setWidth(paramInt);
  }
  
  public void setHorizontalOffset(int paramInt)
  {
    mDropDownHorizontalOffset = paramInt;
  }
  
  public void setModal(boolean paramBoolean)
  {
    mModal = paramBoolean;
    mPopup.setFocusable(paramBoolean);
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    mPopup.setOnDismissListener(paramOnDismissListener);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    mItemClickListener = paramOnItemClickListener;
  }
  
  public void setPromptPosition(int paramInt)
  {
    mPromptPosition = paramInt;
  }
  
  public void setSelection(int paramInt)
  {
    ListViewCompat localListViewCompat = mDropDownList;
    if ((isShowing()) && (localListViewCompat != null))
    {
      localListViewCompat.setListSelectionHidden(false);
      localListViewCompat.setSelection(paramInt);
      if (localListViewCompat.getChoiceMode() != 0) {
        localListViewCompat.setItemChecked(paramInt, true);
      }
    }
  }
  
  public void setVerticalOffset(int paramInt)
  {
    mDropDownVerticalOffset = paramInt;
    mDropDownVerticalOffsetSet = true;
  }
  
  public void setWidth(int paramInt)
  {
    mDropDownWidth = paramInt;
  }
  
  ListViewCompat show(Context paramContext, boolean paramBoolean)
  {
    return new ListViewCompat(paramContext, paramBoolean);
  }
  
  public void show()
  {
    int j = buildDropDown();
    boolean bool2 = isInputMethodNotNeeded();
    PopupWindowCompat.setWindowLayoutType(mPopup, mDropDownWindowLayoutType);
    boolean bool3 = mPopup.isShowing();
    boolean bool1 = true;
    int i;
    Object localObject2;
    if (bool3)
    {
      if (!ViewCompat.d(getAnchorView())) {
        return;
      }
      k = mDropDownWidth;
      if (k == -1)
      {
        i = -1;
      }
      else
      {
        i = k;
        if (k == -2) {
          i = getAnchorView().getWidth();
        }
      }
      k = mDropDownHeight;
      if (k == -1)
      {
        if (!bool2) {
          j = -1;
        }
        if (bool2)
        {
          localObject1 = mPopup;
          if (mDropDownWidth == -1) {
            k = -1;
          } else {
            k = 0;
          }
          ((PopupWindow)localObject1).setWidth(k);
          mPopup.setHeight(0);
        }
        else
        {
          localObject1 = mPopup;
          if (mDropDownWidth == -1) {
            k = -1;
          } else {
            k = 0;
          }
          ((PopupWindow)localObject1).setWidth(k);
          mPopup.setHeight(-1);
        }
      }
      else if (k != -2)
      {
        j = k;
      }
      localObject1 = mPopup;
      if ((mForceIgnoreOutsideTouch) || (mDropDownAlwaysVisible)) {
        bool1 = false;
      }
      ((PopupWindow)localObject1).setOutsideTouchable(bool1);
      localObject1 = mPopup;
      localObject2 = getAnchorView();
      int m = mDropDownHorizontalOffset;
      int n = mDropDownVerticalOffset;
      k = i;
      if (i < 0) {
        k = -1;
      }
      i = j;
      if (j < 0) {
        i = -1;
      }
      ((PopupWindow)localObject1).update((View)localObject2, m, n, k, i);
      return;
    }
    int k = mDropDownWidth;
    if (k == -1)
    {
      i = -1;
    }
    else
    {
      i = k;
      if (k == -2) {
        i = getAnchorView().getWidth();
      }
    }
    k = mDropDownHeight;
    if (k == -1) {
      j = -1;
    } else if (k != -2) {
      j = k;
    }
    mPopup.setWidth(i);
    mPopup.setHeight(j);
    setPopupClipToScreenEnabled(true);
    Object localObject1 = mPopup;
    if ((!mForceIgnoreOutsideTouch) && (!mDropDownAlwaysVisible)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((PopupWindow)localObject1).setOutsideTouchable(bool1);
    mPopup.setTouchInterceptor(mTouchInterceptor);
    if (mPostedShow) {
      PopupWindowCompat.init(mPopup, info);
    }
    if (Build.VERSION.SDK_INT <= 28)
    {
      localObject1 = sGetMaxAvailableHeightMethod;
      if (localObject1 != null)
      {
        localObject2 = mPopup;
        Rect localRect = mAnchorView;
        try
        {
          ((Method)localObject1).invoke(localObject2, new Object[] { localRect });
        }
        catch (Exception localException)
        {
          Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", localException);
        }
      }
    }
    else
    {
      d.showAsDropDown(mPopup, mAnchorView);
    }
    PopupWindowCompat.update(mPopup, getAnchorView(), mDropDownHorizontalOffset, mDropDownVerticalOffset, mDropDownGravity);
    mDropDownList.setSelection(-1);
    if ((!mModal) || (mDropDownList.isInTouchMode())) {
      clearListSelection();
    }
    if (!mModal) {
      mHandler.post(mHideSelector);
    }
  }
  
  public void show(int paramInt)
  {
    mPopup.setInputMethodMode(paramInt);
  }
  
  public void show(Rect paramRect)
  {
    if (paramRect != null) {
      paramRect = new Rect(paramRect);
    } else {
      paramRect = null;
    }
    mAnchorView = paramRect;
  }
  
  public void show(boolean paramBoolean)
  {
    mPostedShow = true;
    info = paramBoolean;
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      View localView = getAnchorView();
      if ((localView != null) && (localView.getWindowToken() != null)) {
        show();
      }
    }
  }
  
  class b
    implements AdapterView.OnItemSelectedListener
  {
    b() {}
    
    public void onItemSelected(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      if (paramInt != -1)
      {
        paramAdapterView = mDropDownList;
        if (paramAdapterView != null) {
          paramAdapterView.setListSelectionHidden(false);
        }
      }
    }
    
    public void onNothingSelected(AdapterView paramAdapterView) {}
  }
  
  static class c
  {
    static int getMaxAvailableHeight(PopupWindow paramPopupWindow, View paramView, int paramInt, boolean paramBoolean)
    {
      return paramPopupWindow.getMaxAvailableHeight(paramView, paramInt, paramBoolean);
    }
  }
  
  static class d
  {
    static void showAsDropDown(PopupWindow paramPopupWindow, Rect paramRect)
    {
      paramPopupWindow.setEpicenterBounds(paramRect);
    }
    
    static void showAsDropDown(PopupWindow paramPopupWindow, boolean paramBoolean)
    {
      paramPopupWindow.setIsClippedToScreen(paramBoolean);
    }
  }
  
  private class e
    implements Runnable
  {
    e() {}
    
    public void run()
    {
      clearListSelection();
    }
  }
  
  private class f
    extends DataSetObserver
  {
    f() {}
    
    public void onChanged()
    {
      if (isShowing()) {
        show();
      }
    }
    
    public void onInvalidated()
    {
      dismiss();
    }
  }
  
  private class g
    implements AbsListView.OnScrollListener
  {
    g() {}
    
    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      if ((paramInt == 1) && (!isInputMethodNotNeeded()) && (mPopup.getContentView() != null))
      {
        paramAbsListView = ListPopupWindow.this;
        mHandler.removeCallbacks(mRunnable);
        mRunnable.run();
      }
    }
  }
  
  private class h
    implements View.OnTouchListener
  {
    h() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      int i = paramMotionEvent.getAction();
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      if (i == 0)
      {
        paramView = mPopup;
        if ((paramView != null) && (paramView.isShowing()) && (j >= 0) && (j < mPopup.getWidth()) && (k >= 0) && (k < mPopup.getHeight()))
        {
          paramView = ListPopupWindow.this;
          mHandler.postDelayed(mRunnable, 250L);
          break label126;
        }
      }
      if (i == 1)
      {
        paramView = ListPopupWindow.this;
        mHandler.removeCallbacks(mRunnable);
      }
      label126:
      return false;
    }
  }
  
  private class i
    implements Runnable
  {
    i() {}
    
    public void run()
    {
      Object localObject = mDropDownList;
      if ((localObject != null) && (ViewCompat.d((View)localObject)) && (mDropDownList.getCount() > mDropDownList.getChildCount()))
      {
        int i = mDropDownList.getChildCount();
        localObject = ListPopupWindow.this;
        if (i <= mListItemExpandMaximum)
        {
          mPopup.setInputMethodMode(2);
          show();
        }
      }
    }
  }
}
