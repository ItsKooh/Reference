package polymorphism3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVUser {

    public static void main(String[] args) {
        // 1. 다형성을 구성한 예
//        TV tv = new LgTV();
        
        // 2. 다형성을 구성 & 팩토리 패턴을 구성한 예
//        BeanFactory factory = new BeanFactory();
//        TV tv = (TV) factory.getBean(args[0]); 
        
        // 3. Spring IoC 컨테이너(DL)을 구성한 예 
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        TV tv = (TV) applicationContext.getBean("tv");
        
        tv.turnOn();
        tv.volumeUp();
        tv.volueDown();
        tv.turnOff();
    }
}
