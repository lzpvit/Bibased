import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

/**
 * Created by LZP on 2018/3/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/*.xml")
@Transactional
public class test1 {

    @Autowired
    private SessionFactory sessionFactory;


    public  Session getSession(){
        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println(sessionFactory == null);
        return sessionFactory.getCurrentSession();
    }
    @Test
    public void test1(){
        getSession();
    }
}
