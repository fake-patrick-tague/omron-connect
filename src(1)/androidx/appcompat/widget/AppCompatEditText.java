package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.DragEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.widget.ByteVector;
import androidx.core.widget.Label;
import v7.internal.R.attr;
import v7.v7.package_13.TintableBackgroundView;
import v7.v7.package_13.ViewCompat;
import v7.v7.package_13.j;
import v7.v7.package_13.menu.x;

public class AppCompatEditText
  extends EditText
  implements TintableBackgroundView, j, androidx.core.widget.Object
{
  private final NavigationMenuPresenter b;
  private final ByteVector l;
  private final AppCompatBackgroundHelper mBackgroundTintHelper;
  private final TimePicker mTimePicker;
  private a pkiVerificationData;
  private final SettingsActivity.5 this$0;
  
  public AppCompatEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.oi_distribution_aboutapp);
  }
  
  public AppCompatEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
    this$0 = new SettingsActivity.5(this);
    l = new ByteVector();
    paramContext = new NavigationMenuPresenter(this);
    b = paramContext;
    paramContext.a(paramAttributeSet, paramInt);
    getView(paramContext);
  }
  
  private a getSuperCaller()
  {
    if (pkiVerificationData == null) {
      pkiVerificationData = new a();
    }
    return pkiVerificationData;
  }
  
  public v7.v7.package_13.b a(v7.v7.package_13.b paramB)
  {
    return l.a(this, paramB);
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
  
  public Editable getText()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return super.getText();
    }
    return super.getEditableText();
  }
  
  public TextClassifier getTextClassifier()
  {
    if (Build.VERSION.SDK_INT < 28)
    {
      SettingsActivity.5 local5 = this$0;
      if (local5 != null) {
        return local5.onMenuItemClick();
      }
    }
    return getSuperCaller().addSubMenu();
  }
  
  void getView(NavigationMenuPresenter paramNavigationMenuPresenter)
  {
    KeyListener localKeyListener = getKeyListener();
    if (paramNavigationMenuPresenter.f(localKeyListener))
    {
      boolean bool1 = super.isFocusable();
      boolean bool2 = super.isClickable();
      boolean bool3 = super.isLongClickable();
      int i = super.getInputType();
      paramNavigationMenuPresenter = paramNavigationMenuPresenter.a(localKeyListener);
      if (paramNavigationMenuPresenter == localKeyListener) {
        return;
      }
      super.setKeyListener(paramNavigationMenuPresenter);
      super.setRawInputType(i);
      super.setFocusable(bool1);
      super.setClickable(bool2);
      super.setLongClickable(bool3);
    }
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    Object localObject1 = super.onCreateInputConnection(paramEditorInfo);
    mTimePicker.initialize(this, (InputConnection)localObject1, paramEditorInfo);
    InputConnection localInputConnection = Resources.a((InputConnection)localObject1, paramEditorInfo, this);
    localObject1 = localInputConnection;
    Object localObject2 = localObject1;
    if (localInputConnection != null)
    {
      localObject2 = localObject1;
      if (Build.VERSION.SDK_INT <= 30)
      {
        String[] arrayOfString = ViewCompat.create(this);
        localObject2 = localObject1;
        if (arrayOfString != null)
        {
          v7.v7.package_13.menu.b.onCreate(paramEditorInfo, arrayOfString);
          localObject2 = x.a(this, localInputConnection, paramEditorInfo);
        }
      }
    }
    return b.b((InputConnection)localObject2, paramEditorInfo);
  }
  
  public boolean onDragEvent(DragEvent paramDragEvent)
  {
    if (SignatureReader.a(this, paramDragEvent)) {
      return true;
    }
    return super.onDragEvent(paramDragEvent);
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    if (SignatureReader.a(this, paramInt)) {
      return true;
    }
    return super.onTextContextMenuItem(paramInt);
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
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    super.setCustomSelectionActionModeCallback(Label.a(this, paramCallback));
  }
  
  public void setEmojiCompatEnabled(boolean paramBoolean)
  {
    b.b(paramBoolean);
  }
  
  public void setKeyListener(KeyListener paramKeyListener)
  {
    super.setKeyListener(b.a(paramKeyListener));
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
      SettingsActivity.5 local5 = this$0;
      if (local5 != null)
      {
        local5.onPreferenceChange(paramTextClassifier);
        return;
      }
    }
    getSuperCaller().b(paramTextClassifier);
  }
  
  class a
  {
    a() {}
    
    public TextClassifier addSubMenu()
    {
      return AppCompatEditText.a(AppCompatEditText.this);
    }
    
    public void b(TextClassifier paramTextClassifier)
    {
      AppCompatEditText.c(AppCompatEditText.this, paramTextClassifier);
    }
  }
}
