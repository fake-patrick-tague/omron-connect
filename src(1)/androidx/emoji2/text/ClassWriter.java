package androidx.emoji2.text;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import v7.v7.util.Log;

public class ClassWriter
{
  private static volatile ClassWriter a;
  private static final Object o = new Object();
  private static final Object v = new Object();
  final boolean b;
  private final Set<g.e> c;
  private final ReadWriteLock d;
  final Attribute g;
  private final boolean h;
  private final int i;
  private final int index;
  private volatile int j;
  private final g k;
  private final p p;
  final boolean r;
  final int[] s;
  private final Handler x;
  
  private ClassWriter(Item paramItem) {}
  
  public static ClassWriter a(Item paramItem)
  {
    Object localObject1 = a;
    if (localObject1 == null)
    {
      Object localObject2 = v;
      try
      {
        ClassWriter localClassWriter = a;
        localObject1 = localClassWriter;
        if (localClassWriter == null)
        {
          localObject1 = new ClassWriter(paramItem);
          a = (ClassWriter)localObject1;
        }
        return localObject1;
      }
      catch (Throwable paramItem)
      {
        throw paramItem;
      }
    }
    return localObject1;
  }
  
  public static boolean a(InputConnection paramInputConnection, Editable paramEditable, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return Label.action(paramInputConnection, paramEditable, paramInt1, paramInt2, paramBoolean);
    }
    return false;
  }
  
  private void b()
  {
    d.writeLock().lock();
    try
    {
      int m = i;
      if (m == 0) {
        j = 0;
      }
      d.writeLock().unlock();
      if (clear() == 0)
      {
        p.a();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      d.writeLock().unlock();
      throw localThrowable;
    }
  }
  
  public static boolean c()
  {
    return a != null;
  }
  
  public static ClassWriter get()
  {
    Object localObject = v;
    for (;;)
    {
      try
      {
        ClassWriter localClassWriter = a;
        if (localClassWriter != null)
        {
          bool = true;
          Log.add(bool, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
          return localClassWriter;
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      boolean bool = false;
    }
  }
  
  public static boolean onKeyDown(Editable paramEditable, int paramInt, KeyEvent paramKeyEvent)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return Label.processKey(paramEditable, paramInt, paramKeyEvent);
    }
    return false;
  }
  
  private boolean put()
  {
    return clear() == 1;
  }
  
  public CharSequence a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    return a(paramCharSequence, paramInt1, paramInt2, paramInt3, 0);
  }
  
  public CharSequence a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Log.add(put(), "Not initialized yet");
    Log.d(paramInt1, "start cannot be negative");
    Log.d(paramInt2, "end cannot be negative");
    Log.d(paramInt3, "maxEmojiCount cannot be negative");
    boolean bool2 = false;
    boolean bool1;
    if (paramInt1 <= paramInt2) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Log.setText(bool1, "start should be <= than end");
    if (paramCharSequence == null) {
      return null;
    }
    if (paramInt1 <= paramCharSequence.length()) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Log.setText(bool1, "start should be < than charSequence length");
    if (paramInt2 <= paramCharSequence.length()) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Log.setText(bool1, "end should be < than charSequence length");
    CharSequence localCharSequence = paramCharSequence;
    if (paramCharSequence.length() != 0)
    {
      if (paramInt1 == paramInt2) {
        return paramCharSequence;
      }
      if (paramInt4 != 1)
      {
        bool1 = bool2;
        if (paramInt4 != 2) {
          bool1 = b;
        }
      }
      else
      {
        bool1 = true;
      }
      localCharSequence = p.a(paramCharSequence, paramInt1, paramInt2, paramInt3, bool1);
    }
    return localCharSequence;
  }
  
  void a()
  {
    ArrayList localArrayList = new ArrayList();
    d.writeLock().lock();
    try
    {
      j = 1;
      localArrayList.addAll(c);
      c.clear();
      d.writeLock().unlock();
      x.post(new CameraActivity.1(localArrayList, j));
      return;
    }
    catch (Throwable localThrowable)
    {
      d.writeLock().unlock();
      throw localThrowable;
    }
  }
  
  public void a(EditorInfo paramEditorInfo)
  {
    if (put())
    {
      if (paramEditorInfo == null) {
        return;
      }
      if (extras == null) {
        extras = new Bundle();
      }
      p.a(paramEditorInfo);
    }
  }
  
  public int clear()
  {
    d.readLock().lock();
    try
    {
      int m = j;
      d.readLock().unlock();
      return m;
    }
    catch (Throwable localThrowable)
    {
      d.readLock().unlock();
      throw localThrowable;
    }
  }
  
  public void clear(Transaction paramTransaction)
  {
    Log.get(paramTransaction, "initCallback cannot be null");
    d.writeLock().lock();
    try
    {
      int m = j;
      if (m != 1)
      {
        m = j;
        if (m != 2)
        {
          c.add(paramTransaction);
          break label78;
        }
      }
      x.post(new CameraActivity.1(paramTransaction, j));
      label78:
      d.writeLock().unlock();
      return;
    }
    catch (Throwable paramTransaction)
    {
      d.writeLock().unlock();
      throw paramTransaction;
    }
  }
  
  void clear(Throwable paramThrowable)
  {
    ArrayList localArrayList = new ArrayList();
    d.writeLock().lock();
    try
    {
      j = 2;
      localArrayList.addAll(c);
      c.clear();
      d.writeLock().unlock();
      x.post(new CameraActivity.1(localArrayList, j, paramThrowable));
      return;
    }
    catch (Throwable paramThrowable)
    {
      d.writeLock().unlock();
      throw paramThrowable;
    }
  }
  
  public boolean d()
  {
    return h;
  }
  
  public CharSequence get(CharSequence paramCharSequence)
  {
    int m;
    if (paramCharSequence == null) {
      m = 0;
    } else {
      m = paramCharSequence.length();
    }
    return get(paramCharSequence, 0, m);
  }
  
  public CharSequence get(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    return a(paramCharSequence, paramInt1, paramInt2, Integer.MAX_VALUE);
  }
  
  public void get(Transaction paramTransaction)
  {
    Log.get(paramTransaction, "initCallback cannot be null");
    d.writeLock().lock();
    try
    {
      c.remove(paramTransaction);
      d.writeLock().unlock();
      return;
    }
    catch (Throwable paramTransaction)
    {
      d.writeLock().unlock();
      throw paramTransaction;
    }
  }
  
  public void init()
  {
    int m = i;
    boolean bool = true;
    if (m != 1) {
      bool = false;
    }
    Log.add(bool, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
    if (put()) {
      return;
    }
    d.writeLock().lock();
    try
    {
      m = j;
      if (m == 0)
      {
        d.writeLock().unlock();
        return;
      }
      j = 0;
      d.writeLock().unlock();
      p.a();
      return;
    }
    catch (Throwable localThrowable)
    {
      d.writeLock().unlock();
      throw localThrowable;
    }
  }
  
  public int newUTF8()
  {
    return index;
  }
}
