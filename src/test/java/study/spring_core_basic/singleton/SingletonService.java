package study.spring_core_basic.singleton;

public class SingletonService {
  private static final SingletonService instance = new SingletonService();

  private SingletonService() {}

  public static SingletonService getInstance() {
    return instance;
  }

  public void logic() {
    System.out.println("싱글톤 로직이 호출됨");
  }
}
