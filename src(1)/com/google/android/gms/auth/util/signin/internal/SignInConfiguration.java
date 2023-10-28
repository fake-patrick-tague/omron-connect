package com.google.android.gms.auth.util.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.auth.util.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@SafeParcelable.Class(creator="SignInConfigurationCreator")
@SafeParcelable.Reserved({1})
public final class SignInConfiguration
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<com.google.android.gms.auth.api.signin.internal.SignInConfiguration> CREATOR = new VerticalProgressBar.SavedState.1();
  @SafeParcelable.Field(getter="getGoogleConfig", id=5)
  private GoogleSignInOptions added;
  @SafeParcelable.Field(getter="getConsumerPkgName", id=2)
  private final String scope;
  
  public SignInConfiguration(String paramString, GoogleSignInOptions paramGoogleSignInOptions)
  {
    scope = Preconditions.checkNotEmpty(paramString);
    added = paramGoogleSignInOptions;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof SignInConfiguration)) {
      return false;
    }
    Object localObject = (SignInConfiguration)paramObject;
    if (scope.equals(scope))
    {
      paramObject = added;
      localObject = added;
      if (paramObject == null) {
        if (localObject != null) {
          break label61;
        }
      } else if (!paramObject.equals(localObject)) {
        return false;
      }
      return true;
    }
    label61:
    return false;
  }
  
  public final int hashCode()
  {
    return new HashAccumulator().addObject(scope).addObject(added).hash();
  }
  
  public final GoogleSignInOptions isAdded()
  {
    return added;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, scope, false);
    SafeParcelWriter.writeParcelable(paramParcel, 5, added, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
