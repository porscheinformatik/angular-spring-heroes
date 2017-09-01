import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';

const responseToHero = response => response.json() as Hero;

const handleError = (error: any): Promise<any> => {
  console.error('An error occurred', error); // for demo purposes only
  return Promise.reject(error.message || error);
};

@Injectable()
export class HeroService {

  constructor(private http: Http) { }

  getHeroes(): Promise<Hero[]> {
    return this.http.get('api/heroes')
      .toPromise()
      .then(response => response.json() as Hero[]);
  }

  getHero(id: number): Promise<Hero> {
    return this.http.get(`api/heroes/${id}`)
      .toPromise()
      .then(responseToHero)
      .catch(handleError);
  }

  update(hero: Hero) {
    return this.http.put(`api/heroes/${hero.id}`, hero)
      .toPromise()
      .then(responseToHero);
  }

  create(name: string) {
    return this.http.post('api/heroes', {name: name})
      .toPromise()
      .then(responseToHero);
  }

  delete(hero: Hero) {
    return this.http.delete(`api/heroes/${hero.id}`)
      .toPromise()
      .then(responseToHero);
  }

}
