package androidx.appcompat.app;

import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;
import v7.v7.menu.Label;

final class g
{
  private static Label a(Label paramLabel1, Label paramLabel2)
  {
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    int i = 0;
    while (i < paramLabel1.size() + paramLabel2.size())
    {
      Locale localLocale;
      if (i < paramLabel1.size()) {
        localLocale = paramLabel1.toString(i);
      } else {
        localLocale = paramLabel2.toString(i - paramLabel1.size());
      }
      if (localLocale != null) {
        localLinkedHashSet.add(localLocale);
      }
      i += 1;
    }
    return Label.a((Locale[])localLinkedHashSet.toArray(new Locale[localLinkedHashSet.size()]));
  }
  
  static Label b(Label paramLabel1, Label paramLabel2)
  {
    if ((paramLabel1 != null) && (!paramLabel1.a())) {
      return a(paramLabel1, paramLabel2);
    }
    return Label.b();
  }
}
