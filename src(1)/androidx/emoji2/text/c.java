package androidx.emoji2.text;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.ContentObserver;
import android.graphics.Typeface;
import v7.v7.asm.ByteVector;
import v7.v7.asm.ClassReader;
import v7.v7.asm.Label;
import v7.v7.asm.h;

public class c
{
  public c() {}
  
  public Typeface a(Context paramContext, Label paramLabel)
    throws PackageManager.NameNotFoundException
  {
    return ClassReader.a(paramContext, null, new Label[] { paramLabel });
  }
  
  public ByteVector a(Context paramContext, h paramH)
    throws PackageManager.NameNotFoundException
  {
    return ClassReader.a(paramContext, null, paramH);
  }
  
  public void add(Context paramContext, ContentObserver paramContentObserver)
  {
    paramContext.getContentResolver().unregisterContentObserver(paramContentObserver);
  }
}
