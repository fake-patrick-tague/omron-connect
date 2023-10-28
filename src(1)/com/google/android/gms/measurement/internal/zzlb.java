package com.google.android.gms.measurement.internal;

import android.os.BaseBundle;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzaa;
import com.google.android.gms.internal.measurement.zzel;
import com.google.android.gms.internal.measurement.zzeq;
import com.google.android.gms.internal.measurement.zzes;
import com.google.android.gms.internal.measurement.zzex;
import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfq;
import com.google.android.gms.internal.measurement.zzfr;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzfv;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzga;
import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzgh;
import com.google.android.gms.internal.measurement.zzgj;
import com.google.android.gms.internal.measurement.zzgk;
import com.google.android.gms.internal.measurement.zzgl;
import com.google.android.gms.internal.measurement.zzjq;
import com.google.android.gms.internal.measurement.zzka;
import com.google.android.gms.internal.measurement.zzko;
import com.google.android.gms.internal.measurement.zzlk;
import com.google.android.gms.internal.measurement.zzoz;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;

public final class zzlb
  extends zzkn
{
  zzlb(zzkz paramZzkz)
  {
    super(paramZzkz);
  }
  
  static boolean add(List paramList, int paramInt)
  {
    return (paramInt < paramList.size() * 64) && ((1L << paramInt % 64 & ((Long)paramList.get(paramInt / 64)).longValue()) != 0L);
  }
  
  private static final void append(StringBuilder paramStringBuilder, int paramInt, String paramString, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    write(paramStringBuilder, paramInt + 1);
    paramStringBuilder.append(paramString);
    paramStringBuilder.append(": ");
    paramStringBuilder.append(paramObject);
    paramStringBuilder.append('\n');
  }
  
  static List encode(BitSet paramBitSet)
  {
    int k = (paramBitSet.length() + 63) / 64;
    ArrayList localArrayList = new ArrayList(k);
    int i = 0;
    while (i < k)
    {
      long l1 = 0L;
      int j = 0;
      while (j < 64)
      {
        int m = i * 64 + j;
        if (m >= paramBitSet.length()) {
          break;
        }
        long l2 = l1;
        if (paramBitSet.get(m)) {
          l2 = l1 | 1L << j;
        }
        j += 1;
        l1 = l2;
      }
      localArrayList.add(Long.valueOf(l1));
      i += 1;
    }
    return localArrayList;
  }
  
  static zzlk equals(zzlk paramZzlk, byte[] paramArrayOfByte)
    throws zzko
  {
    zzjq localZzjq = zzjq.get();
    if (localZzjq != null) {
      return paramZzlk.zzaA(paramArrayOfByte, localZzjq);
    }
    return paramZzlk.zzaz(paramArrayOfByte);
  }
  
  private static final String get(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean1) {
      localStringBuilder.append("Dynamic ");
    }
    if (paramBoolean2) {
      localStringBuilder.append("Sequence ");
    }
    if (paramBoolean3) {
      localStringBuilder.append("Session-Scoped ");
    }
    return localStringBuilder.toString();
  }
  
  static boolean get(String paramString)
  {
    return (paramString != null) && (paramString.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)")) && (paramString.length() <= 310);
  }
  
  static int getByName(zzgb paramZzgb, String paramString)
  {
    if (paramZzgb != null)
    {
      int i = 0;
      while (i < paramZzgb.getByName())
      {
        if (paramString.equals(paramZzgb.zzao(i).next())) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  static final void init(zzfr paramZzfr, String paramString, Object paramObject)
  {
    Object localObject = paramZzfr.getCells();
    int i = 0;
    while (i < ((List)localObject).size())
    {
      if (paramString.equals(((zzfw)((List)localObject).get(i)).getValue())) {
        break label52;
      }
      i += 1;
    }
    i = -1;
    label52:
    localObject = zzfw.get();
    ((zzfv)localObject).get(paramString);
    if ((paramObject instanceof Long)) {
      ((zzfv)localObject).add(((Long)paramObject).longValue());
    }
    if (i >= 0)
    {
      paramZzfr.setTime(i, (zzfv)localObject);
      return;
    }
    paramZzfr.getKey((zzfv)localObject);
  }
  
  private static final void parse(StringBuilder paramStringBuilder, int paramInt, String paramString, zzgh paramZzgh)
  {
    if (paramZzgh == null) {
      return;
    }
    write(paramStringBuilder, 3);
    paramStringBuilder.append(paramString);
    paramStringBuilder.append(" {\n");
    Object localObject;
    if (paramZzgh.getNumberOfColumns() != 0)
    {
      write(paramStringBuilder, 4);
      paramStringBuilder.append("results: ");
      paramString = paramZzgh.read().iterator();
      paramInt = 0;
      while (paramString.hasNext())
      {
        localObject = (Long)paramString.next();
        if (paramInt != 0) {
          paramStringBuilder.append(", ");
        }
        paramStringBuilder.append(localObject);
        paramInt += 1;
      }
      paramStringBuilder.append('\n');
    }
    if (paramZzgh.next() != 0)
    {
      write(paramStringBuilder, 4);
      paramStringBuilder.append("status: ");
      paramString = paramZzgh.remove().iterator();
      paramInt = 0;
      while (paramString.hasNext())
      {
        localObject = (Long)paramString.next();
        if (paramInt != 0) {
          paramStringBuilder.append(", ");
        }
        paramStringBuilder.append(localObject);
        paramInt += 1;
      }
      paramStringBuilder.append('\n');
    }
    if (paramZzgh.register() != 0)
    {
      write(paramStringBuilder, 4);
      paramStringBuilder.append("dynamic_filter_timestamps: {");
      localObject = paramZzgh.getResources().iterator();
      paramInt = 0;
      while (((Iterator)localObject).hasNext())
      {
        zzfq localZzfq = (zzfq)((Iterator)localObject).next();
        if (paramInt != 0) {
          paramStringBuilder.append(", ");
        }
        if (localZzfq.isMounted()) {
          paramString = Integer.valueOf(localZzfq.next());
        } else {
          paramString = null;
        }
        paramStringBuilder.append(paramString);
        paramStringBuilder.append(":");
        if (localZzfq.skipChar()) {
          paramString = Long.valueOf(localZzfq.length());
        } else {
          paramString = null;
        }
        paramStringBuilder.append(paramString);
        paramInt += 1;
      }
      paramStringBuilder.append("}\n");
    }
    if (paramZzgh.add() != 0)
    {
      write(paramStringBuilder, 4);
      paramStringBuilder.append("sequence_filter_timestamps: {");
      paramZzgh = paramZzgh.get().iterator();
      paramInt = 0;
      while (paramZzgh.hasNext())
      {
        localObject = (zzgj)paramZzgh.next();
        if (paramInt != 0) {
          paramStringBuilder.append(", ");
        }
        if (((zzgj)localObject).getInteger()) {
          paramString = Integer.valueOf(((zzgj)localObject).indexOf());
        } else {
          paramString = null;
        }
        paramStringBuilder.append(paramString);
        paramStringBuilder.append(": [");
        paramString = ((zzgj)localObject).getValue().iterator();
        int i = 0;
        while (paramString.hasNext())
        {
          long l = ((Long)paramString.next()).longValue();
          if (i != 0) {
            paramStringBuilder.append(", ");
          }
          paramStringBuilder.append(l);
          i += 1;
        }
        paramStringBuilder.append("]");
        paramInt += 1;
      }
      paramStringBuilder.append("}\n");
    }
    write(paramStringBuilder, 3);
    paramStringBuilder.append("}\n");
  }
  
  static final boolean put(zzaw paramZzaw, Item paramItem)
  {
    Preconditions.checkNotNull(paramZzaw);
    Preconditions.checkNotNull(paramItem);
    return (!TextUtils.isEmpty(key)) || (!TextUtils.isEmpty(id));
  }
  
  static final zzfw remove(zzfs paramZzfs, String paramString)
  {
    paramZzfs = paramZzfs.get().iterator();
    while (paramZzfs.hasNext())
    {
      zzfw localZzfw = (zzfw)paramZzfs.next();
      if (localZzfw.getValue().equals(paramString)) {
        return localZzfw;
      }
    }
    return null;
  }
  
  private static final void toString(StringBuilder paramStringBuilder, int paramInt, String paramString, zzeq paramZzeq)
  {
    if (paramZzeq == null) {
      return;
    }
    write(paramStringBuilder, paramInt);
    paramStringBuilder.append(paramString);
    paramStringBuilder.append(" {\n");
    if (paramZzeq.hasAlias())
    {
      int i = paramZzeq.testConnection();
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              paramString = "BETWEEN";
            } else {
              paramString = "EQUAL";
            }
          }
          else {
            paramString = "GREATER_THAN";
          }
        }
        else {
          paramString = "LESS_THAN";
        }
      }
      else {
        paramString = "UNKNOWN_COMPARISON_TYPE";
      }
      append(paramStringBuilder, paramInt, "comparison_type", paramString);
    }
    if (paramZzeq.set()) {
      append(paramStringBuilder, paramInt, "match_as_float", Boolean.valueOf(paramZzeq.passwordInput()));
    }
    if (paramZzeq.isSigned()) {
      append(paramStringBuilder, paramInt, "comparison_value", paramZzeq.getUUID());
    }
    if (paramZzeq.next()) {
      append(paramStringBuilder, paramInt, "min_comparison_value", paramZzeq.getMajor());
    }
    if (paramZzeq.equals()) {
      append(paramStringBuilder, paramInt, "max_comparison_value", paramZzeq.getMinor());
    }
    write(paramStringBuilder, paramInt);
    paramStringBuilder.append("}\n");
  }
  
  static final Object write(zzfs paramZzfs, String paramString)
  {
    paramZzfs = remove(paramZzfs, paramString);
    if (paramZzfs != null)
    {
      if (paramZzfs.add()) {
        return paramZzfs.getLabel();
      }
      if (paramZzfs.remove()) {
        return Long.valueOf(paramZzfs.currentTimeMillis());
      }
      if (paramZzfs.booleanValue()) {
        return Double.valueOf(paramZzfs.split());
      }
      if (paramZzfs.size() > 0)
      {
        paramString = paramZzfs.delegate();
        paramZzfs = new ArrayList();
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          Object localObject = (zzfw)paramString.next();
          if (localObject != null)
          {
            Bundle localBundle = new Bundle();
            localObject = ((zzfw)localObject).delegate().iterator();
            while (((Iterator)localObject).hasNext())
            {
              zzfw localZzfw = (zzfw)((Iterator)localObject).next();
              if (localZzfw.add()) {
                localBundle.putString(localZzfw.getValue(), localZzfw.getLabel());
              } else if (localZzfw.remove()) {
                localBundle.putLong(localZzfw.getValue(), localZzfw.currentTimeMillis());
              } else if (localZzfw.booleanValue()) {
                localBundle.putDouble(localZzfw.getValue(), localZzfw.split());
              }
            }
            if (!localBundle.isEmpty()) {
              paramZzfs.add(localBundle);
            }
          }
        }
        return (Bundle[])paramZzfs.toArray(new Bundle[paramZzfs.size()]);
      }
    }
    return null;
  }
  
  private static final void write(StringBuilder paramStringBuilder, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      paramStringBuilder.append("  ");
      i += 1;
    }
  }
  
  private final void write(StringBuilder paramStringBuilder, int paramInt, zzel paramZzel)
  {
    if (paramZzel == null) {
      return;
    }
    write(paramStringBuilder, paramInt);
    paramStringBuilder.append("filter {\n");
    if (paramZzel.size()) {
      append(paramStringBuilder, paramInt, "complement", Boolean.valueOf(paramZzel.update()));
    }
    if (paramZzel.isWritable()) {
      append(paramStringBuilder, paramInt, "param_name", this$0.next().next(paramZzel.get()));
    }
    if (paramZzel.isEmpty())
    {
      int i = paramInt + 1;
      Object localObject2 = paramZzel.getInstance();
      if (localObject2 != null)
      {
        write(paramStringBuilder, i);
        paramStringBuilder.append("string_filter {\n");
        Object localObject1;
        if (((zzex)localObject2).read())
        {
          switch (((zzex)localObject2).next())
          {
          default: 
            localObject1 = "IN_LIST";
            break;
          case 6: 
            localObject1 = "EXACT";
            break;
          case 5: 
            localObject1 = "PARTIAL";
            break;
          case 4: 
            localObject1 = "ENDS_WITH";
            break;
          case 3: 
            localObject1 = "BEGINS_WITH";
            break;
          case 2: 
            localObject1 = "REGEXP";
            break;
          case 1: 
            localObject1 = "UNKNOWN_MATCH_TYPE";
          }
          append(paramStringBuilder, i, "match_type", localObject1);
        }
        if (((zzex)localObject2).validate()) {
          append(paramStringBuilder, i, "expression", ((zzex)localObject2).getName());
        }
        if (((zzex)localObject2).write()) {
          append(paramStringBuilder, i, "case_sensitive", Boolean.valueOf(((zzex)localObject2).count()));
        }
        if (((zzex)localObject2).getCardinality() > 0)
        {
          write(paramStringBuilder, i + 1);
          paramStringBuilder.append("expression_list {\n");
          localObject1 = ((zzex)localObject2).list().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            write(paramStringBuilder, i + 2);
            paramStringBuilder.append((String)localObject2);
            paramStringBuilder.append("\n");
          }
          paramStringBuilder.append("}\n");
        }
        write(paramStringBuilder, i);
        paramStringBuilder.append("}\n");
      }
    }
    if (paramZzel.add()) {
      toString(paramStringBuilder, paramInt + 1, "number_filter", paramZzel.toArray());
    }
    write(paramStringBuilder, paramInt);
    paramStringBuilder.append("}\n");
  }
  
  private final void write(StringBuilder paramStringBuilder, int paramInt, List paramList)
  {
    if (paramList == null) {
      return;
    }
    paramInt += 1;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      zzfw localZzfw = (zzfw)localIterator.next();
      if (localZzfw != null)
      {
        write(paramStringBuilder, paramInt);
        paramStringBuilder.append("param {\n");
        boolean bool = localZzfw.isBufferFull();
        Object localObject = null;
        if (bool) {
          paramList = this$0.next().next(localZzfw.getValue());
        } else {
          paramList = null;
        }
        append(paramStringBuilder, paramInt, "name", paramList);
        if (localZzfw.add()) {
          paramList = localZzfw.getLabel();
        } else {
          paramList = null;
        }
        append(paramStringBuilder, paramInt, "string_value", paramList);
        if (localZzfw.remove()) {
          paramList = Long.valueOf(localZzfw.currentTimeMillis());
        } else {
          paramList = null;
        }
        append(paramStringBuilder, paramInt, "int_value", paramList);
        paramList = localObject;
        if (localZzfw.booleanValue()) {
          paramList = Double.valueOf(localZzfw.split());
        }
        append(paramStringBuilder, paramInt, "double_value", paramList);
        if (localZzfw.size() > 0) {
          write(paramStringBuilder, paramInt, localZzfw.delegate());
        }
        write(paramStringBuilder, paramInt);
        paramStringBuilder.append("}\n");
      }
    }
  }
  
  final byte[] encode(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localGZIPOutputStream.write(paramArrayOfByte);
      localGZIPOutputStream.close();
      localByteArrayOutputStream.close();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      this$0.zzay().iterator().append("Failed to gzip content", paramArrayOfByte);
      throw paramArrayOfByte;
    }
  }
  
  final Parcelable get(byte[] paramArrayOfByte, Parcelable.Creator paramCreator)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    Parcel localParcel = Parcel.obtain();
    try
    {
      int i = paramArrayOfByte.length;
      this$0.zzay().iterator().append("Failed to load parcelable from buffer");
    }
    catch (Throwable paramArrayOfByte)
    {
      try
      {
        localParcel.unmarshall(paramArrayOfByte, 0, i);
        localParcel.setDataPosition(0);
        paramArrayOfByte = paramCreator.createFromParcel(localParcel);
        paramArrayOfByte = (Parcelable)paramArrayOfByte;
        localParcel.recycle();
        return paramArrayOfByte;
      }
      catch (SafeParcelReader.ParseException paramArrayOfByte)
      {
        for (;;) {}
      }
      paramArrayOfByte = paramArrayOfByte;
    }
    localParcel.recycle();
    return null;
    localParcel.recycle();
    throw paramArrayOfByte;
  }
  
  final zzaw getValue(zzaa paramZzaa)
  {
    Bundle localBundle = read(paramZzaa.getData(), true);
    if (localBundle.containsKey("_o"))
    {
      localObject = localBundle.get("_o");
      if (localObject != null)
      {
        localObject = localObject.toString();
        break label47;
      }
    }
    Object localObject = "app";
    label47:
    String str2 = zzgv.get(paramZzaa.getName());
    String str1 = str2;
    if (str2 == null) {
      str1 = paramZzaa.getName();
    }
    return new zzaw(str1, new zzau(localBundle), (String)localObject, paramZzaa.intValue());
  }
  
  final String loadData(zzga paramZzga)
  {
    if (paramZzga == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nbatch {\n");
    Iterator localIterator = paramZzga.listFiles().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (zzgc)localIterator.next();
      if (localObject1 != null)
      {
        write(localStringBuilder, 1);
        localStringBuilder.append("bundle {\n");
        if (((zzgc)localObject1).zzbj()) {
          append(localStringBuilder, 1, "protocol_version", Integer.valueOf(((zzgc)localObject1).match()));
        }
        zzoz.isEmpty();
        if ((this$0.append().get(null, zzeb.zzar)) && (((zzgc)localObject1).zzbm())) {
          append(localStringBuilder, 1, "session_stitching_token", ((zzgc)localObject1).getAttributeName());
        }
        append(localStringBuilder, 1, "platform", ((zzgc)localObject1).getName());
        if (((zzgc)localObject1).zzbf()) {
          append(localStringBuilder, 1, "gmp_version", Long.valueOf(((zzgc)localObject1).hasNext()));
        }
        if (((zzgc)localObject1).zzbq()) {
          append(localStringBuilder, 1, "uploading_gmp_version", Long.valueOf(((zzgc)localObject1).getChildren()));
        }
        if (((zzgc)localObject1).zzbd()) {
          append(localStringBuilder, 1, "dynamite_version", Long.valueOf(((zzgc)localObject1).getKey()));
        }
        if (((zzgc)localObject1).zzba()) {
          append(localStringBuilder, 1, "config_version", Long.valueOf(((zzgc)localObject1).indexOf()));
        }
        append(localStringBuilder, 1, "gmp_app_id", ((zzgc)localObject1).readLine());
        append(localStringBuilder, 1, "admob_app_id", ((zzgc)localObject1).url());
        append(localStringBuilder, 1, "app_id", ((zzgc)localObject1).getValue());
        append(localStringBuilder, 1, "app_version", ((zzgc)localObject1).execute());
        if (((zzgc)localObject1).zzaY()) {
          append(localStringBuilder, 1, "app_version_major", Integer.valueOf(((zzgc)localObject1).getRoster()));
        }
        append(localStringBuilder, 1, "firebase_instance_id", ((zzgc)localObject1).trim());
        if (((zzgc)localObject1).zzbc()) {
          append(localStringBuilder, 1, "dev_cert_hash", Long.valueOf(((zzgc)localObject1).intValue()));
        }
        append(localStringBuilder, 1, "app_store", ((zzgc)localObject1).title());
        if (((zzgc)localObject1).zzbp()) {
          append(localStringBuilder, 1, "upload_timestamp_millis", Long.valueOf(((zzgc)localObject1).getObject()));
        }
        if (((zzgc)localObject1).zzbn()) {
          append(localStringBuilder, 1, "start_timestamp_millis", Long.valueOf(((zzgc)localObject1).read()));
        }
        if (((zzgc)localObject1).zzbe()) {
          append(localStringBuilder, 1, "end_timestamp_millis", Long.valueOf(((zzgc)localObject1).getIdentifier()));
        }
        if (((zzgc)localObject1).zzbi()) {
          append(localStringBuilder, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(((zzgc)localObject1).getSize()));
        }
        if (((zzgc)localObject1).zzbh()) {
          append(localStringBuilder, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(((zzgc)localObject1).remove()));
        }
        append(localStringBuilder, 1, "app_instance_id", ((zzgc)localObject1).replace());
        append(localStringBuilder, 1, "resettable_device_id", ((zzgc)localObject1).getAbsolutePath());
        append(localStringBuilder, 1, "ds_id", ((zzgc)localObject1).getData());
        if (((zzgc)localObject1).zzbg()) {
          append(localStringBuilder, 1, "limited_ad_tracking", Boolean.valueOf(((zzgc)localObject1).zzaW()));
        }
        append(localStringBuilder, 1, "os_version", ((zzgc)localObject1).time());
        append(localStringBuilder, 1, "device_model", ((zzgc)localObject1).getFile());
        append(localStringBuilder, 1, "user_default_language", ((zzgc)localObject1).toCharArray());
        if (((zzgc)localObject1).zzbo()) {
          append(localStringBuilder, 1, "time_zone_offset_minutes", Integer.valueOf(((zzgc)localObject1).getType()));
        }
        if (((zzgc)localObject1).zzaZ()) {
          append(localStringBuilder, 1, "bundle_sequential_index", Integer.valueOf(((zzgc)localObject1).write()));
        }
        if (((zzgc)localObject1).zzbl()) {
          append(localStringBuilder, 1, "service_upload", Boolean.valueOf(((zzgc)localObject1).zzaX()));
        }
        append(localStringBuilder, 1, "health_monitor", ((zzgc)localObject1).getString());
        if (((zzgc)localObject1).zzbk()) {
          append(localStringBuilder, 1, "retry_counter", Integer.valueOf(((zzgc)localObject1).next()));
        }
        if (((zzgc)localObject1).zzbb()) {
          append(localStringBuilder, 1, "consent_signals", ((zzgc)localObject1).get());
        }
        paramZzga = ((zzgc)localObject1).getIds();
        Object localObject2;
        if (paramZzga != null)
        {
          localObject2 = paramZzga.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            zzgl localZzgl = (zzgl)((Iterator)localObject2).next();
            if (localZzgl != null)
            {
              write(localStringBuilder, 2);
              localStringBuilder.append("user_property {\n");
              if (localZzgl.execute()) {
                paramZzga = Long.valueOf(localZzgl.getKey());
              } else {
                paramZzga = null;
              }
              append(localStringBuilder, 2, "set_timestamp_millis", paramZzga);
              append(localStringBuilder, 2, "name", this$0.next().get(localZzgl.next()));
              append(localStringBuilder, 2, "string_value", localZzgl.intValue());
              if (localZzgl.match()) {
                paramZzga = Long.valueOf(localZzgl.length());
              } else {
                paramZzga = null;
              }
              append(localStringBuilder, 2, "int_value", paramZzga);
              if (localZzgl.remove()) {
                paramZzga = Double.valueOf(localZzgl.getValue());
              } else {
                paramZzga = null;
              }
              append(localStringBuilder, 2, "double_value", paramZzga);
              write(localStringBuilder, 2);
              localStringBuilder.append("}\n");
            }
          }
        }
        paramZzga = ((zzgc)localObject1).listFiles();
        if (paramZzga != null)
        {
          paramZzga = paramZzga.iterator();
          while (paramZzga.hasNext())
          {
            localObject2 = (zzfo)paramZzga.next();
            if (localObject2 != null)
            {
              write(localStringBuilder, 2);
              localStringBuilder.append("audience_membership {\n");
              if (((zzfo)localObject2).remove()) {
                append(localStringBuilder, 2, "audience_id", Integer.valueOf(((zzfo)localObject2).getValue()));
              }
              if (((zzfo)localObject2).next()) {
                append(localStringBuilder, 2, "new_audience", Boolean.valueOf(((zzfo)localObject2).equals()));
              }
              parse(localStringBuilder, 2, "current_data", ((zzfo)localObject2).get());
              if (((zzfo)localObject2).match()) {
                parse(localStringBuilder, 2, "previous_data", ((zzfo)localObject2).writer());
              }
              write(localStringBuilder, 2);
              localStringBuilder.append("}\n");
            }
          }
        }
        paramZzga = ((zzgc)localObject1).getGroups();
        if (paramZzga != null)
        {
          paramZzga = paramZzga.iterator();
          while (paramZzga.hasNext())
          {
            localObject1 = (zzfs)paramZzga.next();
            if (localObject1 != null)
            {
              write(localStringBuilder, 2);
              localStringBuilder.append("event {\n");
              append(localStringBuilder, 2, "name", this$0.next().toString(((zzfs)localObject1).getValue()));
              if (((zzfs)localObject1).equals()) {
                append(localStringBuilder, 2, "timestamp_millis", Long.valueOf(((zzfs)localObject1).read()));
              }
              if (((zzfs)localObject1).hasNext()) {
                append(localStringBuilder, 2, "previous_timestamp_millis", Long.valueOf(((zzfs)localObject1).next()));
              }
              if (((zzfs)localObject1).execute()) {
                append(localStringBuilder, 2, "count", Integer.valueOf(((zzfs)localObject1).getSize()));
              }
              if (((zzfs)localObject1).length() != 0) {
                write(localStringBuilder, 2, ((zzfs)localObject1).get());
              }
              write(localStringBuilder, 2);
              localStringBuilder.append("}\n");
            }
          }
        }
        write(localStringBuilder, 1);
        localStringBuilder.append("}\n");
      }
    }
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
  
  final long read(byte[] paramArrayOfByte)
  {
    Preconditions.checkNotNull(paramArrayOfByte);
    this$0.get().append();
    MessageDigest localMessageDigest = zzlh.getInstance();
    if (localMessageDigest == null)
    {
      this$0.zzay().iterator().append("Failed to get MD5");
      return 0L;
    }
    return zzlh.read(localMessageDigest.digest(paramArrayOfByte));
  }
  
  final Bundle read(Map paramMap, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramMap.get(str);
      if (localObject == null) {
        localBundle.putString(str, null);
      } else if ((localObject instanceof Long)) {
        localBundle.putLong(str, ((Long)localObject).longValue());
      } else if ((localObject instanceof Double)) {
        localBundle.putDouble(str, ((Double)localObject).doubleValue());
      } else if ((localObject instanceof ArrayList))
      {
        if (paramBoolean)
        {
          localObject = (ArrayList)localObject;
          ArrayList localArrayList = new ArrayList();
          int j = ((List)localObject).size();
          int i = 0;
          while (i < j)
          {
            localArrayList.add(read((Map)((List)localObject).get(i), false));
            i += 1;
          }
          localBundle.putParcelableArray(str, (Parcelable[])localArrayList.toArray(new Parcelable[0]));
        }
      }
      else {
        localBundle.putString(str, localObject.toString());
      }
    }
    return localBundle;
  }
  
  final List read(List paramList1, List paramList2)
  {
    paramList1 = new ArrayList(paramList1);
    paramList2 = paramList2.iterator();
    while (paramList2.hasNext())
    {
      Integer localInteger = (Integer)paramList2.next();
      if (localInteger.intValue() < 0)
      {
        this$0.zzay().hasNext().append("Ignoring negative bit index to be cleared", localInteger);
      }
      else
      {
        i = localInteger.intValue() / 64;
        if (i >= paramList1.size()) {
          this$0.zzay().hasNext().append("Ignoring bit index greater than bitSet size", localInteger, Integer.valueOf(paramList1.size()));
        } else {
          paramList1.set(i, Long.valueOf(((Long)paramList1.get(i)).longValue() & 1L << localInteger.intValue() % 64));
        }
      }
    }
    int j = paramList1.size();
    int i = paramList1.size() - 1;
    int k;
    for (;;)
    {
      k = j;
      j = i;
      if ((i < 0) || (((Long)paramList1.get(i)).longValue() != 0L)) {
        break;
      }
      i -= 1;
    }
    return paramList1.subList(0, k);
  }
  
  final void read(zzfv paramZzfv, Object paramObject)
  {
    Preconditions.checkNotNull(paramObject);
    paramZzfv.descend();
    paramZzfv.parseHeader();
    paramZzfv.linearCombination();
    paramZzfv.inc();
    if ((paramObject instanceof String))
    {
      paramZzfv.setValue((String)paramObject);
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramZzfv.add(((Long)paramObject).longValue());
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramZzfv.getLabel(((Double)paramObject).doubleValue());
      return;
    }
    if ((paramObject instanceof Bundle[]))
    {
      paramObject = (Bundle[])paramObject;
      ArrayList localArrayList = new ArrayList();
      int j = paramObject.length;
      int i = 0;
      while (i < j)
      {
        Object localObject1 = paramObject[i];
        if (localObject1 != null)
        {
          zzfv localZzfv1 = zzfw.get();
          Iterator localIterator = localObject1.keySet().iterator();
          while (localIterator.hasNext())
          {
            Object localObject2 = (String)localIterator.next();
            zzfv localZzfv2 = zzfw.get();
            localZzfv2.get((String)localObject2);
            localObject2 = localObject1.get((String)localObject2);
            if ((localObject2 instanceof Long))
            {
              localZzfv2.add(((Long)localObject2).longValue());
            }
            else if ((localObject2 instanceof String))
            {
              localZzfv2.setValue((String)localObject2);
            }
            else
            {
              if (!(localObject2 instanceof Double)) {
                continue;
              }
              localZzfv2.getLabel(((Double)localObject2).doubleValue());
            }
            localZzfv1.descend(localZzfv2);
          }
          if (localZzfv1.getNumberOfColumns() > 0) {
            localArrayList.add((zzfw)localZzfv1.zzaE());
          }
        }
        i += 1;
      }
      paramZzfv.descend(localArrayList);
      return;
    }
    this$0.zzay().iterator().append("Ignoring invalid (type) event param value", paramObject);
  }
  
  protected final boolean registerAlarm()
  {
    return false;
  }
  
  final Map set(Bundle paramBundle, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject1 = paramBundle.get(str);
      boolean bool = localObject1 instanceof Parcelable[];
      if ((!bool) && (!(localObject1 instanceof ArrayList)) && (!(localObject1 instanceof Bundle)))
      {
        if (localObject1 != null) {
          localHashMap.put(str, localObject1);
        }
      }
      else if (paramBoolean)
      {
        ArrayList localArrayList = new ArrayList();
        int j;
        int i;
        Object localObject2;
        if (bool)
        {
          localObject1 = (Parcelable[])localObject1;
          j = localObject1.length;
          i = 0;
          while (i < j)
          {
            localObject2 = localObject1[i];
            if ((localObject2 instanceof Bundle)) {
              localArrayList.add(set((Bundle)localObject2, false));
            }
            i += 1;
          }
        }
        if ((localObject1 instanceof ArrayList))
        {
          localObject1 = (ArrayList)localObject1;
          j = ((List)localObject1).size();
          i = 0;
          while (i < j)
          {
            localObject2 = ((List)localObject1).get(i);
            if ((localObject2 instanceof Bundle)) {
              localArrayList.add(set((Bundle)localObject2, false));
            }
            i += 1;
          }
        }
        if ((localObject1 instanceof Bundle)) {
          localArrayList.add(set((Bundle)localObject1, false));
        }
        localHashMap.put(str, localArrayList);
      }
    }
    return localHashMap;
  }
  
  final zzfs toString(zzar paramZzar)
  {
    zzfr localZzfr = zzfs.getKey();
    localZzfr.truncate(progress);
    zzat localZzat = new zzat(path);
    while (localZzat.hasNext())
    {
      Object localObject = localZzat.getValue();
      zzfv localZzfv = zzfw.get();
      localZzfv.get((String)localObject);
      localObject = path.get((String)localObject);
      Preconditions.checkNotNull(localObject);
      read(localZzfv, localObject);
      localZzfr.getKey(localZzfv);
    }
    return (zzfs)localZzfr.zzaE();
  }
  
  final String toString(com.google.android.gms.internal.measurement.zzej paramZzej)
  {
    if (paramZzej == null) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nevent_filter {\n");
    if (paramZzej.addElement()) {
      append(localStringBuilder, 0, "filter_id", Integer.valueOf(paramZzej.format()));
    }
    append(localStringBuilder, 0, "event_name", this$0.next().toString(paramZzej.getEntry()));
    String str = get(paramZzej.doSearch(), paramZzej.parseInt(), paramZzej.getSerieId());
    if (!str.isEmpty()) {
      append(localStringBuilder, 0, "filter_type", str);
    }
    if (paramZzej.add()) {
      toString(localStringBuilder, 1, "event_count_filter", paramZzej.getParameter());
    }
    if (paramZzej.size() > 0)
    {
      localStringBuilder.append("  filters {\n");
      paramZzej = paramZzej.get().iterator();
      while (paramZzej.hasNext()) {
        write(localStringBuilder, 2, (zzel)paramZzej.next());
      }
    }
    write(localStringBuilder, 1);
    localStringBuilder.append("}\n}\n");
    return localStringBuilder.toString();
  }
  
  final String toString(zzes paramZzes)
  {
    if (paramZzes == null) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nproperty_filter {\n");
    if (paramZzes.prepare()) {
      append(localStringBuilder, 0, "filter_id", Integer.valueOf(paramZzes.getData()));
    }
    append(localStringBuilder, 0, "property_name", this$0.next().get(paramZzes.getString()));
    String str = get(paramZzes.convert(), paramZzes.getContent(), paramZzes.format());
    if (!str.isEmpty()) {
      append(localStringBuilder, 0, "filter_type", str);
    }
    write(localStringBuilder, 1, paramZzes.get());
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
  
  final boolean update(long paramLong1, long paramLong2)
  {
    return (paramLong1 == 0L) || (paramLong2 <= 0L) || (Math.abs(this$0.zzav().currentTimeMillis() - paramLong1) > paramLong2);
  }
  
  final void write(zzgk paramZzgk, Object paramObject)
  {
    Preconditions.checkNotNull(paramObject);
    paramZzgk.putShort();
    paramZzgk.inc();
    paramZzgk.descend();
    if ((paramObject instanceof String))
    {
      paramZzgk.descend((String)paramObject);
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramZzgk.inc(((Long)paramObject).longValue());
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramZzgk.f(((Double)paramObject).doubleValue());
      return;
    }
    this$0.zzay().iterator().append("Ignoring invalid (type) user attribute value", paramObject);
  }
}
