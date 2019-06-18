package com.spa.pool.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spa.pool.services.ProductDeviceService;

@RestController
public class ProductDeviceController {

  private static Logger log = LogManager.getLogger( ProductDeviceController.class );

  @Autowired
  ProductDeviceService productDeviceService;

  @RequestMapping(value = "/getProductInfo/{productKey}", method = RequestMethod.GET)
  public String getProductInfo( @PathVariable("productKey") String productKey ) {
    log.info( "Inside Controller getgetPoolLevelInfo(): " );
    return productDeviceService.getProductInfo( productKey );
  }
  
  @RequestMapping(value = "/getDeviceListOfProduct/{productKey}", method = RequestMethod.GET)
  public String getDeviceListOfProduct( @PathVariable("productKey") String productKey ) {
    log.info( "Inside Controller getDeviceListOfProduct(): " );
    return productDeviceService.getDeviceListOfProduct( productKey );
  }
  
  @RequestMapping(value = "/getDeviceDetail/{productKey}/{deviceName}", method = RequestMethod.GET)
  public String getDeviceDetail( @PathVariable("productKey") String productKey,
    @PathVariable("deviceName") String deviceName ) {
    log.info( "Inside Controller getDeviceDetail(): " );
    return productDeviceService.getDeviceDetail( productKey, deviceName );
  }
  
  @RequestMapping(value = "/getAllProductList", method = RequestMethod.GET)
  public String getAllProductList() {
    log.info( "Inside Controller getAllProductList(): " );
    return productDeviceService.getAllProductList();
  }
  
}
