import { ParamMap, ActivatedRoute } from '@angular/router';
import { Component, Input } from '@angular/core';
import { Location } from '@angular/common';
import { HeroService } from '../hero.service';

@Component({
  selector: 'hero-detail',
  templateUrl: './hero-detail.component.html',
  styleUrls: ['./hero-detail.component.css']
})
export class HeroDetailComponent {
  @Input() hero: Hero;

  constructor(private heroService: HeroService, private route: ActivatedRoute,
    private location: Location) { }

  ngOnInit(): void {
    this.heroService.getHero(+this.route.snapshot.params.id)
      .then(hero => this.hero = hero);
  }

  goBack() {
    this.location.back();
  }

}
