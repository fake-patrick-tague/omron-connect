package butterknife;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface OnTextChanged
{
  public static enum Callback
  {
    static
    {
      Callback localCallback1 = new Callback("TEXT_CHANGED", 0);
      TEXT_CHANGED = localCallback1;
      Callback localCallback2 = new Callback("BEFORE_TEXT_CHANGED", 1);
      BEFORE_TEXT_CHANGED = localCallback2;
      Callback localCallback3 = new Callback("AFTER_TEXT_CHANGED", 2);
      AFTER_TEXT_CHANGED = localCallback3;
      $VALUES = new Callback[] { localCallback1, localCallback2, localCallback3 };
    }
  }
}
