package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzgc
  extends zzke
  implements zzlm
{
  private static final zzgc this$0;
  private int TYPE_DIALOG;
  private int TYPE_EXPANDED;
  private int _id;
  private long _key;
  private long _value;
  private int anonymous;
  private int arg;
  private zzkl children = zzke.zzbD();
  private zzkj content = zzke.zzbA();
  private String current = "";
  private String dateString = "";
  private String desc = "";
  private long exprs;
  private long f0;
  private int field_6;
  private String filename = "";
  private int form;
  private boolean fsync;
  private String guid = "";
  private long hasnext;
  private long identifier;
  private zzkl ids = zzke.zzbD();
  private long index;
  private String itemId = "";
  private String key = "";
  private zzkl keys = zzke.zzbD();
  private boolean learn_ahead;
  private String mMessage = "";
  private long mMilliTime;
  private long mObject;
  private String packageName = "";
  private int position;
  private zzgf protocol;
  private String pubDate = "";
  private int resolved;
  private String second = "";
  private long size_;
  private int source_id;
  private String subtitle = "";
  private String time = "";
  private String title = "";
  private String track = "";
  private String url = "";
  private long used;
  private long val;
  private String value = "";
  private String year = "";
  private boolean zzaa;
  private String zzab = "";
  private boolean zzac;
  private zzfy zzad;
  private String zzae = "";
  private zzkl zzaf = zzke.zzbD();
  private String zzag = "";
  
  static
  {
    zzgc localZzgc = new zzgc();
    this$0 = localZzgc;
    zzke.zzbJ(zzgc.class, localZzgc);
  }
  
  private zzgc() {}
  
  public static zzgb split()
  {
    return (zzgb)this$0.zzbx();
  }
  
  private final void zzbL()
  {
    zzkl localZzkl = keys;
    if (!localZzkl.get()) {
      keys = zzke.zzbE(localZzkl);
    }
  }
  
  private final void zzbM()
  {
    zzkl localZzkl = ids;
    if (!localZzkl.get()) {
      ids = zzke.zzbE(localZzkl);
    }
  }
  
  protected final Object Decode(int paramInt, Object paramObject1, Object paramObject2)
  {
    paramInt -= 1;
    if (paramInt != 0)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return null;
            }
            return this$0;
          }
          return new zzgb(null);
        }
        return new zzgc();
      }
      paramObject1 = zzfk.mPrefix;
      return zzke.zzbI(this$0, "\0014\000\002\001A4\000\005\000\001?\000\002\033\003\033\004?\001\005?\002\006?\003\007?\005\b?\006\t?\007\n?\b\013?\t\f?\n\r?\013\016?\f\020?\r\021?\016\022?\017\023?\020\024?\021\025?\022\026?\023\027?\024\030?\025\031?\026\032?\004\034?\027\035\033\036?\030\037?\031 ?\032!?\033\"?\034#?\035$?\036%?\037&? '?!)?\",?#-\035.?$/?%2?&4?'5?(7?)9?*:?+;?,??-@\032A?.", new Object[] { "zzf", "zzg", "zzh", "zzi", zzfs.class, "zzj", zzgl.class, "zzk", "zzl", "zzm", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzD", "zzE", "zzF", "zzn", "zzG", "zzH", zzfo.class, "zzI", "zzJ", "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", "zzQ", "zzR", "zzS", "zzT", "zzU", "zzV", "zzW", "zzX", "zzY", "zzZ", paramObject1, "zzaa", "zzab", "zzac", "zzad", "zzae", "zzaf", "zzag" });
    }
    return Byte.valueOf((byte)1);
  }
  
  public final zzgl addFile(int paramInt)
  {
    return (zzgl)ids.get(paramInt);
  }
  
  public final zzfs addPath(int paramInt)
  {
    return (zzfs)keys.get(paramInt);
  }
  
  public final String execute()
  {
    return desc;
  }
  
  public final String get()
  {
    return current;
  }
  
  public final String getAbsolutePath()
  {
    return pubDate;
  }
  
  public final String getAttributeName()
  {
    return zzae;
  }
  
  public final long getChildren()
  {
    return exprs;
  }
  
  public final String getData()
  {
    return value;
  }
  
  public final String getFile()
  {
    return filename;
  }
  
  public final List getGroups()
  {
    return keys;
  }
  
  public final long getIdentifier()
  {
    return identifier;
  }
  
  public final List getIds()
  {
    return ids;
  }
  
  public final long getKey()
  {
    return _key;
  }
  
  public final String getName()
  {
    return packageName;
  }
  
  public final long getObject()
  {
    return mObject;
  }
  
  public final int getRoster()
  {
    return anonymous;
  }
  
  public final long getSize()
  {
    return size_;
  }
  
  public final String getString()
  {
    return mMessage;
  }
  
  public final int getType()
  {
    return arg;
  }
  
  public final String getValue()
  {
    return dateString;
  }
  
  public final long hasNext()
  {
    return hasnext;
  }
  
  public final long indexOf()
  {
    return index;
  }
  
  public final long intValue()
  {
    return _value;
  }
  
  public final int length()
  {
    return ids.size();
  }
  
  public final List listFiles()
  {
    return children;
  }
  
  public final int match()
  {
    return form;
  }
  
  public final int next()
  {
    return position;
  }
  
  public final long read()
  {
    return used;
  }
  
  public final String readLine()
  {
    return itemId;
  }
  
  public final long remove()
  {
    return val;
  }
  
  public final String replace()
  {
    return guid;
  }
  
  public final int size()
  {
    return keys.size();
  }
  
  public final String time()
  {
    return time;
  }
  
  public final String title()
  {
    return title;
  }
  
  public final String toCharArray()
  {
    return track;
  }
  
  public final String trim()
  {
    return year;
  }
  
  public final String url()
  {
    return url;
  }
  
  public final int write()
  {
    return _id;
  }
  
  public final boolean zzaW()
  {
    return fsync;
  }
  
  public final boolean zzaX()
  {
    return learn_ahead;
  }
  
  public final boolean zzaY()
  {
    return (field_6 & 0x2000000) != 0;
  }
  
  public final boolean zzaZ()
  {
    return (field_6 & 0x100000) != 0;
  }
  
  public final boolean zzba()
  {
    return (field_6 & 0x20000000) != 0;
  }
  
  public final boolean zzbb()
  {
    return (resolved & 0x80) != 0;
  }
  
  public final boolean zzbc()
  {
    return (field_6 & 0x80000) != 0;
  }
  
  public final boolean zzbd()
  {
    return (resolved & 0x10) != 0;
  }
  
  public final boolean zzbe()
  {
    return (field_6 & 0x8) != 0;
  }
  
  public final boolean zzbf()
  {
    return (field_6 & 0x4000) != 0;
  }
  
  public final boolean zzbg()
  {
    return (field_6 & 0x20000) != 0;
  }
  
  public final boolean zzbh()
  {
    return (field_6 & 0x20) != 0;
  }
  
  public final boolean zzbi()
  {
    return (field_6 & 0x10) != 0;
  }
  
  public final boolean zzbj()
  {
    return (field_6 & 0x1) != 0;
  }
  
  public final boolean zzbk()
  {
    return (resolved & 0x2) != 0;
  }
  
  public final boolean zzbl()
  {
    return (field_6 & 0x800000) != 0;
  }
  
  public final boolean zzbm()
  {
    return (resolved & 0x2000) != 0;
  }
  
  public final boolean zzbn()
  {
    return (field_6 & 0x4) != 0;
  }
  
  public final boolean zzbo()
  {
    return (field_6 & 0x400) != 0;
  }
  
  public final boolean zzbp()
  {
    return (field_6 & 0x2) != 0;
  }
  
  public final boolean zzbq()
  {
    return (field_6 & 0x8000) != 0;
  }
}
