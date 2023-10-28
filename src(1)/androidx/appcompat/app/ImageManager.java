package androidx.appcompat.app;

import android.app.Activity;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import java.util.Objects;

class ImageManager
{
  static OnBackInvokedCallback get(Object paramObject, AppCompatDelegateImplV7 paramAppCompatDelegateImplV7)
  {
    Objects.requireNonNull(paramAppCompatDelegateImplV7);
    paramAppCompatDelegateImplV7 = new AbstractSession.1(paramAppCompatDelegateImplV7);
    ((OnBackInvokedDispatcher)paramObject).registerOnBackInvokedCallback(1000000, paramAppCompatDelegateImplV7);
    return paramAppCompatDelegateImplV7;
  }
  
  static void put(Object paramObject1, Object paramObject2)
  {
    paramObject2 = (OnBackInvokedCallback)paramObject2;
    ((OnBackInvokedDispatcher)paramObject1).unregisterOnBackInvokedCallback(paramObject2);
  }
  
  static OnBackInvokedDispatcher subscribe(Activity paramActivity)
  {
    return paramActivity.getOnBackInvokedDispatcher();
  }
}
