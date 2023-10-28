package com.alivecor.universal_monitor.bluetooth.configurations;

public class GattError
{
  public static final int GATT_AUTH_FAIL = 137;
  public static final int GATT_BUSY = 132;
  public static final int GATT_CCCD_CFG_ERROR = 253;
  public static final int GATT_CMD_STARTED = 134;
  public static final int GATT_CONGESTED = 143;
  public static final int GATT_CONN_CANCEL = 256;
  public static final int GATT_CONN_FAIL_ESTABLISH = 62;
  public static final int GATT_CONN_L2C_FAILURE = 1;
  public static final int GATT_CONN_LMP_TIMEOUT = 34;
  public static final int GATT_CONN_TERMINATE_LOCAL_HOST = 22;
  public static final int GATT_CONN_TERMINATE_PEER_USER = 19;
  public static final int GATT_CONN_TIMEOUT = 8;
  public static final int GATT_CONTROLLER_BUSY = 58;
  public static final int GATT_DB_FULL = 131;
  public static final int GATT_ENCRYPTED_NO_MITM = 141;
  public static final int GATT_ERROR = 133;
  public static final int GATT_ERR_UNLIKELY = 14;
  public static final int GATT_ILLEGAL_PARAMETER = 135;
  public static final int GATT_INSUF_AUTHENTICATION = 5;
  public static final int GATT_INSUF_AUTHORIZATION = 8;
  public static final int GATT_INSUF_ENCRYPTION = 15;
  public static final int GATT_INSUF_KEY_SIZE = 12;
  public static final int GATT_INSUF_RESOURCE = 17;
  public static final int GATT_INTERNAL_ERROR = 129;
  public static final int GATT_INVALID_ATTR_LEN = 13;
  public static final int GATT_INVALID_CFG = 139;
  public static final int GATT_INVALID_HANDLE = 1;
  public static final int GATT_INVALID_OFFSET = 7;
  public static final int GATT_INVALID_PDU = 4;
  public static final int GATT_MORE = 138;
  public static final int GATT_NOT_ENCRYPTED = 142;
  public static final int GATT_NOT_FOUND = 10;
  public static final int GATT_NOT_LONG = 11;
  public static final int GATT_NO_RESOURCES = 128;
  public static final int GATT_PENDING = 136;
  public static final int GATT_PREPARE_Q_FULL = 9;
  public static final int GATT_PROCEDURE_IN_PROGRESS = 254;
  public static final int GATT_READ_NOT_PERMIT = 2;
  public static final int GATT_REQ_NOT_SUPPORTED = 6;
  public static final int GATT_SERVICE_STARTED = 140;
  public static final int GATT_SUCCESS = 0;
  public static final int GATT_UNACCEPT_CONN_INTERVAL = 59;
  public static final int GATT_UNSUPPORT_GRP_TYPE = 16;
  public static final int GATT_VALUE_OUT_OF_RANGE = 255;
  public static final int GATT_WRITE_NOT_PERMIT = 3;
  public static final int GATT_WRONG_STATE = 130;
  public static final int TOO_MANY_OPEN_CONNECTIONS = 257;
  
  public GattError() {}
  
  public static String connectionErrorToString(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 8)
        {
          if (paramInt != 19)
          {
            if (paramInt != 22)
            {
              if (paramInt != 34)
              {
                if (paramInt != 62)
                {
                  if (paramInt != 133)
                  {
                    if (paramInt != 256)
                    {
                      StringBuilder localStringBuilder = new StringBuilder();
                      localStringBuilder.append("UNKNOWN (");
                      localStringBuilder.append(paramInt);
                      localStringBuilder.append(")");
                      return localStringBuilder.toString();
                    }
                    return "GATT_CONN_CANCEL";
                  }
                  return "GATT_ERROR";
                }
                return "GATT_CONN_FAIL_ESTABLISH";
              }
              return "GATT_CONN_LMP_TIMEOUT";
            }
            return "GATT_CONN_TERMINATE_LOCAL_HOST";
          }
          return "GATT_CONN_TERMINATE_PEER_USER";
        }
        return "GATT_CONN_TIMEOUT";
      }
      return "GATT_CONN_L2C_FAILURE";
    }
    return "GATT_SUCCESS";
  }
  
  public static String gattStatusToString(int paramInt)
  {
    if (paramInt != 34)
    {
      if (paramInt != 257)
      {
        if (paramInt != 58)
        {
          if (paramInt != 59)
          {
            switch (paramInt)
            {
            default: 
              switch (paramInt)
              {
              default: 
                switch (paramInt)
                {
                default: 
                  StringBuilder localStringBuilder = new StringBuilder();
                  localStringBuilder.append("UNKNOWN (");
                  localStringBuilder.append(paramInt);
                  localStringBuilder.append(")");
                  return localStringBuilder.toString();
                }
                break;
              }
            case 17: 
              return "GATT_INSUF_RESOURCE";
            case 16: 
              return "GATT_UNSUPPORT_GRP_TYPE";
            case 15: 
              return "GATT_INSUF_ENCRYPTION";
            case 14: 
              return "GATT_ERR_UNLIKELY";
            case 13: 
              return "GATT_INVALID_ATTR_LEN";
            case 12: 
              return "GATT_INSUF_KEY_SIZE";
            case 11: 
              return "GATT_NOT_LONG";
            case 10: 
              return "GATT_NOT_FOUND";
            case 9: 
              return "GATT_PREPARE_Q_FULL";
            case 8: 
              return "GATT_INSUF_AUTHORIZATION";
            case 7: 
              return "GATT_INVALID_OFFSET";
            case 6: 
              return "GATT_REQ_NOT_SUPPORTED";
            case 5: 
              return "GATT_INSUF_AUTHENTICATION";
            case 4: 
              return "GATT_INVALID_PDU";
            case 3: 
              return "GATT_WRITE_NOT_PERMIT";
            case 2: 
              return "GATT_READ_NOT_PERMIT";
            case 1: 
              return "GATT_INVALID_HANDLE";
            }
            return "GATT_SUCCESS";
            return "GATT_CONGESTED";
            return "GATT_NOT_ENCRYPTED";
            return "GATT_ENCRYPTED_NO_MITM";
            return "GATT_SERVICE_STARTED";
            return "GATT_INVALID_CFG";
            return "GATT_MORE";
            return "GATT_AUTH_FAIL";
            return "GATT_PENDING";
            return "GATT_ILLEGAL_PARAMETER";
            return "GATT_CMD_STARTED";
            return "GATT_ERROR";
            return "GATT_BUSY";
            return "GATT_DB_FULL";
            return "GATT_WRONG_STATE";
            return "GATT_INTERNAL_ERROR";
            return "GATT_NO_RESOURCES";
            return "GATT_VALUE_OUT_OF_RANGE";
            return "GATT_PROCEDURE_IN_PROGRESS";
            return "GATT_CCCD_CFG_ERROR";
          }
          return "GATT_UNACCEPT_CONN_INTERVAL";
        }
        return "GATT_CONTROLLER_BUSY";
      }
      return "TOO_MANY_OPEN_CONNECTIONS";
    }
    return "GATT_CONN_LMP_TIMEOUT";
  }
}
