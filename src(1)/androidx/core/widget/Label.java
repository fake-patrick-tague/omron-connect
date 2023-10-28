package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.view.ActionMode.Callback;
import android.view.View;
import android.widget.TextView;
import java.lang.reflect.Field;
import v7.v7.text.StrBuilder;
import v7.v7.text.c.a.a;

public final class Label
{
  private static Field sMaxModeField;
  private static boolean sMaxModeFieldFetched;
  private static Field sMaximumField;
  private static boolean sMaximumFieldFetched;
  
  public static ActionMode.Callback a(ActionMode.Callback paramCallback)
  {
    ActionMode.Callback localCallback = paramCallback;
    if ((paramCallback instanceof i))
    {
      localCallback = paramCallback;
      if (Build.VERSION.SDK_INT >= 26) {
        localCallback = ((i)paramCallback).b();
      }
    }
    return localCallback;
  }
  
  public static ActionMode.Callback a(TextView paramTextView, ActionMode.Callback paramCallback)
  {
    int i = Build.VERSION.SDK_INT;
    if ((i >= 26) && (i <= 27) && (!(paramCallback instanceof i)))
    {
      if (paramCallback == null) {
        return paramCallback;
      }
      return new i(paramCallback, paramTextView);
    }
    return paramCallback;
  }
  
