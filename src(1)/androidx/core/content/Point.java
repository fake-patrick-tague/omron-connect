package androidx.core.content;

import v7.v7.util.DownloadManager;

public abstract interface Point
{
  public abstract void addOnTrimMemoryListener(DownloadManager paramDownloadManager);
  
  public abstract void removeOnTrimMemoryListener(DownloadManager paramDownloadManager);
}
