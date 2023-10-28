package com.alivecor.mapsforge.record;

import com.alivecor.mapsforge.core.model.MainsFilterFrequency;
import com.alivecor.universal_monitor.Filter;

public class RecordingSettings
{
  public final boolean isPreviewRawPDF;
  public final MainsFilterFrequency mainsFreq;
  public final int maxRecDurationMs;
  public final int minRecDurationMs;
  @Deprecated
  public final boolean noiseDetectorEnabled;
  public final Filter previewFilter;
  public final boolean voiceEnabled;
  public final int yAxisScale;
  
  public RecordingSettings(MainsFilterFrequency paramMainsFilterFrequency, Filter paramFilter, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt3)
  {
    mainsFreq = paramMainsFilterFrequency;
    previewFilter = paramFilter;
    minRecDurationMs = paramInt1;
    maxRecDurationMs = paramInt2;
    noiseDetectorEnabled = paramBoolean1;
    voiceEnabled = paramBoolean2;
    isPreviewRawPDF = paramBoolean3;
    yAxisScale = paramInt3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecordingSettings{mainsFreq=");
    localStringBuilder.append(mainsFreq);
    localStringBuilder.append(", previewFilter=");
    localStringBuilder.append(previewFilter);
    localStringBuilder.append(", minRecDurationMs=");
    localStringBuilder.append(minRecDurationMs);
    localStringBuilder.append(", maxRecDurationMs=");
    localStringBuilder.append(maxRecDurationMs);
    localStringBuilder.append(", noiseDetectorEnabled=");
    localStringBuilder.append(noiseDetectorEnabled);
    localStringBuilder.append(", voiceEnabled=");
    localStringBuilder.append(voiceEnabled);
    localStringBuilder.append(", previewRawPDF=");
    localStringBuilder.append(isPreviewRawPDF);
    localStringBuilder.append(", yAxisScale=");
    localStringBuilder.append(yAxisScale);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
