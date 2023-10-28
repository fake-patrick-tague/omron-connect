package com.alivecor.asm;

import android.content.Context;
import com.alivecor.ecgcore.ECGSignalMV;
import com.alivecor.ecgcore.MainsFrequency;
import com.alivecor.ecgcore.SampleRate;
import com.alivecor.kardia_ai.Classifier;
import com.alivecor.kardia_ai.ClassifierResult;
import com.alivecor.mapsforge.core.EcgFile;
import com.alivecor.mapsforge.core.EcgFile.Lead;
import com.alivecor.mapsforge.core.model.MainsFilterFrequency;
import java.io.File;
import l.a.a;

class d
  implements c
{
  private final Context mContext;
  
  public d(Context paramContext)
  {
    mContext = paramContext.getApplicationContext();
  }
  
  private Item b(ClassifierResult paramClassifierResult, int paramInt)
  {
    int i = heartRate;
    int j = 0;
    paramInt = i;
    if (i < 0) {
      paramInt = 0;
    }
    ClassifierData localClassifierData = new ClassifierData(Priority.valueOf(algorithmDetermination));
    paramClassifierResult = version;
    if (paramClassifierResult != null) {
      try
      {
        Object localObject = paramClassifierResult.split("\\.");
        String str = localObject[0];
        localClassifierData.b(str);
        str = localObject[1];
        localClassifierData.e(str);
        localObject = localObject[2];
        localObject = ((String)localObject).split(" ");
        localObject = localObject[0];
        localClassifierData.a((String)localObject);
      }
      catch (Exception localException)
      {
        a.i(localException, "Couldn't parse Kardia AI version! %s", new Object[] { paramClassifierResult });
      }
    }
    i = j;
    if (((ClassifierData.b)localClassifierData.newUTF8()).getDetermination() != Priority.Normal)
    {
      i = j;
      if (((ClassifierData.b)localClassifierData.newUTF8()).getDetermination() != Priority.High)
      {
        i = j;
        if (((ClassifierData.b)localClassifierData.newUTF8()).getDetermination() != Priority.Low) {
          if (((ClassifierData.b)localClassifierData.newUTF8()).getDetermination() == Priority.Off) {
            i = j;
          } else {
            i = paramInt;
          }
        }
      }
    }
    return new Item(localClassifierData, null, i);
  }
  
  public Item a(File paramFile)
  {
    Classifier localClassifier = getId();
    try
    {
      EcgFile localEcgFile = new EcgFile();
      try
      {
        paramFile = localClassifier.determinationFromFile(paramFile.getAbsolutePath());
        a.a("classify(): Ran with final result %s", new Object[] { paramFile });
        paramFile = b(paramFile, (int)localEcgFile.samplesForLead(EcgFile.Lead.LEAD_1));
        localEcgFile.close();
        return paramFile;
      }
      catch (Throwable paramFile)
      {
        try
        {
          localEcgFile.close();
        }
        catch (Throwable localThrowable)
        {
          paramFile.addSuppressed(localThrowable);
        }
        throw paramFile;
      }
      return new Item(((Exception)paramFile).getMessage());
    }
    catch (Exception paramFile)
    {
      a.c(paramFile, "Could not run KardiaAI Classifier", new Object[0]);
    }
  }
  
  public Item a(double[] paramArrayOfDouble, int paramInt, SampleRate paramSampleRate, MainsFilterFrequency paramMainsFilterFrequency)
  {
    Classifier localClassifier = getId();
    if (paramMainsFilterFrequency == MainsFilterFrequency.MAINS_60_HZ) {
      paramMainsFilterFrequency = MainsFrequency.MAINS_60_HZ;
    } else {
      paramMainsFilterFrequency = MainsFrequency.MAINS_50_HZ;
    }
    return b(localClassifier.determinationFromSignal(new ECGSignalMV(paramArrayOfDouble, paramSampleRate), paramMainsFilterFrequency), paramInt);
  }
  
  protected Classifier getId()
  {
    return new Classifier(false, true);
  }
}
