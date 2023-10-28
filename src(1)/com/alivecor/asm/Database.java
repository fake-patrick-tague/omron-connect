package com.alivecor.asm;

import com.alivecor.ecgcore.ECGSignalATC;
import com.alivecor.ecgcore.MainsFrequency;
import com.alivecor.ecgcore.SampleRate;
import com.alivecor.kardia_ai.StandardOfflineFilter;
import com.alivecor.mapsforge.core.asm.b;
import com.alivecor.mapsforge.core.model.MainsFilterFrequency;
import com.google.gson.reflect.Value;
import com.google.gson.v.c;
import java.lang.reflect.Field;

public class Database
{
  public Database() {}
  
  public static short[] fillBuffer(double[] paramArrayOfDouble)
  {
    int j = paramArrayOfDouble.length;
    short[] arrayOfShort = new short[j];
    int i = 0;
    while (i < j)
    {
      double d2 = paramArrayOfDouble[i];
      double d1;
      if (d2 > 32767.0D)
      {
        d1 = 32767.0D;
      }
      else
      {
        d1 = d2;
        if (d2 < -32768.0D) {
          d1 = -32768.0D;
        }
      }
      arrayOfShort[i] = ((short)(int)d1);
      i += 1;
    }
    return arrayOfShort;
  }
  
  public static short[] getManga(short[] paramArrayOfShort, int paramInt)
  {
    StandardOfflineFilter localStandardOfflineFilter = new StandardOfflineFilter();
    SampleRate localSampleRate = SampleRate.RATE_300_HZ;
    double[] arrayOfDouble = new ECGSignalATC(paramArrayOfShort, localSampleRate).getMVSamples();
    if (MainsFilterFrequency.fromFrequency(paramInt) == MainsFilterFrequency.MAINS_60_HZ) {
      paramArrayOfShort = MainsFrequency.MAINS_60_HZ;
    } else {
      paramArrayOfShort = MainsFrequency.MAINS_50_HZ;
    }
    return b.add(b.add(localStandardOfflineFilter.filter(arrayOfDouble, localSampleRate, paramArrayOfShort), 500));
  }
  
  public static Enum read(Class paramClass, String paramString)
  {
    Field[] arrayOfField = paramClass.getFields();
    if ((arrayOfField != null) && (arrayOfField.length > 0))
    {
      int j = arrayOfField.length;
      int i = 0;
      while (i < j)
      {
        Field localField = arrayOfField[i];
        Value localValue = (Value)localField.getAnnotation(c.class);
        if ((localValue != null) && (localValue.value().equals(paramString))) {
          return Enum.valueOf(paramClass, localField.getName());
        }
        i += 1;
      }
    }
    return null;
  }
  
  public static String read(Enum paramEnum)
  {
    try
    {
      paramEnum = paramEnum.getClass().getField(paramEnum.name()).getAnnotation(c.class);
      paramEnum = (Value)paramEnum;
      if (paramEnum != null)
      {
        paramEnum = paramEnum.value();
        return paramEnum;
      }
    }
    catch (NoSuchFieldException paramEnum) {}
    return null;
  }
  
  public static double[] read(short[] paramArrayOfShort)
  {
    int j = paramArrayOfShort.length;
    double[] arrayOfDouble = new double[j];
    int i = 0;
    while (i < j)
    {
      arrayOfDouble[i] = paramArrayOfShort[i];
      i += 1;
    }
    return arrayOfDouble;
  }
}
