public class VehicleAssembler {
  public static void main(String[] args) throws Exception {
    Engine engine = new Engine();
    FuelTank fuelTank = new FuelTank();
 
    engine.connectAtFuelTank(fuelTank);
    engine.changeShifter(0);
    engine.startWork();
  }
}