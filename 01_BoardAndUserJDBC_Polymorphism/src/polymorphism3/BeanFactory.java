package polymorphism3;

public class BeanFactory {

    public Object getBean(String arg) {
        
        if ( "lg".equals(arg) ) {
            return new LgTV();
        } else if ( "samsung".equals(arg) ) {
            return new SamsungTV();
        }
        
        return null;
    }
}
