package study.spring_core_basic;

import study.spring_core_basic.discount.DiscountPolicy;
import study.spring_core_basic.discount.FixDiscountPolicy;
import study.spring_core_basic.member.MemberRepository;
import study.spring_core_basic.member.MemberService;
import study.spring_core_basic.member.MemberServiceImpl;
import study.spring_core_basic.member.MemoryMemberRepository;
import study.spring_core_basic.order.OrderService;
import study.spring_core_basic.order.OrderServiceImpl;

public class AppConfig {

  public MemberService memberService() {
    return new MemberServiceImpl(memberRepository());
  }

  private MemberRepository memberRepository() {
    return new MemoryMemberRepository();
  }

  public OrderService orderService() {
    return new OrderServiceImpl(memberRepository(), discountPolicy());
  }

  public DiscountPolicy discountPolicy() {
    return new FixDiscountPolicy();
  }
}
