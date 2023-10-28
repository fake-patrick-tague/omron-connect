package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.core.widget.Label;
import java.lang.ref.WeakReference;
import v7.internal.R.styleable;

class TimePicker
{
  private final TextView a;
  private final f b;
  private TintInfo mDrawableBottomTint;
  private TintInfo mDrawableEndTint;
  private TintInfo mDrawableLeftTint;
  private TintInfo mDrawableRightTint;
  private TintInfo mDrawableStartTint;
  private TintInfo mDrawableTopTint;
  private TintInfo mMinute;
  private int n = 0;
  private boolean s;
  private Typeface t;
  private int x = -1;
  
  TimePicker(TextView paramTextView)
  {
    a = paramTextView;
    b = new f(paramTextView);
  }
  
  private void a(int paramInt, float paramFloat)
  {
    b.b(paramInt, paramFloat);
  }
  
  private void applyCompoundDrawableTint(android.graphics.drawable.Drawable paramDrawable, TintInfo paramTintInfo)
  {
    if ((paramDrawable != null) && (paramTintInfo != null)) {
      ViewCompat.tintDrawable(paramDrawable, paramTintInfo, a.getDrawableState());
    }
  }
  
  private void applyStyle(android.graphics.drawable.Drawable paramDrawable1, android.graphics.drawable.Drawable paramDrawable2, android.graphics.drawable.Drawable paramDrawable3, android.graphics.drawable.Drawable paramDrawable4, android.graphics.drawable.Drawable paramDrawable5, android.graphics.drawable.Drawable paramDrawable6)
  {
    int i = Build.VERSION.SDK_INT;
    if ((i >= 17) && ((paramDrawable5 != null) || (paramDrawable6 != null)))
    {
      paramDrawable3 = EditText.getCompoundDrawablesRelative(a);
      paramDrawable1 = a;
      if (paramDrawable5 == null) {
        paramDrawable5 = paramDrawable3[0];
      }
      if (paramDrawable2 == null) {
        paramDrawable2 = paramDrawable3[1];
      }
      if (paramDrawable6 == null) {
        paramDrawable6 = paramDrawable3[2];
      }
      if (paramDrawable4 == null) {
        paramDrawable4 = paramDrawable3[3];
      }
      EditText.setCompoundDrawablesRelativeWithIntrinsicBounds(paramDrawable1, paramDrawable5, paramDrawable2, paramDrawable6, paramDrawable4);
      return;
    }
    if ((paramDrawable1 != null) || (paramDrawable2 != null) || (paramDrawable3 != null) || (paramDrawable4 != null))
    {
      if (i >= 17)
      {
        paramDrawable5 = EditText.getCompoundDrawablesRelative(a);
        if ((paramDrawable5[0] != null) || (paramDrawable5[2] != null))
        {
          paramDrawable1 = a;
          paramDrawable3 = paramDrawable5[0];
          if (paramDrawable2 == null) {
            paramDrawable2 = paramDrawable5[1];
          }
          paramDrawable6 = paramDrawable5[2];
          if (paramDrawable4 == null) {
            paramDrawable4 = paramDrawable5[3];
          }
          EditText.setCompoundDrawablesRelativeWithIntrinsicBounds(paramDrawable1, paramDrawable3, paramDrawable2, paramDrawable6, paramDrawable4);
          return;
        }
      }
      paramDrawable6 = a.getCompoundDrawables();
      paramDrawable5 = a;
      if (paramDrawable1 == null) {
        paramDrawable1 = paramDrawable6[0];
      }
      if (paramDrawable2 == null) {
        paramDrawable2 = paramDrawable6[1];
      }
      if (paramDrawable3 == null) {
        paramDrawable3 = paramDrawable6[2];
      }
      if (paramDrawable4 == null) {
        paramDrawable4 = paramDrawable6[3];
      }
      paramDrawable5.setCompoundDrawablesWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    }
  }
  
  private static TintInfo createTintInfo(Context paramContext, ViewCompat paramViewCompat, int paramInt)
  {
    paramContext = paramViewCompat.getTintList(paramContext, paramInt);
    if (paramContext != null)
    {
      paramViewCompat = new TintInfo();
      mHasTintList = true;
      mTintList = paramContext;
      return paramViewCompat;
    }
    return null;
  }
  
