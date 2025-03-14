package Builder;

public class DIY {
    public static void main(String[] args) {
         var newCharacter = new CharacterBuilder()
                            .setId(5)
                            .setRace("Human")
                            .setPlace("Hieldegard")
                            .setWeapon("Dart")
                            .setKind("Warrior");

        System.out.println(newCharacter.getCharacter());
    }
    
}

class Character{
    private int id;
    private String race;
    private String place;
    private String weapon;
    private String kind; 
    
    

    public Character (int id, String race, String place, String weapon, String kind) {
        super();
       this.id = id;
       this.race=race;
       this.place=place;
       this.weapon = weapon;
       this.kind = kind;
    }
    @Override
        public String toString(){
            return "You are species no. " + id + " and you're a " + race + ". Your origin is from " + place +". The weapon you chose was " + weapon + " and bear the " + kind + " crest." ;
        }
    

}

class CharacterBuilder{
    private int id;
    private String race;
    private String place;
    private String weapon;
    private String kind; 
    
    public CharacterBuilder setId(int id) {
        this.id = id;
        return this;
    }
    public CharacterBuilder setRace(String race) {
        this.race = race;
        return this;
    }
    public CharacterBuilder setPlace(String place) {
        this.place = place;
        return this;
    }
    public CharacterBuilder setWeapon(String weapon) {
        this.weapon = weapon;
        return this;
    }
    public CharacterBuilder setKind(String kind) {
        this.kind = kind;
        return this;
    }

    public Character getCharacter(){
        return new Character(id, race, place, weapon, kind);
    }


}