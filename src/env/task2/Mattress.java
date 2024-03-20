package task2;

import cartago.Artifact;
import cartago.ArtifactId;
import cartago.OPERATION;
import cartago.ObsProperty;

public class Mattress extends Artifact {

    public void init(){
        defineObsProperty("mattress", "idle");
    }

    @OPERATION
    public void setVibrationsMode() {
        ObsProperty prop = getObsProperty("mattress");

        if ("idle".equals(prop.stringValue())) {
            prop.updateValue("vibrating");

            try {
                ArtifactId wristbandId = lookupArtifact("wristband");
                execLinkedOp(wristbandId,"increaseMethodCounter");
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    @OPERATION
    public void setIdleMode() {
        ObsProperty prop = getObsProperty("mattress");
        
        if ("vibrating".equals(prop.stringValue())) {
            prop.updateValue("idle");

            try {
                ArtifactId wristbandId = lookupArtifact("wristband");
                execLinkedOp(wristbandId,"decreaseMethodCounter");
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
    
}
