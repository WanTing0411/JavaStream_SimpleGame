package de.tum.in.ase;

import java.util.List;

public class Tank extends Player {
    // TODO: Implement part 4.
    private List<Ability> abilities;
    private Armor shield;
    public Tank(String name, List<Ability> abilities, List<Armor> armor, Weapon weapon, String weaponType, Armor shield) {
        super(name, armor, weapon, weaponType);
        specification="Tank";
        this.abilities = abilities;
        this.shield =shield;
        equipShield();
        strength = getStrength()+15;
        intelligence = getIntelligence()+4;
        agility = getAgility()+6;
        spirit = getSpirit()+2;
        amountOfArmor = getAmountOfArmor()+30;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public Armor getShield() {
        return shield;
    }

    private void equipShield(){
        amountOfArmor+=getShield().getAmountOfArmor();
        strength+=getShield().getStrength();
        intelligence+=getShield().getIntelligence();
        agility+=getShield().getAgility();
        spirit+=getShield().getSpirit();
    }
    @Override
    public void attack(Player target) {
        if(getWeaponType() != weapon.getType()){
            System.out.println("You don't have a weapon to attack!");
        }else{
            double Damage = getStrength() * 0.7 + weapon.getDamage() + getAgility() * 0.6 - target.amountOfArmor;
            if(Damage<0){
                System.out.println("Target "+target.getName()+" didn't receive any damage!");
            } else if (target.getHealth() -Damage <= 0) {
                System.out.println(this.getName() + " killed " + target.getName());
                setHealth(0);
                level++;
            }else{
                target.setHealth(target.getHealth() -Damage);
            }
        }
    }

    @Override
    public void useAbility(Player target) {
        int random=(int)(Math.random()*this.getAbilities().size());
        if(this.getAbilities().get(random).getSpecification()!=target.getSpecification()){
            System.out.println(getName()+" has no skills to use!");
            System.out.println("Target "+target.getName()+" didn't receive any damage!");
        } else{
            int NewArmor= this.getAbilities().get(random).getArmor()+getAmountOfArmor();
            this.getAbilities().get(random).setArmor(NewArmor);
            double Bedamaged=getHealth()-target.getAmountOfArmor();
            if(Bedamaged<0){
                System.out.println("Target "+target.getName()+" didn't receive any damage!");
            }else{
                System.out.println("Hey you! I am here, attack me!");
            }
        }

    }

    // TODO: Implement part 5.

    // TODO: Implement part 6.
}
