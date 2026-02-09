Feature: Authentification
@login
  Scenario: Connexion réussie avec des identifiants valides à l'application de RH
    Given l'utilisateur est sur la page de connexion
    When il saisit le username "standard_user" et le mot de passe "secret_sauce"
    Then l'utilisateur est sur la Home page


@loginFail
  Scenario Outline: Connexion échouée avec un mot de passe incorrect
     Given l'utilisateur est sur la page de connexion
     When il saisit le username "<username>" et le mot de passe "<password>"
     Then l'utilisateur n'est pas sur la Home page

     Examples:
       | username        | password     |
       | standard_user   | sauce_secret |
       | locked_out_user | secret_sauce |