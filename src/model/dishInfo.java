package model;

public class dishInfo {
	int dishesId,recommend;
	float dishesPrice;
	String dishesName,dishesDiscript,dishesImg,dishesTxt;
	public dishInfo(int dishesId,String dishesName, String dishesDiscript, 
			String dishesImg,String dishesTxt,
			int recommend, float dishesPrice) {
		super();
		this.dishesId = dishesId;
		this.recommend = recommend;
		this.dishesPrice = dishesPrice;
		this.dishesName = dishesName;
		this.dishesDiscript = dishesDiscript;
		this.dishesImg = dishesImg;
		this.dishesTxt = dishesTxt;
	}
	public dishInfo() {
		super();
	}
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
	public float getDishesPrice() {
		return dishesPrice;
	}
	public void setDishesPrice(float dishesPrice) {
		this.dishesPrice = dishesPrice;
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
	@Override
	public String toString() {
		return "dishInfo [dishesId=" + dishesId + ", recommend=" + recommend
				+ ", dishesPrice=" + dishesPrice + ", dishesName=" + dishesName
				+ ", dishesDiscript=" + dishesDiscript + ", dishesImg="
				+ dishesImg + ", dishesTxt=" + dishesTxt + "]";
	}
	
	
}
