import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Hero } from '../../model/hero';
import { BehaviorSubject, tap } from 'rxjs';

@Injectable()
export class HeroService {
  private heroes$ = new BehaviorSubject<Hero[]>([]);
  private loaded = false;

  constructor(private http: HttpClient) {}

  getHeroes() {
    if (!this.loaded) {
      this.http.get<Hero[]>(`api/heroes`).subscribe((heroes) => {
        this.heroes$.next(heroes);
        this.loaded = true;
      });
    }
    return this.heroes$;
  }

  getHero(id: number) {
    return this.http.get<Hero>(`api/heroes/${id}`);
  }

  update(hero: Hero) {
    return this.http.put<Hero>(`api/heroes/${hero.id}`, hero).pipe(
      tap((changedHero) => {
        const currentList = this.heroes$.value;
        const changedIdx = currentList.findIndex((h) => h.id === changedHero.id);
        this.updateList([
          ...currentList.slice(0, changedIdx),
          changedHero,
          ...currentList.slice(changedIdx + 1),
        ]);
      })
    );
  }

  create(name: string) {
    return this.http.post<Hero>('api/heroes', { name }).pipe(
      tap((hero) => {
        this.updateList([hero, ...this.heroes$.value]);
      })
    );
  }

  delete(hero: Hero) {
    return this.http.delete<Hero>(`api/heroes/${hero.id}`).pipe(
      tap((_) => {
        this.heroes$.next(this.heroes$.value.filter((h) => h.id !== hero.id));
      })
    );
  }

  private updateList(heroes: Hero[]) {
    const newHeroes = [...heroes];
    newHeroes.sort((a, b) => a.name.localeCompare(b.name));
    this.heroes$.next(newHeroes);
  }
}
