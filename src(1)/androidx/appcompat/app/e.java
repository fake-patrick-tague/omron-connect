package androidx.appcompat.app;

import android.content.Context;
import androidx.activity.ComponentActivity;
import androidx.activity.asm.c;
import androidx.savedstate.ClassWriter;

class e
  implements c
{
  e(AppCompatActivity paramAppCompatActivity) {}
  
  public void a(Context paramContext)
  {
    paramContext = k.getDelegate();
    paramContext.installViewFactory();
    paramContext.onCreate(k.getSavedStateRegistry().a("androidx:appcompat"));
  }
}
