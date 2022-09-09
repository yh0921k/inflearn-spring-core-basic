package study.spring_core_basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.spring_core_basic.member.Grade;
import study.spring_core_basic.member.Member;
import study.spring_core_basic.member.MemberService;

public class MemberApp {
  public static void main(String[] args) {
    //    AppConfig appConfig = new AppConfig();
    //    MemberService memberService = appConfig.memberService();

    // Annotation 설정 클래스를 기반으로 스프링 구성 요소 인스턴스를 컨테이너에 등록하며, 어플리케이션을 구동한다.
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    // 기본적으로 Bean의 이름은 메서드 이름으로 지어진다.
    MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

    Member member = new Member(1L, "Member A", Grade.VIP);
    memberService.join(member);

    Member findMember = memberService.findMember(1L);
    System.out.println("Create Member : " + member.getName());
    System.out.println("Find Member : " + findMember.getName());
  }
}
