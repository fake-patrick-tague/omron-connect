package butterknife;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface OnItemSelected
{
  public static enum Callback
  {
    static
    {
      Callback localCallback1 = new Callback("ITEM_SELECTED", 0);
      ITEM_SELECTED = localCallback1;
      Callback localCallback2 = new Callback("NOTHING_SELECTED", 1);
      NOTHING_SELECTED = localCallback2;
      $VALUES = new Callback[] { localCallback1, localCallback2 };
    }
  }
}
