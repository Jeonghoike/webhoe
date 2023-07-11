package strategy2.modul;

import strategy2.interfaces.FuelHybrid;
import strategy2.interfaces.Km20;

public class CarTestMain {
	public static void main(String[] args) {
		Car[] cars = {new Accent(), new Genesis(), new Sonata()};
		for(int idx=0 ; idx<cars.length ; idx++) {
			cars[idx].shape();
			cars[idx].drive();
			cars[idx].isEngine();
			cars[idx].isKmperLiter();
			cars[idx].isFuel();
		}
		System.out.println("소나타의 연료를 hybrid로, 연비를 20km/l로 업그레이드");
		cars[2].setFuel(new FuelHybrid());
		cars[2].setKm(new Km20());
		for(int idx=0 ; idx<cars.length ; idx++) {
			cars[idx].shape();
			cars[idx].drive();
			cars[idx].isEngine();
			cars[idx].isKmperLiter();
			cars[idx].isFuel();
		}
	}//main
}
