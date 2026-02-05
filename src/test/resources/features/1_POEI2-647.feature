Feature: Connexion échouée avec un mot de passe incorrect

	@POEI2-647 @CC
	Scenario Outline: Connexion échouée avec un mot de passe incorrect
		Given l'utilisateur est sur la page de connexion
		     When il saisit le username "<username>" et le mot de passe "<password>"
		     Then l'utilisateur n'est pas sur la Home page
		
		     Examples:
               | username        | password     |
               | standard_user   | secret_sauce           |
               | locked_out_user | secret_sauce |
		
