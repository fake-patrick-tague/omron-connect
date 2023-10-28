package androidx.core.graphics.drawable;

import android.content.ContentResolver;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.BaseBundle;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.content.asm.Label;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;

public class IconCompat
  extends CustomVersionedParcelable
{
  static final PorterDuff.Mode name = PorterDuff.Mode.SRC_IN;
  public int a = 0;
  public int b = -1;
  public ColorStateList c = null;
  PorterDuff.Mode id = name;
  public int n = 0;
  public String q;
  public String s = null;
  public Parcelable value = null;
  Object x;
  public byte[] y = null;
  
  public IconCompat() {}
  
  IconCompat(int paramInt)
  {
    b = paramInt;
  }
  
  public static IconCompat a(android.content.Context paramContext, int paramInt)
  {
    v7.v7.util.Context.get(paramContext);
    return a(paramContext.getResources(), paramContext.getPackageName(), paramInt);
  }
  
  public static IconCompat a(Resources paramResources, String paramString, int paramInt)
  {
    v7.v7.util.Context.get(paramString);
    IconCompat localIconCompat;
    if (paramInt != 0)
    {
      localIconCompat = new IconCompat(2);
      n = paramInt;
      if (paramResources == null) {}
    }
    try
    {
      paramResources = paramResources.getResourceName(paramInt);
      x = paramResources;
    }
    catch (Resources.NotFoundException paramResources)
    {
      for (;;) {}
    }
    throw new IllegalArgumentException("Icon resource cannot be found");
    x = paramString;
    q = paramString;
    return localIconCompat;
    throw new IllegalArgumentException("Drawable resource ID must not be 0");
  }
  
  public static IconCompat a(Bitmap paramBitmap)
  {
    v7.v7.util.Context.get(paramBitmap);
    IconCompat localIconCompat = new IconCompat(1);
    x = paramBitmap;
    return localIconCompat;
  }
  
  public static IconCompat a(Icon paramIcon)
  {
    return a.d(paramIcon);
  }
  
  public static IconCompat a(String paramString)
  {
    v7.v7.util.Context.get(paramString);
    IconCompat localIconCompat = new IconCompat(6);
    x = paramString;
    return localIconCompat;
  }
  
  public static IconCompat b(Uri paramUri)
  {
    v7.v7.util.Context.get(paramUri);
    return a(paramUri.toString());
  }
  
  private Drawable doInBackground(android.content.Context paramContext)
  {
    Object localObject;
    switch (b)
    {
    default: 
      return null;
    case 6: 
      localObject = open(paramContext);
      if (localObject == null) {
        break label301;
      }
      if (Build.VERSION.SDK_INT >= 26) {
        return b.apply(null, new BitmapDrawable(paramContext.getResources(), BitmapFactory.decodeStream((InputStream)localObject)));
      }
      return new BitmapDrawable(paramContext.getResources(), transform(BitmapFactory.decodeStream((InputStream)localObject), false));
    case 5: 
      return new BitmapDrawable(paramContext.getResources(), transform((Bitmap)x, false));
    case 4: 
      localObject = open(paramContext);
      if (localObject == null) {
        break label301;
      }
      return new BitmapDrawable(paramContext.getResources(), BitmapFactory.decodeStream((InputStream)localObject));
    case 3: 
      return new BitmapDrawable(paramContext.getResources(), BitmapFactory.decodeByteArray((byte[])x, n, a));
    case 2: 
      String str = d();
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = paramContext.getPackageName();
      }
      localObject = get(paramContext, (String)localObject);
      try
      {
        paramContext = Label.getDrawable((Resources)localObject, n, paramContext.getTheme());
        return paramContext;
      }
      catch (RuntimeException paramContext)
      {
        android.util.Log.e("IconCompat", String.format("Unable to load resource 0x%08x from pkg=%s", new Object[] { Integer.valueOf(n), x }), paramContext);
        return null;
      }
    }
    return new BitmapDrawable(paramContext.getResources(), (Bitmap)x);
    label301:
    return null;
  }
  
  public static IconCompat from(Uri paramUri)
  {
    v7.v7.util.Context.get(paramUri);
    return generate(paramUri.toString());
  }
  
  public static IconCompat generate(String paramString)
  {
    v7.v7.util.Context.get(paramString);
    IconCompat localIconCompat = new IconCompat(4);
    x = paramString;
    return localIconCompat;
  }
  
  static Resources get(android.content.Context paramContext, String paramString)
  {
    if ("android".equals(paramString)) {
      return Resources.getSystem();
    }
    paramContext = paramContext.getPackageManager();
    try
    {
      ApplicationInfo localApplicationInfo = paramContext.getApplicationInfo(paramString, 8192);
      if (localApplicationInfo != null)
      {
        paramContext = paramContext.getResourcesForApplication(localApplicationInfo);
        return paramContext;
      }
      return null;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      android.util.Log.e("IconCompat", String.format("Unable to find pkg=%s for icon", new Object[] { paramString }), paramContext);
    }
    return null;
  }
  
  private static String getNetworkTypeName(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN";
    case 6: 
      return "URI_MASKABLE";
    case 5: 
      return "BITMAP_MASKABLE";
    case 4: 
      return "URI";
    case 3: 
      return "DATA";
    case 2: 
      return "RESOURCE";
    }
    return "BITMAP";
  }
  
  static Bitmap transform(Bitmap paramBitmap, boolean paramBoolean)
  {
    int i = (int)(Math.min(paramBitmap.getWidth(), paramBitmap.getHeight()) * 0.6666667F);
    Bitmap localBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint(3);
    float f1 = i;
    float f2 = 0.5F * f1;
    float f3 = 0.9166667F * f2;
    if (paramBoolean)
    {
      float f4 = 0.010416667F * f1;
      localPaint.setColor(0);
      localPaint.setShadowLayer(f4, 0.0F, f1 * 0.020833334F, 1023410176);
      localCanvas.drawCircle(f2, f2, f3, localPaint);
      localPaint.setShadowLayer(f4, 0.0F, 0.0F, 503316480);
      localCanvas.drawCircle(f2, f2, f3, localPaint);
      localPaint.clearShadowLayer();
    }
    localPaint.setColor(-16777216);
    Object localObject = Shader.TileMode.CLAMP;
    localObject = new BitmapShader(paramBitmap, (Shader.TileMode)localObject, (Shader.TileMode)localObject);
    Matrix localMatrix = new Matrix();
    localMatrix.setTranslate(-(paramBitmap.getWidth() - i) / 2.0F, -(paramBitmap.getHeight() - i) / 2.0F);
    ((Shader)localObject).setLocalMatrix(localMatrix);
    localPaint.setShader((Shader)localObject);
    localCanvas.drawCircle(f2, f2, f3, localPaint);
    localCanvas.setBitmap(null);
    return localBitmap;
  }
  
  public int a()
  {
    int i = b;
    if ((i == -1) && (Build.VERSION.SDK_INT >= 23)) {
      return a.a(x);
    }
    if (i == 2) {
      return n;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("called getResId() on ");
    localStringBuilder.append(this);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public void a(android.content.Context paramContext)
  {
    if (b == 2)
    {
      Object localObject = x;
      if (localObject != null)
      {
        localObject = (String)localObject;
        if (!((String)localObject).contains(":")) {
          return;
        }
        String str2 = localObject.split(":", -1)[1];
        String str1 = str2.split("/", -1)[0];
        String str3 = str2.split("/", -1)[1];
        String str4 = localObject.split(":", -1)[0];
        if ("0_resource_name_obfuscated".equals(str3))
        {
          android.util.Log.i("IconCompat", "Found obfuscated resource, not trying to update resource id for it");
          return;
        }
        str2 = d();
        int i = get(paramContext, str2).getIdentifier(str3, str1, str4);
        if (n != i)
        {
          paramContext = new StringBuilder();
          paramContext.append("Id has changed for ");
          paramContext.append(str2);
          paramContext.append(" ");
          paramContext.append((String)localObject);
          android.util.Log.i("IconCompat", paramContext.toString());
          n = i;
        }
      }
    }
  }
  
  public int b()
  {
    int j = b;
    int i = j;
    if (j == -1)
    {
      i = j;
      if (Build.VERSION.SDK_INT >= 23) {
        i = a.get(x);
      }
    }
    return i;
  }
  
  public String d()
  {
    int i = b;
    if ((i == -1) && (Build.VERSION.SDK_INT >= 23)) {
      return a.b(x);
    }
    if (i == 2)
    {
      localObject = q;
      if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        return q;
      }
      return ((String)x).split(":", -1)[0];
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("called getResPackage() on ");
    ((StringBuilder)localObject).append(this);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public Bundle doInBackground()
  {
    Bundle localBundle = new Bundle();
    switch (b)
    {
    default: 
      break;
    case 0: 
      throw new IllegalArgumentException("Invalid icon");
    case 3: 
      localBundle.putByteArray("obj", (byte[])x);
      break;
    case 2: 
    case 4: 
    case 6: 
      localBundle.putString("obj", (String)x);
      break;
    case 1: 
    case 5: 
      localBundle.putParcelable("obj", (Bitmap)x);
      break;
    }
    localBundle.putParcelable("obj", (Parcelable)x);
    localBundle.putInt("type", b);
    localBundle.putInt("int1", n);
    localBundle.putInt("int2", a);
    localBundle.putString("string1", q);
    Object localObject = c;
    if (localObject != null) {
      localBundle.putParcelable("tint_list", (Parcelable)localObject);
    }
    localObject = id;
    if (localObject != name) {
      localBundle.putString("tint_mode", ((Enum)localObject).name());
    }
    return localBundle;
  }
  
  public Bitmap get()
  {
    int i = b;
    if ((i == -1) && (Build.VERSION.SDK_INT >= 23))
    {
      localObject = x;
      if ((localObject instanceof Bitmap)) {
        return (Bitmap)localObject;
      }
      return null;
    }
    if (i == 1) {
      return (Bitmap)x;
    }
    if (i == 5) {
      return transform((Bitmap)x, true);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("called getBitmap() on ");
    ((StringBuilder)localObject).append(this);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public Icon get(android.content.Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return a.get(this, paramContext);
    }
    throw new UnsupportedOperationException("This method is only supported on API level 23+");
  }
  
  public Drawable getDrawable(android.content.Context paramContext)
  {
    a(paramContext);
    if (Build.VERSION.SDK_INT >= 23) {
      return a.getDrawable(get(paramContext), paramContext);
    }
    paramContext = doInBackground(paramContext);
    if ((paramContext != null) && ((c != null) || (id != name)))
    {
      paramContext.mutate();
      DrawableCompat.append(paramContext, c);
      DrawableCompat.setTintMode(paramContext, id);
    }
    return paramContext;
  }
  
  public Icon getIcon()
  {
    return get(null);
  }
  
  public void init()
  {
    id = PorterDuff.Mode.valueOf(s);
    Object localObject;
    switch (b)
    {
    default: 
      
    case 0: 
      
    case 3: 
      x = y;
      return;
    case 2: 
    case 4: 
    case 6: 
      localObject = new String(y, Charset.forName("UTF-16"));
      x = localObject;
      if ((b == 2) && (q == null))
      {
        q = ((String)localObject).split(":", -1)[0];
        return;
      }
      break;
    case 1: 
    case 5: 
      localObject = value;
      if (localObject != null)
      {
        x = localObject;
        return;
      }
      localObject = y;
      x = localObject;
      b = 3;
      n = 0;
      a = localObject.length;
      return;
    case -1: 
      localObject = value;
      if (localObject != null)
      {
        x = localObject;
        return;
      }
      throw new IllegalArgumentException("Invalid icon");
    }
  }
  
  public InputStream open(android.content.Context paramContext)
  {
    Uri localUri = read();
    Object localObject = localUri.getScheme();
    if ((!"content".equals(localObject)) && (!"file".equals(localObject)))
    {
      paramContext = (String)x;
      try
      {
        paramContext = new FileInputStream(new File(paramContext));
        return paramContext;
      }
      catch (FileNotFoundException paramContext)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Unable to load image from path: ");
        ((StringBuilder)localObject).append(localUri);
        android.util.Log.w("IconCompat", ((StringBuilder)localObject).toString(), paramContext);
      }
    }
    else
    {
      try
      {
        paramContext = paramContext.getContentResolver().openInputStream(localUri);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Unable to load image from URI: ");
        ((StringBuilder)localObject).append(localUri);
        android.util.Log.w("IconCompat", ((StringBuilder)localObject).toString(), paramContext);
      }
    }
    return null;
  }
  
  public Uri read()
  {
    int i = b;
    if ((i == -1) && (Build.VERSION.SDK_INT >= 23)) {
      return a.toString(x);
    }
    if ((i != 4) && (i != 6))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("called getUri() on ");
      localStringBuilder.append(this);
      throw new IllegalStateException(localStringBuilder.toString());
    }
    return Uri.parse((String)x);
  }
  
  public String toString()
  {
    if (b == -1) {
      return String.valueOf(x);
    }
    StringBuilder localStringBuilder = new StringBuilder("Icon(typ=");
    localStringBuilder.append(getNetworkTypeName(b));
    switch (b)
    {
    default: 
      break;
    case 4: 
    case 6: 
      localStringBuilder.append(" uri=");
      localStringBuilder.append(x);
      break;
    case 3: 
      localStringBuilder.append(" len=");
      localStringBuilder.append(n);
      if (a != 0)
      {
        localStringBuilder.append(" off=");
        localStringBuilder.append(a);
      }
      break;
    case 2: 
      localStringBuilder.append(" pkg=");
      localStringBuilder.append(q);
      localStringBuilder.append(" id=");
      localStringBuilder.append(String.format("0x%08x", new Object[] { Integer.valueOf(a()) }));
      break;
    case 1: 
    case 5: 
      localStringBuilder.append(" size=");
      localStringBuilder.append(((Bitmap)x).getWidth());
      localStringBuilder.append("x");
      localStringBuilder.append(((Bitmap)x).getHeight());
    }
    if (c != null)
    {
      localStringBuilder.append(" tint=");
      localStringBuilder.append(c);
    }
    if (id != name)
    {
      localStringBuilder.append(" mode=");
      localStringBuilder.append(id);
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void update(boolean paramBoolean)
  {
    s = id.name();
    switch (b)
    {
    default: 
      return;
    case 0: 
      return;
    case 4: 
    case 6: 
      y = x.toString().getBytes(Charset.forName("UTF-16"));
      return;
    case 3: 
      y = ((byte[])x);
      return;
    case 2: 
      y = ((String)x).getBytes(Charset.forName("UTF-16"));
      return;
    case 1: 
    case 5: 
      if (paramBoolean)
      {
        Bitmap localBitmap = (Bitmap)x;
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        localBitmap.compress(Bitmap.CompressFormat.PNG, 90, localByteArrayOutputStream);
        y = localByteArrayOutputStream.toByteArray();
        return;
      }
      value = ((Parcelable)x);
      return;
    }
    if (!paramBoolean)
    {
      value = ((Parcelable)x);
      return;
    }
    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
  }
  
  static class a
  {
    static int a(Object paramObject)
    {
      if (Build.VERSION.SDK_INT >= 28) {
        return IconCompat.c.add(paramObject);
      }
      try
      {
        Object localObject = paramObject.getClass();
        localObject = ((Class)localObject).getMethod("getResId", new Class[0]);
        paramObject = ((Method)localObject).invoke(paramObject, new Object[0]);
        paramObject = (Integer)paramObject;
        int i = paramObject.intValue();
        return i;
      }
      catch (NoSuchMethodException paramObject)
      {
        android.util.Log.e("IconCompat", "Unable to get icon resource", paramObject);
        return 0;
      }
      catch (InvocationTargetException paramObject)
      {
        android.util.Log.e("IconCompat", "Unable to get icon resource", paramObject);
        return 0;
      }
      catch (IllegalAccessException paramObject)
      {
        android.util.Log.e("IconCompat", "Unable to get icon resource", paramObject);
      }
      return 0;
    }
    
    static String b(Object paramObject)
    {
      if (Build.VERSION.SDK_INT >= 28) {
        return IconCompat.c.remove(paramObject);
      }
      try
      {
        Object localObject = paramObject.getClass();
        localObject = ((Class)localObject).getMethod("getResPackage", new Class[0]);
        paramObject = ((Method)localObject).invoke(paramObject, new Object[0]);
        return (String)paramObject;
      }
      catch (NoSuchMethodException paramObject)
      {
        android.util.Log.e("IconCompat", "Unable to get icon package", paramObject);
        return null;
      }
      catch (InvocationTargetException paramObject)
      {
        android.util.Log.e("IconCompat", "Unable to get icon package", paramObject);
        return null;
      }
      catch (IllegalAccessException paramObject)
      {
        android.util.Log.e("IconCompat", "Unable to get icon package", paramObject);
      }
      return null;
    }
    
    static IconCompat d(Object paramObject)
    {
      v7.v7.util.Log.valueOf(paramObject);
      int i = get(paramObject);
      if (i != 2)
      {
        if (i != 4)
        {
          if (i != 6)
          {
            IconCompat localIconCompat = new IconCompat(-1);
            x = paramObject;
            return localIconCompat;
          }
          return IconCompat.b(toString(paramObject));
        }
        return IconCompat.from(toString(paramObject));
      }
      return IconCompat.a(null, b(paramObject), a(paramObject));
    }
    
    static int get(Object paramObject)
    {
      if (Build.VERSION.SDK_INT >= 28) {
        return IconCompat.c.get(paramObject);
      }
      try
      {
        Object localObject = paramObject.getClass();
        localObject = ((Class)localObject).getMethod("getType", new Class[0]);
        localObject = ((Method)localObject).invoke(paramObject, new Object[0]);
        localObject = (Integer)localObject;
        int i = ((Integer)localObject).intValue();
        return i;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unable to get icon type ");
        localStringBuilder.append(paramObject);
        android.util.Log.e("IconCompat", localStringBuilder.toString(), localNoSuchMethodException);
        return -1;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unable to get icon type ");
        localStringBuilder.append(paramObject);
        android.util.Log.e("IconCompat", localStringBuilder.toString(), localInvocationTargetException);
        return -1;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unable to get icon type ");
        localStringBuilder.append(paramObject);
        android.util.Log.e("IconCompat", localStringBuilder.toString(), localIllegalAccessException);
      }
      return -1;
    }
    
    static Icon get(IconCompat paramIconCompat, android.content.Context paramContext)
    {
      switch (b)
      {
      default: 
        break;
      case 0: 
        throw new IllegalArgumentException("Unknown type");
      case 6: 
        int i = Build.VERSION.SDK_INT;
        if (i >= 30)
        {
          paramContext = IconCompat.d.build(paramIconCompat.read());
        }
        else if (paramContext != null)
        {
          paramContext = paramIconCompat.open(paramContext);
          if (paramContext != null)
          {
            if (i >= 26) {
              paramContext = IconCompat.b.createBitmap(BitmapFactory.decodeStream(paramContext));
            } else {
              paramContext = Icon.createWithBitmap(IconCompat.transform(BitmapFactory.decodeStream(paramContext), false));
            }
          }
          else
          {
            paramContext = new StringBuilder();
            paramContext.append("Cannot load adaptive icon from uri: ");
            paramContext.append(paramIconCompat.read());
            throw new IllegalStateException(paramContext.toString());
          }
        }
        else
        {
          paramContext = new StringBuilder();
          paramContext.append("Context is required to resolve the file uri of the icon: ");
          paramContext.append(paramIconCompat.read());
          throw new IllegalArgumentException(paramContext.toString());
        }
      case 5: 
        if (Build.VERSION.SDK_INT >= 26) {
          paramContext = IconCompat.b.createBitmap((Bitmap)x);
        } else {
          paramContext = Icon.createWithBitmap(IconCompat.transform((Bitmap)x, false));
        }
        break;
      case 4: 
        paramContext = Icon.createWithContentUri((String)x);
        break;
      case 3: 
        paramContext = Icon.createWithData((byte[])x, n, a);
        break;
      case 2: 
        paramContext = Icon.createWithResource(paramIconCompat.d(), n);
        break;
      case 1: 
        paramContext = Icon.createWithBitmap((Bitmap)x);
        Object localObject = c;
        if (localObject != null) {
          paramContext.setTintList((ColorStateList)localObject);
        }
        localObject = id;
        paramIconCompat = paramContext;
        if (localObject == IconCompat.name) {
          return paramIconCompat;
        }
        paramContext.setTintMode((PorterDuff.Mode)localObject);
        return paramContext;
      }
      paramIconCompat = (Icon)x;
      return paramIconCompat;
    }
    
    static Drawable getDrawable(Icon paramIcon, android.content.Context paramContext)
    {
      return paramIcon.loadDrawable(paramContext);
    }
    
    static Uri toString(Object paramObject)
    {
      if (Build.VERSION.SDK_INT >= 28) {
        return IconCompat.c.toString(paramObject);
      }
      try
      {
        Object localObject = paramObject.getClass();
        localObject = ((Class)localObject).getMethod("getUri", new Class[0]);
        paramObject = ((Method)localObject).invoke(paramObject, new Object[0]);
        return (Uri)paramObject;
      }
      catch (NoSuchMethodException paramObject)
      {
        android.util.Log.e("IconCompat", "Unable to get icon uri", paramObject);
        return null;
      }
      catch (InvocationTargetException paramObject)
      {
        android.util.Log.e("IconCompat", "Unable to get icon uri", paramObject);
        return null;
      }
      catch (IllegalAccessException paramObject)
      {
        android.util.Log.e("IconCompat", "Unable to get icon uri", paramObject);
      }
      return null;
    }
  }
  
  static class b
  {
    static Drawable apply(Drawable paramDrawable1, Drawable paramDrawable2)
    {
      return (Drawable)new AdaptiveIconDrawable(paramDrawable1, paramDrawable2);
    }
    
    static Icon createBitmap(Bitmap paramBitmap)
    {
      return Icon.createWithAdaptiveBitmap(paramBitmap);
    }
  }
  
  static class c
  {
    static int add(Object paramObject)
    {
      return ((Icon)paramObject).getResId();
    }
    
    static int get(Object paramObject)
    {
      return ((Icon)paramObject).getType();
    }
    
    static String remove(Object paramObject)
    {
      return ((Icon)paramObject).getResPackage();
    }
    
    static Uri toString(Object paramObject)
    {
      return ((Icon)paramObject).getUri();
    }
  }
  
  static class d
  {
    static Icon build(Uri paramUri)
    {
      return Icon.createWithAdaptiveBitmapContentUri(paramUri);
    }
  }
}
