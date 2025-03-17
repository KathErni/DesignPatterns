enum Mobs {
  GOBLIN,
  SLIME,
  WIZARD,
  BANDIT,
}

class MobsIcon {
  private mob: Mobs;
  private icon: Uint8Array | null;

  constructor(mob: Mobs, icon: Uint8Array | null) {
    this.mob = mob;
    this.icon = icon;
  }

  getMob(): Mobs {
    return this.mob;
  }
}

class Coords {
  private x: number;
  private y: number;
  private mob: MobsIcon;

  constructor(x: number, y: number, mob: MobsIcon) {
    this.x = x;
    this.y = y;
    this.mob = mob;
  }

  track(): void {
    console.log(`${Mobs[this.mob.getMob()]} spotted at (${this.x},${this.y})`);
  }
}

class MobIconFactory {
  private icons: MobsIcon[] = [];

  getMobIcon(type: Mobs): MobsIcon {
    let icon = this.icons.find((icon) => icon.getMob() === type);
    if (!icon) {
      icon = new MobsIcon(type, null);
      this.icons.push(icon);
    }
    return icon;
  }
}

class CoordsService {
  private factory: MobIconFactory;

  constructor(factory: MobIconFactory) {
    this.factory = factory;
  }

  getCoordinates(): Coords[] {
    const coordinates: Coords[] = [];
    const field1 = new Coords(1, 2, this.factory.getMobIcon(Mobs.WIZARD));
    const field2 = new Coords(3, 5, this.factory.getMobIcon(Mobs.GOBLIN));
    coordinates.push(field1);
    coordinates.push(field2);

    return coordinates;
  }
}

class DIYFlyweight {
  public static main(): void {
    const service = new CoordsService(new MobIconFactory());
    for (const coord of service.getCoordinates()) {
      coord.track();
    }
  }
}

DIYFlyweight.main();
