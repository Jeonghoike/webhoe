package com.lec.ex03_speaktv;

public class TestMain {
	public static void main(String[] args) {
		Speaker speaker = new Speaker();
		TV tv = new TV();
		IVolume[] devices = {speaker, tv};
		for(IVolume device : devices) {
			device.volumeUp();
			device.volumeUp(50);
			device.volumeDown();
			device.volumeDown(50);
			device.setMute(true);
			device.setMute(false);
		}
		IVolume.changeBattery(); // static
	}
}
