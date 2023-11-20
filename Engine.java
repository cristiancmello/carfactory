public class Engine {
  private int maxSpeed = 200;
  private FuelTank fuelTank;
  private int speedInKm = 0;
  private int shifter = 0;
  private int shifterMax = 6;
  private int fuelToInject = 0;
  private boolean gainedStrength = false;

  public void connectAtFuelTank(FuelTank fuelTank) {
    this.fuelTank = fuelTank;
  }

  public void startWork() throws Exception {
    while(true) {
       cycle();

       System.out.println("Engine speed: " + speedInKm + " km/h");
       System.out.println("Fuel tank level: " + fuelTank.getTankLevel());
       Thread.sleep(500);
    }
  }

  public void changeShifter(int position) throws Exception {
    if (gainedStrength == false && position > 2) throw new Exception("Engine tilt! Insufficient strength");
    shifter = position;
  }
  
  private void injectFuelInPiston() throws Exception {
    System.out.println("Injecting fuel in Piston");
    fuelTank.consumes(fuelToInject);
  }

  private void igniteFuelInPiston() {
    System.out.println("Ignite fuel in Piston");
    rotateAxes();
  }

  private void rotateAxes() {
    System.out.println("Rotating Axes");

    if (shifter == 0) {
      speedInKm = 0;
      fuelToInject = 100;
      gainedStrength = false;
    }

    if (shifter == 1) {
      speedInKm = 20;
      fuelToInject = 150;
      gainedStrength = true;
    }

    if (shifter == 2) {
      speedInKm = 40;
      fuelToInject = 200;
      gainedStrength = true;
    }

    if (shifter == 3) {
      speedInKm = 50;
      fuelToInject = 300;
      gainedStrength = false;
    }

    if (shifter == 4) {
      speedInKm = 60;
      fuelToInject = 350;
      gainedStrength = false;
    }

    if (shifter == 5) {
      speedInKm = 120;
      fuelToInject = 400;
      gainedStrength = false;
    }
  }

  private void cycle() throws Exception {
    injectFuelInPiston();
    igniteFuelInPiston();
  }
}