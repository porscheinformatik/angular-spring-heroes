import { TestBed, inject } from '@angular/core/testing';

import { HeroService } from './hero.service';
import { HEROES } from './mock-heroes';

describe('HeroService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [HeroService]
    });
  });

  it('should return heroes', inject([HeroService], (service: HeroService, done) => {
    service.getHeroes().then(heroes => {
      expect(heroes).toBe(HEROES);
      done();
    });
  }));
});
