package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemberServiceTest{

    @Test
    @DisplayName("회원가입 및 회원 일치 검증")
    void join(){
        Appconfig appconfig = new Appconfig();

        Member member =  new Member(1L,"Park", Grade.VIP);
        MemberService memberService = appconfig.memberService();
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        Assertions.assertThat(member).isEqualTo(findMember);


    }
}
