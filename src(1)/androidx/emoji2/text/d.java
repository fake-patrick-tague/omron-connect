package androidx.emoji2.text;

import android.os.BaseBundle;
import android.view.inputmethod.EditorInfo;

final class d
  extends p
{
  private volatile h g;
  private volatile Label i;
  
  d(ClassWriter paramClassWriter)
  {
    super(paramClassWriter);
  }
  
  CharSequence a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    return i.a(paramCharSequence, paramInt1, paramInt2, paramInt3, paramBoolean);
  }
  
  void a()
  {
    try
    {
      g.a.a localA = new g.a.a(this);
      b.g.a(localA);
      return;
    }
    catch (Throwable localThrowable)
    {
      b.clear(localThrowable);
    }
  }
  
  void a(EditorInfo paramEditorInfo)
  {
    extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", g.a());
    extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", b.b);
  }
  
  void b(h paramH)
  {
    if (paramH == null)
    {
      b.clear(new IllegalArgumentException("metadataRepo cannot be null"));
      return;
    }
    g = paramH;
    paramH = g;
    SizeMetrics localSizeMetrics = new SizeMetrics();
    g localG = ClassWriter.a(b);
    ClassWriter localClassWriter = b;
    i = new Label(paramH, localSizeMetrics, localG, r, s);
    b.a();
  }
}
