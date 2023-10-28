package com.alivecor.mapsforge.record;

import com.alivecor.asm.Priority;
import com.alivecor.mapsforge.core.model.YAxisScaleTypes;
import k.a.a.b;

class PdfData
{
  public final String appName;
  public final Priority finalDetermination;
  public final boolean isEnhancedFilter;
  public final boolean isInverted;
  public final ReportRawPDFType isReportRawPDF;
  public final String logoAsset;
  public final String noteString;
  public final PaperSize paperSize;
  public final PatientData patientData;
  public final String patientId;
  public final float recordedHr;
  public final b recordingDate;
  public final long recordingDurationMillis;
  public final String recordingUuid;
  public final String tagString;
  public final YAxisScaleTypes yAxisScaleTypes;
  
  PdfData(String paramString1, String paramString2, boolean paramBoolean1, b paramB, PatientData paramPatientData, PaperSize paramPaperSize, String paramString3, float paramFloat, Priority paramPriority, long paramLong, String paramString4, String paramString5, String paramString6, boolean paramBoolean2, ReportRawPDFType paramReportRawPDFType, YAxisScaleTypes paramYAxisScaleTypes)
  {
    recordingUuid = paramString2;
    isEnhancedFilter = paramBoolean1;
    recordingDate = paramB;
    patientData = paramPatientData;
    recordedHr = paramFloat;
    finalDetermination = paramPriority;
    recordingDurationMillis = paramLong;
    tagString = paramString4;
    noteString = paramString5;
    patientId = paramString6;
    isInverted = paramBoolean2;
    paperSize = paramPaperSize;
    logoAsset = paramString3;
    appName = paramString1;
    isReportRawPDF = paramReportRawPDFType;
    yAxisScaleTypes = paramYAxisScaleTypes;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PdfData{recordingUuid='");
    localStringBuilder.append(recordingUuid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isEnhancedFilter=");
    localStringBuilder.append(isEnhancedFilter);
    localStringBuilder.append(", recordingDate=");
    localStringBuilder.append(recordingDate);
    localStringBuilder.append(", patientData=");
    localStringBuilder.append(patientData);
    localStringBuilder.append(", recordedHr=");
    localStringBuilder.append(recordedHr);
    localStringBuilder.append(", finalDetermination=");
    localStringBuilder.append(finalDetermination);
    localStringBuilder.append(", recordingDurationMillis=");
    localStringBuilder.append(recordingDurationMillis);
    localStringBuilder.append(", tagString='");
    localStringBuilder.append(tagString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", noteString='");
    localStringBuilder.append(noteString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", patientId='");
    localStringBuilder.append(patientId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isInverted=");
    localStringBuilder.append(isInverted);
    localStringBuilder.append(", paperSize=");
    localStringBuilder.append(paperSize);
    localStringBuilder.append(", logoAsset='");
    localStringBuilder.append(logoAsset);
    localStringBuilder.append('\'');
    localStringBuilder.append(", appName='");
    localStringBuilder.append(appName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", previewRawPDF='");
    localStringBuilder.append(isReportRawPDF);
    localStringBuilder.append('\'');
    localStringBuilder.append(", yAxisScale='");
    localStringBuilder.append(yAxisScaleTypes);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  enum PaperSize
  {
    static
    {
      PaperSize localPaperSize1 = new PaperSize("A4", 0);
      LEGAL = localPaperSize1;
      PaperSize localPaperSize2 = new PaperSize("LETTER", 1);
      LETTER = localPaperSize2;
      $VALUES = new PaperSize[] { localPaperSize1, localPaperSize2 };
    }
  }
  
  class PatientData
  {
    public final long lastIndex;
    public final String lastName;
    
    PatientData(String paramString, long paramLong)
    {
      lastName = paramString;
      lastIndex = paramLong;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PatientData{firstName='");
      localStringBuilder.append(PdfData.this);
      localStringBuilder.append('\'');
      localStringBuilder.append(", lastName='");
      localStringBuilder.append(lastName);
      localStringBuilder.append('\'');
      localStringBuilder.append(", dob=");
      localStringBuilder.append(lastIndex);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
}
