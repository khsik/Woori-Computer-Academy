package day0220;

public class Car2 {
	// 클래스 변수 (= 인스턴스 변수)
	private int speed;
	private boolean stop;
	
	// 생성자
	Car2(){}
	
	// 메서드
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		if(speed < 0) {
			this.speed = 0;
			return;
		} else {
			this.speed = speed;
		}
	}
	
	public boolean isStop() {
		return stop;
	}
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
}
