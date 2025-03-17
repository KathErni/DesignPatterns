
interface ISubject {
  request(): void;
}

class RealSubject implements ISubject {

  enormousData: number[];
  constructor() {
    this.enormousData = [1, 2, 3];
  }

  request() {
    return this.enormousData;
  }
}

class ProxySubject implements ISubject {

  enormousData: number[];
  realSubject: RealSubject;

  constructor() {
    this.enormousData = [];
    this.realSubject = new RealSubject();
  }
  request() {
    if (this.enormousData.length === 0) {
      console.log("pulling data from RealSubject");
      this.enormousData = this.realSubject.request();
      return this.enormousData;
    }
    console.log("pulling data from Proxy cache");
    return this.enormousData;
  }
}

// The Client
const PROXY_SUBJECT = new ProxySubject();
console.log(PROXY_SUBJECT.request());
console.log(PROXY_SUBJECT.request());
