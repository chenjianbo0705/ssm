package bobo.learning.ssm.service.impl;
/*
 * @author  bobo
 * @date  2020/10/29 14:17
 * @Email:1498244906@qq.com
 */

import bobo.learning.ssm.dao.IOdersDao;
import bobo.learning.ssm.domain.Orders;
import bobo.learning.ssm.service.IOrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {
    @Autowired
    private IOdersDao iOdersDao;

    @Override
    public List<Orders> findAll(int age,int size) throws Exception {
        //页码值 和 每页显示的参数
        PageHelper.startPage(age,size);
        return  iOdersDao.findAll();
    }

    @Override
    public Orders findById(String ordersId) throws Exception {
        return iOdersDao.findById(ordersId);
    }
}
