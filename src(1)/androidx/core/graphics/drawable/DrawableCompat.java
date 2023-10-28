package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class DrawableCompat
{
  private static boolean b;
  private static Method c;
  private static Method sGetLayoutDirectionMethod;
  private static boolean sGetLayoutDirectionMethodFetched;
  
  public static void a(Drawable paramDrawable)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23)
    {
      paramDrawable.clearColorFilter();
      return;
    }
    if (i >= 21)
    {
      paramDrawable.clearColorFilter();
      if ((paramDrawable instanceof InsetDrawable))
      {
        a(DrawableCompatKitKat.getIcon((InsetDrawable)paramDrawable));
        return;
      }
      if ((paramDrawable instanceof Integer))
      {
        a(((Integer)paramDrawable).getWrappedDrawable());
        return;
      }
      if ((paramDrawable instanceof DrawableContainer))
      {
        paramDrawable = (DrawableContainer.DrawableContainerState)((DrawableContainer)paramDrawable).getConstantState();
        if (paramDrawable != null)
        {
          i = 0;
          int j = paramDrawable.getChildCount();
          while (i < j)
          {
            Drawable localDrawable = DrawableCompatKitKat.getItem(paramDrawable, i);
            if (localDrawable != null) {
              a(localDrawable);
            }
            i += 1;
          }
        }
      }
    }
    else
    {
      paramDrawable.clearColorFilter();
    }
  }
  
  public static boolean a(Drawable paramDrawable, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23) {
      return ViewCompat.a(paramDrawable, paramInt);
    }
    if (i >= 17)
    {
      if (!b)
      {
        Object localObject = java.lang.Integer.TYPE;
        try
        {
          localObject = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[] { localObject });
          c = (Method)localObject;
          ((Method)localObject).setAccessible(true);
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          Log.i("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", localNoSuchMethodException);
        }
        b = true;
      }
      Method localMethod = c;
      if (localMethod != null) {
        try
        {
          localMethod.invoke(paramDrawable, new Object[] { java.lang.Integer.valueOf(paramInt) });
          return true;
        }
        catch (Exception paramDrawable)
        {
          Log.i("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", paramDrawable);
          c = null;
        }
      }
    }
    return false;
  }
  
  public static void append(Drawable paramDrawable, ColorStateList paramColorStateList)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      DrawableImpl.setTintList(paramDrawable, paramColorStateList);
      return;
    }
    if ((paramDrawable instanceof DrawableWrapper)) {
      ((DrawableWrapper)paramDrawable).setTintList(paramColorStateList);
    }
  }
  
  public static void applyTheme(Drawable paramDrawable, Resources.Theme paramTheme)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      DrawableImpl.applyTheme(paramDrawable, paramTheme);
    }
  }
  
  public static boolean canApplyTheme(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return DrawableImpl.canApplyTheme(paramDrawable);
    }
    return false;
  }
  
  public static int getAlpha(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return DrawableCompatKitKat.getAlpha(paramDrawable);
    }
    return 0;
  }
  
  public static ColorFilter getColorFilter(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return DrawableImpl.getColorFilter(paramDrawable);
    }
    return null;
  }
  
  public static Drawable getDrawable(Drawable paramDrawable)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23) {
      return paramDrawable;
    }
    if (i >= 21)
    {
      if (!(paramDrawable instanceof DrawableWrapper)) {
        return new DrawableWrapperLollipop(paramDrawable);
      }
      return paramDrawable;
    }
    if (!(paramDrawable instanceof DrawableWrapper)) {
      return new DrawableWrapperDonut(paramDrawable);
    }
    return paramDrawable;
  }
  
  public static int getLayoutDirection(Drawable paramDrawable)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23) {
      return ViewCompat.getLayoutDirection(paramDrawable);
    }
    if (i >= 17)
    {
      if (!sGetLayoutDirectionMethodFetched)
      {
        try
        {
          Method localMethod1 = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
          sGetLayoutDirectionMethod = localMethod1;
          localMethod1.setAccessible(true);
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          Log.i("DrawableCompat", "Failed to retrieve getLayoutDirection() method", localNoSuchMethodException);
        }
        sGetLayoutDirectionMethodFetched = true;
      }
      Method localMethod2 = sGetLayoutDirectionMethod;
      if (localMethod2 != null) {
        try
        {
          paramDrawable = localMethod2.invoke(paramDrawable, new Object[0]);
          paramDrawable = (java.lang.Integer)paramDrawable;
          i = paramDrawable.intValue();
          return i;
        }
        catch (Exception paramDrawable)
        {
          Log.i("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", paramDrawable);
          sGetLayoutDirectionMethod = null;
        }
      }
    }
    return 0;
  }
  
  public static void inflate(Drawable paramDrawable, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      DrawableImpl.inflate(paramDrawable, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    }
    paramDrawable.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
  }
  
  public static boolean isAutoMirrored(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return DrawableCompatKitKat.isAutoMirrored(paramDrawable);
    }
    return false;
  }
  
  public static void jumpToCurrentState(Drawable paramDrawable)
  {
    paramDrawable.jumpToCurrentState();
  }
  
  public static void setAutoMirrored(Drawable paramDrawable, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      DrawableCompatKitKat.setAutoMirrored(paramDrawable, paramBoolean);
    }
  }
  
  public static void setHotspot(Drawable paramDrawable, float paramFloat1, float paramFloat2)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      DrawableImpl.setHotspot(paramDrawable, paramFloat1, paramFloat2);
    }
  }
  
  public static void setHotspotBounds(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      DrawableImpl.setHotspotBounds(paramDrawable, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public static void setTint(Drawable paramDrawable, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      DrawableImpl.setTint(paramDrawable, paramInt);
      return;
    }
    if ((paramDrawable instanceof DrawableWrapper)) {
      ((DrawableWrapper)paramDrawable).setTint(paramInt);
    }
  }
  
  public static void setTintMode(Drawable paramDrawable, PorterDuff.Mode paramMode)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      DrawableImpl.setTintMode(paramDrawable, paramMode);
      return;
    }
    if ((paramDrawable instanceof DrawableWrapper)) {
      ((DrawableWrapper)paramDrawable).setTintMode(paramMode);
    }
  }
  
  public static Drawable unwrap(Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if ((paramDrawable instanceof Integer)) {
      localDrawable = ((Integer)paramDrawable).getWrappedDrawable();
    }
    return localDrawable;
  }
  
  class DrawableImpl
  {
    static void applyTheme(Drawable paramDrawable, Resources.Theme paramTheme)
    {
      paramDrawable.applyTheme(paramTheme);
    }
    
    static boolean canApplyTheme(Drawable paramDrawable)
    {
      return paramDrawable.canApplyTheme();
    }
    
    static ColorFilter getColorFilter(Drawable paramDrawable)
    {
      return paramDrawable.getColorFilter();
    }
    
    static void inflate(Drawable paramDrawable, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
      throws XmlPullParserException, IOException
    {
      paramDrawable.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    }
    
    static void setHotspot(Drawable paramDrawable, float paramFloat1, float paramFloat2)
    {
      paramDrawable.setHotspot(paramFloat1, paramFloat2);
    }
    
    static void setHotspotBounds(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      paramDrawable.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    static void setTint(Drawable paramDrawable, int paramInt)
    {
      paramDrawable.setTint(paramInt);
    }
    
    static void setTintList(Drawable paramDrawable, ColorStateList paramColorStateList)
    {
      paramDrawable.setTintList(paramColorStateList);
    }
    
    static void setTintMode(Drawable paramDrawable, PorterDuff.Mode paramMode)
    {
      paramDrawable.setTintMode(paramMode);
    }
  }
}
