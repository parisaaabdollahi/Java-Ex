package j2os.org;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring {
    private static final ApplicationContext CONTEXT = new ClassPathXmlApplicationContext("spring.xml");

    public static Object getBean(String beanId) {
        return CONTEXT.getBean(beanId);
    }


}
