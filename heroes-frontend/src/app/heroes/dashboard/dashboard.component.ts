import { Component, OnInit, inject } from '@angular/core';
import { HeroService } from '../hero.service';
import { Hero } from '../../../model/hero';
import {
  MatCard,
  MatCardHeader,
  MatCardTitle,
  MatCardSubtitle,
  MatCardImage,
  MatCardContent,
  MatCardActions,
} from '@angular/material/card';
import { MatAnchor } from '@angular/material/button';
import { RouterLink } from '@angular/router';
import { TranslatePipe } from '@ngx-translate/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
  standalone: true,
  imports: [
    MatCard,
    MatCardHeader,
    MatCardTitle,
    MatCardSubtitle,
    MatCardImage,
    MatCardContent,
    MatCardActions,
    MatAnchor,
    RouterLink,
    TranslatePipe,
  ],
})
export class DashboardComponent implements OnInit {
  private readonly heroService = inject(HeroService);

  heroes!: Hero[];

  ngOnInit() {
    this.heroService.getHeroes().subscribe((heroes) => (this.heroes = heroes.slice(0, 4)));
  }
}
