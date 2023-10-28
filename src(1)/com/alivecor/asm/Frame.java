package com.alivecor.asm;

abstract class Frame
{
  public Frame() {}
  
  static Attribute a(o paramO, c paramC, f paramF)
  {
    return paramO.a(paramC, paramF);
  }
  
  static f a(MethodVisitor paramMethodVisitor)
  {
    return paramMethodVisitor.visitVarInsn();
  }
  
  static c c(h paramH)
  {
    return paramH.c();
  }
}
