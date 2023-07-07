package com.lec.ex04_actor;

public class Actor implements IPoliceMan, IChef, IFireFighter {
	private String name;
	public Actor(String name) {
		this.name = name;
	}

	@Override
	public void outFire() {
		System.out.println(name + "는(은) 소방관입니다. 불을 끕니다");
	}

	@Override
	public void saveMan() {
		System.out.println(name + "는(은) 소방관입니다. 사람을 구합니다");
	}

	@Override
	public void makePizza() {
		System.out.println(name + "는(은) 요리사입니다. 피자를 굽습니다");
	}

	@Override
	public void makeSpaghetti() {
		System.out.println(name + "는(은) 요리사입니다. 스파게티를 만듭니다");
	}

	@Override
	public void canCatchCriminal() {
		System.out.println(name + "는(은) 경찰관입니다. 범인을 잡습니다");
	}

	@Override
	public void canSearch() {
		System.out.println(name + "는(은) 경찰관입니다. 물건을 찾습니다");
	}

}
