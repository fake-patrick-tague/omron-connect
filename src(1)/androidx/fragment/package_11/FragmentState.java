package androidx.fragment.package_11;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class FragmentState
  implements Parcelable
{
  public static final Parcelable.Creator<androidx.fragment.app.FragmentState> CREATOR = new a();
  final String c;
  final boolean is_favorite;
  final Bundle mArguments;
  final String mClassName;
  final int mContainerId;
  final boolean mDetached;
  final int mFragmentId;
  final boolean mFromLayout;
  final int mIndex;
  final boolean mRetainInstance;
  Bundle mSavedFragmentState;
  final String mTag;
  final boolean mType;
  
  FragmentState(Parcel paramParcel)
  {
    mClassName = paramParcel.readString();
    c = paramParcel.readString();
    int i = paramParcel.readInt();
    boolean bool2 = true;
    boolean bool1;
    if (i != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    mFromLayout = bool1;
    mFragmentId = paramParcel.readInt();
    mContainerId = paramParcel.readInt();
    mTag = paramParcel.readString();
    if (paramParcel.readInt() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    mRetainInstance = bool1;
    if (paramParcel.readInt() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    is_favorite = bool1;
    if (paramParcel.readInt() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    mDetached = bool1;
    mArguments = paramParcel.readBundle();
    if (paramParcel.readInt() != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    mType = bool1;
    mSavedFragmentState = paramParcel.readBundle();
    mIndex = paramParcel.readInt();
  }
  
  FragmentState(Fragment paramFragment)
  {
    mClassName = paramFragment.getClass().getName();
    c = mWho;
    mFromLayout = mFromLayout;
    mFragmentId = mFragmentId;
    mContainerId = mContainerId;
    mTag = mTag;
    mRetainInstance = mRetainInstance;
    is_favorite = mRemoving;
    mDetached = mDetached;
    mArguments = mArguments;
    mType = mHidden;
    mIndex = mMaxState.ordinal();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  Fragment instantiate(Loader paramLoader, ClassLoader paramClassLoader)
  {
    paramLoader = paramLoader.instantiate(paramClassLoader, mClassName);
    Bundle localBundle = mArguments;
    if (localBundle != null) {
      localBundle.setClassLoader(paramClassLoader);
    }
    paramLoader.setArguments(mArguments);
    mWho = c;
    mFromLayout = mFromLayout;
    mRestored = true;
    mFragmentId = mFragmentId;
    mContainerId = mContainerId;
    mTag = mTag;
    mRetainInstance = mRetainInstance;
    mRemoving = is_favorite;
    mDetached = mDetached;
    mHidden = mType;
    mMaxState = androidx.lifecycle.Lifecycle.State.values()[mIndex];
    paramClassLoader = mSavedFragmentState;
    if (paramClassLoader != null)
    {
      mSavedFragmentState = paramClassLoader;
      return paramLoader;
    }
    mSavedFragmentState = new Bundle();
    return paramLoader;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("FragmentState{");
    localStringBuilder.append(mClassName);
    localStringBuilder.append(" (");
    localStringBuilder.append(c);
    localStringBuilder.append(")}:");
    if (mFromLayout) {
      localStringBuilder.append(" fromLayout");
    }
    if (mContainerId != 0)
    {
      localStringBuilder.append(" id=0x");
      localStringBuilder.append(Integer.toHexString(mContainerId));
    }
    String str = mTag;
    if ((str != null) && (!str.isEmpty()))
    {
      localStringBuilder.append(" tag=");
      localStringBuilder.append(mTag);
    }
    if (mRetainInstance) {
      localStringBuilder.append(" retainInstance");
    }
    if (is_favorite) {
      localStringBuilder.append(" removing");
    }
    if (mDetached) {
      localStringBuilder.append(" detached");
    }
    if (mType) {
      localStringBuilder.append(" hidden");
    }
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  class a
    implements Parcelable.Creator<androidx.fragment.app.FragmentState>
  {
    a() {}
    
    public FragmentState[] a(int paramInt)
    {
      return new FragmentState[paramInt];
    }
    
    public FragmentState readDate(Parcel paramParcel)
    {
      return new FragmentState(paramParcel);
    }
  }
}
