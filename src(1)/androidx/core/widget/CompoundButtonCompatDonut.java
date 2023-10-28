package androidx.core.widget;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.CheckedTextView;
import java.lang.reflect.Field;

class CompoundButtonCompatDonut
{
  private static Field sButtonDrawableField;
  private static boolean sButtonDrawableFieldFetched;
  
  static Drawable getButtonDrawable(CheckedTextView paramCheckedTextView)
  {
    if (!sButtonDrawableFieldFetched)
    {
      try
      {
        Field localField1 = CheckedTextView.class.getDeclaredField("mCheckMarkDrawable");
        sButtonDrawableField = localField1;
        localField1.setAccessible(true);
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        Log.i("CheckedTextViewCompat", "Failed to retrieve mCheckMarkDrawable field", localNoSuchFieldException);
      }
      sButtonDrawableFieldFetched = true;
    }
    Field localField2 = sButtonDrawableField;
    if (localField2 != null) {
      try
      {
        paramCheckedTextView = localField2.get(paramCheckedTextView);
        return (Drawable)paramCheckedTextView;
      }
      catch (IllegalAccessException paramCheckedTextView)
      {
        Log.i("CheckedTextViewCompat", "Failed to get check mark drawable via reflection", paramCheckedTextView);
        sButtonDrawableField = null;
      }
    }
    return null;
  }
}
