import { ActivatedRoute } from '@angular/router';
import { Component, OnInit, inject } from '@angular/core';
import { Location } from '@angular/common';
import { HeroService } from '../hero.service';
import { Hero } from '../../../model/hero';
import { TranslateDirective, TranslatePipe } from '@ngx-translate/core';
import { MatFormField, MatLabel } from '@angular/material/form-field';
import { MatInput } from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import { MatButton } from '@angular/material/button';

@Component({
  selector: 'hero-detail',
  templateUrl: './hero-detail.component.html',
  styleUrls: ['./hero-detail.component.css'],
  standalone: true,
  imports: [
    TranslateDirective,
    MatFormField,
    MatLabel,
    MatInput,
    FormsModule,
    MatButton,
    TranslatePipe,
  ],
})
export class HeroDetailComponent implements OnInit {
  private readonly heroService = inject(HeroService);
  private readonly route = inject(ActivatedRoute);
  private readonly location = inject(Location);

  hero?: Hero;

  ngOnInit(): void {
    this.heroService
      .getHero(+this.route.snapshot.params.id)
      .subscribe((hero) => (this.hero = hero));
  }

  goBack() {
    this.location.back();
  }

  onSave() {
    if (this.hero) {
      this.heroService.update(this.hero).subscribe(() => this.goBack());
    }
  }
}
