package com.uhutu.dcom.order.model;

import com.uhutu.dcom.order.enumer.ETeslaExec;

public class TeslaModelStatus {

	private ETeslaExec execStep = ETeslaExec.Undefined;

	public ETeslaExec getExecStep() {
		return execStep;
	}

	public void setExecStep(ETeslaExec execStep) {
		this.execStep = execStep;
	}

}
