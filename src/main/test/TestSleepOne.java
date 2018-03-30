import com.first.SleepOne;
import com.first.SleepTwo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 周云龙
 * @date 2018/3/28 16:35
 */

public class TestSleepOne {

    /**
     * 测试spring加载bean
     */
    @Test
    public void checkSpringBeanFactory(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
//        SleepOne sleepOne = (SleepOne) applicationContext.getBean("sleep1");
        SleepOne sleepOne = applicationContext.getBean("one", SleepOne.class);
//        sleepOne.setMessage("LaLaLa...");
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

    /**
     * 测试spring默认的单例模式
     */
    @Test
    public void checkSingleton(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        //单例bean引用了非单例的bean,放弃控制反转，你可以实现ApplicationContextAware接口来让bean A(SleepTwo)感知到容器，
        // 并且在需要的时候通过使用使用getBean("B")向容器请求一个（新的）bean B实例
        SleepTwo sleep2 = applicationContext.getBean("sleep2",SleepTwo.class);
        for (int i=5;i>0;i--){
            sleep2.print();
        }
    }
}
