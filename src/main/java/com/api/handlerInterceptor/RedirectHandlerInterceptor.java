package com.api.handlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


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

    logger.info("Write a logic to perform an action here before the actual handler is executed !!");
    return true;
  }
}
