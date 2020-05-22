/**
 * 
 */
package com.cg.obs.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author sohel
 *
 */
@FeignClient(name = "transactions")
public interface TransactionControlllerFeign {

}