  private void init(Context paramContext, TintTypedArray paramTintTypedArray)
  {
    n = paramTintTypedArray.getInt(R.styleable.RippleView_rv_rippleDuration, n);
    int k = Build.VERSION.SDK_INT;
    boolean bool2 = false;
    if (k >= 28)
    {
      i = paramTintTypedArray.getInt(R.styleable.GRAVITY, -1);
      x = i;
      if (i != -1) {
        n = (n & 0x2 | 0x0);
      }
    }
    int i = R.styleable.TYPE;
    Object localObject1;
    Object localObject2;
    if ((!paramTintTypedArray.hasValue(i)) && (!paramTintTypedArray.hasValue(R.styleable.PullToRefresh_ptrAnimationStyle)))
    {
      i = R.styleable.MaterialProgressBar_mpb_tintMode;
      if (paramTintTypedArray.hasValue(i))
      {
        s = false;
        i = paramTintTypedArray.getInt(i, 1);
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3) {
              return;
            }
            t = Typeface.MONOSPACE;
            return;
          }
          t = Typeface.SERIF;
          return;
        }
        t = Typeface.SANS_SERIF;
      }
    }
    else
    {
      t = null;
      int j = R.styleable.PullToRefresh_ptrAnimationStyle;
      if (paramTintTypedArray.hasValue(j)) {
        i = j;
      }
      j = x;
      int m = n;
      localObject1 = this;
      if (!paramContext.isRestricted())
      {
        paramContext = new Plot(this, j, m, new WeakReference(a));
        j = n;
        localObject1 = this;
        localObject2 = this;
      }
      try
      {
        Object localObject3 = paramTintTypedArray.getType(i, j, paramContext);
        localObject1 = this;
        if (localObject3 != null)
        {
          localObject1 = this;
          if (k >= 28)
          {
            j = x;
            paramContext = this;
            localObject1 = paramContext;
            if (j != -1)
            {
              localObject1 = paramContext;
              localObject2 = paramContext;
              Typeface localTypeface = Typeface.create((Typeface)localObject3, 0);
              j = x;
              localObject3 = paramContext;
              if ((n & 0x2) != 0) {
                bool1 = true;
              } else {
                bool1 = false;
              }
              localObject1 = localObject3;
              localObject2 = localObject3;
              paramContext = Paint.get(localTypeface, j, bool1);
              t = paramContext;
              localObject1 = localObject3;
              break label354;
            }
          }
          t = ((Typeface)localObject3);
        }
        label354:
        if (t == null) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        s = bool1;
      }
      catch (UnsupportedOperationException paramContext)
      {
        boolean bool1;
        for (;;) {}
      }
      catch (Resources.NotFoundException paramContext)
      {
        for (;;)
        {
          localObject1 = localObject2;
        }
      }
      if (t == null)
      {
        paramTintTypedArray = paramTintTypedArray.getString(i);
        if (paramTintTypedArray != null)
        {
          paramContext = (Context)localObject1;
          if (Build.VERSION.SDK_INT >= 28)
          {
            i = x;
            paramContext = (Context)localObject1;
            if (i != -1)
            {
              paramContext = Typeface.create(paramTintTypedArray, 0);
              i = x;
              bool1 = bool2;
              if ((n & 0x2) != 0) {
                bool1 = true;
              }
              t = Paint.get(paramContext, i, bool1);
              return;
            }
          }
          t = Typeface.create(paramTintTypedArray, n);
          return;
        }
      }
    }
  }
  
  private void loadFromAttributes()
  {
    TintInfo localTintInfo = mMinute;
    mDrawableBottomTint = localTintInfo;
    mDrawableLeftTint = localTintInfo;
    mDrawableTopTint = localTintInfo;
    mDrawableRightTint = localTintInfo;
    mDrawableStartTint = localTintInfo;
    mDrawableEndTint = localTintInfo;
  }
  
  void applyStyle()
  {
    android.graphics.drawable.Drawable[] arrayOfDrawable;
    if ((mDrawableBottomTint != null) || (mDrawableLeftTint != null) || (mDrawableTopTint != null) || (mDrawableRightTint != null))
    {
      arrayOfDrawable = a.getCompoundDrawables();
      applyCompoundDrawableTint(arrayOfDrawable[0], mDrawableBottomTint);
      applyCompoundDrawableTint(arrayOfDrawable[1], mDrawableLeftTint);
      applyCompoundDrawableTint(arrayOfDrawable[2], mDrawableTopTint);
      applyCompoundDrawableTint(arrayOfDrawable[3], mDrawableRightTint);
    }
    if ((Build.VERSION.SDK_INT >= 17) && ((mDrawableStartTint != null) || (mDrawableEndTint != null)))
    {
      arrayOfDrawable = EditText.getCompoundDrawablesRelative(a);
      applyCompoundDrawableTint(arrayOfDrawable[0], mDrawableStartTint);
      applyCompoundDrawableTint(arrayOfDrawable[2], mDrawableEndTint);
    }
  }
  
  void applyStyle(Context paramContext, int paramInt)
  {
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramInt, R.styleable.TextAppearance);
    paramInt = R.styleable.TextAppearance_textAllCaps;
    if (localTintTypedArray.hasValue(paramInt)) {
      setEnabled(localTintTypedArray.getBoolean(paramInt, false));
    }
    paramInt = Build.VERSION.SDK_INT;
    if (paramInt < 23)
    {
      i = R.styleable.TextAppearance_android_textColor;
      ColorStateList localColorStateList;
      if (localTintTypedArray.hasValue(i))
      {
        localColorStateList = localTintTypedArray.getColor(i);
        if (localColorStateList != null) {
          a.setTextColor(localColorStateList);
        }
      }
      i = R.styleable.CENTER;
      if (localTintTypedArray.hasValue(i))
      {
        localColorStateList = localTintTypedArray.getColor(i);
        if (localColorStateList != null) {
          a.setLinkTextColor(localColorStateList);
        }
      }
      i = R.styleable.y;
      if (localTintTypedArray.hasValue(i))
      {
        localColorStateList = localTintTypedArray.getColor(i);
        if (localColorStateList != null) {
          a.setHintTextColor(localColorStateList);
        }
      }
    }
    int i = R.styleable.TextAppearance_android_textSize;
    if ((localTintTypedArray.hasValue(i)) && (localTintTypedArray.getDimensionPixelSize(i, -1) == 0)) {
      a.setTextSize(0, 0.0F);
    }
    init(paramContext, localTintTypedArray);
    if (paramInt >= 26)
    {
      paramInt = R.styleable.END;
      if (localTintTypedArray.hasValue(paramInt))
      {
        paramContext = localTintTypedArray.getString(paramInt);
        if (paramContext != null) {
          Log.setText(a, paramContext);
        }
      }
    }
    localTintTypedArray.recycle();
    paramContext = t;
    if (paramContext != null) {
      a.setTypeface(paramContext, n);
    }
  }
  
  int getCurrentHour()
  {
    return b.getValue();
  }
  
  int getCurrentMinute()
  {
    return b.clear();
  }
  
  PorterDuff.Mode getHour()
  {
    TintInfo localTintInfo = mMinute;
    if (localTintInfo != null) {
      return mTintMode;
    }
    return null;
  }
  
  int getHours()
  {
    return b.get();
  }
  
  ColorStateList getMinute()
  {
    TintInfo localTintInfo = mMinute;
    if (localTintInfo != null) {
      return mTintList;
    }
    return null;
  }
  
  int getTypeface()
  {
    return b.add();
  }
  
  void init(AttributeSet paramAttributeSet, int paramInt)
  {
    Context localContext = a.getContext();
    ViewCompat localViewCompat = ViewCompat.get();
    Object localObject1 = R.styleable.DialogPreference;
    Object localObject2 = TintTypedArray.obtainStyledAttributes(localContext, paramAttributeSet, (int[])localObject1, paramInt, 0);
    Object localObject3 = a;
    v7.v7.package_13.ViewCompat.obtainStyledAttributes((View)localObject3, ((View)localObject3).getContext(), (int[])localObject1, paramAttributeSet, ((TintTypedArray)localObject2).getResourceId(), paramInt, 0);
    int i = ((TintTypedArray)localObject2).getResourceId(R.styleable.Preference_icon, -1);
    int j = R.styleable.FloatingActionMenu_menu_labels_showAnimation;
    if (((TintTypedArray)localObject2).hasValue(j)) {
      mDrawableBottomTint = createTintInfo(localContext, localViewCompat, ((TintTypedArray)localObject2).getResourceId(j, 0));
    }
    j = R.styleable.DialogPreference_dialogLayout;
    if (((TintTypedArray)localObject2).hasValue(j)) {
      mDrawableLeftTint = createTintInfo(localContext, localViewCompat, ((TintTypedArray)localObject2).getResourceId(j, 0));
    }
    j = R.styleable.FloatingActionMenu_menu_labels_hideAnimation;
    if (((TintTypedArray)localObject2).hasValue(j)) {
      mDrawableTopTint = createTintInfo(localContext, localViewCompat, ((TintTypedArray)localObject2).getResourceId(j, 0));
    }
    j = R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop;
    if (((TintTypedArray)localObject2).hasValue(j)) {
      mDrawableRightTint = createTintInfo(localContext, localViewCompat, ((TintTypedArray)localObject2).getResourceId(j, 0));
    }
    int k = Build.VERSION.SDK_INT;
    if (k >= 17)
    {
      j = R.styleable.NavigationView_itemIconTint;
      if (((TintTypedArray)localObject2).hasValue(j)) {
        mDrawableStartTint = createTintInfo(localContext, localViewCompat, ((TintTypedArray)localObject2).getResourceId(j, 0));
      }
      j = R.styleable.NavigationView_itemTextColor;
      if (((TintTypedArray)localObject2).hasValue(j)) {
        mDrawableEndTint = createTintInfo(localContext, localViewCompat, ((TintTypedArray)localObject2).getResourceId(j, 0));
      }
    }
    ((TintTypedArray)localObject2).recycle();
    boolean bool3 = a.getTransformationMethod() instanceof PasswordTransformationMethod;
    boolean bool1;
    label353:
    Object localObject4;
    Object localObject5;
    if (i != -1)
    {
      localObject7 = TintTypedArray.obtainStyledAttributes(localContext, i, R.styleable.TextAppearance);
      if (!bool3)
      {
        i = R.styleable.TextAppearance_textAllCaps;
        if (((TintTypedArray)localObject7).hasValue(i))
        {
          bool1 = ((TintTypedArray)localObject7).getBoolean(i, false);
          i = 1;
          break label353;
        }
      }
      bool1 = false;
      i = 0;
      init(localContext, (TintTypedArray)localObject7);
      if (k < 23)
      {
        j = R.styleable.TextAppearance_android_textColor;
        if (((TintTypedArray)localObject7).hasValue(j)) {
          localObject1 = ((TintTypedArray)localObject7).getColor(j);
        } else {
          localObject1 = null;
        }
        j = R.styleable.y;
        if (((TintTypedArray)localObject7).hasValue(j)) {
          localObject2 = ((TintTypedArray)localObject7).getColor(j);
        } else {
          localObject2 = null;
        }
        j = R.styleable.CENTER;
        localObject3 = localObject1;
        localObject4 = localObject2;
        if (((TintTypedArray)localObject7).hasValue(j))
        {
          localObject5 = ((TintTypedArray)localObject7).getColor(j);
          localObject3 = localObject1;
          localObject1 = localObject2;
          break label484;
        }
      }
      else
      {
        localObject3 = null;
        localObject4 = null;
      }
      localObject5 = null;
      localObject1 = localObject4;
      label484:
      j = R.styleable.CoordinatorLayout_LayoutParams_layout_behavior;
      if (((TintTypedArray)localObject7).hasValue(j)) {
        localObject4 = ((TintTypedArray)localObject7).getString(j);
      } else {
        localObject4 = null;
      }
      if (k >= 26)
      {
        j = R.styleable.END;
        if (((TintTypedArray)localObject7).hasValue(j))
        {
          localObject6 = ((TintTypedArray)localObject7).getString(j);
          break label551;
        }
      }
      localObject6 = null;
      label551:
      ((TintTypedArray)localObject7).recycle();
      localObject2 = localObject3;
      localObject3 = localObject6;
    }
    else
    {
      bool1 = false;
      i = 0;
      localObject3 = null;
      localObject2 = null;
      localObject4 = null;
      localObject1 = null;
      localObject5 = null;
    }
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(localContext, paramAttributeSet, R.styleable.TextAppearance, paramInt, 0);
    boolean bool2 = bool1;
    j = i;
    if (!bool3)
    {
      int m = R.styleable.TextAppearance_textAllCaps;
      bool2 = bool1;
      j = i;
      if (localTintTypedArray.hasValue(m))
      {
        bool2 = localTintTypedArray.getBoolean(m, false);
        j = 1;
      }
    }
    Object localObject6 = localObject2;
    Object localObject7 = localObject1;
    Object localObject8 = localObject5;
    if (k < 23)
    {
      i = R.styleable.TextAppearance_android_textColor;
      if (localTintTypedArray.hasValue(i)) {
        localObject2 = localTintTypedArray.getColor(i);
      }
      i = R.styleable.y;
      if (localTintTypedArray.hasValue(i)) {
        localObject1 = localTintTypedArray.getColor(i);
      }
      i = R.styleable.CENTER;
      localObject6 = localObject2;
      localObject7 = localObject1;
      localObject8 = localObject5;
      if (localTintTypedArray.hasValue(i))
      {
        localObject8 = localTintTypedArray.getColor(i);
        localObject7 = localObject1;
        localObject6 = localObject2;
      }
    }
    i = R.styleable.CoordinatorLayout_LayoutParams_layout_behavior;
    if (localTintTypedArray.hasValue(i)) {
      localObject4 = localTintTypedArray.getString(i);
    }
    localObject1 = localObject3;
    if (k >= 26)
    {
      i = R.styleable.END;
      localObject1 = localObject3;
      if (localTintTypedArray.hasValue(i)) {
        localObject1 = localTintTypedArray.getString(i);
      }
    }
    if (k >= 28)
    {
      i = R.styleable.TextAppearance_android_textSize;
      if ((localTintTypedArray.hasValue(i)) && (localTintTypedArray.getDimensionPixelSize(i, -1) == 0)) {
        a.setTextSize(0, 0.0F);
      }
    }
    init(localContext, localTintTypedArray);
    localTintTypedArray.recycle();
    if (localObject6 != null) {
      a.setTextColor((ColorStateList)localObject6);
    }
    if (localObject7 != null) {
      a.setHintTextColor((ColorStateList)localObject7);
    }
    if (localObject8 != null) {
      a.setLinkTextColor((ColorStateList)localObject8);
    }
    if ((!bool3) && (j != 0)) {
      setEnabled(bool2);
    }
    localObject2 = t;
    if (localObject2 != null) {
      if (x == -1) {
        a.setTypeface((Typeface)localObject2, n);
      } else {
        a.setTypeface((Typeface)localObject2);
      }
    }
    if (localObject1 != null) {
      Log.setText(a, (String)localObject1);
    }
    if (localObject4 != null) {
      if (k >= 24)
      {
        Field.setProperty(a, Field.getMessage((String)localObject4));
      }
      else if (k >= 21)
      {
        localObject1 = localObject4.split(",")[0];
        EditText.setText(a, Library.getCountry((String)localObject1));
      }
    }
    b.a(paramAttributeSet, paramInt);
    if ((ViewUtils.mIs24HourMode) && (b.get() != 0))
    {
      localObject1 = b.e();
      if (localObject1.length > 0) {
        if (Log.d(a) != -1.0F) {
          Log.set(a, b.getValue(), b.add(), b.clear(), 0);
        } else {
          Log.setText(a, (int[])localObject1, 0);
        }
      }
    }
    localObject6 = TintTypedArray.obtainStyledAttributes(localContext, paramAttributeSet, R.styleable.a);
    paramInt = ((TintTypedArray)localObject6).getResourceId(R.styleable.h, -1);
    if (paramInt != -1) {
      paramAttributeSet = localViewCompat.getDrawable(localContext, paramInt);
    } else {
      paramAttributeSet = null;
    }
    paramInt = ((TintTypedArray)localObject6).getResourceId(R.styleable.SlidingMenu_selectorDrawable, -1);
    if (paramInt != -1) {
      localObject1 = localViewCompat.getDrawable(localContext, paramInt);
    } else {
      localObject1 = null;
    }
    paramInt = ((TintTypedArray)localObject6).getResourceId(R.styleable.BetterPickersDialogFragment_bpDialogBackground, -1);
    if (paramInt != -1) {
      localObject2 = localViewCompat.getDrawable(localContext, paramInt);
    } else {
      localObject2 = null;
    }
    paramInt = ((TintTypedArray)localObject6).getResourceId(R.styleable.FloatingActionMenu_menu_labels_style, -1);
    if (paramInt != -1) {
      localObject3 = localViewCompat.getDrawable(localContext, paramInt);
    } else {
      localObject3 = null;
    }
    paramInt = ((TintTypedArray)localObject6).getResourceId(R.styleable.FloatingActionButton_fab_showAnimation, -1);
    if (paramInt != -1) {
      localObject4 = localViewCompat.getDrawable(localContext, paramInt);
    } else {
      localObject4 = null;
    }
    paramInt = ((TintTypedArray)localObject6).getResourceId(R.styleable.TextInputLayout_counterTextAppearance, -1);
    if (paramInt != -1) {
      localObject5 = localViewCompat.getDrawable(localContext, paramInt);
    } else {
      localObject5 = null;
    }
    applyStyle(paramAttributeSet, (android.graphics.drawable.Drawable)localObject1, (android.graphics.drawable.Drawable)localObject2, (android.graphics.drawable.Drawable)localObject3, (android.graphics.drawable.Drawable)localObject4, (android.graphics.drawable.Drawable)localObject5);
    paramInt = R.styleable.CardView_cardBackgroundColor;
    if (((TintTypedArray)localObject6).hasValue(paramInt))
    {
      paramAttributeSet = ((TintTypedArray)localObject6).getColor(paramInt);
      Label.a(a, paramAttributeSet);
    }
    paramInt = R.styleable.ROW;
    if (((TintTypedArray)localObject6).hasValue(paramInt))
    {
      paramAttributeSet = Drawable.parseTintMode(((TintTypedArray)localObject6).getInt(paramInt, -1), null);
      Label.a(a, paramAttributeSet);
    }
    paramInt = ((TintTypedArray)localObject6).getDimensionPixelSize(R.styleable.FloatingActionButton_fab_shadowYOffset, -1);
    i = ((TintTypedArray)localObject6).getDimensionPixelSize(R.styleable.Iconics_ico_offset_y, -1);
    j = ((TintTypedArray)localObject6).getDimensionPixelSize(R.styleable.Iconics_ico_padding, -1);
    ((TintTypedArray)localObject6).recycle();
    if (paramInt != -1) {
      Label.a(a, paramInt);
    }
    if (i != -1) {
      Label.setText(a, i);
    }
    if (j != -1) {
      Label.init(a, j);
    }
  }
  
  void initialize(TextView paramTextView, InputConnection paramInputConnection, EditorInfo paramEditorInfo)
  {
    if ((Build.VERSION.SDK_INT < 30) && (paramInputConnection != null)) {
      v7.v7.package_13.menu.b.init(paramEditorInfo, paramTextView.getText());
    }
  }
  
  void onSaveInstanceState(int paramInt, float paramFloat)
  {
    if ((!ViewUtils.mIs24HourMode) && (!onSaveInstanceState())) {
      a(paramInt, paramFloat);
    }
  }
  
  boolean onSaveInstanceState()
  {
    return b.a();
  }
  
  void setEnabled()
  {
    b.draw();
  }
  
  void setEnabled(int paramInt)
  {
    b.a(paramInt);
  }
  
  void setEnabled(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IllegalArgumentException
  {
    b.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  void setEnabled(boolean paramBoolean)
  {
    a.setAllCaps(paramBoolean);
  }
  
  void setEnabled(int[] paramArrayOfInt, int paramInt)
    throws IllegalArgumentException
  {
    b.a(paramArrayOfInt, paramInt);
  }
  
  void setMinute()
  {
    applyStyle();
  }
  
  void setMinute(ColorStateList paramColorStateList)
  {
    if (mMinute == null) {
      mMinute = new TintInfo();
    }
    TintInfo localTintInfo = mMinute;
    mTintList = paramColorStateList;
    boolean bool;
    if (paramColorStateList != null) {
      bool = true;
    } else {
      bool = false;
    }
    mHasTintList = bool;
    loadFromAttributes();
  }
  
  void setMinute(PorterDuff.Mode paramMode)
  {
    if (mMinute == null) {
      mMinute = new TintInfo();
    }
    TintInfo localTintInfo = mMinute;
    mTintMode = paramMode;
    boolean bool;
    if (paramMode != null) {
      bool = true;
    } else {
      bool = false;
    }
    mHasTintMode = bool;
    loadFromAttributes();
  }
  
  void setTime(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!ViewUtils.mIs24HourMode) {
      setEnabled();
    }
  }
  
  int[] setTime()
  {
    return b.e();
  }
  
  void update(WeakReference paramWeakReference, Typeface paramTypeface)
  {
    if (s)
    {
      t = paramTypeface;
      paramWeakReference = (TextView)paramWeakReference.get();
      if (paramWeakReference != null)
      {
        if (v7.v7.package_13.ViewCompat.d(paramWeakReference))
        {
          paramWeakReference.post(new b(this, paramWeakReference, paramTypeface, n));
          return;
        }
        paramWeakReference.setTypeface(paramTypeface, n);
      }
    }
  }
}
