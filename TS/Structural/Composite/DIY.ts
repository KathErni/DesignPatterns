interface DiyComponent {
  change(): void;
  play(): void;
  stop(): void;
}

class Music implements DiyComponent {
  private name: string;

  constructor(name: string) {
    this.name = name;
  }

  change(): void {
    console.log(`Change music: ${this.name}`);
  }

  play(): void {
    console.log(`Play music: ${this.name}`);
  }

  stop(): void {
    console.log(`Stop music: ${this.name}`);
  }
}

class Group implements DiyComponent {
  private components: DiyComponent[] = [];

  add(component: DiyComponent): void {
    this.components.push(component);
  }

  change(): void {
    for (const component of this.components) {
      component.change();
    }
  }

  play(): void {
    for (const component of this.components) {
      component.play();
    }
  }

  stop(): void {
    for (const component of this.components) {
      component.stop();
    }
  }
}

class DIYComposite {
  public static main(): void {
    const playlist1 = new Group();
    playlist1.add(new Music("You Belong with Me"));
    playlist1.add(new Music("Teardrops on my Guitar"));

    const playlist2 = new Group();
    playlist2.add(new Music("Bad Guy"));
    playlist2.add(new Music("Ocean Eyes"));

    const group = new Group();
    group.add(playlist1);
    group.add(playlist2);

    playlist2.change();
    playlist2.stop();
    playlist1.play();
    group.stop();
  }
}

DIYComposite.main();
