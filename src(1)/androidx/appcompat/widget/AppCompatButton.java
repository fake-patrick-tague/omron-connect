package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityRecord;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.widget.Label;
import v7.internal.R.attr;
import v7.v7.package_13.TintableBackgroundView;

public class AppCompatButton
  extends Button
  implements TintableBackgroundView, androidx.core.widget.Object
{
  private MethodWriter mBackgroundTint;
  private final AppCompatBackgroundHelper mBackgroundTintHelper;
  private final TimePicker mTimePicker;
  
  public AppCompatButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.ringtonePreferenceStyle);
  }
  
  public AppCompatButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(TintContextWrapper.wrap(paramContext), paramAttributeSet, paramInt);
    ThemeUtils.a(this, getContext());
    paramContext = new AppCompatBackgroundHelper(this);
    mBackgroundTintHelper = paramContext;
    paramContext.loadFromAttributes(paramAttributeSet, paramInt);
    paramContext = new TimePicker(this);
    mTimePicker = paramContext;
    paramContext.init(paramAttributeSet, paramInt);
    paramContext.applyStyle();
    getEmojiTextViewHelper().a(paramAttributeSet, paramInt);
  }
  
  private MethodWriter getEmojiTextViewHelper()
  {
    if (mBackgroundTint == null) {
      mBackgroundTint = new MethodWriter(this);
    }
    return mBackgroundTint;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Object localObject = mBackgroundTintHelper;
    if (localObject != null) {
      ((AppCompatBackgroundHelper)localObject).applySupportBackgroundTint();
    }
    localObject = mTimePicker;
    if (localObject != null) {
      ((TimePicker)localObject).applyStyle();
    }
  }
  
  public int getAutoSizeMaxTextSize()
  {
    if (ViewUtils.mIs24HourMode) {
      return super.getAutoSizeMaxTextSize();
    }
    TimePicker localTimePicker = mTimePicker;
    if (localTimePicker != null) {
      return localTimePicker.getTypeface();
    }
    return -1;
  }
  
  public int getAutoSizeMinTextSize()
  {
    if (ViewUtils.mIs24HourMode) {
      return super.getAutoSizeMinTextSize();
    }
    TimePicker localTimePicker = mTimePicker;
    if (localTimePicker != null) {
      return localTimePicker.getCurrentHour();
    }
    return -1;
  }
  
  public int getAutoSizeStepGranularity()
  {
    if (ViewUtils.mIs24HourMode) {
      return super.getAutoSizeStepGranularity();
    }
    TimePicker localTimePicker = mTimePicker;
    if (localTimePicker != null) {
      return localTimePicker.getCurrentMinute();
    }
    return -1;
  }
  
  public int[] getAutoSizeTextAvailableSizes()
  {
    if (ViewUtils.mIs24HourMode) {
      return super.getAutoSizeTextAvailableSizes();
    }
    TimePicker localTimePicker = mTimePicker;
    if (localTimePicker != null) {
      return localTimePicker.setTime();
    }
    return new int[0];
  }
  
  public int getAutoSizeTextType()
  {
    if (ViewUtils.mIs24HourMode)
    {
      if (super.getAutoSizeTextType() == 1) {
        return 1;
      }
    }
    else
    {
      TimePicker localTimePicker = mTimePicker;
      if (localTimePicker != null) {
        return localTimePicker.getHours();
      }
    }
    return 0;
  }
  
  public ActionMode.Callback getCustomSelectionActionModeCallback()
  {
    return Label.a(super.getCustomSelectionActionModeCallback());
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      return localAppCompatBackgroundHelper.getSupportBackgroundTintList();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      return localAppCompatBackgroundHelper.getSupportBackgroundTintMode();
    }
    return null;
  }
  
  public ColorStateList getSupportCompoundDrawablesTintList()
  {
    return mTimePicker.getMinute();
  }
  
  public PorterDuff.Mode getSupportCompoundDrawablesTintMode()
  {
    return mTimePicker.getHour();
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(Button.class.getName());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(Button.class.getName());
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    TimePicker localTimePicker = mTimePicker;
    if (localTimePicker != null) {
      localTimePicker.setTime(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    paramCharSequence = mTimePicker;
    if ((paramCharSequence != null) && (!ViewUtils.mIs24HourMode) && (paramCharSequence.onSaveInstanceState())) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt1 != 0) {
      mTimePicker.setEnabled();
    }
  }
  
  public void setAllCaps(boolean paramBoolean)
  {
    super.setAllCaps(paramBoolean);
    getEmojiTextViewHelper().e(paramBoolean);
  }
  
  public void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IllegalArgumentException
  {
    if (ViewUtils.mIs24HourMode)
    {
      super.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    TimePicker localTimePicker = mTimePicker;
    if (localTimePicker != null) {
      localTimePicker.setEnabled(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt)
    throws IllegalArgumentException
  {
    if (ViewUtils.mIs24HourMode)
    {
      super.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
      return;
    }
    TimePicker localTimePicker = mTimePicker;
    if (localTimePicker != null) {
      localTimePicker.setEnabled(paramArrayOfInt, paramInt);
    }
  }
  
  public void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    if (ViewUtils.mIs24HourMode)
    {
      super.setAutoSizeTextTypeWithDefaults(paramInt);
      return;
    }
    TimePicker localTimePicker = mTimePicker;
    if (localTimePicker != null) {
      localTimePicker.setEnabled(paramInt);
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      localAppCompatBackgroundHelper.onSetBackgroundDrawable(paramDrawable);
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      localAppCompatBackgroundHelper.loadFromAttributes(paramInt);
    }
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    super.setCustomSelectionActionModeCallback(Label.a(this, paramCallback));
  }
  
  public void setEmojiCompatEnabled(boolean paramBoolean)
  {
    getEmojiTextViewHelper().f(paramBoolean);
  }
  
  public void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    super.setFilters(getEmojiTextViewHelper().f(paramArrayOfInputFilter));
  }
  
  public void setSupportAllCaps(boolean paramBoolean)
  {
    TimePicker localTimePicker = mTimePicker;
    if (localTimePicker != null) {
      localTimePicker.setEnabled(paramBoolean);
    }
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      localAppCompatBackgroundHelper.setSupportBackgroundTintList(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      localAppCompatBackgroundHelper.setSupportBackgroundTintMode(paramMode);
    }
  }
  
  public void setSupportCompoundDrawablesTintList(ColorStateList paramColorStateList)
  {
    mTimePicker.setMinute(paramColorStateList);
    mTimePicker.applyStyle();
  }
  
  public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode paramMode)
  {
    mTimePicker.setMinute(paramMode);
    mTimePicker.applyStyle();
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    TimePicker localTimePicker = mTimePicker;
    if (localTimePicker != null) {
      localTimePicker.applyStyle(paramContext, paramInt);
    }
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    if (ViewUtils.mIs24HourMode)
    {
      super.setTextSize(paramInt, paramFloat);
      return;
    }
    TimePicker localTimePicker = mTimePicker;
    if (localTimePicker != null) {
      localTimePicker.onSaveInstanceState(paramInt, paramFloat);
    }
  }
}
