package com.lec.ex03_speaktv;

public class TV implements IVolume {
	private int volumeLevel;
	public TV() {
		volumeLevel = 5;
	}
	@Override
	public void volumeUp() {
		if(volumeLevel < TV_MAX_VOLUME) {
			volumeLevel++;
			System.out.println("TV 볼륨을 1만큼 올려 현재 볼륨은" + volumeLevel);
		}else {
			System.out.println("TV볼륨이 최대치(" + TV_MAX_VOLUME+")여서 올리지 못함");
		}
	}

	@Override
	public void volumeUp(int level) {
		if(volumeLevel + level < TV_MAX_VOLUME) {
			volumeLevel += level;//volumeLevel = volumeLevel + level;
			System.out.println("TV 볼륨을" + level + "만큼 올려 현재 볼륨은" + volumeLevel);
		}else {
			int tempLevel = TV_MAX_VOLUME-volumeLevel;
			volumeLevel = TV_MAX_VOLUME;
			System.out.println("TV 볼륨을 " + tempLevel + "만큼 올려도 최대치("+TV_MAX_VOLUME+")입니다");
		}

	}

	@Override
	public void volumeDown() {
		if(volumeLevel > TV_MIN_VOLUME) {
			volumeLevel--;
			System.out.println("TV볼륨울 1만큼 내려 현재 볼륨" + volumeLevel);
		}else {
			System.out.println("TV볼륨이 최소치입니다("+ TV_MIN_VOLUME + ")입니다");
		}
	}
	@Override
	public void volumeDown(int level) {
		if(volumeLevel-level > TV_MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("TV볼륨을" + level + "만큼 내려 현재 볼륨은" + volumeLevel);
		}else {
			int tempLevel = volumeLevel - TV_MIN_VOLUME;
			volumeLevel = TV_MIN_VOLUME;
			System.out.println("TV볼륨을"+ tempLevel + "만큼 내려 볼륨이 최소치(" + TV_MIN_VOLUME+")");
		} // if
	}//volumeDown
} // class
