package study.spring_core_basic.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.spring_core_basic.member.Grade;
import study.spring_core_basic.member.Member;

class RateDiscountPolicyTest {

  RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

  @Test
  @DisplayName("등급이 VIP인 경우 10% 할인이 적용")
  void discount() {
    // given
    Member member = new Member(1L, "memberVIP", Grade.VIP);

    // when
    int discount = discountPolicy.discount(member, 10000);

    // then
    Assertions.assertThat(discount).isEqualTo(1000);
  }

  @Test
  @DisplayName("등급이 VIP가 아닌 경우 할인이 적용되지 않음")
  void notVIP() {
    // given
    Member member = new Member(2L, "memberBASIC", Grade.BASIC);

    // when
    int discount = discountPolicy.discount(member, 10000);

    // then
    Assertions.assertThat(discount).isEqualTo(0);
  }
}