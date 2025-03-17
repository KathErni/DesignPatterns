class Character {
  private id: number;
  private race: string;
  private place: string;
  private weapon: string;
  private kind: string;

  constructor(
    id: number,
    race: string,
    place: string,
    weapon: string,
    kind: string
  ) {
    this.id = id;
    this.race = race;
    this.place = place;
    this.weapon = weapon;
    this.kind = kind;
  }

  toString(): string {
    return `You are species no. ${this.id} and you're a ${this.race}. Your origin is from ${this.place}. The weapon you chose was ${this.weapon} and you bear the ${this.kind} crest.`;
  }
}

class CharacterBuilder {
  private id: number;
  private race: string;
  private place: string;
  private weapon: string;
  private kind: string;

  setId(id: number): CharacterBuilder {
    this.id = id;
    return this;
  }

  setRace(race: string): CharacterBuilder {
    this.race = race;
    return this;
  }

  setPlace(place: string): CharacterBuilder {
    this.place = place;
    return this;
  }

  setWeapon(weapon: string): CharacterBuilder {
    this.weapon = weapon;
    return this;
  }

  setKind(kind: string): CharacterBuilder {
    this.kind = kind;
    return this;
  }

  getCharacter(): Character {
    return new Character(
      this.id,
      this.race,
      this.place,
      this.weapon,
      this.kind
    );
  }
}

function main(): void {
  const newCharacter = new CharacterBuilder()
    .setId(5)
    .setRace("Human")
    .setPlace("Hieldegard")
    .setWeapon("Dart")
    .setKind("Warrior")
    .getCharacter();

  console.log(newCharacter.toString());
}

main();
