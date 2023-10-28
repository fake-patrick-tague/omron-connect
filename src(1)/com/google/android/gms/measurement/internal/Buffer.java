package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

final class Buffer
{
  private long a;
  private boolean active;
  private String buffer;
  private long c;
  private String code;
  private long container;
  private long count;
  private final String data;
  private String date;
  private long element;
  private String end;
  private long flags;
  private String head;
  private long id;
  private boolean index;
  private long key;
  private String label;
  private long last;
  private long length;
  private String mValue;
  private String name;
  private List names;
  private long next;
  private long offset;
  private long pos;
  private long position;
  private boolean s;
  private long size;
  private String source;
  private final zzfy this$0;
  private Boolean value;
  
  Buffer(zzfy paramZzfy, String paramString)
  {
    Preconditions.checkNotNull(paramZzfy);
    Preconditions.checkNotEmpty(paramString);
    this$0 = paramZzfy;
    data = paramString;
    paramZzfy.zzaz().append();
  }
  
  public final void add(long paramLong)
  {
    this$0.zzaz().append();
    boolean bool2 = index;
    boolean bool1;
    if (c != paramLong) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    index = (bool2 | bool1);
    c = paramLong;
  }
  
  public final void add(String paramString)
  {
    this$0.zzaz().append();
    index |= FieldInfo.put(buffer, paramString) ^ true;
    buffer = paramString;
  }
  
  public final void append()
  {
    this$0.zzaz().append();
    long l2 = element + 1L;
    long l1 = l2;
    if (l2 > 2147483647L)
    {
      this$0.zzay().hasNext().append("Bundle index overflow. appId", zzeo.get(data));
      l1 = 0L;
    }
    index = true;
    element = l1;
  }
  
  public final void append(long paramLong)
  {
    this$0.zzaz().append();
    boolean bool2 = index;
    boolean bool1;
    if (next != paramLong) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    index = (bool2 | bool1);
    next = paramLong;
  }
  
  public final void append(String paramString)
  {
    this$0.zzaz().append();
    index |= FieldInfo.put(end, paramString) ^ true;
    end = paramString;
  }
  
  public final long available()
  {
    this$0.zzaz().append();
    return length;
  }
  
  public final long copyTo()
  {
    this$0.zzaz().append();
    return flags;
  }
  
  public final String encode()
  {
    this$0.zzaz().append();
    return code;
  }
  
  public final void encode(long paramLong)
  {
    this$0.zzaz().append();
    boolean bool2 = index;
    boolean bool1;
    if (pos != paramLong) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    index = (bool2 | bool1);
    pos = paramLong;
  }
  
  public final void encode(String paramString)
  {
    this$0.zzaz().append();
    String str = paramString;
    if (true == TextUtils.isEmpty(paramString)) {
      str = null;
    }
    index |= true ^ FieldInfo.put(code, str);
    code = str;
  }
  
  public final String format()
  {
    this$0.zzaz().append();
    return head;
  }
  
  public final String get()
  {
    this$0.zzaz().append();
    return mValue;
  }
  
  public final String getContent()
  {
    this$0.zzaz().append();
    return end;
  }
  
  public final String getDate()
  {
    this$0.zzaz().append();
    return date;
  }
  
  public final long getID()
  {
    this$0.zzaz().append();
    return id;
  }
  
  public final long getKey()
  {
    this$0.zzaz().append();
    return key;
  }
  
  public final String getLabel()
  {
    this$0.zzaz().append();
    return label;
  }
  
  public final long getLength()
  {
    this$0.zzaz().append();
    return a;
  }
  
  public final List getName()
  {
    this$0.zzaz().append();
    return names;
  }
  
  public final long getOffset()
  {
    this$0.zzaz().append();
    return c;
  }
  
  public final long getPos()
  {
    this$0.zzaz().append();
    return pos;
  }
  
  public final String getString()
  {
    this$0.zzaz().append();
    return buffer;
  }
  
  public final String getTitle()
  {
    this$0.zzaz().append();
    return source;
  }
  
  public final String getValue()
  {
    this$0.zzaz().append();
    return data;
  }
  
  public final String name()
  {
    this$0.zzaz().append();
    return name;
  }
  
  public final long next()
  {
    this$0.zzaz().append();
    return last;
  }
  
  public final void next(long paramLong)
  {
    this$0.zzaz().append();
    boolean bool2 = index;
    boolean bool1;
    if (flags != paramLong) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    index = (bool2 | bool1);
    flags = paramLong;
  }
  
  public final long offset()
  {
    this$0.zzaz().append();
    return offset;
  }
  
  public final long peek()
  {
    this$0.zzaz().append();
    return next;
  }
  
  public final long put()
  {
    this$0.zzaz().append();
    return 0L;
  }
  
  public final void put(long paramLong)
  {
    this$0.zzaz().append();
    boolean bool2 = index;
    boolean bool1;
    if (count != paramLong) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    index = (bool2 | bool1);
    count = paramLong;
  }
  
  public final void put(String paramString)
  {
    this$0.zzaz().append();
    index |= FieldInfo.put(head, paramString) ^ true;
    head = paramString;
  }
  
