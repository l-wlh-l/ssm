package ssm;

import com.wlh.ssm.domain.Items;
import com.wlh.ssm.domain.User;
import com.wlh.ssm.service.ItemsService;
import com.wlh.ssm.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @ClassName SsmTest
 * @Description TODO
 * @Author wlh
 * @Date 2019/3/1 11:12
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext_service.xml"})
public class SsmTest {

    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext_dao.xml");
        UserService userService = applicationContext.getBean(UserService.class);

        List<User> users = userService.findAll();
        for (User user : users) {
            System.out.println(users);
        }

    }

    @Test
    public void test2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext_dao.xml");
        ItemsService itemsService = applicationContext.getBean(ItemsService.class);
        List<Items> all = itemsService.findAll();
        for (Items items : all) {
            System.out.println(items);
        }
    }
}
