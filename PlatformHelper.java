public class PlatformHelper {

    private boolean platformDown = true; //platform down = ramp uppe
    protected boolean getPlatformDown(){
        return platformDown;
    }

    protected void raisePlatform() {
        platformDown = false;
    }

    protected void lowerPlatform() {
        platformDown = true;
    }

}
