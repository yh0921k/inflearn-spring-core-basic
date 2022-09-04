package study.spring_core_basic.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.spring_core_basic.AppConfig;

class MemberServiceTest {

  MemberService memberService;

  @BeforeEach
  public void beforeEach() {
    AppConfig appConfig = new AppConfig();
    memberService = appConfig.memberService();
  }
  @Test
  void join() {
    // given : 주어진 환경
    Member member = new Member(1L, "Member A", Grade.VIP);

    // when : 수행할 로직
    memberService.join(member);
    Member findMember = memberService.findMember(1L);

    // then : 결과
    Assertions.assertThat(member).isEqualTo(findMember);
  }
}