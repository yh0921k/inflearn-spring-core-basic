package study.spring_core_basic.discount;

import study.spring_core_basic.member.Grade;
import study.spring_core_basic.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

  private final int discountPercent = 10;

  @Override
  public int discount(Member member, int price) {
    if(member.getGrade() == Grade.VIP) {
      return price * discountPercent / 100;
    }
    return 0;
  }
}
