package study.spring_core_basic.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.spring_core_basic.common.MyLogger;

@Service
@RequiredArgsConstructor
public class LogDemoService {

  private final MyLogger myLogger;

  public void logic(String id) {
    myLogger.log("service id = " + id);
  }
}
