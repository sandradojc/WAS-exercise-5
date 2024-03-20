package task2;

import cartago.Artifact;
import cartago.LINK;
import cartago.ObsProperty;

public class Wristband extends Artifact {

    int methodCounter = 0;
    
    public void init(){
        defineObsProperty("owner_state", "asleep");
    }

    @LINK
    public void increaseMethodCounter() {
        methodCounter++;
        ObsProperty prop = getObsProperty("owner_state");
        
        if (methodCounter == 3 && "asleep".equals(prop.stringValue())) {
            prop.updateValue("awake");
        }
    }

    @LINK
    public void decreaseMethodCounter() {
        methodCounter = methodCounter - 1;
    }
}

