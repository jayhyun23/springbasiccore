package hello.core.member;

import hello.core.Appconfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

//        Appconfig appconfig = new Appconfig();
//        MemberService memberService = appconfig.memberService();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Appconfig.class);

        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);

        Member member = new Member(1L,"Park",Grade.VIP);
        memberService.join(member);

        Member findMember  = memberService.findMember(1L);

        System.out.println("new Member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());


    }
}
