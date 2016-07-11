package model;

import java.sql.Date;

public class orderInfo {
	
	int orderId,waiterId,orderState,tableId;
	String orderBeginDate,orderEndDate;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getWaiterId() {
		return waiterId;
	}
	public void setWaiterId(int waiterId) {
		this.waiterId = waiterId;
	}
	public int getOrderState() {
		return orderState;
	}
	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}
	public int getTableId() {
		return tableId;
	}
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
	public String getOrderBeginDate() {
		return orderBeginDate;
	}
	public void setOrderBeginDate(String orderBeginDate) {
		this.orderBeginDate = orderBeginDate;
	}
	public String getOrderEndDate() {
		return orderEndDate;
	}
	public void setOrderEndDate(String orderEndDate) {
		this.orderEndDate = orderEndDate;
	}
	
	public orderInfo(int orderId, int waiterId, int orderState, int tableId,
			String orderBeginDate, String orderEndDate) {
		super();
		this.orderId = orderId;
		this.waiterId = waiterId;
		this.orderState = orderState;
		this.tableId = tableId;
		this.orderBeginDate = orderBeginDate;
		this.orderEndDate = orderEndDate;
	}
	public orderInfo() {
	}
	@Override
	public String toString() {
		return "orderInfo [orderId=" + orderId + ", waiterId=" + waiterId
				+ ", orderState=" + orderState + ", tableId=" + tableId
				+ ", orderBeginDate=" + orderBeginDate + ", orderEndDate="
				+ orderEndDate + "]";
	}
	
}
