package study.spring_core_basic.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.spring_core_basic.AppConfig;
import study.spring_core_basic.member.MemberService;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

  @Test
  @DisplayName("스프링이 없는 순수한 DI 컨테이너")
  void pureContainer() {
    AppConfig appConfig = new AppConfig();

    // 1. 조회: 호출할 때 마다 객체 생성
    MemberService memberService1 = appConfig.memberService();

    // 2. 조회: 호출할 때 마다 객체 생성
    MemberService memberService2 = appConfig.memberService();

    // 참조값이 다른 것을 확인
    System.out.println("memberService1 = " + memberService1);
    System.out.println("memberService2 = " + memberService2);

    assertThat(memberService1).isNotSameAs(memberService2);
  }

  @Test
  @DisplayName("싱글톤 패턴을 적용한 객체 사용")
  void singletonServiceTest() {
    SingletonService singletonService1 = SingletonService.getInstance();
    SingletonService singletonService2 = SingletonService.getInstance();

    System.out.println("singletonService1 = " + singletonService1);
    System.out.println("singletonService2 = " + singletonService2);

    // isEqualTo는 equals() 메서드를 통한 비교와 동일하다.
    // isSameAs는 자바의 == 비교와 동일하다.
    assertThat(singletonService1).isSameAs(singletonService2);
  }
}
