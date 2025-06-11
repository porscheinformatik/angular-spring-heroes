import { Component, OnInit, inject } from '@angular/core';
import { HeroService } from '../hero.service';
import { Router } from '@angular/router';
import { Hero } from '../../../model/hero';
import { BehaviorSubject } from 'rxjs';
import { MatFormField, MatLabel } from '@angular/material/form-field';
import { MatInput } from '@angular/material/input';
import { MatButton, MatIconButton } from '@angular/material/button';
import {
  MatTable,
  MatColumnDef,
  MatHeaderCellDef,
  MatHeaderCell,
  MatCellDef,
  MatCell,
  MatHeaderRowDef,
  MatHeaderRow,
  MatRowDef,
  MatRow,
} from '@angular/material/table';
import { MatIcon } from '@angular/material/icon';
import { TranslatePipe } from '@ngx-translate/core';

@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css'],
  standalone: true,
  imports: [
    MatFormField,
    MatLabel,
    MatInput,
    MatButton,
    MatTable,
    MatColumnDef,
    MatHeaderCellDef,
    MatHeaderCell,
    MatCellDef,
    MatCell,
    MatIconButton,
    MatIcon,
    MatHeaderRowDef,
    MatHeaderRow,
    MatRowDef,
    MatRow,
    TranslatePipe,
  ],
})
export class HeroesComponent implements OnInit {
  private heroService = inject(HeroService);
  private router = inject(Router);

  heroes$ = new BehaviorSubject<Hero[]>([]);
  displayedColumns = ['id', 'name', 'actions'];

  ngOnInit(): void {
    this.getHeroes();
  }

  getHeroes() {
    this.heroes$ = this.heroService.getHeroes();
  }

  add(name: string): void {
    name = name.trim();
    if (!name) {
      return;
    }
    this.heroService.create(name).subscribe();
  }

  delete(hero: Hero) {
    this.heroService.delete(hero).subscribe();
  }

  gotoDetail(hero: Hero) {
    this.router.navigate(['/detail', hero.id]);
  }
}
