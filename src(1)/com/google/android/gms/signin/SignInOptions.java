package com.google.android.gms.signin;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.package_12.Api.ApiOptions.Optional;

public final class SignInOptions
  implements Api.ApiOptions.Optional
{
  public static final SignInOptions SET = new SignInOptions(false, false, null, false, null, null, false, null, null, null);
  private final Long commentCount;
  private final boolean derived;
  private final String dislikeCount;
  private final Long favoriteCount;
  private final boolean is_favorite;
  private final String likeCount;
  private final String newValue;
  private final boolean processed;
  private final boolean showIcons;
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof SignInOptions)) {
      return false;
    }
    paramObject = (SignInOptions)paramObject;
    return (Objects.equal(null, null)) && (Objects.equal(null, null)) && (Objects.equal(null, null)) && (Objects.equal(null, null)) && (Objects.equal(null, null));
  }
  
  public final int hashCode()
  {
    Boolean localBoolean = Boolean.FALSE;
    return Objects.hashCode(new Object[] { localBoolean, localBoolean, null, localBoolean, localBoolean, null, null, null, null });
  }
}
