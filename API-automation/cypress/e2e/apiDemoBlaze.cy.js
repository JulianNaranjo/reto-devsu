/// <reference types="Cypress"/>

describe('User services test suites', () => {

  const urlBlaze = 'https://api.demoblaze.com/'
  const user_password = 'Julian123'
  const user = 'UserRetoApi' + Math.floor(Math.random() * 1000)

  it('New user signup', () => {
    cy.request({
      method: 'POST',
      url: urlBlaze + 'signup',
      body: {
        username: user,
        password: user_password
      },
    })
    .then((response)=>{
      expect(response.status).to.eq(200);
      })

  })

  it('User already exists', () => {
    cy.request({
      method: 'POST',
      url: urlBlaze + 'signup',
      body: {
        username: user,
        password: user_password
      },
      failOnStatusCode: false,
    }).then((response)=>{
      expect(response.status).to.eq(200);
      expect(response.body.errorMessage).to.eq('This user already exist.');
    })
  })

  it('User and password OK in login', () => {
    cy.request({
      method: 'POST',
      url: urlBlaze + 'login',
      body: {
        username: user,
        password: user_password
      },
    }).then((response)=>{
      expect(response.status).to.equal(200);
      expect(response.body).to.include('Auth_token');
    })
  })

  it('User wrong in login', () => {
    cy.request({
      method: 'POST',
      url: urlBlaze + 'login',
      body: {
        username: user + 'Noexist' ,
        password: user_password
      },
    }).then((response) => {
      expect(response.status).to.eq(200);
      expect(response.body.errorMessage).to.eq('User does not exist.');
    })
  }) 

  it('password wrong in login', () => {
    cy.request({
      method: 'POST',
      url: urlBlaze + 'login',
      body: {
        username: user,
        password: user_password + 'Wrong'
      },
    }).then((response) => {
      expect(response.status).to.eq(200);
      expect(response.body.errorMessage).to.eq('Wrong password.');
    })
  }) 
  
})