package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.f;
import v7.internal.R.attr;
import v7.internal.R.id;
import v7.internal.R.layout;
import v7.internal.R.styleable;
import v7.internal.view.ActionMode;
import v7.v7.package_13.ViewCompat;

public class ActionBarContextView
  extends AbsActionBarView
{
  private View mClose;
  private int mCloseItemLayout;
  private View mCustomView;
  private CharSequence mSubtitle;
  private int mSubtitleStyleRes;
  private TextView mSubtitleView;
  private CharSequence mTitle;
  private LinearLayout mTitleLayout;
  private boolean mTitleOptional;
  private int mTitleStyleRes;
  private TextView mTitleView;
  private View unreadFrame;
  
  public ActionBarContextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.description);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.ActionMode, paramInt, 0);
    ViewCompat.setBackgroundDrawable(this, paramContext.getDrawable(R.styleable.ActionMode_background));
    mTitleStyleRes = paramContext.getResourceId(R.styleable.ActionMode_titleTextStyle, 0);
    mSubtitleStyleRes = paramContext.getResourceId(R.styleable.ActionMode_subtitleTextStyle, 0);
    mContentHeight = paramContext.getLayoutDimension(R.styleable.Spinner_android_dropDownWidth, 0);
    mCloseItemLayout = paramContext.getResourceId(R.styleable.Spinner_android_popupBackground, R.layout.TextAppearance_AppCompat_Widget_ActionBar_Title);
    paramContext.recycle();
  }
  
  private void initTitle()
  {
    if (mTitleLayout == null)
    {
      LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
      localObject = (LinearLayout)getChildAt(getChildCount() - 1);
      mTitleLayout = ((LinearLayout)localObject);
      mTitleView = ((TextView)((View)localObject).findViewById(R.id.action_bar_title));
      mSubtitleView = ((TextView)mTitleLayout.findViewById(R.id.action_bar_subtitle));
      if (mTitleStyleRes != 0) {
        mTitleView.setTextAppearance(getContext(), mTitleStyleRes);
      }
      if (mSubtitleStyleRes != 0) {
        mSubtitleView.setTextAppearance(getContext(), mSubtitleStyleRes);
      }
    }
    mTitleView.setText(mTitle);
    mSubtitleView.setText(mSubtitle);
    boolean bool2 = TextUtils.isEmpty(mTitle);
    boolean bool1 = TextUtils.isEmpty(mSubtitle) ^ true;
    Object localObject = mSubtitleView;
    int j = 0;
    if (bool1) {
      i = 0;
    } else {
      i = 8;
    }
    ((View)localObject).setVisibility(i);
    localObject = mTitleLayout;
    int i = j;
    if (!(bool2 ^ true)) {
      if (bool1) {
        i = j;
      } else {
        i = 8;
      }
    }
    ((View)localObject).setVisibility(i);
    if (mTitleLayout.getParent() == null) {
      addView(mTitleLayout);
    }
  }
  
  public void closeMode()
  {
    if (mClose == null) {
      killMode();
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.MarginLayoutParams(-1, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
  }
  
  public CharSequence getSubtitle()
  {
    return mSubtitle;
  }
  
  public CharSequence getTitle()
  {
    return mTitle;
  }
  
  public void initForMode(final ActionMode paramActionMode)
  {
    Object localObject = mClose;
    if (localObject == null)
    {
      localObject = LayoutInflater.from(getContext()).inflate(mCloseItemLayout, this, false);
      mClose = ((View)localObject);
      addView((View)localObject);
    }
    else if (((View)localObject).getParent() == null)
    {
      addView(mClose);
    }
    localObject = mClose.findViewById(R.id.action_mode_close_button);
    unreadFrame = ((View)localObject);
    ((View)localObject).setOnClickListener(new a(paramActionMode));
    paramActionMode = (f)paramActionMode.getMenu();
    localObject = mActionMenuPresenter;
    if (localObject != null) {
      ((ActionMenuPresenter)localObject).dismissPopupMenus();
    }
    localObject = new ActionMenuPresenter(getContext());
    mActionMenuPresenter = ((ActionMenuPresenter)localObject);
    ((ActionMenuPresenter)localObject).setReserveOverflow(true);
    localObject = new ViewGroup.LayoutParams(-2, -1);
    paramActionMode.addMenuPresenter(mActionMenuPresenter, mPopupContext);
    paramActionMode = (ActionMenuView)mActionMenuPresenter.getMenuView(this);
    mMenuView = paramActionMode;
    ViewCompat.setBackgroundDrawable(paramActionMode, null);
    addView(mMenuView, (ViewGroup.LayoutParams)localObject);
  }
  
  public boolean isTitleOptional()
  {
    return mTitleOptional;
  }
  
  public void killMode()
  {
    removeAllViews();
    mCustomView = null;
    mMenuView = null;
    mActionMenuPresenter = null;
    View localView = unreadFrame;
    if (localView != null) {
      localView.setOnClickListener(null);
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ActionMenuPresenter localActionMenuPresenter = mActionMenuPresenter;
    if (localActionMenuPresenter != null)
    {
      localActionMenuPresenter.hideOverflowMenu();
      mActionMenuPresenter.hideSubMenus();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramBoolean = ViewUtils.isLayoutRtl(this);
    if (paramBoolean) {
      i = paramInt3 - paramInt1 - getPaddingRight();
    } else {
      i = getPaddingLeft();
    }
    int j = getPaddingTop();
    int k = paramInt4 - paramInt2 - getPaddingTop() - getPaddingBottom();
    Object localObject = mClose;
    paramInt2 = i;
    if (localObject != null)
    {
      paramInt2 = i;
      if (((View)localObject).getVisibility() != 8)
      {
        localObject = (ViewGroup.MarginLayoutParams)mClose.getLayoutParams();
        if (paramBoolean) {
          paramInt2 = rightMargin;
        } else {
          paramInt2 = leftMargin;
        }
        if (paramBoolean) {
          paramInt4 = leftMargin;
        } else {
          paramInt4 = rightMargin;
        }
        paramInt2 = AbsActionBarView.next(i, paramInt2, paramBoolean);
        paramInt2 = AbsActionBarView.next(paramInt2 + positionChild(mClose, paramInt2, j, k, paramBoolean), paramInt4, paramBoolean);
      }
    }
    paramInt4 = paramInt2;
    localObject = mTitleLayout;
    int i = paramInt4;
    if (localObject != null)
    {
      i = paramInt4;
      if (mCustomView == null)
      {
        i = paramInt4;
        if (((View)localObject).getVisibility() != 8) {
          i = paramInt2 + positionChild(mTitleLayout, paramInt2, j, k, paramBoolean);
        }
      }
    }
    localObject = mCustomView;
    if (localObject != null) {
      positionChild((View)localObject, i, j, k, paramBoolean);
    }
    if (paramBoolean) {
      paramInt1 = getPaddingLeft();
    } else {
      paramInt1 = paramInt3 - paramInt1 - getPaddingRight();
    }
    localObject = mMenuView;
    if (localObject != null) {
      positionChild((View)localObject, paramInt1, j, k, paramBoolean ^ true);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int k = 1073741824;
    if (i == 1073741824)
    {
      if (View.MeasureSpec.getMode(paramInt2) != 0)
      {
        int i1 = View.MeasureSpec.getSize(paramInt1);
        i = mContentHeight;
        if (i <= 0) {
          i = View.MeasureSpec.getSize(paramInt2);
        }
        int i2 = getPaddingTop() + getPaddingBottom();
        paramInt1 = i1 - getPaddingLeft() - getPaddingRight();
        int n = i - i2;
        int j = View.MeasureSpec.makeMeasureSpec(n, Integer.MIN_VALUE);
        localObject = mClose;
        int m = 0;
        paramInt2 = paramInt1;
        if (localObject != null)
        {
          paramInt1 = measureChildView((View)localObject, paramInt1, j, 0);
          localObject = (ViewGroup.MarginLayoutParams)mClose.getLayoutParams();
          paramInt2 = paramInt1 - (leftMargin + rightMargin);
        }
        localObject = mMenuView;
        paramInt1 = paramInt2;
        if (localObject != null)
        {
          paramInt1 = paramInt2;
          if (((View)localObject).getParent() == this) {
            paramInt1 = measureChildView(mMenuView, paramInt2, j, 0);
          }
        }
        localObject = mTitleLayout;
        paramInt2 = paramInt1;
        int i3;
        if (localObject != null)
        {
          paramInt2 = paramInt1;
          if (mCustomView == null) {
            if (mTitleOptional)
            {
              paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
              mTitleLayout.measure(paramInt2, j);
              i3 = mTitleLayout.getMeasuredWidth();
              if (i3 <= paramInt1) {
                j = 1;
              } else {
                j = 0;
              }
              paramInt2 = paramInt1;
              if (j != 0) {
                paramInt2 = paramInt1 - i3;
              }
              localObject = mTitleLayout;
              if (j != 0) {
                paramInt1 = 0;
              } else {
                paramInt1 = 8;
              }
              ((View)localObject).setVisibility(paramInt1);
            }
            else
            {
              paramInt2 = measureChildView((View)localObject, paramInt1, j, 0);
            }
          }
        }
        localObject = mCustomView;
        if (localObject != null)
        {
          localObject = ((View)localObject).getLayoutParams();
          i3 = width;
          if (i3 != -2) {
            paramInt1 = 1073741824;
          } else {
            paramInt1 = Integer.MIN_VALUE;
          }
          j = paramInt2;
          if (i3 >= 0) {
            j = Math.min(i3, paramInt2);
          }
          i3 = height;
          if (i3 != -2) {
            paramInt2 = k;
          } else {
            paramInt2 = Integer.MIN_VALUE;
          }
          k = n;
          if (i3 >= 0) {
            k = Math.min(i3, n);
          }
          mCustomView.measure(View.MeasureSpec.makeMeasureSpec(j, paramInt1), View.MeasureSpec.makeMeasureSpec(k, paramInt2));
        }
        if (mContentHeight <= 0)
        {
          k = getChildCount();
          paramInt2 = 0;
          paramInt1 = m;
          while (paramInt1 < k)
          {
            j = getChildAt(paramInt1).getMeasuredHeight() + i2;
            i = paramInt2;
            if (j > paramInt2) {
              i = j;
            }
            paramInt1 += 1;
            paramInt2 = i;
          }
          setMeasuredDimension(i1, paramInt2);
          return;
        }
        setMeasuredDimension(i1, i);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getClass().getSimpleName());
      ((StringBuilder)localObject).append(" can only be used with android:layout_height=\"wrap_content\"");
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getClass().getSimpleName());
    ((StringBuilder)localObject).append(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void setContentHeight(int paramInt)
  {
    mContentHeight = paramInt;
  }
  
  public void setCustomView(View paramView)
  {
    Object localObject = mCustomView;
    if (localObject != null) {
      removeView((View)localObject);
    }
    mCustomView = paramView;
    if (paramView != null)
    {
      localObject = mTitleLayout;
      if (localObject != null)
      {
        removeView((View)localObject);
        mTitleLayout = null;
      }
    }
    if (paramView != null) {
      addView(paramView);
    }
    requestLayout();
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    mSubtitle = paramCharSequence;
    initTitle();
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    mTitle = paramCharSequence;
    initTitle();
    ViewCompat.b(this, paramCharSequence);
  }
  
  public void setTitleOptional(boolean paramBoolean)
  {
    if (paramBoolean != mTitleOptional) {
      requestLayout();
    }
    mTitleOptional = paramBoolean;
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public boolean showOverflowMenu()
  {
    ActionMenuPresenter localActionMenuPresenter = mActionMenuPresenter;
    if (localActionMenuPresenter != null) {
      return localActionMenuPresenter.showOverflowMenu();
    }
    return false;
  }
  
  class a
    implements View.OnClickListener
  {
    a(ActionMode paramActionMode) {}
    
    public void onClick(View paramView)
    {
      paramActionMode.finish();
    }
  }
}
