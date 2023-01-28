import { inject, TestBed } from '@angular/core/testing';
import { TranslateModule } from '@ngx-translate/core';
import { Hero } from 'src/model/hero';
import { HeroService } from './hero.service';

const HEROES: Hero[] = [{ id: 1, name: 'Hero #1' }];

describe('HeroService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [TranslateModule.forRoot()],
      providers: [HeroService],
    });
  });

  it('should return heroes', inject([HeroService], (service: HeroService, done) => {
    service.getHeroes().subscribe((heroes) => {
      expect(heroes).toBe(HEROES);
      done();
    });
  }));
});
