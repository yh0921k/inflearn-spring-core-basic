package study.spring_core_basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import study.spring_core_basic.member.MemberRepository;
import study.spring_core_basic.member.MemoryMemberRepository;

@Configuration
@ComponentScan(
    excludeFilters =
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {

  @Bean(name = "memoryMemberRepository")
  public MemberRepository memberRepository() {
    return new MemoryMemberRepository();
  }
}
