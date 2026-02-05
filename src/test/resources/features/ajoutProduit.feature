Feature: AJout Produit


  Background: Login
    Given l'utilisateur est sur la page de connexion
    When il saisit le username "standard_user" et le mot de passe "secret_sauce"
    Then l'utilisateur est sur la Home page

  @product

  Scenario: Ajout d'un produit au panier
    Given l'utilisateur est sur la Home page
    When il clique sur le bouton du produit "sauce labs backpack"
    And il clique sur le logo panier pour ouvrir le panier
    Then le produit "sauce labs backpack" est ajouté au panier