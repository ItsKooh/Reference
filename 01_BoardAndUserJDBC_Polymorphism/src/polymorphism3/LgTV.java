package polymorphism3;

public class LgTV implements TV {
    
    public LgTV() {
        System.out.println("====> LgTV 생성");
    }

    public void turnOn() {
        System.out.println("LgTv ---- 전원On");
    }
    
    public void turnOff() {
        System.out.println("LgTv ---- 전원off");
    }
    
    public void volumeUp() {
        System.out.println("LgTv ---- 소리Up");
    }
    
    public void volueDown() {
        System.out.println("LgTv ---- 소리Down");
    }
    

}
