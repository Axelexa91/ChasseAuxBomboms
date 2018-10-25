/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entité;

/**
 *
 * @author axelz
 */
public abstract class Entité {
    protected String nom;
    protected boolean estVivant;
    public abstract void Parler(String paroles);
    public abstract void Crier();
    public abstract void Deplacer();
    public abstract void Fouiller();
    protected int defence;
    protected int bonbons;
    protected int pointsDeVie;
    public abstract void voirDeplacement();
}