package study.spring_core_basic.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import study.spring_core_basic.common.MyLogger;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

  private final LogDemoService logDemoService;
  private final ObjectProvider<MyLogger> myLoggerObjectProvider;

  @RequestMapping("log-demo")
  @ResponseBody
  public String logDemo(HttpServletRequest request) throws InterruptedException {
    MyLogger myLogger = myLoggerObjectProvider.getObject();
    String requestURL = request.getRequestURL().toString();
    myLogger.setRequestURL(requestURL);

    myLogger.log("controller test");
    Thread.sleep(1000);
    logDemoService.logic("testId");
    return "OK";
  }
}
