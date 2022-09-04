package study.spring_core_basic.discount;

import study.spring_core_basic.member.Grade;
import study.spring_core_basic.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{
  private final int discountFixAmount = 1000;

  @Override
  public int discount(Member member, int price) {
    // Enum 타입의 비교는 '==' 연산자 사용
    if(member.getGrade() == Grade.VIP) {
      return discountFixAmount;
    }
    return 0;
  }
}
