package com.spa.pool.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.iot.model.v20180120.QueryDeviceDetailRequest;
import com.aliyuncs.iot.model.v20180120.QueryDeviceDetailResponse;
import com.aliyuncs.iot.model.v20180120.QueryDeviceRequest;
import com.aliyuncs.iot.model.v20180120.QueryDeviceResponse;
import com.aliyuncs.iot.model.v20180120.QueryProductListRequest;
import com.aliyuncs.iot.model.v20180120.QueryProductListResponse;
import com.aliyuncs.iot.model.v20180120.QueryProductRequest;
import com.aliyuncs.iot.model.v20180120.QueryProductResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;


@Service
public class ProductDeviceServiceImpl
  implements
  ProductDeviceService {

  private static Logger log = LogManager.getLogger( ProductDeviceServiceImpl.class );
  private static final String accessKeyId = "LTAIkKQgC7BfZCLe";
  private static final String accessSecret = "6M8lloSKaleARyUJvRjJqwquDI6ize";
  private static final String regionId = "cn-shanghai";

  @Override
  public String getAllProductList() {
    log.info( "Calling  getAllProductList() " );
    QueryProductListResponse response = null;
    DefaultProfile profile = DefaultProfile.getProfile( regionId, accessKeyId, accessSecret );
    IAcsClient client = new DefaultAcsClient( profile );
    QueryProductListRequest request = new QueryProductListRequest();
    request.setCurrentPage( 1 );
    request.setPageSize( 10 );
    try {
      response = client.getAcsResponse( request );
    } catch( ServerException e ) {
      log.error( "ServerException in getAllProductList() ", e );
    } catch( ClientException e ) {
      log.error( "ClientException in getAllProductList() ", e );
    }
    return ( new Gson().toJson( response ) );
  }

  @Override
  public String getProductInfo( String productKey ) {
    log.info( "Calling  getAllProductInfo() :: with accessKey : and accessId " );
    QueryProductResponse response = null;
    DefaultProfile profile = DefaultProfile.getProfile( regionId, accessKeyId, accessSecret );
    IAcsClient client = new DefaultAcsClient( profile );

    QueryProductRequest request = new QueryProductRequest();
    request.setProductKey( productKey );
    try {
      response = client.getAcsResponse( request );
    } catch( ServerException e ) {
      log.error( "ServerException in getProductInfo() :: with productKey :" + productKey, e );
    } catch( ClientException e ) {
      log.error( "ClientException in getProductInfo() :: with productKey :" + productKey, e );
    }
    return ( new Gson().toJson( response ) );
  }

  @Override
  public String getDeviceListOfProduct( String productKey ) {
    DefaultProfile profile = DefaultProfile.getProfile( regionId, accessKeyId, accessSecret );
    IAcsClient client = new DefaultAcsClient( profile );
    QueryDeviceResponse response = null;
    QueryDeviceRequest request = new QueryDeviceRequest();
    request.setProductKey( productKey );

    try {
      response = client.getAcsResponse( request );
    } catch( ServerException e ) {
      log.error( "ServerException in getDeviceListOfProduct() :: with productKey :" + productKey, e );
    } catch( ClientException e ) {
      log.error( "ClientException in getDeviceListOfProduct() :: with productKey :" + productKey, e );
    }
    return ( new Gson().toJson( response ) );
  }


  @Override
  public String getDeviceDetail( String productKey, String deviceName ) {
    DefaultProfile profile = DefaultProfile.getProfile( regionId, accessKeyId, accessSecret );
    IAcsClient client = new DefaultAcsClient( profile );

    QueryDeviceDetailRequest request = new QueryDeviceDetailRequest();
    request.setDeviceName( deviceName );
    request.setProductKey( productKey );
    QueryDeviceDetailResponse response = null;
    try {
      response = client.getAcsResponse( request );
      System.out.println( new Gson().toJson( response ) );
    } catch( ServerException e ) {
      log.error(
        "ServerException in getDeviceDetail() :: with productKey :" + productKey + " and deviceName :" + deviceName,
        e );
    } catch( ClientException e ) {
      log.error(
        "ClientException in getDeviceDetail() :: with productKey :" + productKey + " and deviceName :" + deviceName,
        e );
    }
    return ( new Gson().toJson( response ) );

  }

}
