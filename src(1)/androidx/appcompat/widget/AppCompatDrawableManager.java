package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import c.e.d;
import c.e.g;
import c.e.h;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import v7.development.colorpickerview.drawable.VectorDrawableCompat;
import v7.util.Label;
import v7.util.SimpleArrayMap;
import v7.util.SparseArray;

public final class AppCompatDrawableManager
{
  private static final d0.c COLOR_FILTER_CACHE = new d0.c(6);
  private static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
  private static AppCompatDrawableManager INSTANCE;
  private d0.f cache;
  private boolean found;
  private g<String, d0.e> mDelegates;
  private final WeakHashMap<Context, d<WeakReference<Drawable.ConstantState>>> mDrawableCaches = new WeakHashMap(0);
  private h<String> mKnownDrawableIdTags;
  private WeakHashMap<Context, h<ColorStateList>> mTintLists;
  private TypedValue mTypedValue;
  
  public AppCompatDrawableManager() {}
  
  private void addDelegate(String paramString, d0.e paramE)
  {
    if (mDelegates == null) {
      mDelegates = new SimpleArrayMap();
    }
    mDelegates.put(paramString, paramE);
  }
  
  private boolean addDrawableToCache(Context paramContext, long paramLong, android.graphics.drawable.Drawable paramDrawable)
  {
    try
    {
      Drawable.ConstantState localConstantState = paramDrawable.getConstantState();
      if (localConstantState != null)
      {
        SparseArray localSparseArray = (SparseArray)mDrawableCaches.get(paramContext);
        paramDrawable = localSparseArray;
        if (localSparseArray == null)
        {
          paramDrawable = new SparseArray();
          mDrawableCaches.put(paramContext, paramDrawable);
        }
        paramDrawable.put(paramLong, new WeakReference(localConstantState));
        return true;
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  private void addTintListToCache(Context paramContext, int paramInt, ColorStateList paramColorStateList)
  {
    if (mTintLists == null) {
      mTintLists = new WeakHashMap();
    }
    Label localLabel2 = (Label)mTintLists.get(paramContext);
    Label localLabel1 = localLabel2;
    if (localLabel2 == null)
    {
      localLabel1 = new Label();
      mTintLists.put(paramContext, localLabel1);
    }
    localLabel1.d(paramInt, paramColorStateList);
  }
  
  private static long createCacheKey(TypedValue paramTypedValue)
  {
    return assetCookie << 32 | data;
  }
  
  private android.graphics.drawable.Drawable createDrawableIfNeeded(Context paramContext, int paramInt)
  {
    if (mTypedValue == null) {
      mTypedValue = new TypedValue();
    }
    TypedValue localTypedValue = mTypedValue;
    paramContext.getResources().getValue(paramInt, localTypedValue, true);
    long l = createCacheKey(localTypedValue);
    Object localObject = getCachedDrawable(paramContext, l);
    if (localObject != null) {
      return localObject;
    }
    localObject = cache;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((d0.f)localObject).tintDrawable(this, paramContext, paramInt);
    }
    if (localObject != null)
    {
      ((android.graphics.drawable.Drawable)localObject).setChangingConfigurations(changingConfigurations);
      addDrawableToCache(paramContext, l, (android.graphics.drawable.Drawable)localObject);
    }
    return localObject;
  }
  
  private static PorterDuffColorFilter createTintFilter(ColorStateList paramColorStateList, PorterDuff.Mode paramMode, int[] paramArrayOfInt)
  {
    if ((paramColorStateList != null) && (paramMode != null)) {
      return getPorterDuffColorFilter(paramColorStateList.getColorForState(paramArrayOfInt, 0), paramMode);
    }
    return null;
  }
  
  public static AppCompatDrawableManager get()
  {
    try
    {
      if (INSTANCE == null)
      {
        localAppCompatDrawableManager = new AppCompatDrawableManager();
        INSTANCE = localAppCompatDrawableManager;
        installDefaultInflateDelegates(localAppCompatDrawableManager);
      }
      AppCompatDrawableManager localAppCompatDrawableManager = INSTANCE;
      return localAppCompatDrawableManager;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  private android.graphics.drawable.Drawable getCachedDrawable(Context paramContext, long paramLong)
  {
    try
    {
      SparseArray localSparseArray = (SparseArray)mDrawableCaches.get(paramContext);
      if (localSparseArray == null) {
        return null;
      }
      Object localObject = (WeakReference)localSparseArray.get(paramLong);
      if (localObject != null)
      {
        localObject = (Drawable.ConstantState)((WeakReference)localObject).get();
        if (localObject != null)
        {
          paramContext = ((Drawable.ConstantState)localObject).newDrawable(paramContext.getResources());
          return paramContext;
        }
        localSparseArray.remove(paramLong);
      }
      return null;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  private android.graphics.drawable.Drawable getDrawable(Context paramContext, int paramInt, boolean paramBoolean, android.graphics.drawable.Drawable paramDrawable)
  {
    Object localObject = get(paramContext, paramInt);
    if (localObject != null)
    {
      paramContext = paramDrawable;
      if (Drawable.canSafelyMutateDrawable(paramDrawable)) {
        paramContext = paramDrawable.mutate();
      }
      paramContext = DrawableCompat.getDrawable(paramContext);
      DrawableCompat.append(paramContext, (ColorStateList)localObject);
      paramDrawable = getDrawable(paramInt);
      localObject = paramContext;
      if (paramDrawable != null)
      {
        DrawableCompat.setTintMode(paramContext, paramDrawable);
        return paramContext;
      }
    }
    else
    {
      localObject = cache;
      if ((localObject != null) && (((d0.f)localObject).tintDrawable(paramContext, paramInt, paramDrawable))) {
        return paramDrawable;
      }
      localObject = paramDrawable;
      if (!get(paramContext, paramInt, paramDrawable))
      {
        localObject = paramDrawable;
        if (paramBoolean) {
          return null;
        }
      }
    }
    return localObject;
  }
  
  public static PorterDuffColorFilter getPorterDuffColorFilter(int paramInt, PorterDuff.Mode paramMode)
  {
    try
    {
      d0.c localC = COLOR_FILTER_CACHE;
      PorterDuffColorFilter localPorterDuffColorFilter2 = localC.get(paramInt, paramMode);
      PorterDuffColorFilter localPorterDuffColorFilter1 = localPorterDuffColorFilter2;
      if (localPorterDuffColorFilter2 == null)
      {
        localPorterDuffColorFilter1 = new PorterDuffColorFilter(paramInt, paramMode);
        localC.put(paramInt, paramMode, localPorterDuffColorFilter1);
      }
      return localPorterDuffColorFilter1;
    }
    catch (Throwable paramMode)
    {
      throw paramMode;
    }
  }
  
  private ColorStateList getTintListFromCache(Context paramContext, int paramInt)
  {
    WeakHashMap localWeakHashMap = mTintLists;
    if (localWeakHashMap != null)
    {
      paramContext = (Label)localWeakHashMap.get(paramContext);
      if (paramContext != null) {
        return (ColorStateList)paramContext.get(paramInt);
      }
    }
    return null;
  }
  
  private static void installDefaultInflateDelegates(AppCompatDrawableManager paramAppCompatDrawableManager)
  {
    if (Build.VERSION.SDK_INT < 24)
    {
      paramAppCompatDrawableManager.addDelegate("vector", new d0.g());
      paramAppCompatDrawableManager.addDelegate("animated-vector", new d0.b());
      paramAppCompatDrawableManager.addDelegate("animated-selector", new d0.a());
      paramAppCompatDrawableManager.addDelegate("drawable", new d0.d());
    }
  }
  
  private static boolean isVectorDrawable(android.graphics.drawable.Drawable paramDrawable)
  {
    return ((paramDrawable instanceof VectorDrawableCompat)) || ("android.graphics.drawable.VectorDrawable".equals(paramDrawable.getClass().getName()));
  }
  
  private android.graphics.drawable.Drawable loadDrawableFromDelegates(Context paramContext, int paramInt)
  {
    Object localObject1 = mDelegates;
    Object localObject3;
    if ((localObject1 != null) && (!((SimpleArrayMap)localObject1).isEmpty()))
    {
      localObject1 = mKnownDrawableIdTags;
      if (localObject1 != null)
      {
        localObject1 = (String)((Label)localObject1).get(paramInt);
        if ("appcompat_skip_skip".equals(localObject1)) {
          break label420;
        }
        if ((localObject1 != null) && (mDelegates.get(localObject1) == null)) {
          return null;
        }
      }
      else
      {
        mKnownDrawableIdTags = new Label();
      }
      if (mTypedValue == null) {
        mTypedValue = new TypedValue();
      }
      TypedValue localTypedValue = mTypedValue;
      Object localObject4 = paramContext.getResources();
      ((Resources)localObject4).getValue(paramInt, localTypedValue, true);
      long l = createCacheKey(localTypedValue);
      Object localObject2 = getCachedDrawable(paramContext, l);
      localObject1 = localObject2;
      if (localObject2 != null) {
        return localObject2;
      }
      localObject2 = string;
      localObject3 = localObject1;
      if (localObject2 != null)
      {
        localObject3 = localObject1;
        if (((CharSequence)localObject2).toString().endsWith(".xml"))
        {
          localObject3 = localObject1;
          try
          {
            localObject4 = ((Resources)localObject4).getXml(paramInt);
            localObject3 = localObject1;
            AttributeSet localAttributeSet = Xml.asAttributeSet((XmlPullParser)localObject4);
            int i;
            do
            {
              localObject3 = localObject1;
              i = ((XmlPullParser)localObject4).next();
            } while ((i != 2) && (i != 1));
            if (i == 2)
            {
              localObject3 = localObject1;
              localObject2 = ((XmlPullParser)localObject4).getName();
              Object localObject5 = mKnownDrawableIdTags;
              localObject3 = localObject1;
              ((Label)localObject5).d(paramInt, localObject2);
              localObject5 = mDelegates;
              localObject3 = localObject1;
              localObject2 = ((SimpleArrayMap)localObject5).get(localObject2);
              localObject5 = (d0.e)localObject2;
              localObject2 = localObject1;
              if (localObject5 != null)
              {
                localObject3 = localObject1;
                localObject2 = ((d0.e)localObject5).create(paramContext, (XmlPullParser)localObject4, localAttributeSet, paramContext.getTheme());
              }
              localObject3 = localObject2;
              if (localObject2 != null)
              {
                i = changingConfigurations;
                localObject3 = localObject2;
                ((android.graphics.drawable.Drawable)localObject2).setChangingConfigurations(i);
                localObject3 = localObject2;
                addDrawableToCache(paramContext, l, (android.graphics.drawable.Drawable)localObject2);
                localObject3 = localObject2;
              }
            }
            else
            {
              localObject3 = localObject1;
              paramContext = new XmlPullParserException("No start tag found");
              throw paramContext;
            }
          }
          catch (Exception paramContext)
          {
            Log.e("ResourceManagerInternal", "Exception while inflating drawable", paramContext);
          }
        }
      }
      if (localObject3 != null) {
        break label422;
      }
      mKnownDrawableIdTags.d(paramInt, "appcompat_skip_skip");
      return localObject3;
    }
    label420:
    return null;
    label422:
    return localObject3;
  }
  
  private void tintDrawable(Context paramContext)
  {
    if (found) {
      return;
    }
    found = true;
    paramContext = getDrawable(paramContext, v7.internal.widget.TintInfo.abc_cab_background_internal_bg);
    if ((paramContext != null) && (isVectorDrawable(paramContext))) {
      return;
    }
    found = false;
    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
  }
  
  static void tintDrawable(android.graphics.drawable.Drawable paramDrawable, TintInfo paramTintInfo, int[] paramArrayOfInt)
  {
    Object localObject = paramDrawable.getState();
    if (Drawable.canSafelyMutateDrawable(paramDrawable))
    {
      int i;
      if (paramDrawable.mutate() == paramDrawable) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0)
      {
        Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
        return;
      }
    }
    if (((paramDrawable instanceof LayerDrawable)) && (paramDrawable.isStateful()))
    {
      paramDrawable.setState(new int[0]);
      paramDrawable.setState((int[])localObject);
    }
    boolean bool = mHasTintList;
    if ((!bool) && (!mHasTintMode))
    {
      paramDrawable.clearColorFilter();
    }
    else
    {
      if (bool) {
        localObject = mTintList;
      } else {
        localObject = null;
      }
      if (mHasTintMode) {
        paramTintInfo = mTintMode;
      } else {
        paramTintInfo = DEFAULT_MODE;
      }
      paramDrawable.setColorFilter(createTintFilter((ColorStateList)localObject, paramTintInfo, paramArrayOfInt));
    }
    if (Build.VERSION.SDK_INT <= 23) {
      paramDrawable.invalidateSelf();
    }
  }
  
  ColorStateList get(Context paramContext, int paramInt)
  {
    try
    {
      Object localObject1 = getTintListFromCache(paramContext, paramInt);
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = cache;
        if (localObject1 == null) {
          localObject1 = null;
        } else {
          localObject1 = ((d0.f)localObject1).getTintList(paramContext, paramInt);
        }
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          addTintListToCache(paramContext, paramInt, (ColorStateList)localObject1);
          localObject2 = localObject1;
        }
      }
      return localObject2;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public void get(Context paramContext)
  {
    try
    {
      paramContext = (SparseArray)mDrawableCaches.get(paramContext);
      if (paramContext != null) {
        paramContext.clear();
      }
      return;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public void get(d0.f paramF)
  {
    try
    {
      cache = paramF;
      return;
    }
    catch (Throwable paramF)
    {
      throw paramF;
    }
  }
  
  boolean get(Context paramContext, int paramInt, android.graphics.drawable.Drawable paramDrawable)
  {
    d0.f localF = cache;
    return (localF != null) && (localF.tintDrawableUsingColorFilter(paramContext, paramInt, paramDrawable));
  }
  
  PorterDuff.Mode getDrawable(int paramInt)
  {
    d0.f localF = cache;
    if (localF == null) {
      return null;
    }
    return localF.getTintMode(paramInt);
  }
  
  public android.graphics.drawable.Drawable getDrawable(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = getDrawable(paramContext, paramInt, false);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  android.graphics.drawable.Drawable getDrawable(Context paramContext, int paramInt, boolean paramBoolean)
  {
    try
    {
      tintDrawable(paramContext);
      Object localObject2 = loadDrawableFromDelegates(paramContext, paramInt);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = createDrawableIfNeeded(paramContext, paramInt);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = ContextCompat.getDrawable(paramContext, paramInt);
      }
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = getDrawable(paramContext, paramInt, paramBoolean, (android.graphics.drawable.Drawable)localObject2);
      }
      if (localObject1 != null) {
        Drawable.a((android.graphics.drawable.Drawable)localObject1);
      }
      return localObject1;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  android.graphics.drawable.Drawable getDrawable(Context paramContext, Attribute paramAttribute, int paramInt)
  {
    try
    {
      android.graphics.drawable.Drawable localDrawable2 = loadDrawableFromDelegates(paramContext, paramInt);
      android.graphics.drawable.Drawable localDrawable1 = localDrawable2;
      if (localDrawable2 == null) {
        localDrawable1 = paramAttribute.getIcon(paramInt);
      }
      if (localDrawable1 != null)
      {
        paramContext = getDrawable(paramContext, paramInt, false, localDrawable1);
        return paramContext;
      }
      return null;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
}
