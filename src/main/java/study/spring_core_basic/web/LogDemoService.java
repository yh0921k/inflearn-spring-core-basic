package study.spring_core_basic.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import study.spring_core_basic.common.MyLogger;

@Service
@RequiredArgsConstructor
public class LogDemoService {

  private final ObjectProvider<MyLogger> myLoggerObjectProvider;

  public void logic(String id) {
    MyLogger myLogger = myLoggerObjectProvider.getObject();
    myLogger.log("service id = " + id);
  }
}
