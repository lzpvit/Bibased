import com.lzp.app1.dao.Bibased;
import com.lzp.app1.dao.Message_board;
import com.lzp.app1.dao.User;
import com.lzp.app1.services.BibasedService;
import com.lzp.app1.services.History_warningService;
import com.lzp.app1.services.Message_boardService;
import com.lzp.app1.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by LZP on 2018/4/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
@Rollback(value = false)
public class test2 {
    @Autowired
    BibasedService bibasedService;
    @Autowired
    Message_boardService message_boardService;
    @Autowired
    UserService userService;
    @Autowired
    History_warningService history_warningService;
    @Test
    public void test1(){
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
      //  Bibased bibased = (Bibased) applicationContext.getBean("bibased");
        Bibased bibased = new Bibased("11","4654","56","5454","45564","561651");
        bibasedService.insert_bibased(bibased);
    }
    @Test
    public void test2(){
        java.util.Date date = new java.util.Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.format(date.getTime());
        Message_board message_board= new Message_board("hibernateT",0,date);
        message_boardService.message_board_insert(message_board);
    }
    @Test
    public void test3(){
        String email="lzpvit@163.co";
       User user = userService.select_user(email);
        System.out.println(user.getName());
    }
    @Test
    public void test4(){
       List list = history_warningService.select_history_warning();
        System.out.println(list.size());
    }
}
