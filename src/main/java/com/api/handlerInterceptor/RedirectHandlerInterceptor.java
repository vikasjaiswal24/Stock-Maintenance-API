package com.api.handlerInterceptor;

import com.api.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.api.domain.ProductRequest;


/**
 * These three methods provide flexibility to do all kinds of pre- and post-processing.
 *
 * prehandle() – called before the actual handler is executed, but the view is not generated yet
 * postHandle() – called after the handler is executed
 * afterCompletion() – called after the complete request has finished and view was generated
 */
@Controller("org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping")
public class RedirectHandlerInterceptor extends HandlerInterceptorAdapter {

  private static final Logger logger = LoggerFactory.getLogger(RedirectHandlerInterceptor.class);

  @Autowired
  StockService stockMaintenanceService;

  /**
   * This method will get call before the request handler method in Controller.
   * @param request
   * @param response
   * @param handler
   * @return true :: if the execution chain should proceed with the next interceptor or the handler itself.
   * @return false :: DispatcherServlet assumes that this interceptor has already dealt with the response itself so no action required.
   */
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

    logger.info("Inside preHandle() method HandlerInterceptor !!");

    List<ProductRequest> productList = RedirectHandlerInterceptor.createDemoData();
    for (ProductRequest product : productList) {
      stockMaintenanceService.createOrUpdateStock(product);
    }
    return true;
  }

  public static List<ProductRequest> createDemoData() {

    List<ProductRequest> productList = new ArrayList<>();

    for (int i=9; i>=0; --i) {
      ProductRequest buildStock = new ProductRequest();

      buildStock.setId("ST201"+String.valueOf(i));
      buildStock.setTimeStamp(new Date(2010+i, 1, 8, 10, 17, 32 ));
      //buildStock.setTimeStamp(new Date("2019-01-12T17:52:15.015Z"));
      buildStock.setProductId(110+i);
      buildStock.setQuantity(10+i);
      productList.add(buildStock);

      buildStock.setId("ST201"+String.valueOf(i));
      buildStock.setTimeStamp(new Date(2010+i, 4, 9, 11, 37, 17 ));
      buildStock.setProductId(210+i);
      buildStock.setQuantity(50+i);
      productList.add(buildStock);

      buildStock.setId("ST201"+String.valueOf(i));
      buildStock.setTimeStamp(new Date(2010+i, 7, 4, 20, 14, 52 ));
      buildStock.setProductId(310+i);
      buildStock.setQuantity(80+i);
      productList.add(buildStock);

      buildStock.setId("ST201"+String.valueOf(i));
      buildStock.setTimeStamp(new Date(2010+i, 10, 9, 21, 7, 11 ));
      buildStock.setProductId(410+i);
      buildStock.setQuantity(90+i);
      productList.add(buildStock);
    }
    return productList;
  }

}
