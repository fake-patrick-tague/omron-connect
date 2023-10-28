package androidx.work;

import android.net.Network;
import android.net.Uri;
import androidx.work.impl.utils.asm.f;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

public final class WorkerParameters
{
  private ExtendedDigest baseDigest;
  private Executor callbackExecutor;
  private UUID j;
  private Label k;
  private a mCommand;
  private int mDrawableId;
  private Pair mItem;
  private f mParentMenu;
  private Set<String> mSubCommands;
  private LayoutManager m_instance;
  
  public WorkerParameters(UUID paramUUID, Label paramLabel, Collection paramCollection, a paramA, int paramInt, Executor paramExecutor, f paramF, Pair paramPair, ExtendedDigest paramExtendedDigest, LayoutManager paramLayoutManager)
  {
    j = paramUUID;
    k = paramLabel;
    mSubCommands = new HashSet(paramCollection);
    mCommand = paramA;
    mDrawableId = paramInt;
    callbackExecutor = paramExecutor;
    mParentMenu = paramF;
    mItem = paramPair;
    baseDigest = paramExtendedDigest;
    m_instance = paramLayoutManager;
  }
  
  public Label a()
  {
    return k;
  }
  
  public Executor build()
  {
    return callbackExecutor;
  }
  
  public UUID e()
  {
    return j;
  }
  
  public Pair get()
  {
    return mItem;
  }
  
  public LayoutManager getInstance()
  {
    return m_instance;
  }
  
  public static class a
  {
    public List<String> allStartTags = Collections.emptyList();
    public List<Uri> allTags = Collections.emptyList();
    public Network mNetwork;
    
    public a() {}
  }
}
