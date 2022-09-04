package study.spring_core_basic.order;

import study.spring_core_basic.discount.DiscountPolicy;
import study.spring_core_basic.discount.FixDiscountPolicy;
import study.spring_core_basic.member.Member;
import study.spring_core_basic.member.MemberRepository;
import study.spring_core_basic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

  private final MemberRepository memberRepository = new MemoryMemberRepository();
  private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

  // SRP가 잘 지켜진 로직으로, 할인 정책에 대한 변경이 필요할 때 주문 로직을 수정할 필요가 없음
  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);

    // Member 대신 Grade를 인수로 사용할 수 있지만, 내부 정책 및 확장성에 따라 달라짐
    int discountPrice = discountPolicy.discount(member, itemPrice);

    return new Order(memberId, itemName, itemPrice, discountPrice);
  }
}
