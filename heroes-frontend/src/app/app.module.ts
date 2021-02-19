import {HttpClient, HttpClientModule} from '@angular/common/http';
import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {TranslateLoader, TranslateModule} from '@ngx-translate/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HeroDetailComponent} from './heroes/hero-detail/hero-detail.component';
import {HeroService} from './heroes/hero.service';
import {HeroesComponent} from './heroes/heroes/heroes.component';
import {DashboardComponent} from './heroes/dashboard/dashboard.component';
import {TranslateHttpLoader} from '@ngx-translate/http-loader';

// AoT requires an exported function for factories
export const HTTP_LOADER_FACTORY = (http: HttpClient) => new TranslateHttpLoader(http, '/api/translations/', '.json');

@NgModule({
  declarations: [
    AppComponent,
    HeroDetailComponent,
    HeroesComponent,
    DashboardComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: HTTP_LOADER_FACTORY,
        deps: [HttpClient]
      },
    }),
  ],
  providers: [HeroService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
