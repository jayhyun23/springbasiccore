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
}
