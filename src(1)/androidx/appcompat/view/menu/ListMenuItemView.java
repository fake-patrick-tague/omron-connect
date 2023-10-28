package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.AbsListView.SelectionBoundsAdjuster;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.widget.TintTypedArray;
import v7.internal.R.attr;
import v7.internal.R.id;
import v7.internal.R.layout;
import v7.internal.R.styleable;
import v7.v7.package_13.ViewCompat;

public class ListMenuItemView
  extends LinearLayout
  implements MenuView.ItemView, AbsListView.SelectionBoundsAdjuster
{
  private ImageView c;
  private Drawable close;
  private ImageView d;
  private LinearLayout f;
  private boolean i;
  private Drawable mBackground;
  private CheckBox mCheckBox;
  private boolean mForceShowIcon;
  private ImageView mIconView;
  private LayoutInflater mInflater;
  private MenuItemImpl mItemData;
  private boolean mPreserveIconSpacing;
  private RadioButton mRadioButton;
  private TextView mShortcutView;
  private int mTextAppearance;
  private Context mTextAppearanceContext;
  private TextView mTitleView;
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.H);
  }
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = TintTypedArray.obtainStyledAttributes(getContext(), paramAttributeSet, R.styleable.SherlockMenuView, paramInt, 0);
    mBackground = paramAttributeSet.getDrawable(R.styleable.SherlockMenuView_itemBackground);
    mTextAppearance = paramAttributeSet.getResourceId(R.styleable.SherlockMenuView_itemTextAppearance, -1);
    mPreserveIconSpacing = paramAttributeSet.getBoolean(R.styleable.SherlockMenuView_preserveIconSpacing, false);
    mTextAppearanceContext = paramContext;
    close = paramAttributeSet.getDrawable(R.styleable.BezelImageView_biv_maskDrawable);
    paramContext = paramContext.getTheme();
    paramInt = R.attr.switchPreferenceStyle;
    paramContext = paramContext.obtainStyledAttributes(null, new int[] { 16843049 }, paramInt, 0);
    i = paramContext.hasValue(0);
    paramAttributeSet.recycle();
    paramContext.recycle();
  }
  
  private void a(View paramView)
  {
    a(paramView, -1);
  }
  
  private void a(View paramView, int paramInt)
  {
    LinearLayout localLinearLayout = f;
    if (localLinearLayout != null)
    {
      localLinearLayout.addView(paramView, paramInt);
      return;
    }
    addView(paramView, paramInt);
  }
  
  private LayoutInflater getInflater()
  {
    if (mInflater == null) {
      mInflater = LayoutInflater.from(getContext());
    }
    return mInflater;
  }
  
  private void insertCheckBox()
  {
    CheckBox localCheckBox = (CheckBox)getInflater().inflate(R.layout.abc_list_menu_item_checkbox, this, false);
    mCheckBox = localCheckBox;
    a(localCheckBox);
  }
  
  private void insertIconView()
  {
    ImageView localImageView = (ImageView)getInflater().inflate(R.layout.abc_list_menu_item_icon, this, false);
    mIconView = localImageView;
    a(localImageView, 0);
  }
  
  private void insertRadioButton()
  {
    RadioButton localRadioButton = (RadioButton)getInflater().inflate(R.layout.abc_list_menu_item_radio, this, false);
    mRadioButton = localRadioButton;
    a(localRadioButton);
  }
  
  private void setSubMenuArrowVisible(boolean paramBoolean)
  {
    ImageView localImageView = d;
    if (localImageView != null)
    {
      int j;
      if (paramBoolean) {
        j = 0;
      } else {
        j = 8;
      }
      localImageView.setVisibility(j);
    }
  }
  
  public void adjustListItemSelectionBounds(Rect paramRect)
  {
    Object localObject = c;
    if ((localObject != null) && (((View)localObject).getVisibility() == 0))
    {
      localObject = (LinearLayout.LayoutParams)c.getLayoutParams();
      top += c.getHeight() + topMargin + bottomMargin;
    }
  }
  
  public MenuItemImpl getItemData()
  {
    return mItemData;
  }
  
  public void initialize(MenuItemImpl paramMenuItemImpl, int paramInt)
  {
    mItemData = paramMenuItemImpl;
    if (paramMenuItemImpl.isVisible()) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    setVisibility(paramInt);
    setTitle(paramMenuItemImpl.getTitleForItemView(this));
    setCheckable(paramMenuItemImpl.isCheckable());
    setShortcut(paramMenuItemImpl.shouldShowShortcut(), paramMenuItemImpl.getShortcut());
    setIcon(paramMenuItemImpl.getIcon());
    setEnabled(paramMenuItemImpl.isEnabled());
    setSubMenuArrowVisible(paramMenuItemImpl.hasSubMenu());
    setContentDescription(paramMenuItemImpl.getContentDescription());
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ViewCompat.setBackgroundDrawable(this, mBackground);
    Object localObject = (TextView)findViewById(R.id.title);
    mTitleView = ((TextView)localObject);
    int j = mTextAppearance;
    if (j != -1) {
      ((TextView)localObject).setTextAppearance(mTextAppearanceContext, j);
    }
    mShortcutView = ((TextView)findViewById(R.id.label));
    localObject = (ImageView)findViewById(R.id.thumbnail);
    d = ((ImageView)localObject);
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable(close);
    }
    c = ((ImageView)findViewById(R.id.timer_time_text));
    f = ((LinearLayout)findViewById(R.id.delete));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((mIconView != null) && (mPreserveIconSpacing))
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)mIconView.getLayoutParams();
      int j = height;
      if ((j > 0) && (width <= 0)) {
        width = j;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean prefersCondensedTitle()
  {
    return false;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    if ((!paramBoolean) && (mRadioButton == null) && (mCheckBox == null)) {
      return;
    }
    Object localObject1;
    Object localObject2;
    if (mItemData.isExclusiveCheckable())
    {
      if (mRadioButton == null) {
        insertRadioButton();
      }
      localObject1 = mRadioButton;
      localObject2 = mCheckBox;
    }
    else
    {
      if (mCheckBox == null) {
        insertCheckBox();
      }
      localObject1 = mCheckBox;
      localObject2 = mRadioButton;
    }
    if (paramBoolean)
    {
      ((CompoundButton)localObject1).setChecked(mItemData.isChecked());
      if (((View)localObject1).getVisibility() != 0) {
        ((View)localObject1).setVisibility(0);
      }
      if ((localObject2 != null) && (((View)localObject2).getVisibility() != 8)) {
        ((View)localObject2).setVisibility(8);
      }
    }
    else
    {
      localObject1 = mCheckBox;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      localObject1 = mRadioButton;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    Object localObject;
    if (mItemData.isExclusiveCheckable())
    {
      if (mRadioButton == null) {
        insertRadioButton();
      }
      localObject = mRadioButton;
    }
    else
    {
      if (mCheckBox == null) {
        insertCheckBox();
      }
      localObject = mCheckBox;
    }
    ((CompoundButton)localObject).setChecked(paramBoolean);
  }
  
  public void setForceShowIcon(boolean paramBoolean)
  {
    mForceShowIcon = paramBoolean;
    mPreserveIconSpacing = paramBoolean;
  }
  
  public void setGroupDividerEnabled(boolean paramBoolean)
  {
    ImageView localImageView = c;
    if (localImageView != null)
    {
      int j;
      if ((!i) && (paramBoolean)) {
        j = 0;
      } else {
        j = 8;
      }
      localImageView.setVisibility(j);
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    int j;
    if ((!mItemData.shouldShowIcon()) && (!mForceShowIcon)) {
      j = 0;
    } else {
      j = 1;
    }
    if ((j == 0) && (!mPreserveIconSpacing)) {
      return;
    }
    ImageView localImageView = mIconView;
    if ((localImageView == null) && (paramDrawable == null) && (!mPreserveIconSpacing)) {
      return;
    }
    if (localImageView == null) {
      insertIconView();
    }
    if ((paramDrawable == null) && (!mPreserveIconSpacing))
    {
      mIconView.setVisibility(8);
      return;
    }
    localImageView = mIconView;
    if (j == 0) {
      paramDrawable = null;
    }
    localImageView.setImageDrawable(paramDrawable);
    if (mIconView.getVisibility() != 0) {
      mIconView.setVisibility(0);
    }
  }
  
  public void setShortcut(boolean paramBoolean, char paramChar)
  {
    if ((paramBoolean) && (mItemData.shouldShowShortcut())) {
      paramChar = '\000';
    } else {
      paramChar = '\b';
    }
    if (paramChar == 0) {
      mShortcutView.setText(mItemData.a());
    }
    if (mShortcutView.getVisibility() != paramChar) {
      mShortcutView.setVisibility(paramChar);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      mTitleView.setText(paramCharSequence);
      if (mTitleView.getVisibility() != 0) {
        mTitleView.setVisibility(0);
      }
    }
    else if (mTitleView.getVisibility() != 8)
    {
      mTitleView.setVisibility(8);
    }
  }
}
