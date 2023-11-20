public class FuelTank {
  private int maxLevel = 4;
  private int tankQuantityInMl = 1000;
  private int quantityFuelLevel = tankQuantityInMl / maxLevel;


  public void consumes(int quantityInMl) throws Exception {
    if (quantityInMl > tankQuantityInMl) throw new Exception("Empty tank");
    
    tankQuantityInMl -= quantityInMl;
  }

  public double getTankLevel() {
    return tankQuantityInMl / quantityFuelLevel;
  }
}