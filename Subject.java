import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Subject{

    // int hour;
    // int minute;
    // int second;
    ArrayList<Observer> observerList= new ArrayList<Observer>();


    public void attach(Observer o){
        observerList.add(o);

    }
    public void detach(Observer o){
        observerList.remove(observerList.indexOf(o));
    }
    public abstract void notifyObserver();       
    
}

abstract class Observer{
    public abstract void update(Subject s);
}

class ClockTimer extends Subject{
   int  hour;
     int minute;
     int second;

 
    public void notifyObserver(){
        for (int i =0; i<observerList.size(); i++){
            observerList.get(i).update(this);
        }
    };


    public void tick(){
        LocalDateTime now = LocalDateTime.now();
        hour = now.getHour();
        // System.out.println(hour);
        minute = now.getMinute();
        second = now.getSecond();
        notifyObserver();
        
    }

}

class AnalogClock extends Observer{
   

    public void update(Subject s){
        System.out.println("Hour= " + ((ClockTimer)s).hour + " " + "Minute= " + ((ClockTimer)s).minute + " " +  "Second= " + ((ClockTimer)s).second + " " );
                
        
        draw();

    }
    public void draw(){
        System.out.println("The clock is analogue");
    }

}

class DigitalClock extends Observer{
    public void update(Subject s){
        System.out.println("Hour= " + ((ClockTimer)s).hour + " " + "Minute= " + ((ClockTimer)s).minute + " " +  "Second= " + ((ClockTimer)s).second + " " );
        
        draw();
    }
    public void draw(){
        System.out.println("The clock is digital");
    }
}

class Clock{
    public static void main(String args[]){
        ClockTimer ct = new ClockTimer();
       
        Timer timer = new Timer();
		timer.schedule(new TimerTask() {
		  @Override
		  public void run() {
		    ct.tick();
            
		  }
		}, 0, 1000);

        AnalogClock analog = new AnalogClock();
       
        DigitalClock digital = new DigitalClock();

        ct.attach(analog);
    
        ct.attach(digital);
        ct.notifyObserver();
        //analog.update(ct);

        //ct.detach(analog);

        Timer timer2 = new Timer();
		timer2.schedule(new TimerTask() {
		  @Override
		  public void run() {
		    ct.detach(analog);
            
		  }
		}, 2000);

        


      

        
        


    }
}


