package bobo.learning.ssm.service;
/*
 * @author  bobo
 * @date  2020/10/29 14:16
 * @Email:1498244906@qq.com
 */

import bobo.learning.ssm.domain.Orders;



import java.util.List;

public interface IOrdersService {




    List<Orders> findAll(int page, int size) throws Exception;

    Orders findById(String ordersId) throws  Exception;
}
