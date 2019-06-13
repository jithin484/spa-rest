package com.spa.pool.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class PoolPumpServiceImpl
  implements
  PoolPumpService {

  private static Logger log = LogManager.getLogger( PoolPumpServiceImpl.class );

  @Override
  public String getPoolLevelInfo( Integer id ) {
    log.info( "Calling  getPoolLevelInfo() :: get service with id : " + id );
    // Logic to return pool info
    return "Service Info for Pool Pump Id : " + id;
  }
}
