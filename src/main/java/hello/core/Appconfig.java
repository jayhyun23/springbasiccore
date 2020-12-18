package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRespository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Appconfig {

    @Bean
    public MemberService memberService(){
        //1번
        System.out.println("Call Appconfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(){
        //2번
        System.out.println("Call Appconfig.orderService");
        /*return new OrderServiceImpl(memberRepository(), discountPolicy());*/
        return null;

    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

    @Bean
    public MemberRepository memberRepository() {
        //3번
        System.out.println("Call Appconfig.memberRepository");
        return new MemoryMemberRespository();
    }

}
