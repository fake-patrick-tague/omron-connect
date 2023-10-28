package androidx.core.content.asm;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.XmlResourceParser;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.core.content.g.j.d;
import androidx.core.content.g.j.e;
import androidx.core.graphics.ClassWriter;
import java.io.IOException;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

public final class Label
{
  private static final ThreadLocal<TypedValue> TL_TYPED_VALUE = new ThreadLocal();
  private static final WeakHashMap<j.e, SparseArray<j.d>> d = new WeakHashMap(0);
  private static final java.lang.Object e = new java.lang.Object();
  
  public static ColorStateList a(Resources paramResources, int paramInt, Resources.Theme paramTheme)
    throws Resources.NotFoundException
  {
    Handle localHandle = new Handle(paramResources, paramTheme);
    ColorStateList localColorStateList = a(localHandle, paramInt);
    if (localColorStateList != null) {
      return localColorStateList;
    }
    localColorStateList = b(paramResources, paramInt, paramTheme);
    if (localColorStateList != null)
    {
      a(localHandle, paramInt, localColorStateList, paramTheme);
      return localColorStateList;
    }
    if (Build.VERSION.SDK_INT >= 23) {
      return ContextCompat.getColorStateList(paramResources, paramInt, paramTheme);
    }
    return paramResources.getColorStateList(paramInt);
  }
  
  private static ColorStateList a(Handle paramHandle, int paramInt)
  {
    java.lang.Object localObject = e;
    try
    {
      SparseArray localSparseArray = (SparseArray)d.get(paramHandle);
      if ((localSparseArray != null) && (localSparseArray.size() > 0))
      {
        e localE = (e)localSparseArray.get(paramInt);
        if (localE != null)
        {
          if (a.equals(f.getConfiguration()))
          {
            paramHandle = a;
            if (((paramHandle == null) && (f == 0)) || ((paramHandle != null) && (f == paramHandle.hashCode())))
            {
              paramHandle = c;
              return paramHandle;
            }
          }
          localSparseArray.remove(paramInt);
        }
      }
      return null;
    }
    catch (Throwable paramHandle)
    {
      throw paramHandle;
    }
  }
  
  public static Typeface a(Context paramContext, int paramInt)
    throws Resources.NotFoundException
  {
    if (paramContext.isRestricted()) {
      return null;
    }
    return a(paramContext, paramInt, new TypedValue(), 0, null, null, false, false);
  }
  
  public static Typeface a(Context paramContext, int paramInt1, TypedValue paramTypedValue, int paramInt2, d paramD)
    throws Resources.NotFoundException
  {
    if (paramContext.isRestricted()) {
      return null;
    }
    return a(paramContext, paramInt1, paramTypedValue, paramInt2, paramD, null, true, false);
  }
  
  private static Typeface a(Context paramContext, int paramInt1, TypedValue paramTypedValue, int paramInt2, d paramD, Handler paramHandler, boolean paramBoolean1, boolean paramBoolean2)
  {
    Resources localResources = paramContext.getResources();
    localResources.getValue(paramInt1, paramTypedValue, true);
    paramContext = a(paramContext, localResources, paramTypedValue, paramInt1, paramInt2, paramD, paramHandler, paramBoolean1, paramBoolean2);
    if ((paramContext == null) && (paramD == null))
    {
      if (paramBoolean2) {
        return paramContext;
      }
      paramContext = new StringBuilder();
      paramContext.append("Font resource ID #0x");
      paramContext.append(Integer.toHexString(paramInt1));
      paramContext.append(" could not be retrieved.");
      throw new Resources.NotFoundException(paramContext.toString());
    }
    return paramContext;
  }
  
