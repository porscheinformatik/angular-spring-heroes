describe('Open start page', function () {
  it('Open Start Page', function () {
    cy.visit('/');

    cy.contains('Tour of Heroes');
  });

  it('Add hero to list', function () {
    cy.visit('/heroes');

    cy.get('#heroName').type('My Superhero{enter}');

    cy.get('table.heroes tbody').contains('My Superhero');
  });

  it('Edit hero name', function () {
    cy.visit('/heroes');

    cy.get('table.heroes tbody').children().last().find('.edit').click();

    cy.get('#heroName').type('{selectall}ZZZZ Superhero');

    cy.contains('Save').click();

    cy.get('table.heroes tbody').last().contains('ZZZZ Superhero');
  });

  it('Remove hero from list', function () {
    cy.visit('/heroes');

    cy.get('table.heroes tbody')
      .children()
      .its('length')
      .then((lengthBefore) => {
        cy.get('table.heroes tbody').children().last().find('.delete').click();

        cy.get('table.heroes tbody')
          .children()
          .should('have.length', lengthBefore - 1);
      });
  });
});
