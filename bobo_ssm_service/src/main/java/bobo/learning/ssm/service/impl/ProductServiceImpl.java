package bobo.learning.ssm.service.impl;
/*
 * @author  bobo
 * @date  2020/10/29 10:23
 * @Email:1498244906@qq.com
 */

import bobo.learning.ssm.dao.IProductDao;
import bobo.learning.ssm.domain.Product;
import bobo.learning.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl  implements IProductService {

    @Autowired
    private IProductDao productDao;


    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);

    }
}