  public static v7.v7.text.Label a(TextView paramTextView)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 28) {
      return new v7.v7.text.Label(b.e(paramTextView));
    }
    c.a.a localA = new c.a.a(new TextPaint(paramTextView.getPaint()));
    if (i >= 23)
    {
      localA.b(h.b(paramTextView));
      localA.a(h.f(paramTextView));
    }
    if (i >= 18) {
      localA.b(onCreateView(paramTextView));
    }
    return localA.a();
  }
  
  public static void a(TextView paramTextView, int paramInt)
  {
    v7.v7.util.Log.set(paramInt);
    int i = Build.VERSION.SDK_INT;
    if (i >= 28)
    {
      b.d(paramTextView, paramInt);
      return;
    }
    Paint.FontMetricsInt localFontMetricsInt = paramTextView.getPaint().getFontMetricsInt();
    if ((i >= 16) && (!TextViewCompat.TextViewCompatImpl.validate(paramTextView))) {
      i = ascent;
    } else {
      i = top;
    }
    if (paramInt > Math.abs(i)) {
      paramTextView.setPadding(paramTextView.getPaddingLeft(), paramInt + i, paramTextView.getPaddingRight(), paramTextView.getPaddingBottom());
    }
  }
  
  public static void a(TextView paramTextView, ColorStateList paramColorStateList)
  {
    v7.v7.util.Log.valueOf(paramTextView);
    if (Build.VERSION.SDK_INT >= 24)
    {
      h.setColor(paramTextView, paramColorStateList);
      return;
    }
    if ((paramTextView instanceof Object)) {
      ((Object)paramTextView).setSupportCompoundDrawablesTintList(paramColorStateList);
    }
  }
  
  public static void a(TextView paramTextView, PorterDuff.Mode paramMode)
  {
    v7.v7.util.Log.valueOf(paramTextView);
    if (Build.VERSION.SDK_INT >= 24)
    {
      h.setEnabled(paramTextView, paramMode);
      return;
    }
    if ((paramTextView instanceof Object)) {
      ((Object)paramTextView).setSupportCompoundDrawablesTintMode(paramMode);
    }
  }
  
  public static void a(TextView paramTextView, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 18)
    {
      d.setCompoundDrawablesRelative(paramTextView, paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
      return;
    }
    if (i >= 17)
    {
      int j = d.a(paramTextView);
      i = 1;
      if (j != 1) {
        i = 0;
      }
      Drawable localDrawable;
      if (i != 0) {
        localDrawable = paramDrawable3;
      } else {
        localDrawable = paramDrawable1;
      }
      if (i == 0) {
        paramDrawable1 = paramDrawable3;
      }
      paramTextView.setCompoundDrawables(localDrawable, paramDrawable2, paramDrawable1, paramDrawable4);
      return;
    }
    paramTextView.setCompoundDrawables(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
  }
  
  public static void a(TextView paramTextView, v7.v7.text.Label paramLabel)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 18) {
      d.c(paramTextView, getCode(paramLabel.getColor()));
    }
    if (i < 23)
    {
      float f = paramLabel.getPaint().getTextScaleX();
      paramTextView.getPaint().set(paramLabel.getPaint());
      if (f == paramTextView.getTextScaleX()) {
        paramTextView.setTextScaleX(f / 2.0F + 1.0F);
      }
      paramTextView.setTextScaleX(f);
      return;
    }
    paramTextView.getPaint().set(paramLabel.getPaint());
    h.d(paramTextView, paramLabel.getName());
    h.setChecked(paramTextView, paramLabel.a());
  }
  
  public static void a(TextView paramTextView, StrBuilder paramStrBuilder)
  {
    if (Build.VERSION.SDK_INT >= 29)
    {
      paramTextView.setText((CharSequence)paramStrBuilder.append());
      return;
    }
    if (a(paramTextView).a(paramStrBuilder.size()))
    {
      paramTextView.setText(paramStrBuilder);
      return;
    }
    throw new IllegalArgumentException("Given text can not be applied to TextView.");
  }
  
  public static Drawable[] b(TextView paramTextView)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 18) {
      return d.a(paramTextView);
    }
    if (i >= 17)
    {
      int j = d.a(paramTextView);
      i = 1;
      if (j != 1) {
        i = 0;
      }
      Drawable[] arrayOfDrawable = paramTextView.getCompoundDrawables();
      paramTextView = arrayOfDrawable;
      if (i != 0)
      {
        paramTextView = arrayOfDrawable[2];
        Drawable localDrawable = arrayOfDrawable[0];
        arrayOfDrawable[0] = paramTextView;
        arrayOfDrawable[2] = localDrawable;
        return arrayOfDrawable;
      }
    }
    else
    {
      paramTextView = paramTextView.getCompoundDrawables();
    }
    return paramTextView;
  }
  
  private static int getCode(TextDirectionHeuristic paramTextDirectionHeuristic)
  {
    if (paramTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
      return 1;
    }
    if (paramTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
      return 1;
    }
    if (paramTextDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
      return 2;
    }
    if (paramTextDirectionHeuristic == TextDirectionHeuristics.LTR) {
      return 3;
    }
    if (paramTextDirectionHeuristic == TextDirectionHeuristics.RTL) {
      return 4;
    }
    if (paramTextDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
      return 5;
    }
    if (paramTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
      return 6;
    }
    if (paramTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
      return 7;
    }
    return 1;
  }
  
  public static int getMaxLines(TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return TextViewCompat.TextViewCompatImpl.getMaxLines(paramTextView);
    }
    if (!sMaxModeFieldFetched)
    {
      sMaxModeField = retrieveField("mMaxMode");
      sMaxModeFieldFetched = true;
    }
    Field localField = sMaxModeField;
    if ((localField != null) && (retrieveIntFromField(localField, paramTextView) == 1))
    {
      if (!sMaximumFieldFetched)
      {
        sMaximumField = retrieveField("mMaximum");
        sMaximumFieldFetched = true;
      }
      localField = sMaximumField;
      if (localField != null) {
        return retrieveIntFromField(localField, paramTextView);
      }
    }
    return -1;
  }
  
  public static void init(TextView paramTextView, int paramInt)
  {
    v7.v7.util.Log.set(paramInt);
    int i = paramTextView.getPaint().getFontMetricsInt(null);
    if (paramInt != i) {
      paramTextView.setLineSpacing(paramInt - i, 1.0F);
    }
  }
  
  private static TextDirectionHeuristic onCreateView(TextView paramTextView)
  {
    if ((paramTextView.getTransformationMethod() instanceof PasswordTransformationMethod)) {
      return TextDirectionHeuristics.LTR;
    }
    int j = Build.VERSION.SDK_INT;
    int i = 0;
    if ((j >= 28) && ((paramTextView.getInputType() & 0xF) == 3))
    {
      i = Character.getDirectionality(b.toString(NativeWith.get(d.d(paramTextView)))[0].codePointAt(0));
      if ((i != 1) && (i != 2)) {
        return TextDirectionHeuristics.LTR;
      }
      return TextDirectionHeuristics.RTL;
    }
    if (d.a(paramTextView) == 1) {
      i = 1;
    }
    switch (d.c(paramTextView))
    {
    default: 
      if (i != 0) {
        return TextDirectionHeuristics.FIRSTSTRONG_RTL;
      }
      break;
    case 7: 
      return TextDirectionHeuristics.FIRSTSTRONG_RTL;
    case 6: 
      return TextDirectionHeuristics.FIRSTSTRONG_LTR;
    case 5: 
      return TextDirectionHeuristics.LOCALE;
    case 4: 
      return TextDirectionHeuristics.RTL;
    case 3: 
      return TextDirectionHeuristics.LTR;
    case 2: 
      return TextDirectionHeuristics.ANYRTL_LTR;
    }
    return TextDirectionHeuristics.FIRSTSTRONG_LTR;
  }
  
  private static Field retrieveField(String paramString)
  {
    java.lang.Object localObject1 = null;
    try
    {
      localObject2 = TextView.class.getDeclaredField(paramString);
      localObject1 = localObject2;
      ((Field)localObject2).setAccessible(true);
      return localObject2;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      java.lang.Object localObject2;
      for (;;) {}
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Could not retrieve ");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(" field.");
    android.util.Log.e("TextViewCompat", ((StringBuilder)localObject2).toString());
    return localObject1;
  }
  
  private static int retrieveIntFromField(Field paramField, TextView paramTextView)
  {
    try
    {
      int i = paramField.getInt(paramTextView);
      return i;
    }
    catch (IllegalAccessException paramTextView)
    {
      for (;;) {}
    }
    paramTextView = new StringBuilder();
    paramTextView.append("Could not retrieve value of ");
    paramTextView.append(paramField.getName());
    paramTextView.append(" field.");
    android.util.Log.d("TextViewCompat", paramTextView.toString());
    return -1;
  }
  
  public static int setText(TextView paramTextView)
  {
    return paramTextView.getPaddingBottom() + getPaintgetFontMetricsIntbottom;
  }
  
  public static void setText(TextView paramTextView, int paramInt)
  {
    v7.v7.util.Log.set(paramInt);
    Paint.FontMetricsInt localFontMetricsInt = paramTextView.getPaint().getFontMetricsInt();
    int i;
    if ((Build.VERSION.SDK_INT >= 16) && (!TextViewCompat.TextViewCompatImpl.validate(paramTextView))) {
      i = descent;
    } else {
      i = bottom;
    }
    if (paramInt > Math.abs(i)) {
      paramTextView.setPadding(paramTextView.getPaddingLeft(), paramTextView.getPaddingTop(), paramTextView.getPaddingRight(), paramInt - i);
    }
  }
  
  public static void setTextAppearance(TextView paramTextView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramTextView.setTextAppearance(paramInt);
      return;
    }
    paramTextView.setTextAppearance(paramTextView.getContext(), paramInt);
  }
  
  public static int updatePadding(TextView paramTextView)
  {
    return paramTextView.getPaddingTop() - getPaintgetFontMetricsInttop;
  }
}
