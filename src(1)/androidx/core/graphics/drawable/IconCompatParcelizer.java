package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.versionedparcelable.ByteVector;

public class IconCompatParcelizer
{
  public IconCompatParcelizer() {}
  
  public static IconCompat read(ByteVector paramByteVector)
  {
    IconCompat localIconCompat = new IconCompat();
    b = paramByteVector.a(b, 1);
    y = paramByteVector.a(y, 2);
    value = paramByteVector.read(value, 3);
    n = paramByteVector.a(n, 4);
    a = paramByteVector.a(a, 5);
    c = ((ColorStateList)paramByteVector.read(c, 6));
    s = paramByteVector.a(s, 7);
    q = paramByteVector.a(q, 8);
    localIconCompat.init();
    return localIconCompat;
  }
  
  public static void write(IconCompat paramIconCompat, ByteVector paramByteVector)
  {
    paramByteVector.add(true, true);
    paramIconCompat.update(paramByteVector.put());
    int i = b;
    if (-1 != i) {
      paramByteVector.add(i, 1);
    }
    Object localObject = y;
    if (localObject != null) {
      paramByteVector.add((byte[])localObject, 2);
    }
    localObject = value;
    if (localObject != null) {
      paramByteVector.add((Parcelable)localObject, 3);
    }
    i = n;
    if (i != 0) {
      paramByteVector.add(i, 4);
    }
    i = a;
    if (i != 0) {
      paramByteVector.add(i, 5);
    }
    localObject = c;
    if (localObject != null) {
      paramByteVector.add((Parcelable)localObject, 6);
    }
    localObject = s;
    if (localObject != null) {
      paramByteVector.put((String)localObject, 7);
    }
    paramIconCompat = q;
    if (paramIconCompat != null) {
      paramByteVector.put(paramIconCompat, 8);
    }
  }
}
