package androidx.core.package_10;

import android.app.Person;
import android.os.BaseBundle;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;

public class h
{
  CharSequence a;
  boolean b;
  String c;
  String d;
  IconCompat h;
  boolean i;
  
  h(e paramE)
  {
    a = a;
    h = h;
    c = c;
    d = d;
    b = b;
    i = i;
  }
  
  public String a()
  {
    Object localObject = c;
    if (localObject != null) {
      return localObject;
    }
    if (a != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("name:");
      ((StringBuilder)localObject).append(a);
      return ((StringBuilder)localObject).toString();
    }
    return "";
  }
  
  public boolean c()
  {
    return b;
  }
  
  public String e()
  {
    return d;
  }
  
  public boolean f()
  {
    return i;
  }
  
  public CharSequence get()
  {
    return a;
  }
  
  public String getCount()
  {
    return c;
  }
  
  public Person getText()
  {
    return Support.getView(this);
  }
  
  public IconCompat getTitle()
  {
    return h;
  }
  
  public Bundle onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putCharSequence("name", a);
    Object localObject = h;
    if (localObject != null) {
      localObject = ((IconCompat)localObject).doInBackground();
    } else {
      localObject = null;
    }
    localBundle.putBundle("icon", (Bundle)localObject);
    localBundle.putString("uri", c);
    localBundle.putString("key", d);
    localBundle.putBoolean("isBot", b);
    localBundle.putBoolean("isImportant", i);
    return localBundle;
  }
}
