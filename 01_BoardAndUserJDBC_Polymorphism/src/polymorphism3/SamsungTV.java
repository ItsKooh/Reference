package polymorphism3;

public class SamsungTV implements TV {

    public SamsungTV() {
        System.out.println("====> SamsungTV 생성");
    }

    public void turnOn() {
        System.out.println("SamsungTV ---- 전원On");
    }
    
    public void turnOff() {
        System.out.println("SamsungTV ---- 전원off");
    }
    
    public void volumeUp() {
        System.out.println("SamsungTV ---- 소리Up");
    }
    
    public void volueDown() {
        System.out.println("SamsungTV ---- 소리Down");
    }

}
