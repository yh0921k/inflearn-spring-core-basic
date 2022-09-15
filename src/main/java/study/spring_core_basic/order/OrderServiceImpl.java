package study.spring_core_basic.order;

import study.spring_core_basic.discount.DiscountPolicy;
import study.spring_core_basic.member.Member;
import study.spring_core_basic.member.MemberRepository;

public class OrderServiceImpl implements OrderService{

  private final MemberRepository memberRepository;
  private final DiscountPolicy discountPolicy;

  public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
    this.memberRepository = memberRepository;
    this.discountPolicy = discountPolicy;
  }

  // SRP가 잘 지켜진 로직으로, 할인 정책에 대한 변경이 필요할 때 주문 로직을 수정할 필요가 없음
  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);

    // Member 대신 Grade를 인수로 사용할 수 있지만, 내부 정책 및 확장성에 따라 달라짐
    int discountPrice = discountPolicy.discount(member, itemPrice);

    return new Order(memberId, itemName, itemPrice, discountPrice);
  }

  // 테스트 용도
  public MemberRepository getMemberRepository() {
    return memberRepository;
  }
}
