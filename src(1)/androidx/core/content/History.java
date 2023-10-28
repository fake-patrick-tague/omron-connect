package androidx.core.content;

import v7.v7.util.DownloadManager;

public abstract interface History
{
  public abstract void addOnConfigurationChangedListener(DownloadManager paramDownloadManager);
  
  public abstract void removeOnConfigurationChangedListener(DownloadManager paramDownloadManager);
}
