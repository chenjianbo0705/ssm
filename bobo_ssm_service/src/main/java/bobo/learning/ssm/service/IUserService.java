package bobo.learning.ssm.service;
/*
 * @author  bobo
 * @date  2020/10/29 19:39
 * @Email:1498244906@qq.com
 */


import bobo.learning.ssm.domain.Role;
import bobo.learning.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface IUserService extends UserDetailsService {

    List<UserInfo> findAll() throws  Exception;

    void save(UserInfo userInfo) throws  Exception;
    //ID 查询信息
    UserInfo findById(String id) throws  Exception;
    List<Role> findOtherRoles(String userId) throws Exception;

    void addRoleToUser(String userId, String[] roleIds);
}
