import { enableProdMode } from '@angular/core';

import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app.config';
import { AppComponent } from './app/app.component';
import { environment } from './environments/environment';
import { initToolbar } from '@stagewise/toolbar';
import AngularPlugin from '@stagewise-plugins/angular';

if (environment.production) {
  enableProdMode();
} else {
  initToolbar({
    plugins: [AngularPlugin],
  });
}

bootstrapApplication(AppComponent, appConfig).catch((err) => console.error(err));
