package hello.core;

import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void rateDiscount(){
        long memberId = 1l;
        Member member = new Member(memberId,"Park", Grade.VIP);

        int discount = discountPolicy.discount(member,10000);
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 10% 할인이 적용되면 안된다.")
    void rateDiscountFail(){
        Member member = new Member(2L,"Park2",Grade.BASIC);

        int discount = discountPolicy.discount(member,10000);
        assertThat(discount).isEqualTo(0);

    }
}