  public final void putLong(long paramLong)
  {
    this$0.zzaz().append();
    boolean bool2 = index;
    boolean bool1;
    if (a != paramLong) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    index = (bool2 | bool1);
    a = paramLong;
  }
  
  public final long read()
  {
    this$0.zzaz().append();
    return size;
  }
  
  public final void read(long paramLong)
  {
    this$0.zzaz().append();
    boolean bool2 = index;
    boolean bool1;
    if (last != paramLong) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    index = (bool2 | bool1);
    last = paramLong;
  }
  
  public final void read(String paramString)
  {
    this$0.zzaz().append();
    String str = paramString;
    if (true == TextUtils.isEmpty(paramString)) {
      str = null;
    }
    index |= true ^ FieldInfo.put(name, str);
    name = str;
  }
  
  public final void read(boolean paramBoolean)
  {
    this$0.zzaz().append();
    boolean bool2 = index;
    boolean bool1;
    if (s != paramBoolean) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    index = (bool2 | bool1);
    s = paramBoolean;
  }
  
  public final Boolean readByteArray()
  {
    this$0.zzaz().append();
    return value;
  }
  
  public final void readInt(long paramLong)
  {
    this$0.zzaz().append();
    boolean bool2 = index;
    boolean bool1;
    if (position != paramLong) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    index = (bool2 | bool1);
    position = paramLong;
  }
  
  public final long readLong()
  {
    this$0.zzaz().append();
    return position;
  }
  
  public final void remove(long paramLong)
  {
    this$0.zzaz().append();
    boolean bool2 = index;
    boolean bool1;
    if (key != paramLong) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    index = (bool2 | bool1);
    key = paramLong;
  }
  
  public final long set()
  {
    this$0.zzaz().append();
    return element;
  }
  
  public final void set(String paramString)
  {
    this$0.zzaz().append();
    index |= FieldInfo.put(mValue, paramString) ^ true;
    mValue = paramString;
  }
  
  public final void shift(long paramLong)
  {
    this$0.zzaz().append();
    boolean bool2 = index;
    boolean bool1;
    if (offset != paramLong) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    index = (bool2 | bool1);
    offset = paramLong;
  }
  
  public final long size()
  {
    this$0.zzaz().append();
    return count;
  }
  
  public final void skip()
  {
    this$0.zzaz().append();
    index = false;
  }
  
  public final void skip(long paramLong)
  {
    this$0.zzaz().append();
    boolean bool2 = index;
    boolean bool1;
    if (size != paramLong) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    index = (bool2 | bool1);
    size = paramLong;
  }
  
  public final void start(long paramLong)
  {
    this$0.zzaz().append();
    boolean bool2 = index;
    boolean bool1;
    if (container != paramLong) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    index = (bool2 | bool1);
    container = paramLong;
  }
  
  public final String write()
  {
    this$0.zzaz().append();
    String str = label;
    write(null);
    return str;
  }
  
  public final void write(long paramLong)
  {
    this$0.zzaz().append();
    boolean bool2 = index;
    boolean bool1;
    if (id != paramLong) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    index = (bool2 | bool1);
    id = paramLong;
  }
  
  public final void write(String paramString)
  {
    this$0.zzaz().append();
    index |= FieldInfo.put(label, paramString) ^ true;
    label = paramString;
  }
  
  public final long writeTo()
  {
    this$0.zzaz().append();
    return container;
  }
  
  public final void zzaa(long paramLong)
  {
    boolean bool1 = true;
    if (paramLong >= 0L) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    Preconditions.checkArgument(bool2);
    this$0.zzaz().append();
    boolean bool2 = index;
    if (element == paramLong) {
      bool1 = false;
    }
    index = (bool2 | bool1);
    element = paramLong;
  }
  
  public final void zzab(long paramLong)
  {
    this$0.zzaz().append();
    boolean bool2 = index;
    boolean bool1;
    if (length != paramLong) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    index = (bool2 | bool1);
    length = paramLong;
  }
  
  public final void zzac(boolean paramBoolean)
  {
    this$0.zzaz().append();
    boolean bool2 = index;
    boolean bool1;
    if (active != paramBoolean) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    index = (bool2 | bool1);
    active = paramBoolean;
  }
  
  public final void zzad(Boolean paramBoolean)
  {
    this$0.zzaz().append();
    index |= FieldInfo.put(value, paramBoolean) ^ true;
    value = paramBoolean;
  }
  
  public final void zzae(String paramString)
  {
    this$0.zzaz().append();
    index |= FieldInfo.put(source, paramString) ^ true;
    source = paramString;
  }
  
  public final void zzaf(List paramList)
  {
    this$0.zzaz().append();
    if (!FieldInfo.put(names, paramList))
    {
      index = true;
      if (paramList != null) {
        paramList = new ArrayList(paramList);
      } else {
        paramList = null;
      }
      names = paramList;
    }
  }
  
  public final void zzag(String paramString)
  {
    this$0.zzaz().append();
    index |= FieldInfo.put(date, paramString) ^ true;
    date = paramString;
  }
  
  public final boolean zzah()
  {
    this$0.zzaz().append();
    return s;
  }
  
  public final boolean zzai()
  {
    this$0.zzaz().append();
    return active;
  }
  
  public final boolean zzaj()
  {
    this$0.zzaz().append();
    return index;
  }
}
