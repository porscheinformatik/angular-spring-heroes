import { Injectable } from '@angular/core';
import 'rxjs/add/operator/toPromise';
import { HttpClient } from '@angular/common/http';
import { Hero } from '../../model/hero';

@Injectable()
export class HeroService {

  constructor(private http: HttpClient) { }

  getHeroes() {
    return this.http.get<Hero[]>('api/heroes');
  }

  getHero(id: number) {
    return this.http.get<Hero>(`api/heroes/${id}`);
  }

  update(hero: Hero) {
    return this.http.put<Hero>(`api/heroes/${hero.id}`, hero);
  }

  create(name: string) {
    return this.http.post<Hero>('api/heroes', { name: name });
  }

  delete(hero: Hero) {
    return this.http.delete<Hero>(`api/heroes/${hero.id}`);
  }

}
