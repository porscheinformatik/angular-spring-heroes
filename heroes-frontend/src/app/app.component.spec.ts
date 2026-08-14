import { TestBed } from '@angular/core/testing';
import { provideRouter } from '@angular/router';
import { provideTranslateService } from '@ngx-translate/core';
import { AppComponent } from './app.component';

describe('AppComponent', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AppComponent],
      providers: [provideRouter([]), provideTranslateService()],
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;

    expect(app).toBeTruthy();
  });

  it('should render the site title', () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();

    const compiled: HTMLElement = fixture.nativeElement;

    expect(compiled.querySelector('.app-name')?.textContent).toContain('site-title');
  });

  it('should render the main navigation links', () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();

    const compiled: HTMLElement = fixture.nativeElement;
    const linkTexts = Array.from(compiled.querySelectorAll('a')).map((link) =>
      link.textContent?.trim(),
    );

    expect(linkTexts).toEqual(expect.arrayContaining(['nav.dashboard', 'nav.heroes']));
  });
});
