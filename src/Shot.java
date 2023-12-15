
public class Shot {
	private int x = -1;
	private int y = -1;
	private boolean hit = false;
	
	public Shot(int x, int y) {
		this.x = x;
		this.y = y;
	}
	//resolve hit or miss
	public void  resolve(boolean shot) {
		hit = shot;
	}
	//check for equality
	public boolean equals(Shot s) {
		if(x != s.x) {
			return false;
		}
		if(y != s.y) {
			return false;
		}
		return true;
	}
	//display itself
	public String[][] display(String[][] field){
		if(hit) {
			field[y][x] = " H";
		}else {
			field[y][x] = " M";
		}		
		return field;
	}
	public int getY() {
		return y;
	}
	public int getX() {
		return x;
	}
}