package androidx.core.package_10;

import android.app.Person;
import android.app.Person.Builder;
import android.graphics.drawable.Icon;
import androidx.core.graphics.drawable.IconCompat;

class Support
{
  static Person getView(h paramH)
  {
    Person.Builder localBuilder = new Person.Builder().setName(paramH.get());
    Icon localIcon;
    if (paramH.getTitle() != null) {
      localIcon = paramH.getTitle().getIcon();
    } else {
      localIcon = null;
    }
    return localBuilder.setIcon(localIcon).setUri(paramH.getCount()).setKey(paramH.e()).setBot(paramH.c()).setImportant(paramH.f()).build();
  }
  
  static h onCreate(Person paramPerson)
  {
    e localE = new e().a(paramPerson.getName());
    IconCompat localIconCompat;
    if (paramPerson.getIcon() != null) {
      localIconCompat = IconCompat.a(paramPerson.getIcon());
    } else {
      localIconCompat = null;
    }
    return localE.a(localIconCompat).a(paramPerson.getUri()).b(paramPerson.getKey()).a(paramPerson.isBot()).b(paramPerson.isImportant()).a();
  }
}
