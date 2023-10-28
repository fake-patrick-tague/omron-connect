package com.alivecor.upgrade;

public enum SampleRate
{
  static
  {
    SampleRate localSampleRate1 = new SampleRate("SAMPLE_RATE_125_HZ", 0);
    SAMPLE_RATE_125_HZ = localSampleRate1;
    SampleRate localSampleRate2 = new SampleRate("SAMPLE_RATE_250_HZ", 1);
    SAMPLE_RATE_250_HZ = localSampleRate2;
    SampleRate localSampleRate3 = new SampleRate("SAMPLE_RATE_300_HZ", 2);
    SAMPLE_RATE_300_HZ = localSampleRate3;
    SampleRate localSampleRate4 = new SampleRate("SAMPLE_RATE_500_HZ", 3);
    SAMPLE_RATE_500_HZ = localSampleRate4;
    SampleRate localSampleRate5 = new SampleRate("SAMPLE_RATE_600_HZ", 4);
    SAMPLE_RATE_600_HZ = localSampleRate5;
    $VALUES = new SampleRate[] { localSampleRate1, localSampleRate2, localSampleRate3, localSampleRate4, localSampleRate5 };
  }
}
