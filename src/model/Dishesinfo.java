package model;

public class Dishesinfo {
	int dishesId,recommend;
	String dishesName,dishesDiscript,dishesImg,dishesTxt;
	float dishesPrice;
	public int getDishesId() {
		return dishesId;
	}
	public void setDishesId(int dishesId) {
		this.dishesId = dishesId;
	}
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	public String getDishesName() {
		return dishesName;
	}
	public void setDishesName(String dishesName) {
		this.dishesName = dishesName;
	}
	public String getDishesDiscript() {
		return dishesDiscript;
	}
	public void setDishesDiscript(String dishesDiscript) {
		this.dishesDiscript = dishesDiscript;
	}
	public String getDishesImg() {
		return dishesImg;
	}
	public void setDishesImg(String dishesImg) {
		this.dishesImg = dishesImg;
	}
	public String getDishesTxt() {
		return dishesTxt;
	}
	public void setDishesTxt(String dishesTxt) {
		this.dishesTxt = dishesTxt;
	}
	public float getDishesPrice() {
		return dishesPrice;
	}
	public void setDishesPrice(float dishesPrice) {
		this.dishesPrice = dishesPrice;
	}
	public Dishesinfo(int dishesId, int recommend, String dishesName,
			String dishesDiscript, String dishesImg, String dishesTxt,
			float dishesPrice) {
		super();
		this.dishesId = dishesId;
		this.recommend = recommend;
		this.dishesName = dishesName;
		this.dishesDiscript = dishesDiscript;
		this.dishesImg = dishesImg;
		this.dishesTxt = dishesTxt;
		this.dishesPrice = dishesPrice;
	}
	public Dishesinfo() {
	}
	@Override
	public String toString() {
		return "dishesinfo [dishesId=" + dishesId + ", recommend=" + recommend
				+ ", dishesName=" + dishesName + ", dishesDiscript="
				+ dishesDiscript + ", dishesImg=" + dishesImg + ", dishesTxt="
				+ dishesTxt + ", dishesPrice=" + dishesPrice + "]";
	}
	
}
