package com.alivecor.mapsforge.record;

public enum ResultError
{
  static
  {
    ResultError localResultError = new ResultError("WRONG_INPUT", 0);
    WRONG_INPUT = localResultError;
    $VALUES = new ResultError[] { localResultError };
  }
}
