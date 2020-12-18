package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    @Test
    void createOrder(){
        Appconfig appconfig = new Appconfig();
        MemberService memberService = appconfig.memberService();
        OrderService orderService =  appconfig.orderService();

        long memberId = 1L;
        Member member = new Member(memberId,"Park", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"모자",10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }

    /*필드에 직접 주입하게 된 경우 사용자가 원하는 값으로 변경하기 불가능
    * 아래 Runtime 시 에러가 발생하는 이유는 스프링 빈을 생성하지 않은 채 직접 실행시키기 때문에
    * 해당 Repository = null 로 발생
    * 가급적이면 사용하지 말자!
    *
    * */
   /* @Test
    void filedInjection(){
        OrderServiceImpl orderService = new OrderServiceImpl();
        orderService.createOrder(1L, "iTemA", 10000);

    }*/
}
