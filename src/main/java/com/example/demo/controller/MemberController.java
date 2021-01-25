package com.example.demo.controller;

import com.example.demo.dao.PositionDao;
import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;
import com.example.demo.service.TeamService;
import com.example.demo.type.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;
    private final TeamService teamService;
    private final PositionDao positionDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    public MemberController(MemberService memberService, TeamService teamService, PositionDao positionDao) {
        this.memberService = memberService;
        this.teamService = teamService;
        this.positionDao = positionDao;

    }

    @GetMapping("")
    public String displayIndex(Model model){
        List<Member> list = memberService.findAll();
        model.addAttribute("members", list);
        return "member/index";
    }

    @GetMapping("/{id}")
    public String displayView(@PathVariable Integer id, Model model) {
        Member member = memberService.findById(id);
        model.addAttribute("member", member);
        return "member/show";
    }

    @GetMapping("/add")
    public String displayAdd(Model model) {
        Map<Integer, String> roleList = new HashMap();
        Map<Integer, String> teamList = new HashMap();
        Map<Integer, String> positionList = new HashMap();
        Map<Integer, String> officeList = new HashMap();
        Map<Integer, String> sexTypeList = new HashMap();
        roleList = RoleType.getRoleTypeList();
        teamList = TeamType.getTeamTypeList();
        positionList = PositionType.getPositionTypeList();
        officeList = Office.getOfficeTypeList();
        sexTypeList = SexType.getSexTypeList();
        /*model.addAttribute("date", new Date());*/
        model.addAttribute("roleList", roleList);
        model.addAttribute("teamList", teamList);
        model.addAttribute("positionList", positionList);
        model.addAttribute("officeList", officeList);
        model.addAttribute("sexTypeList", sexTypeList);
        model.addAttribute("member", new Member());
        return "member/add";
    }

    @RequestMapping(value = "/save", params = "save", method = RequestMethod.POST)
    public String displaySave(@Validated Member member, BindingResult result,
                              Model model) {
        if (result.hasErrors()) {
            Map<Integer, String> roleList = new HashMap();
            Map<Integer, String> teamList = new HashMap();
            Map<Integer, String> positionList = new HashMap();
            Map<Integer, String> officeList = new HashMap();
            Map<Integer, String> sexTypeList = new HashMap();
            roleList = RoleType.getRoleTypeList();
            teamList = TeamType.getTeamTypeList();
            positionList = PositionType.getPositionTypeList();
            officeList = Office.getOfficeTypeList();
            sexTypeList = SexType.getSexTypeList();
            model.addAttribute("roleList", roleList);
            model.addAttribute("teamList", teamList);
            model.addAttribute("positionList", positionList);
            model.addAttribute("officeList", officeList);
            model.addAttribute("sexTypeList", sexTypeList);

            return "member/add";
        }
        String encodedPassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(encodedPassword);
        memberService.insertMember(member);
        return "redirect:/member";
    }

    @RequestMapping(value = "/save", params = "cancel", method = RequestMethod.POST)
    public String displayCancel(Model model) {
        return "redirect:/member";
    }

    @GetMapping("/{id}/edit")
    public String displayEdit(@PathVariable Integer id, Model model) {
        Member member = memberService.findById(id);
        Map<Integer, String> roleList = new HashMap();
        Map<Integer, String> teamList = new HashMap();
        Map<Integer, String> positionList = new HashMap();
        Map<Integer, String> officeList = new HashMap();
        Map<Integer, String> sexTypeList = new HashMap();
        roleList = RoleType.getRoleTypeList();
        teamList = TeamType.getTeamTypeList();
        positionList = PositionType.getPositionTypeList();
        officeList = Office.getOfficeTypeList();
        sexTypeList = SexType.getSexTypeList();
        model.addAttribute("roleList", roleList);
        model.addAttribute("teamList", teamList);
        model.addAttribute("positionList", positionList);
        model.addAttribute("officeList", officeList);
        model.addAttribute("sexTypeList", sexTypeList);
        model.addAttribute("member", member);
        return "member/edit";
        }

    @RequestMapping(value = "/update", params = "update", method = RequestMethod.POST)
    public String displayUpdate(@Validated Member member, BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            Map<Integer, String> roleList = new HashMap();
            Map<Integer, String> teamList = new HashMap();
            Map<Integer, String> positionList = new HashMap();
            Map<Integer, String> officeList = new HashMap();
            Map<Integer, String> sexTypeList = new HashMap();
            roleList = RoleType.getRoleTypeList();
            teamList = TeamType.getTeamTypeList();
            positionList = PositionType.getPositionTypeList();
            officeList = Office.getOfficeTypeList();
            sexTypeList = SexType.getSexTypeList();
            model.addAttribute("roleList", roleList);
            model.addAttribute("teamList", teamList);
            model.addAttribute("positionList", positionList);
            model.addAttribute("officeList", officeList);
            model.addAttribute("sexTypeList", sexTypeList);
            model.addAttribute("memberUpdateRequest", member);
            return "member/edit";
        }
        memberService.updateMember(member);
        return "redirect:/member";
    }

    @RequestMapping(value = "/update", params = "cancel", method = RequestMethod.POST)
    public String displayEditCancel(Member member, Model model) {
        Integer id = member.getId();
        return "redirect:/member/" + id;
    }

    @PostMapping("/delete")
    String delete(@RequestParam Integer memberId) {
        memberService.removeMember(memberId);
        return "redirect:/member";
    }
}
