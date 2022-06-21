package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    //회원가입
    public Long join(Member member){
        validateDuplicateMember(member);    //중복회원 검증(비즈니스 로직)
        memberRepository.save(member);
        return member.getId();  // 영속성 컨텍스트에서 저장한 pk
    }

    private void validateDuplicateMember(Member member) {
        //exception
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }
    }

    // 회원 전체 조회

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    // 회원 단건조회
    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }
}
