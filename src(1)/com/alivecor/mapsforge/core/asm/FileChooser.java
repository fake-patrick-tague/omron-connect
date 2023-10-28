package com.alivecor.mapsforge.core.asm;

import java.io.File;
import java.io.FileFilter;

class FileChooser
  implements FileFilter
{
  FileChooser(long paramLong) {}
  
  public boolean accept(File paramFile)
  {
    return (paramFile.lastModified() < filter) && (paramFile.getName().endsWith(".pdf"));
  }
}
