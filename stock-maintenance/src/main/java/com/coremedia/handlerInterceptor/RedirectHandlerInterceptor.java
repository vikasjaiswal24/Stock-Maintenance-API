package com.coremedia.handlerInterceptor;

import com.coremedia.service.StockMaintenanceService;
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

import com.coremedia.domain.ProductRequest;

@Controller("org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping")
public class RedirectHandlerInterceptor extends HandlerInterceptorAdapter {

  private static final Logger logger = LoggerFactory.getLogger(RedirectHandlerInterceptor.class);

  @Autowired
  StockMaintenanceService stockMaintenanceService;

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
      buildStock.setTimeStamp(new Date(2010+i, 8, 8, 10, 17, 32 ));
      //buildStock.setTimeStamp(new Date("2019-01-12T17:52:15.015Z"));
      buildStock.setProductId(110+i);
      buildStock.setQuantity(10+i);

      productList.add(buildStock);

      buildStock.setId("ST201"+String.valueOf(i));
      buildStock.setTimeStamp(new Date(2010+i, 9, 9, 11, 37, 17 ));
      buildStock.setProductId(210+i);
      buildStock.setQuantity(50+i);

      productList.add(buildStock);
    }

    return productList;
  }

}
