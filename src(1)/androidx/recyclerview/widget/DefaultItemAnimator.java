package androidx.recyclerview.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import v7.v7.package_13.ViewCompat;

public class DefaultItemAnimator
  extends SimpleItemAnimator
{
  private static TimeInterpolator mDefaultInterpolator;
  ArrayList<RecyclerView.b0> mAddAnimations = new ArrayList();
  ArrayList<ArrayList<RecyclerView.b0>> mAdditionsList = new ArrayList();
  ArrayList<RecyclerView.b0> mChangeAnimations = new ArrayList();
  ArrayList<ArrayList<g.i>> mChangesList = new ArrayList();
  ArrayList<RecyclerView.b0> mMoveAnimations = new ArrayList();
  ArrayList<ArrayList<g.j>> mMovesList = new ArrayList();
  private ArrayList<RecyclerView.b0> mPendingAdditions = new ArrayList();
  private ArrayList<g.i> mPendingChanges = new ArrayList();
  private ArrayList<g.j> mPendingMoves = new ArrayList();
  private ArrayList<RecyclerView.b0> mPendingRemovals = new ArrayList();
  ArrayList<RecyclerView.b0> mRemoveAnimations = new ArrayList();
  
  public DefaultItemAnimator() {}
  
  private void animateRemoveImpl(RecyclerView.b0 paramB0)
  {
    View localView = itemView;
    ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
    mRemoveAnimations.add(paramB0);
    localViewPropertyAnimator.setDuration(getRemoveDuration()).alpha(0.0F).setListener(new DefaultItemAnimator.4(this, paramB0, localViewPropertyAnimator, localView)).start();
  }
  
  private void endChangeAnimation(List paramList, RecyclerView.b0 paramB0)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      ChangeInfo localChangeInfo = (ChangeInfo)paramList.get(i);
      if ((endChangeAnimationIfNecessary(localChangeInfo, paramB0)) && (oldHolder == null) && (newHolder == null)) {
        paramList.remove(localChangeInfo);
      }
      i -= 1;
    }
  }
  
  private void endChangeAnimationIfNecessary(ChangeInfo paramChangeInfo)
  {
    RecyclerView.b0 localB0 = oldHolder;
    if (localB0 != null) {
      endChangeAnimationIfNecessary(paramChangeInfo, localB0);
    }
    localB0 = newHolder;
    if (localB0 != null) {
      endChangeAnimationIfNecessary(paramChangeInfo, localB0);
    }
  }
  
  private boolean endChangeAnimationIfNecessary(ChangeInfo paramChangeInfo, RecyclerView.b0 paramB0)
  {
    RecyclerView.b0 localB0 = newHolder;
    boolean bool = false;
    if (localB0 == paramB0)
    {
      newHolder = null;
    }
    else
    {
      if (oldHolder != paramB0) {
        break label69;
      }
      oldHolder = null;
      bool = true;
    }
    itemView.setAlpha(1.0F);
    itemView.setTranslationX(0.0F);
    itemView.setTranslationY(0.0F);
    dispatchChangeFinished(paramB0, bool);
    return true;
    label69:
    return false;
  }
  
  private void resetAnimation(RecyclerView.b0 paramB0)
  {
    if (mDefaultInterpolator == null) {
      mDefaultInterpolator = new ValueAnimator().getInterpolator();
    }
    itemView.animate().setInterpolator(mDefaultInterpolator);
    endAnimation(paramB0);
  }
  
  public boolean animateAdd(RecyclerView.b0 paramB0)
  {
    resetAnimation(paramB0);
    itemView.setAlpha(0.0F);
    mPendingAdditions.add(paramB0);
    return true;
  }
  
  public boolean animateChange(RecyclerView.b0 paramB01, RecyclerView.b0 paramB02, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramB01 == paramB02) {
      return animateMove(paramB01, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    float f1 = itemView.getTranslationX();
    float f2 = itemView.getTranslationY();
    float f3 = itemView.getAlpha();
    resetAnimation(paramB01);
    int i = (int)(paramInt3 - paramInt1 - f1);
    int j = (int)(paramInt4 - paramInt2 - f2);
    itemView.setTranslationX(f1);
    itemView.setTranslationY(f2);
    itemView.setAlpha(f3);
    if (paramB02 != null)
    {
      resetAnimation(paramB02);
      itemView.setTranslationX(-i);
      itemView.setTranslationY(-j);
      itemView.setAlpha(0.0F);
    }
    mPendingChanges.add(new ChangeInfo(paramB01, paramB02, paramInt1, paramInt2, paramInt3, paramInt4));
    return true;
  }
  
  void animateChangeImpl(ChangeInfo paramChangeInfo)
  {
    Object localObject1 = oldHolder;
    View localView = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = itemView;
    }
    Object localObject2 = newHolder;
    if (localObject2 != null) {
      localView = itemView;
    }
    if (localObject1 != null)
    {
      localObject2 = ((View)localObject1).animate().setDuration(getChangeDuration());
      mChangeAnimations.add(oldHolder);
      ((ViewPropertyAnimator)localObject2).translationX(fromY - toX);
      ((ViewPropertyAnimator)localObject2).translationY(fromX - toY);
      ((ViewPropertyAnimator)localObject2).alpha(0.0F).setListener(new DefaultItemAnimator.7(this, paramChangeInfo, (ViewPropertyAnimator)localObject2, (View)localObject1)).start();
    }
    if (localView != null)
    {
      localObject1 = localView.animate();
      mChangeAnimations.add(newHolder);
      ((ViewPropertyAnimator)localObject1).translationX(0.0F).translationY(0.0F).setDuration(getChangeDuration()).alpha(1.0F).setListener(new DefaultItemAnimator.8(this, paramChangeInfo, (ViewPropertyAnimator)localObject1, localView)).start();
    }
  }
  
  public boolean animateMove(RecyclerView.b0 paramB0, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = itemView;
    paramInt1 += (int)localView.getTranslationX();
    paramInt2 += (int)itemView.getTranslationY();
    resetAnimation(paramB0);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if ((i == 0) && (j == 0))
    {
      dispatchMoveFinished(paramB0);
      return false;
    }
    if (i != 0) {
      localView.setTranslationX(-i);
    }
    if (j != 0) {
      localView.setTranslationY(-j);
    }
    mPendingMoves.add(new MoveInfo(paramB0, paramInt1, paramInt2, paramInt3, paramInt4));
    return true;
  }
  
  void animateMoveImpl(RecyclerView.b0 paramB0, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = itemView;
    paramInt1 = paramInt3 - paramInt1;
    paramInt2 = paramInt4 - paramInt2;
    if (paramInt1 != 0) {
      localView.animate().translationX(0.0F);
    }
    if (paramInt2 != 0) {
      localView.animate().translationY(0.0F);
    }
    ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
    mMoveAnimations.add(paramB0);
    localViewPropertyAnimator.setDuration(getMoveDuration()).setListener(new DefaultItemAnimator.6(this, paramB0, paramInt1, localView, paramInt2, localViewPropertyAnimator)).start();
  }
  
  public boolean animateRemove(RecyclerView.b0 paramB0)
  {
    resetAnimation(paramB0);
    mPendingRemovals.add(paramB0);
    return true;
  }
  
  public boolean canReuseUpdatedViewHolder(RecyclerView.b0 paramB0, List paramList)
  {
    return (!paramList.isEmpty()) || (super.canReuseUpdatedViewHolder(paramB0, paramList));
  }
  
  void cancelAll(List paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      getitemView.animate().cancel();
      i -= 1;
    }
  }
  
  void close(RecyclerView.b0 paramB0)
  {
    View localView = itemView;
    ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
    mAddAnimations.add(paramB0);
    localViewPropertyAnimator.alpha(1.0F).setDuration(getAnimationDuration()).setListener(new ValueAnimatorCompatImplHoneycombMr1.2(this, paramB0, localView, localViewPropertyAnimator)).start();
  }
  
  void dispatchFinishedWhenDone()
  {
    if (!isRunning()) {
      b();
    }
  }
  
  public void endAnimation(RecyclerView.b0 paramB0)
  {
    View localView = itemView;
    localView.animate().cancel();
    int i = mPendingMoves.size() - 1;
    while (i >= 0)
    {
      if (mPendingMoves.get(i)).holder == paramB0)
      {
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        dispatchMoveFinished(paramB0);
        mPendingMoves.remove(i);
      }
      i -= 1;
    }
    endChangeAnimation(mPendingChanges, paramB0);
    if (mPendingRemovals.remove(paramB0))
    {
      localView.setAlpha(1.0F);
      dispatchRemoveFinished(paramB0);
    }
    if (mPendingAdditions.remove(paramB0))
    {
      localView.setAlpha(1.0F);
      dispatchAddFinished(paramB0);
    }
    i = mChangesList.size() - 1;
    ArrayList localArrayList;
    while (i >= 0)
    {
      localArrayList = (ArrayList)mChangesList.get(i);
      endChangeAnimation(localArrayList, paramB0);
      if (localArrayList.isEmpty()) {
        mChangesList.remove(i);
      }
      i -= 1;
    }
    i = mMovesList.size() - 1;
    while (i >= 0)
    {
      localArrayList = (ArrayList)mMovesList.get(i);
      int j = localArrayList.size() - 1;
      while (j >= 0)
      {
        if (getholder == paramB0)
        {
          localView.setTranslationY(0.0F);
          localView.setTranslationX(0.0F);
          dispatchMoveFinished(paramB0);
          localArrayList.remove(j);
          if (!localArrayList.isEmpty()) {
            break;
          }
          mMovesList.remove(i);
          break;
        }
        j -= 1;
      }
      i -= 1;
    }
    i = mAdditionsList.size() - 1;
    while (i >= 0)
    {
      localArrayList = (ArrayList)mAdditionsList.get(i);
      if (localArrayList.remove(paramB0))
      {
        localView.setAlpha(1.0F);
        dispatchAddFinished(paramB0);
        if (localArrayList.isEmpty()) {
          mAdditionsList.remove(i);
        }
      }
      i -= 1;
    }
    mRemoveAnimations.remove(paramB0);
    mAddAnimations.remove(paramB0);
    mChangeAnimations.remove(paramB0);
    mMoveAnimations.remove(paramB0);
    dispatchFinishedWhenDone();
  }
  
  public void endAnimations()
  {
    Object localObject1 = mPendingMoves;
    DefaultItemAnimator localDefaultItemAnimator = this;
    int i = ((ArrayList)localObject1).size() - 1;
    Object localObject2;
    while (i >= 0)
    {
      localObject1 = (MoveInfo)mPendingMoves.get(i);
      localObject2 = holder.itemView;
      ((View)localObject2).setTranslationY(0.0F);
      ((View)localObject2).setTranslationX(0.0F);
      localDefaultItemAnimator.dispatchMoveFinished(holder);
      localObject1 = mPendingMoves;
      ((ArrayList)localObject1).remove(i);
      i -= 1;
    }
    localObject1 = mPendingRemovals;
    i = ((ArrayList)localObject1).size() - 1;
    while (i >= 0)
    {
      localDefaultItemAnimator.dispatchRemoveFinished((RecyclerView.b0)mPendingRemovals.get(i));
      localObject1 = mPendingRemovals;
      ((ArrayList)localObject1).remove(i);
      i -= 1;
    }
    localObject1 = mPendingAdditions;
    i = ((ArrayList)localObject1).size() - 1;
    while (i >= 0)
    {
      localObject1 = (RecyclerView.b0)mPendingAdditions.get(i);
      itemView.setAlpha(1.0F);
      localDefaultItemAnimator.dispatchAddFinished((RecyclerView.b0)localObject1);
      localObject1 = mPendingAdditions;
      ((ArrayList)localObject1).remove(i);
      i -= 1;
    }
    localObject1 = mPendingChanges;
    i = ((ArrayList)localObject1).size() - 1;
    while (i >= 0)
    {
      localObject1 = mPendingChanges;
      localDefaultItemAnimator.endChangeAnimationIfNecessary((ChangeInfo)((ArrayList)localObject1).get(i));
      i -= 1;
    }
    mPendingChanges.clear();
    if (!localDefaultItemAnimator.isRunning()) {
      return;
    }
    localObject1 = mMovesList;
    i = ((ArrayList)localObject1).size() - 1;
    int j;
    while (i >= 0)
    {
      localObject1 = mMovesList;
      localObject1 = (ArrayList)((ArrayList)localObject1).get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (MoveInfo)((ArrayList)localObject1).get(j);
        View localView = holder.itemView;
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        localDefaultItemAnimator.dispatchMoveFinished(holder);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          mMovesList.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    localObject1 = mAdditionsList;
    i = ((ArrayList)localObject1).size() - 1;
    while (i >= 0)
    {
      localObject1 = mAdditionsList;
      localObject1 = (ArrayList)((ArrayList)localObject1).get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (RecyclerView.b0)((ArrayList)localObject1).get(j);
        itemView.setAlpha(1.0F);
        localDefaultItemAnimator.dispatchAddFinished((RecyclerView.b0)localObject2);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          mAdditionsList.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    localObject1 = mChangesList;
    i = ((ArrayList)localObject1).size() - 1;
    while (i >= 0)
    {
      localObject1 = mChangesList;
      localObject1 = (ArrayList)((ArrayList)localObject1).get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localDefaultItemAnimator.endChangeAnimationIfNecessary((ChangeInfo)((ArrayList)localObject1).get(j));
        if (((ArrayList)localObject1).isEmpty()) {
          mChangesList.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    localDefaultItemAnimator.cancelAll(mRemoveAnimations);
    localDefaultItemAnimator.cancelAll(mMoveAnimations);
    localDefaultItemAnimator.cancelAll(mAddAnimations);
    localDefaultItemAnimator.cancelAll(mChangeAnimations);
    localDefaultItemAnimator.b();
  }
  
  public boolean isRunning()
  {
    return (!mPendingAdditions.isEmpty()) || (!mPendingChanges.isEmpty()) || (!mPendingMoves.isEmpty()) || (!mPendingRemovals.isEmpty()) || (!mMoveAnimations.isEmpty()) || (!mRemoveAnimations.isEmpty()) || (!mAddAnimations.isEmpty()) || (!mChangeAnimations.isEmpty()) || (!mMovesList.isEmpty()) || (!mAdditionsList.isEmpty()) || (!mChangesList.isEmpty());
  }
  
  public void runPendingAnimations()
  {
    boolean bool1 = mPendingRemovals.isEmpty() ^ true;
    boolean bool2 = mPendingMoves.isEmpty() ^ true;
    boolean bool3 = mPendingChanges.isEmpty() ^ true;
    boolean bool4 = mPendingAdditions.isEmpty() ^ true;
    if ((!bool1) && (!bool2) && (!bool4) && (!bool3)) {
      return;
    }
    Object localObject1 = mPendingRemovals.iterator();
    while (((Iterator)localObject1).hasNext()) {
      animateRemoveImpl((RecyclerView.b0)((Iterator)localObject1).next());
    }
    mPendingRemovals.clear();
    Object localObject2;
    if (bool2)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(mPendingMoves);
      mMovesList.add(localObject1);
      mPendingMoves.clear();
      localObject2 = new DefaultItemAnimator.1(this, (ArrayList)localObject1);
      if (bool1) {
        ViewCompat.postOnAnimationDelayed(get0holder.itemView, (Runnable)localObject2, getRemoveDuration());
      } else {
        ((Runnable)localObject2).run();
      }
    }
    if (bool3)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(mPendingChanges);
      mChangesList.add(localObject1);
      mPendingChanges.clear();
      localObject2 = new DefaultItemAnimator.3(this, (ArrayList)localObject1);
      if (bool1) {
        ViewCompat.postOnAnimationDelayed(get0oldHolder.itemView, (Runnable)localObject2, getRemoveDuration());
      } else {
        ((Runnable)localObject2).run();
      }
    }
    if (bool4)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(mPendingAdditions);
      mAdditionsList.add(localObject1);
      mPendingAdditions.clear();
      localObject2 = new DefaultItemAnimator.2(this, (ArrayList)localObject1);
      if ((!bool1) && (!bool2) && (!bool3))
      {
        ((Runnable)localObject2).run();
        return;
      }
      long l3 = 0L;
      long l1;
      if (bool1) {
        l1 = getRemoveDuration();
      } else {
        l1 = 0L;
      }
      if (bool2) {
        l2 = getMoveDuration();
      } else {
        l2 = 0L;
      }
      if (bool3) {
        l3 = getChangeDuration();
      }
      long l2 = Math.max(l2, l3);
      ViewCompat.postOnAnimationDelayed(get0itemView, (Runnable)localObject2, l1 + l2);
    }
  }
  
  class ChangeInfo
  {
    public int fromX;
    public int fromY;
    public RecyclerView.b0 newHolder;
    public int toX;
    public int toY;
    
    private ChangeInfo(RecyclerView.b0 paramB0)
    {
      newHolder = paramB0;
    }
    
    ChangeInfo(RecyclerView.b0 paramB0, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this(paramB0);
      toX = paramInt1;
      toY = paramInt2;
      fromY = paramInt3;
      fromX = paramInt4;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ChangeInfo{oldHolder=");
      localStringBuilder.append(DefaultItemAnimator.this);
      localStringBuilder.append(", newHolder=");
      localStringBuilder.append(newHolder);
      localStringBuilder.append(", fromX=");
      localStringBuilder.append(toX);
      localStringBuilder.append(", fromY=");
      localStringBuilder.append(toY);
      localStringBuilder.append(", toX=");
      localStringBuilder.append(fromY);
      localStringBuilder.append(", toY=");
      localStringBuilder.append(fromX);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
  
  class MoveInfo
  {
    public int fromX;
    public int fromY;
    public int toX;
    public int toY;
    
    MoveInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      fromX = paramInt1;
      fromY = paramInt2;
      toX = paramInt3;
      toY = paramInt4;
    }
  }
}
