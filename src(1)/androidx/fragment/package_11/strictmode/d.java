package androidx.fragment.package_11.strictmode;

import androidx.fragment.package_11.Fragment;

public abstract class d
  extends RuntimeException
{
  private final Fragment r;
  
  public d(Fragment paramFragment, String paramString)
  {
    super(paramString);
    r = paramFragment;
  }
  
  public final Fragment a()
  {
    return r;
  }
}
