package study.spring_core_basic;

import study.spring_core_basic.member.Grade;
import study.spring_core_basic.member.Member;
import study.spring_core_basic.member.MemberService;

public class MemberApp {
  public static void main(String[] args) {
    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();

    Member member = new Member(1L, "Member A", Grade.VIP);
    memberService.join(member);

    Member findMember = memberService.findMember(1L);
    System.out.println("Create Member : " + member.getName());
    System.out.println("Find Member : " + findMember.getName());
  }
}
