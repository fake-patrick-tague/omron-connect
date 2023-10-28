package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

class TintResources
  extends ResourcesWrapper
{
  private final WeakReference<Context> mContextRef;
  
  public TintResources(Context paramContext, Resources paramResources)
  {
    super(paramResources);
    mContextRef = new WeakReference(paramContext);
  }
  
  public Drawable getDrawable(int paramInt)
    throws Resources.NotFoundException
  {
    Drawable localDrawable = getIcon(paramInt);
    Context localContext = (Context)mContextRef.get();
    if ((localDrawable != null) && (localContext != null)) {
      AppCompatDrawableManager.get().get(localContext, paramInt, localDrawable);
    }
    return localDrawable;
  }
}
