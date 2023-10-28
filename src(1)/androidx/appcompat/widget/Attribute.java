package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;

public class Attribute
  extends ResourcesWrapper
{
  private static boolean mHasValue;
  private final WeakReference<Context> mContextRef;
  
  public Attribute(Context paramContext, Resources paramResources)
  {
    super(paramResources);
    mContextRef = new WeakReference(paramContext);
  }
  
  public static boolean get()
  {
    return (hasValue()) && (Build.VERSION.SDK_INT <= 20);
  }
  
  public static boolean hasValue()
  {
    return mHasValue;
  }
  
  public Drawable getDrawable(int paramInt)
    throws Resources.NotFoundException
  {
    Context localContext = (Context)mContextRef.get();
    if (localContext != null) {
      return AppCompatDrawableManager.get().getDrawable(localContext, this, paramInt);
    }
    return getIcon(paramInt);
  }
}
