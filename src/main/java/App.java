import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    private static final Logger logger = Logger.getLogger(App.class.getName());
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld bean =
                (HelloWorld) applicationContext.getBean("helloworld");
        logger.log(Level.INFO, bean.getMessage());
        HelloWorld bean1 =
                (HelloWorld) applicationContext.getBean("helloworld");
        logger.log(Level.INFO, bean1.getMessage());

        Cat bean2 = (Cat) applicationContext.getBean("cat");
        logger.log(Level.INFO, bean2.getName());
        Cat bean3 = (Cat) applicationContext.getBean("cat");
        logger.log(Level.INFO, bean3.getName());

        boolean first = bean.equals(bean1);
        boolean second = bean2.equals(bean3);

        logger.log(Level.INFO, String.valueOf(first));
        logger.log(Level.INFO, String.valueOf(second));
    }
}