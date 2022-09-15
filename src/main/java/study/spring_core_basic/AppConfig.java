package study.spring_core_basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.spring_core_basic.discount.DiscountPolicy;
import study.spring_core_basic.discount.RateDiscountPolicy;
import study.spring_core_basic.member.MemberRepository;
import study.spring_core_basic.member.MemberService;
import study.spring_core_basic.member.MemberServiceImpl;
import study.spring_core_basic.member.MemoryMemberRepository;
import study.spring_core_basic.order.OrderService;
import study.spring_core_basic.order.OrderServiceImpl;

@Configuration
public class AppConfig {

  @Bean
  public MemberService memberService() {
    System.out.println("Call AppConfig.memberService");
    return new MemberServiceImpl(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository() {
    System.out.println("Call AppConfig.memberRepository");
    return new MemoryMemberRepository();
  }

  @Bean
  public OrderService orderService() {
    System.out.println("Call AppConfig.orderService");
    return new OrderServiceImpl(memberRepository(), discountPolicy());
  }

  @Bean
  public DiscountPolicy discountPolicy() {
    return new RateDiscountPolicy();
  }
}
