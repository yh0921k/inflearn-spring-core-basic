package study.spring_core_basic;

import study.spring_core_basic.discount.FixDiscountPolicy;
import study.spring_core_basic.member.MemberService;
import study.spring_core_basic.member.MemberServiceImpl;
import study.spring_core_basic.member.MemoryMemberRepository;
import study.spring_core_basic.order.OrderService;
import study.spring_core_basic.order.OrderServiceImpl;

public class AppConfig {

  public MemberService memberService() {
    return new MemberServiceImpl(new MemoryMemberRepository());
  }

  public OrderService orderService() {
    return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
  }
}
