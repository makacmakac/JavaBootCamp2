package sk.tuke.lightsout;

public class Light {
    private boolean OnOff;

    public Light(boolean OnOff) {
        this.OnOff = OnOff;
    }

    public boolean getOnOff(){
        return  OnOff;

    }

   public void toggleOnOff(){
        this.OnOff=!OnOff;
   }


}
