package bobo.learning.ssm.service;
/*
 * @author  bobo
 * @date  2020/10/30 14:32
 * @Email:1498244906@qq.com
 */

import bobo.learning.ssm.domain.Permission;
import bobo.learning.ssm.domain.Role;

import java.util.List;


public interface IRoleService {
    public List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;

    Role findById(String roleId) throws  Exception;

    List<Permission> findOtherPermissions(String roleId) throws Exception;

    void addPermissionToRole(String roleId, String[] permissionIds) throws Exception;

    void deleteRoleById(String roleId) throws Exception;
}
