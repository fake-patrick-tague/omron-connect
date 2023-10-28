package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.SparseIntArray;
import v7.util.ArrayMap;

class b
  extends ByteVector
{
  private final Parcel a;
  private int b = -1;
  private final SparseIntArray c = new SparseIntArray();
  private final int d;
  private final int e;
  private int f = 0;
  private int g = -1;
  private final String h;
  
  b(Parcel paramParcel)
  {
    this(paramParcel, paramParcel.dataPosition(), paramParcel.dataSize(), "", new ArrayMap(), new ArrayMap(), new ArrayMap());
  }
  
  private b(Parcel paramParcel, int paramInt1, int paramInt2, String paramString, ArrayMap paramArrayMap1, ArrayMap paramArrayMap2, ArrayMap paramArrayMap3)
  {
    super(paramArrayMap1, paramArrayMap2, paramArrayMap3);
    a = paramParcel;
    d = paramInt1;
    e = paramInt2;
    f = paramInt1;
    h = paramString;
  }
  
  protected ByteVector a()
  {
    Parcel localParcel = a;
    int k = localParcel.dataPosition();
    int j = f;
    int i = j;
    if (j == d) {
      i = e;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(h);
    localStringBuilder.append("  ");
    return new b(localParcel, k, i, localStringBuilder.toString(), this$0, data, buffer);
  }
  
  public void a(int paramInt)
  {
    write();
    g = paramInt;
    c.put(paramInt, a.dataPosition());
    write(0);
    write(paramInt);
  }
  
  public void a(Parcelable paramParcelable)
  {
    a.writeParcelable(paramParcelable, 0);
  }
  
  protected void a(CharSequence paramCharSequence)
  {
    TextUtils.writeToParcel(paramCharSequence, a, 0);
  }
  
  public int b()
  {
    return a.readInt();
  }
  
  public boolean b(int paramInt)
  {
    while (f < e)
    {
      int i = b;
      if (i == paramInt) {
        return true;
      }
      if (String.valueOf(i).compareTo(String.valueOf(paramInt)) > 0) {
        return false;
      }
      a.setDataPosition(f);
      i = a.readInt();
      b = a.readInt();
      f += i;
    }
    return b == paramInt;
  }
  
  public boolean c()
  {
    return a.readInt() != 0;
  }
  
  public Parcelable get()
  {
    return a.readParcelable(b.class.getClassLoader());
  }
  
  protected CharSequence getQueueTitle()
  {
    return (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(a);
  }
  
  public String getValue()
  {
    return a.readString();
  }
  
  public byte[] read()
  {
    int i = a.readInt();
    if (i < 0) {
      return null;
    }
    byte[] arrayOfByte = new byte[i];
    a.readByteArray(arrayOfByte);
    return arrayOfByte;
  }
  
  public void write()
  {
    int i = g;
    if (i >= 0)
    {
      i = c.get(i);
      int j = a.dataPosition();
      a.setDataPosition(i);
      a.writeInt(j - i);
      a.setDataPosition(j);
    }
  }
  
  public void write(int paramInt)
  {
    a.writeInt(paramInt);
  }
  
  public void write(String paramString)
  {
    a.writeString(paramString);
  }
  
  public void write(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      a.writeInt(paramArrayOfByte.length);
      a.writeByteArray(paramArrayOfByte);
      return;
    }
    a.writeInt(-1);
  }
}
