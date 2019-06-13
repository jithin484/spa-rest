package com.spa.pool.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spa.pool.services.PoolPumpService;

@RestController
public class PoolController {

  private static Logger log = LogManager.getLogger( PoolController.class );

  @Autowired
  PoolPumpService poolPumpService;

  @RequestMapping(value = "/getgetPoolLevelInfo/{poolPumpId}", method = RequestMethod.GET)
  public String getgetPoolLevelInfo( @PathVariable("poolPumpId") Integer poolPumpId ) {
    log.info( "Inside Controller getgetPoolLevelInfo(): " + poolPumpId );
    return poolPumpService.getPoolLevelInfo( poolPumpId );
  }
}
