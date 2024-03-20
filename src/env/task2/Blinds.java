package task2;

import cartago.Artifact;
import cartago.ArtifactId;
import cartago.OPERATION;
import cartago.ObsProperty;

public class Blinds extends Artifact {

    public void init(){
        defineObsProperty("blinds", "lowered");
    }

    @OPERATION
    public void raiseBlinds() {
        ObsProperty prop = getObsProperty("blinds");

        if ("lowered".equals(prop.stringValue())) {
            prop.updateValue("raised");
            
            try {
                ArtifactId wristbandId = lookupArtifact("wristband");
                execLinkedOp(wristbandId,"increaseMethodCounter");
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    @OPERATION
    public void lowerBlinds() {
        ObsProperty prop = getObsProperty("blinds");

        if ("raised".equals(prop.stringValue())) {
            prop.updateValue("lowered");

            try {
                ArtifactId wristbandId = lookupArtifact("wristband");
                execLinkedOp(wristbandId,"decreaseMethodCounter");
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
