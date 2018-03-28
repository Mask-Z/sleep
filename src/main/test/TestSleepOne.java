import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 周云龙
 * @date 2018/3/28 16:35
 */

public class TestSleepOne {

    @Test
    public void checkSpringBeanFactory(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        SleepOne sleepOne = (SleepOne) applicationContext.getBean("sleep1");
        sleepOne.setMessage("LaLaLa...");
        sleepOne.printMesage();
    }

    @Test
    public void testException(){
        System.out.println(1111111111);
        try {
            System.out.println(2 / 1);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("抛出异常: "+e);
        }finally {
            System.out.println(333);
        }
        System.out.println(22222222);
    }
}
