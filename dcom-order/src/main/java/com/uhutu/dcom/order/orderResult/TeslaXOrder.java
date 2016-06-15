package com.uhutu.dcom.order.orderResult;

import com.uhutu.dcom.order.model.TeslaModelStatus;

public class TeslaXOrder {
	private TeslaModelStatus status = new TeslaModelStatus();

	public TeslaModelStatus getStatus() {
		return status;
	}

	public void setStatus(TeslaModelStatus status) {
		this.status = status;
	}
}
