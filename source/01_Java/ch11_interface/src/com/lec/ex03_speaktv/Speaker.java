package com.lec.ex03_speaktv;

public class Speaker implements IVolume {
	private int volumeLevel;
	public Speaker() {
		volumeLevel = 10;
	}
	@Override
	public void volumeUp() {
		if(volumeLevel < SPEAKER_MAX_VOLUME) {
			volumeLevel++;
			System.out.println("SPEAKER 볼륨을 1만큼 올려 현재 볼륨은" + volumeLevel);
		}else {
			System.out.println("SPEAKER볼륨이 최대치(" + SPEAKER_MAX_VOLUME+")여서 올리지 못함");
		}
	}

	@Override
	public void volumeUp(int level) {
		if(volumeLevel + level < SPEAKER_MAX_VOLUME) {
			volumeLevel += level;//volumeLevel = volumeLevel + level;
			System.out.println("SPEAKER 볼륨을" + level + "만큼 올려 현재 볼륨은" + volumeLevel);
		}else {
			int tempLevel = SPEAKER_MAX_VOLUME-volumeLevel;
			volumeLevel = SPEAKER_MAX_VOLUME;
			System.out.println("SPEAKER 볼륨을 " + tempLevel + "만큼 올려도 최대치("+SPEAKER_MAX_VOLUME+")입니다");
		}

	}

	@Override
	public void volumeDown() {
		if(volumeLevel > SPEAKER_MIN_VOLUME) {
			volumeLevel--;
			System.out.println("SPEAKER볼륨울 1만큼 내려 현재 볼륨" + volumeLevel);
		}else {
			System.out.println("SPEAKER볼륨이 최소치입니다("+ SPEAKER_MIN_VOLUME + ")입니다");
		}
	}
	@Override
	public void volumeDown(int level) {
		if(volumeLevel-level > SPEAKER_MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("SPEAKER볼륨을" + level + "만큼 내려 현재 볼륨은" + volumeLevel);
		}else {
			int tempLevel = volumeLevel - SPEAKER_MIN_VOLUME;
			volumeLevel = SPEAKER_MIN_VOLUME;
			System.out.println("SPEAKER볼륨을"+ tempLevel + "만큼 내려 볼륨이 최소치(" + SPEAKER_MIN_VOLUME+")");
		} // if
	}//volumeDown
} // class
