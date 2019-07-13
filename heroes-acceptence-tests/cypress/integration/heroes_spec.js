describe('Open start page', function() {
  it('Open Start Page', function() {
    cy.visit('/')

    cy.contains('Tour of Heroes')
  })

  it('Add hero to list', function() {
    cy.visit('/heroes')

    cy.get('#heroName').type('My Superhero{enter}')

    cy.get('ul.heroes').contains('My Superhero')
  })

  it('Edit hero name', function() {
    cy.visit('/heroes')

    cy.get('ul.heroes').children().last().click()

    cy.get('button').contains('View Details').click()

    cy.get('#heroName').type('{selectall}Another Superhero')

    cy.contains('Save').click()

    cy.contains('Back').click()

    cy.get('ul.heroes').last().contains('Another Superhero')
  })

  it('Remove hero from list', function() {
    cy.visit('/heroes')

    cy.get('ul.heroes').children().first().find('.delete').click()

    expect(cy.get('ul.heroes').contains('Another Superhero').should('not.exist'))

  })

})
