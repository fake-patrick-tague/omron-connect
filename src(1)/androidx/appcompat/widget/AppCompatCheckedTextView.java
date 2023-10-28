package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import android.widget.TextView;
import androidx.core.widget.Label;
import androidx.core.widget.c;
import v7.internal.R.attr;
import v7.v7.package_13.TintableBackgroundView;

public class AppCompatCheckedTextView
  extends CheckedTextView
  implements c, TintableBackgroundView, androidx.core.widget.Object
{
  private MethodWriter D;
  private final AppCompatBackgroundHelper mBackgroundTintHelper;
  private final ClassWriter mTextHelper;
  private final TimePicker mTimePicker;
  
  public AppCompatCheckedTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.shiftedCodes);
  }
  
  public AppCompatCheckedTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(TintContextWrapper.wrap(paramContext), paramAttributeSet, paramInt);
    ThemeUtils.a(this, getContext());
    paramContext = new TimePicker(this);
    mTimePicker = paramContext;
    paramContext.init(paramAttributeSet, paramInt);
    paramContext.applyStyle();
    paramContext = new AppCompatBackgroundHelper(this);
    mBackgroundTintHelper = paramContext;
    paramContext.loadFromAttributes(paramAttributeSet, paramInt);
    paramContext = new ClassWriter(this);
    mTextHelper = paramContext;
    paramContext.a(paramAttributeSet, paramInt);
    getEmojiTextViewHelper().a(paramAttributeSet, paramInt);
  }
  
  private MethodWriter getEmojiTextViewHelper()
  {
    if (D == null) {
      D = new MethodWriter(this);
    }
    return D;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Object localObject = mTimePicker;
    if (localObject != null) {
      ((TimePicker)localObject).applyStyle();
    }
    localObject = mBackgroundTintHelper;
    if (localObject != null) {
      ((AppCompatBackgroundHelper)localObject).applySupportBackgroundTint();
    }
    localObject = mTextHelper;
    if (localObject != null) {
      ((ClassWriter)localObject).applyButtonTint();
    }
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
  
  public ColorStateList getSupportCheckMarkTintList()
  {
    ClassWriter localClassWriter = mTextHelper;
    if (localClassWriter != null) {
      return localClassWriter.c();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportCheckMarkTintMode()
  {
    ClassWriter localClassWriter = mTextHelper;
    if (localClassWriter != null) {
      return localClassWriter.getSupportButtonTintMode();
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
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return Resources.a(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, this);
  }
  
  public void setAllCaps(boolean paramBoolean)
  {
    super.setAllCaps(paramBoolean);
    getEmojiTextViewHelper().e(paramBoolean);
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
  
  public void setCheckMarkDrawable(int paramInt)
  {
    setCheckMarkDrawable(v7.internal.transition.util.View.getDrawable(getContext(), paramInt));
  }
  
  public void setCheckMarkDrawable(Drawable paramDrawable)
  {
    super.setCheckMarkDrawable(paramDrawable);
    paramDrawable = mTextHelper;
    if (paramDrawable != null) {
      paramDrawable.b();
    }
  }
  
  public void setCompoundDrawables(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    super.setCompoundDrawables(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    paramDrawable1 = mTimePicker;
    if (paramDrawable1 != null) {
      paramDrawable1.setMinute();
    }
  }
  
  public void setCompoundDrawablesRelative(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    super.setCompoundDrawablesRelative(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    paramDrawable1 = mTimePicker;
    if (paramDrawable1 != null) {
      paramDrawable1.setMinute();
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
  
  public void setSupportCheckMarkTintList(ColorStateList paramColorStateList)
  {
    ClassWriter localClassWriter = mTextHelper;
    if (localClassWriter != null) {
      localClassWriter.setSupportButtonTintList(paramColorStateList);
    }
  }
  
  public void setSupportCheckMarkTintMode(PorterDuff.Mode paramMode)
  {
    ClassWriter localClassWriter = mTextHelper;
    if (localClassWriter != null) {
      localClassWriter.setSupportButtonTintMode(paramMode);
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
}
