package com.lec.ex04_actor;

public class ActorTestMain {
	public static void main(String[] args) {
		Actor tom =  new Actor("≈Ω ≈©∑Á¡Ó");
		tom.outFire();
		tom.saveMan();
		tom.canCatchCriminal();
		tom.canSearch();
		tom.makePizza();
		tom.makeSpaghetti();
		System.out.println("-----------------------");
		IFireFighter fireTom = tom;
		fireTom.outFire();
		fireTom.saveMan();
		//fireTom.makeSpaghetti();
		IChef chefTom = tom;
		chefTom.makePizza();
		chefTom.makeSpaghetti();
		IPoliceMan policeTom = tom;
		policeTom.canCatchCriminal();
		policeTom.canSearch();
	}
}
