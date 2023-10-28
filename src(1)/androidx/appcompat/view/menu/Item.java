package androidx.appcompat.view.menu;

import android.os.Handler;
import android.os.SystemClock;
import android.view.MenuItem;
import java.util.List;

class Item
  implements androidx.appcompat.widget.Item
{
  Item(w paramW) {}
  
  public void a(f paramF, MenuItem paramMenuItem)
  {
    Handler localHandler = a.f;
    h localH = null;
    localHandler.removeCallbacksAndMessages(null);
    int j = a.a.size();
    int i = 0;
    while (i < j)
    {
      if (paramF == a.a.get(i)).c) {
        break label75;
      }
      i += 1;
    }
    i = -1;
    label75:
    if (i == -1) {
      return;
    }
    i += 1;
    if (i < a.a.size()) {
      localH = (h)a.a.get(i);
    }
    paramMenuItem = new d.c.a(this, localH, paramMenuItem, paramF);
    long l = SystemClock.uptimeMillis();
    a.f.postAtTime(paramMenuItem, paramF, l + 200L);
  }
  
  public void toString(f paramF, MenuItem paramMenuItem)
  {
    a.f.removeCallbacksAndMessages(paramF);
  }
}
