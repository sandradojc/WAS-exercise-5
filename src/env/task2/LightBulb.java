package task2;

import cartago.Artifact;
import cartago.ArtifactId;
import cartago.OPERATION;
import cartago.ObsProperty;

public class LightBulb extends Artifact {

    public void init(){
        defineObsProperty("lights", "off");
    }

    @OPERATION
    public void turnOnLights() {
        ObsProperty prop = getObsProperty("lights");

        if ("off".equals(prop.stringValue())) {
            prop.updateValue("on");

            try {
                ArtifactId wristbandId = lookupArtifact("wristband");
                execLinkedOp(wristbandId,"increaseMethodCounter");
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    @OPERATION
    public void turnOffLights() {
        ObsProperty prop = getObsProperty("lights");

        if ("on".equals(prop.stringValue())) {
            prop.updateValue("off");
            
            try {
                ArtifactId wristbandId = lookupArtifact("wristband");
                execLinkedOp(wristbandId,"decreaseMethodCounter");
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
    
}
