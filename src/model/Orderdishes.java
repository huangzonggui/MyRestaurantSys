package model;

public class Orderdishes {
	int odId,orderReference,dishes,num,status;

	public int getOdId() {
		return odId;
	}

	public void setOdId(int odId) {
		this.odId = odId;
	}

	public int getOrderReference() {
		return orderReference;
	}

	public void setOrderReference(int orderReference) {
		this.orderReference = orderReference;
	}

	public int getDishes() {
		return dishes;
	}

	public void setDishes(int dishes) {
		this.dishes = dishes;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int statu) {
		this.status = statu;
	}

	public Orderdishes(int odId, int orderReference, int dishes, int num,
			int statu) {
		super();
		this.odId = odId;
		this.orderReference = orderReference;
		this.dishes = dishes;
		this.num = num;
		this.status = statu;
	}

	public Orderdishes() {
	}

	@Override
	public String toString() {
		return "Orderdishes [odId=" + odId + ", orderReference="
				+ orderReference + ", dishes=" + dishes + ", num=" + num
				+ ", status=" + status + "]";
	}
	
}
