package study.spring_core_basic.member;

public interface MemberService {

  void join(Member member);

  Member findMember(Long memberId);
}
