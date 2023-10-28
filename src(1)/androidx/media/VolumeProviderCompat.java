package androidx.media;

public abstract class VolumeProviderCompat
{
  public abstract class Callback
  {
    public Callback() {}
    
    public abstract void onVolumeChanged(VolumeProviderCompat paramVolumeProviderCompat);
  }
}
