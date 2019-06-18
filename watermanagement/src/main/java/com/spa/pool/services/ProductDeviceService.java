package com.spa.pool.services;

public interface ProductDeviceService {

  public String getProductInfo( String productKey );
  
  public String getDeviceListOfProduct( String productKey );

  String getDeviceDetail( String productKey, String deviceName );

  String getAllProductList();

}
