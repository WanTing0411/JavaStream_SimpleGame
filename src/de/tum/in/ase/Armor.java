package de.tum.in.ase;

public class Armor extends Item{
  // TODO: Implement part 2.
  private int amountOfArmor;
  public Armor(String armorType, String specification, int amountOfArmor, int strength, int intelligence, int agility, int spirit){
      super(armorType);
      this.specification=specification;
      this.amountOfArmor=amountOfArmor;
      this.strength=strength;
      this.intelligence=intelligence;
      this.agility=agility;
      this.spirit=spirit;
  }

    public int getAmountOfArmor() {
        return amountOfArmor;
    }
}
