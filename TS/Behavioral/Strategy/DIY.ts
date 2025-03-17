interface Ability {
  changeAbility(name: string): void;
}

class Mage implements Ability {
  changeAbility(name: string): void {
    console.log("Ability: Mage");
  }
}

class Soldier implements Ability {
  changeAbility(name: string): void {
    console.log("Ability: Soldier");
  }
}

class Rogue implements Ability {
  changeAbility(name: string): void {
    console.log("Ability: Rogue");
  }
}

interface Gender {
  changeGender(name: string): void;
}

class Female implements Gender {
  changeGender(name: string): void {
    console.log("Gender: Female");
  }
}

class Male implements Gender {
  changeGender(name: string): void {
    console.log("Gender: Male");
  }
}

interface Race {
  changeRace(name: string): void;
}

class Human implements Race {
  changeRace(name: string): void {
    console.log("Race: Human");
  }
}

class Monster implements Race {
  changeRace(name: string): void {
    console.log("Race: Monster");
  }
}

class CharacterPick {
  store(name: string, ability: Ability, gender: Gender, race: Race): void {
    ability.changeAbility(name);
    gender.changeGender(name);
    race.changeRace(name);
  }
}

// The Client
console.log("Character: Joan");
const characterPick = new CharacterPick();
characterPick.store("Player 1", new Mage(), new Female(), new Human());
