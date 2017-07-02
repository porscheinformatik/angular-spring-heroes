import { HeroesFrontendPage } from './app.po';

describe('heroes-frontend App', () => {
  let page: HeroesFrontendPage;

  beforeEach(() => {
    page = new HeroesFrontendPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
