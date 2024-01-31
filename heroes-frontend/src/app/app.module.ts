import { HttpClient, HttpClientModule } from '@angular/common/http';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { TranslateLoader, TranslateModule } from '@ngx-translate/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeroDetailComponent } from './heroes/hero-detail/hero-detail.component';
import { HeroService } from './heroes/hero.service';
import { HeroesComponent } from './heroes/heroes/heroes.component';
import { DashboardComponent } from './heroes/dashboard/dashboard.component';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatCardModule } from '@angular/material/card';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MAT_FORM_FIELD_DEFAULT_OPTIONS } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatTableModule } from '@angular/material/table';

// AoT requires an exported function for factories
export const HTTP_LOADER_FACTORY = (http: HttpClient) =>
  new TranslateHttpLoader(http, '/api/translations/', '.json');

@NgModule({
  declarations: [AppComponent, HeroDetailComponent, HeroesComponent, DashboardComponent],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: HTTP_LOADER_FACTORY,
        deps: [HttpClient],
      },
    }),
    BrowserAnimationsModule,
    MatCardModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatInputModule,
    MatTableModule,
  ],
  providers: [
    HeroService,
    {
      provide: MAT_FORM_FIELD_DEFAULT_OPTIONS,
      useValue: { appearance: 'outline' },
    },
    provideClientHydration(),
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
