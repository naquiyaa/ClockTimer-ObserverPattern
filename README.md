# ClockTimer-ObserverPattern
Java Clock Timer Using Observer Pattern

This Java application creates a clock application. The **ClockTimer** class maintains the current time. It extends the abstract Subject class, which provides methods to attach, detach, and notify observer objects. The **ClockTimer** class updates all the observers about the changing time using the **notifyObserver()** method. 
The **Observer** class is an abstract class that defines the **update()** method, which is implemented by the **AnalogClock** and **DigitalClock** classes.

The **Clock** class is the main class and demonstrates the use of the clock application.

Output:
![image](https://github.com/naquiyaa/ClockTimer-ObserverPattern/assets/98004035/8927cf1e-20a7-4fdb-9b0c-beb29023974b)
