package com.google.android.gms.auth.util.identity;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;

@SafeParcelable.Class(creator="SavePasswordRequestCreator")
public class SavePasswordRequest
  extends AbstractSafeParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<com.google.android.gms.auth.api.identity.SavePasswordRequest> CREATOR = new DiscreteSeekBar.CustomState.1();
  @SafeParcelable.Field(getter="getSignInPassword", id=1)
  private final SignInPassword destination;
  @SafeParcelable.Field(getter="getSessionId", id=2)
  private final String source;
  
  SavePasswordRequest(SignInPassword paramSignInPassword, String paramString)
  {
    destination = ((SignInPassword)Preconditions.checkNotNull(paramSignInPassword));
    source = paramString;
  }
  
  public static Builder builder()
  {
    return new Builder();
  }
  
  public static Builder put(SavePasswordRequest paramSavePasswordRequest)
  {
    Preconditions.checkNotNull(paramSavePasswordRequest);
    Builder localBuilder = builder();
    localBuilder.setSignInPassword(paramSavePasswordRequest.getSignInPassword());
    paramSavePasswordRequest = source;
    if (paramSavePasswordRequest != null) {
      localBuilder.put(paramSavePasswordRequest);
    }
    return localBuilder;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof SavePasswordRequest)) {
      return false;
    }
    paramObject = (SavePasswordRequest)paramObject;
    return (Objects.equal(destination, destination)) && (Objects.equal(source, source));
  }
  
  public SignInPassword getSignInPassword()
  {
    return destination;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { destination, source });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, getSignInPassword(), paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 2, source, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public final class Builder
  {
    private String data;
    private SignInPassword dataSource;
    
    public Builder() {}
    
    public SavePasswordRequest build()
    {
      return new SavePasswordRequest(dataSource, data);
    }
    
    public final Builder put(String paramString)
    {
      data = paramString;
      return this;
    }
    
    public Builder setSignInPassword(SignInPassword paramSignInPassword)
    {
      dataSource = paramSignInPassword;
      return this;
    }
  }
}
