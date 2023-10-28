package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.graphics.ClassWriter;
import c.h.o.c;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import v7.v7.package_13.TintableBackgroundView;
import v7.v7.text.StrBuilder;

public class AppCompatTextView
  extends TextView
  implements TintableBackgroundView, androidx.core.widget.Object
{
  private MethodWriter D;
  private a c = null;
  private Future<c> delegate;
  private boolean e = false;
  private final AppCompatBackgroundHelper mBackgroundTintHelper;
  private final SettingsActivity.5 mPreferenceChangeListener;
  private final TimePicker mTimePicker;
  
  public AppCompatTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842884);
  }
  
  public AppCompatTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
    mPreferenceChangeListener = new SettingsActivity.5(this);
    getEmojiTextViewHelper().a(paramAttributeSet, paramInt);
  }
  
  private void clear()
  {
    Object localObject = delegate;
    if (localObject != null)
    {
      delegate = null;
      try
      {
        localObject = ((Future)localObject).get();
        localObject = (StrBuilder)localObject;
        androidx.core.widget.Label.a(this, (StrBuilder)localObject);
        return;
      }
      catch (InterruptedException localInterruptedException) {}catch (ExecutionException localExecutionException) {}
    }
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
      return getSuperCaller().d();
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
      return getSuperCaller().processBlock();
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
      return getSuperCaller().stringWidth();
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
      return getSuperCaller().findItem();
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
      if (getSuperCaller().f() == 1) {
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
    return androidx.core.widget.Label.a(super.getCustomSelectionActionModeCallback());
  }
  
  public int getFirstBaselineToTopHeight()
  {
    return androidx.core.widget.Label.updatePadding(this);
  }
  
  public int getLastBaselineToBottomHeight()
  {
    return androidx.core.widget.Label.setText(this);
  }
  
  a getSuperCaller()
  {
    if (c == null)
    {
      int i = Build.VERSION.SDK_INT;
      if (i >= 28) {
        c = new c();
      } else if (i >= 26) {
        c = new b();
      }
    }
    return c;
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
  
  public CharSequence getText()
  {
    clear();
    return super.getText();
  }
  
  public TextClassifier getTextClassifier()
  {
    if (Build.VERSION.SDK_INT < 28)
    {
      SettingsActivity.5 local5 = mPreferenceChangeListener;
      if (local5 != null) {
        return local5.onMenuItemClick();
      }
    }
    return getSuperCaller().e();
  }
  
  public v7.v7.text.Label getTextMetricsParamsCompat()
  {
    return androidx.core.widget.Label.a(this);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    InputConnection localInputConnection = super.onCreateInputConnection(paramEditorInfo);
    mTimePicker.initialize(this, localInputConnection, paramEditorInfo);
    return Resources.a(localInputConnection, paramEditorInfo, this);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    TimePicker localTimePicker = mTimePicker;
    if (localTimePicker != null) {
      localTimePicker.setTime(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    clear();
    super.onMeasure(paramInt1, paramInt2);
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
      getSuperCaller().sendMouseEvent(paramInt1, paramInt2, paramInt3, paramInt4);
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
      getSuperCaller().update(paramArrayOfInt, paramInt);
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
      getSuperCaller().b(paramInt);
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
  
  public void setCompoundDrawablesRelativeWithIntrinsicBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Context localContext = getContext();
    Drawable localDrawable3 = null;
    if (paramInt1 != 0) {
      localObject = v7.internal.transition.util.View.getDrawable(localContext, paramInt1);
    } else {
      localObject = null;
    }
    Drawable localDrawable1;
    if (paramInt2 != 0) {
      localDrawable1 = v7.internal.transition.util.View.getDrawable(localContext, paramInt2);
    } else {
      localDrawable1 = null;
    }
    Drawable localDrawable2;
    if (paramInt3 != 0) {
      localDrawable2 = v7.internal.transition.util.View.getDrawable(localContext, paramInt3);
    } else {
      localDrawable2 = null;
    }
    if (paramInt4 != 0) {
      localDrawable3 = v7.internal.transition.util.View.getDrawable(localContext, paramInt4);
    }
    setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable)localObject, localDrawable1, localDrawable2, localDrawable3);
    Object localObject = mTimePicker;
    if (localObject != null) {
      ((TimePicker)localObject).setMinute();
    }
  }
  
  public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    super.setCompoundDrawablesRelativeWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    paramDrawable1 = mTimePicker;
    if (paramDrawable1 != null) {
      paramDrawable1.setMinute();
    }
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Context localContext = getContext();
    Drawable localDrawable3 = null;
    if (paramInt1 != 0) {
      localObject = v7.internal.transition.util.View.getDrawable(localContext, paramInt1);
    } else {
      localObject = null;
    }
    Drawable localDrawable1;
    if (paramInt2 != 0) {
      localDrawable1 = v7.internal.transition.util.View.getDrawable(localContext, paramInt2);
    } else {
      localDrawable1 = null;
    }
    Drawable localDrawable2;
    if (paramInt3 != 0) {
      localDrawable2 = v7.internal.transition.util.View.getDrawable(localContext, paramInt3);
    } else {
      localDrawable2 = null;
    }
    if (paramInt4 != 0) {
      localDrawable3 = v7.internal.transition.util.View.getDrawable(localContext, paramInt4);
    }
    setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, localDrawable1, localDrawable2, localDrawable3);
    Object localObject = mTimePicker;
    if (localObject != null) {
      ((TimePicker)localObject).setMinute();
    }
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    super.setCompoundDrawablesWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    paramDrawable1 = mTimePicker;
    if (paramDrawable1 != null) {
      paramDrawable1.setMinute();
    }
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    super.setCustomSelectionActionModeCallback(androidx.core.widget.Label.a(this, paramCallback));
  }
  
  public void setEmojiCompatEnabled(boolean paramBoolean)
  {
    getEmojiTextViewHelper().f(paramBoolean);
  }
  
  public void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    super.setFilters(getEmojiTextViewHelper().f(paramArrayOfInputFilter));
  }
  
  public void setFirstBaselineToTopHeight(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      getSuperCaller().setFrom(paramInt);
      return;
    }
    androidx.core.widget.Label.a(this, paramInt);
  }
  
  public void setLastBaselineToBottomHeight(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      getSuperCaller().beginTask(paramInt);
      return;
    }
    androidx.core.widget.Label.setText(this, paramInt);
  }
  
  public void setLineHeight(int paramInt)
  {
    androidx.core.widget.Label.init(this, paramInt);
  }
  
  public void setPrecomputedText(StrBuilder paramStrBuilder)
  {
    androidx.core.widget.Label.a(this, paramStrBuilder);
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
  
  public void setTextClassifier(TextClassifier paramTextClassifier)
  {
    if (Build.VERSION.SDK_INT < 28)
    {
      SettingsActivity.5 local5 = mPreferenceChangeListener;
      if (local5 != null)
      {
        local5.onPreferenceChange(paramTextClassifier);
        return;
      }
    }
    getSuperCaller().setFrom(paramTextClassifier);
  }
  
  public void setTextFuture(Future paramFuture)
  {
    delegate = paramFuture;
    if (paramFuture != null) {
      requestLayout();
    }
  }
  
  public void setTextMetricsParamsCompat(v7.v7.text.Label paramLabel)
  {
    androidx.core.widget.Label.a(this, paramLabel);
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
  
  public void setTypeface(Typeface paramTypeface, int paramInt)
  {
    if (e) {
      return;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramTypeface != null)
    {
      localObject1 = localObject2;
      if (paramInt > 0) {
        localObject1 = ClassWriter.get(getContext(), paramTypeface, paramInt);
      }
    }
    e = true;
    if (localObject1 != null) {
      paramTypeface = (Typeface)localObject1;
    }
    try
    {
      super.setTypeface(paramTypeface, paramInt);
      e = false;
      return;
    }
    catch (Throwable paramTypeface)
    {
      e = false;
      throw paramTypeface;
    }
  }
  
  private static abstract interface a
  {
    public abstract void b(int paramInt);
    
    public abstract void beginTask(int paramInt);
    
    public abstract int d();
    
    public abstract TextClassifier e();
    
    public abstract int f();
    
    public abstract int[] findItem();
    
    public abstract int processBlock();
    
    public abstract void sendMouseEvent(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract void setFrom(int paramInt);
    
    public abstract void setFrom(TextClassifier paramTextClassifier);
    
    public abstract int stringWidth();
    
    public abstract void update(int[] paramArrayOfInt, int paramInt);
  }
  
  class b
    implements AppCompatTextView.a
  {
    b() {}
    
    public void b(int paramInt)
    {
      AppCompatTextView.f(AppCompatTextView.this, paramInt);
    }
    
    public void beginTask(int paramInt) {}
    
    public int d()
    {
      return AppCompatTextView.d(AppCompatTextView.this);
    }
    
    public TextClassifier e()
    {
      return AppCompatTextView.e(AppCompatTextView.this);
    }
    
    public int f()
    {
      return AppCompatTextView.f(AppCompatTextView.this);
    }
    
    public int[] findItem()
    {
      return AppCompatTextView.a(AppCompatTextView.this);
    }
    
    public int processBlock()
    {
      return AppCompatTextView.decrypt(AppCompatTextView.this);
    }
    
    public void sendMouseEvent(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppCompatTextView.setTextAppearance(AppCompatTextView.this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public void setFrom(int paramInt) {}
    
    public void setFrom(TextClassifier paramTextClassifier)
    {
      AppCompatTextView.setTextAppearance(AppCompatTextView.this, paramTextClassifier);
    }
    
    public int stringWidth()
    {
      return AppCompatTextView.measureText(AppCompatTextView.this);
    }
    
    public void update(int[] paramArrayOfInt, int paramInt)
    {
      AppCompatTextView.setTextAppearance(AppCompatTextView.this, paramArrayOfInt, paramInt);
    }
  }
  
  class c
    extends AppCompatTextView.b
  {
    c()
    {
      super();
    }
    
    public void beginTask(int paramInt)
    {
      AppCompatTextView.setTextAppearance(AppCompatTextView.this, paramInt);
    }
    
    public void setFrom(int paramInt)
    {
      AppCompatTextView.setOnClickListener(AppCompatTextView.this, paramInt);
    }
  }
}
