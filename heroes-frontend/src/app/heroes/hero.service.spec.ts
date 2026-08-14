import { provideHttpClient } from '@angular/common/http';
import { provideHttpClientTesting, HttpTestingController } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';
import { Hero } from '../../model/hero';
import { HeroService } from './hero.service';

const HEROES: Hero[] = [{ id: 1, name: 'Hero #1' }];

describe('HeroService', () => {
  let service: HeroService;
  let httpTestingController: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [HeroService, provideHttpClient(), provideHttpClientTesting()],
    });

    service = TestBed.inject(HeroService);
    httpTestingController = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpTestingController.verify();
  });

  it('should return heroes', () => {
    let latestHeroes: Hero[] | undefined;

    service.getHeroes().subscribe((heroes) => {
      latestHeroes = heroes;
    });

    expect(latestHeroes).toEqual([]);

    const request = httpTestingController.expectOne('api/heroes');
    expect(request.request.method).toBe('GET');

    request.flush(HEROES);

    expect(latestHeroes).toEqual(HEROES);
  });
});
