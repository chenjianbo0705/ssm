package bobo.learning.ssm.controller;

import bobo.learning.ssm.domain.Role;
import bobo.learning.ssm.domain.UserInfo;
import bobo.learning.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/*
 * @author  bobo
 * @date  2020/10/30 10:27
 * @Email:1498244906@qq.com
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;

    //给用户添加角色
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId", required = true) String userId, @RequestParam(name = "ids", required = true) String[] roleIds) {
        iUserService.addRoleToUser(userId, roleIds);
        return "redirect:findAll.do";
    }

    //查询用户以及用户可以添加的角色
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id", required = true) String userid) throws Exception {
        ModelAndView mv = new ModelAndView();
        //1.根据用户id查询用户
        UserInfo userInfo = iUserService.findById(userid);
        //2.根据用户id查询可以添加的角色
        List<Role> otherRoles = iUserService.findOtherRoles(userid);
        mv.addObject("user", userInfo);
        mv.addObject("roleList", otherRoles);
        mv.setViewName("user-role-add");
        return mv;
    }



    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userInfo= iUserService.findAll();
        mv.setViewName("user-list");
        mv.addObject("userList",userInfo);
        return mv;
    }

    @RequestMapping("/save.do")
    public String  save(UserInfo userInfo) throws Exception {
        iUserService.save(userInfo);
        return "redirect:findAll.do";
    }
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = iUserService.findById(id);
        mv.setViewName("user-show");
        mv.addObject("user",userInfo);

        return mv;
    }
}
