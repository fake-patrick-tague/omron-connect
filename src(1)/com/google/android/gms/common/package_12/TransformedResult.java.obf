package com.google.android.gms.common.api;

public abstract class TransformedResult<R extends Result>
{
  public TransformedResult() {}
  
  public abstract void andFinally(ResultCallbacks<? super R> paramResultCallbacks);
  
  public abstract <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> paramResultTransform);
}
