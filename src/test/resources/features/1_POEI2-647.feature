Feature: Tests Sauce_Demo

	@POEI2-647 @POEI2-701 @CC
	Scenario Outline: Connexion échouée avec un mot de passe incorrect
		Given l'utilisateur est sur la page de connexion
		     When il saisit le username "<username>" et le mot de passe "<password>"
		     Then l'utilisateur n'est pas sur la Home page
		
		     Examples:
		       | username        | password     |
		       | standard_user   | sauce_secret |
		       | locked_out_user | secret_sauce |
		
