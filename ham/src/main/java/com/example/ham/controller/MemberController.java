package com.example.ham.controller;

import com.example.ham.domain.Member;
import com.example.ham.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public ResponseEntity<List<Member>> getMembersResponse() {
        List<Member> members = memberService.findMembers();
        return ResponseEntity.ok()
                .body(members);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<Optional<Member>> getMemberResponseById(@PathVariable Long memberId) {
        Optional<Member> findMember = memberService.findById(memberId);
        return ResponseEntity.ok()
                .body(findMember);
    }

    @PostMapping("/{memberId}")
    public ResponseEntity<Member> saveMember() {
        Member member = new Member();
        member.setId(1L);
        member.setName("test");
        memberService.save(member);
        return ResponseEntity.ok()
                .body(member);
    }
}