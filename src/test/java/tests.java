import com.lzp.app1.dao.Bibased;
import com.lzp.app1.dao.Notice;
import com.lzp.app1.dao.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.text.SimpleDateFormat;

/**
 * Created by LZP on 2018/3/16.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/hello-servlet.xml")
public class tests {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;
    @Before
    public void init(){
       // Configuration configuration =new Configuration().configure();
        //sessionFactory = configuration.buildSessionFactory();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/hello-servlet.xml");
        SessionFactory sessionFactory = (SessionFactory) applicationContext.getBean("sessionFactory");
        session = sessionFactory.getCurrentSession();
        transaction = session.beginTransaction();
    }
    @After
    public void destroy(){
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
    @Test
    public void test1(){
        Bibased bibased = new Bibased("13213","651615","166","46464","411166","984646464");
        session.save(bibased);
    }
    @Test
    public void test2(){
        User user = new User("PP",1,"161616@163.com","15678964523");
        session.save(user);
    }
    @Test
    public void test3(){
        java.util.Date date = new java.util.Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.format(date.getTime());
        Notice notice = new Notice("夫君子之行，静以修身，俭以养德。非淡泊无以明志，非宁静无以致远。夫学须静也，才须学也，非学无以广才，非志无以成学。淫慢则不能励精，险躁则不能冶性。年与时驰，意与日去，遂成枯落，多不接世，悲守穷庐，将复何及！",1,date);
        session.save(notice);
    }
    @Test
    public void test4(){

    }
}
