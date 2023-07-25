package com.lec.ex4_object;

public class Point3D {
	private double x;
	private double y;
	private double z;
	public Point3D(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public Point3D() {
		
		return;
	}
	@Override
	public String toString() {
		return "ÁÂÇ¥°ª [" + x + "," + y + "," + z + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Point3D) {
			Point3D other = (Point3D)obj;
//			boolean xChk = x == other.x;
//			boolean yChk = y == other.y;
//			boolean zChk = z == other.z;
//			return xChk && yChk && zChk;
			return x==other.x && y==other.y && z==other.z;
		}
		return false;
	}
}
