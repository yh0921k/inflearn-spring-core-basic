package study.spring_core_basic.order;

import org.junit.jupiter.api.Test;
import study.spring_core_basic.discount.FixDiscountPolicy;
import study.spring_core_basic.member.Grade;
import study.spring_core_basic.member.Member;
import study.spring_core_basic.member.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceImplTest {

  @Test
  void createOrder() {
    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
    memoryMemberRepository.save(new Member(1L, "name", Grade.VIP));

    OrderServiceImpl orderService = new OrderServiceImpl(memoryMemberRepository, new FixDiscountPolicy());
    Order order = orderService.createOrder(1L, "ItemA", 20000);
    assertThat(order.getDiscountPrice()).isEqualTo(1000);
  }
}