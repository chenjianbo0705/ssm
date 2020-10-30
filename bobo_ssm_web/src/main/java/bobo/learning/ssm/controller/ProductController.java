package bobo.learning.ssm.controller;

import bobo.learning.ssm.domain.Product;
import bobo.learning.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/*
 * @author  bobo
 * @date  2020/10/29 10:36
 * @Email:1498244906@qq.com
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    //添加产品
    @RequestMapping("/save.do")
    public  String  save(Product product) throws Exception {
        productService.save(product);
        return "redirect:findAll.do";


    }

    //查询全部产品
    @RequestMapping("/findAll.do")
    @RolesAllowed("ADMIN")
    public ModelAndView findAll() throws Exception {
        System.out.println(111);
        ModelAndView mv = new ModelAndView();
        List<Product> ps = productService.findAll();
        mv.addObject("productList", ps);
        mv.setViewName("product-list1");
        return mv;

    }

}
