package Strategy;

public class DIY {
    public static void main(String[] args) {
        System.out.println("Character: Joan");
        var characterPick = new CharacterPick();
        characterPick.store("Player 1", new Mage(), new Female(), new Human());
    }
    
}
class CharacterPick{
    public void store(String name, Ability ability, Gender gender,Race race){
        ability.changeAbility(name);
        gender.changeGender(name);
        race.changeRace(name);

    }

}

interface Ability{
    void changeAbility(String name);
}

class Mage implements Ability{

    @Override
    public void changeAbility(String name) {
        System.out.println("Ability: Mage");
    }

}

class Soldier implements Ability{

    @Override
    public void changeAbility(String name) {
        System.out.println("Ability: Soldier");
    }

}

class Rogue implements Ability{

    @Override
    public void changeAbility(String name) {
        System.out.println("Ability: Rogue");
    }
    
}


interface Gender{
    void changeGender(String name);
}

class Female implements Gender{

    @Override
    public void changeGender(String name) {
        System.out.println("Gender: Female");
      }


}

class Male implements Gender{

    @Override
    public void changeGender(String name) {
        System.out.println("Gender: Male");
      }

}

interface Race{
    void changeRace(String name);
}

class Human implements Race{

    @Override
    public void changeRace(String name) {
        System.out.println("Race: Human");
     }

}

class Monster implements Race{

    @Override
    public void changeRace(String name) {
       System.out.println("Race: Monster");
       }

}