  private static Typeface a(Context paramContext, Resources paramResources, TypedValue paramTypedValue, int paramInt1, int paramInt2, d paramD, Handler paramHandler, boolean paramBoolean1, boolean paramBoolean2)
  {
    java.lang.Object localObject1 = string;
    java.lang.Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((CharSequence)localObject1).toString();
      if (!((String)localObject1).startsWith("res/"))
      {
        if (paramD != null)
        {
          paramD.a(-3, paramHandler);
          return null;
        }
      }
      else
      {
        localObject2 = ClassWriter.b(paramResources, paramInt1, (String)localObject1, assetCookie, paramInt2);
        if (localObject2 != null)
        {
          if (paramD == null) {
            break label382;
          }
          paramD.a((Typeface)localObject2, paramHandler);
          return localObject2;
        }
        if (paramBoolean2) {
          return null;
        }
        try
        {
          paramBoolean2 = ((String)localObject1).toLowerCase().endsWith(".xml");
          if (paramBoolean2)
          {
            localObject2 = Item.inflate(paramResources.getXml(paramInt1), paramResources);
            if (localObject2 == null)
            {
              android.util.Log.e("ResourcesCompat", "Failed to find font-family tag");
              if (paramD == null) {
                break label385;
              }
              paramD.a(-3, paramHandler);
              return null;
            }
            i = assetCookie;
            paramContext = ClassWriter.a(paramContext, (Object)localObject2, paramResources, paramInt1, (String)localObject1, i, paramInt2, paramD, paramHandler, paramBoolean1);
            return paramContext;
          }
          int i = assetCookie;
          paramContext = ClassWriter.a(paramContext, paramResources, paramInt1, (String)localObject1, i, paramInt2);
          if (paramD == null) {
            break label387;
          }
          if (paramContext != null)
          {
            paramD.a(paramContext, paramHandler);
            return paramContext;
          }
          paramD.a(-3, paramHandler);
          return paramContext;
        }
        catch (IOException paramContext)
        {
          paramResources = new StringBuilder();
          paramResources.append("Failed to read xml resource ");
          paramResources.append((String)localObject1);
          android.util.Log.e("ResourcesCompat", paramResources.toString(), paramContext);
        }
        catch (XmlPullParserException paramContext)
        {
          paramResources = new StringBuilder();
          paramResources.append("Failed to parse xml resource ");
          paramResources.append((String)localObject1);
          android.util.Log.e("ResourcesCompat", paramResources.toString(), paramContext);
        }
        if (paramD == null) {
          break label389;
        }
        paramD.a(-3, paramHandler);
        return null;
      }
    }
    else
    {
      paramContext = new StringBuilder();
      paramContext.append("Resource \"");
      paramContext.append(paramResources.getResourceName(paramInt1));
      paramContext.append("\" (");
      paramContext.append(Integer.toHexString(paramInt1));
      paramContext.append(") is not a Font: ");
      paramContext.append(paramTypedValue);
      throw new Resources.NotFoundException(paramContext.toString());
    }
    return null;
    label382:
    return localObject2;
    label385:
    return null;
    label387:
    return paramContext;
    label389:
    return null;
  }
  
  public static void a(Context paramContext, int paramInt, d paramD, Handler paramHandler)
    throws Resources.NotFoundException
  {
    v7.v7.util.Log.valueOf(paramD);
    if (paramContext.isRestricted())
    {
      paramD.a(-4, paramHandler);
      return;
    }
    a(paramContext, paramInt, new TypedValue(), 0, paramD, paramHandler, false, false);
  }
  
  private static void a(Handle paramHandle, int paramInt, ColorStateList paramColorStateList, Resources.Theme paramTheme)
  {
    java.lang.Object localObject = e;
    try
    {
      WeakHashMap localWeakHashMap = d;
      SparseArray localSparseArray2 = (SparseArray)localWeakHashMap.get(paramHandle);
      SparseArray localSparseArray1 = localSparseArray2;
      if (localSparseArray2 == null)
      {
        localSparseArray1 = new SparseArray();
        localWeakHashMap.put(paramHandle, localSparseArray1);
      }
      localSparseArray1.append(paramInt, new e(paramColorStateList, f.getConfiguration(), paramTheme));
      return;
    }
    catch (Throwable paramHandle)
    {
      throw paramHandle;
    }
  }
  
  private static boolean a(Resources paramResources, int paramInt)
  {
    TypedValue localTypedValue = getTypedValue();
    paramResources.getValue(paramInt, localTypedValue, true);
    paramInt = type;
    return (paramInt >= 28) && (paramInt <= 31);
  }
  
  private static ColorStateList b(Resources paramResources, int paramInt, Resources.Theme paramTheme)
  {
    if (a(paramResources, paramInt)) {
      return null;
    }
    XmlResourceParser localXmlResourceParser = paramResources.getXml(paramInt);
    try
    {
      paramResources = Type.create(paramResources, localXmlResourceParser, paramTheme);
      return paramResources;
    }
    catch (Exception paramResources)
    {
      android.util.Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", paramResources);
    }
    return null;
  }
  
  public static int getColor(Resources paramResources, int paramInt, Resources.Theme paramTheme)
    throws Resources.NotFoundException
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return ContextCompat.getColor(paramResources, paramInt, paramTheme);
    }
    return paramResources.getColor(paramInt);
  }
  
  public static Drawable getDrawable(Resources paramResources, int paramInt, Resources.Theme paramTheme)
    throws Resources.NotFoundException
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ResourcesCompatApi21.getDrawable(paramResources, paramInt, paramTheme);
    }
    return paramResources.getDrawable(paramInt);
  }
  
  public static Drawable getDrawableForDensity(Resources paramResources, int paramInt1, int paramInt2, Resources.Theme paramTheme)
    throws Resources.NotFoundException
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21) {
      return ResourcesCompatApi21.getDrawableForDensity(paramResources, paramInt1, paramInt2, paramTheme);
    }
    if (i >= 15) {
      return ResourcesCompatIcsMr1.getDrawableForDensity(paramResources, paramInt1, paramInt2);
    }
    return paramResources.getDrawable(paramInt1);
  }
  
  private static TypedValue getTypedValue()
  {
    ThreadLocal localThreadLocal = TL_TYPED_VALUE;
    TypedValue localTypedValue2 = (TypedValue)localThreadLocal.get();
    TypedValue localTypedValue1 = localTypedValue2;
    if (localTypedValue2 == null)
    {
      localTypedValue1 = new TypedValue();
      localThreadLocal.set(localTypedValue1);
    }
    return localTypedValue1;
  }
}
