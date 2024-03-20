package task2;

import cartago.Artifact;

public class CalendarService extends Artifact {
    
    public void init(){
        defineObsProperty("upcoming_event", "now");
    }

}
