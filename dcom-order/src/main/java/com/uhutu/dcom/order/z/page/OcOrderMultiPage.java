package com.uhutu.dcom.order.z.page;

import com.uhutu.zoocom.baseannotation.ZooPage;
import com.uhutu.zoocom.define.DefineWebDeploy;
import com.uhutu.zoocom.root.RootPageMulti;
import com.uhutu.zoodata.dbbase.BaseEntity;

@ZooPage(value = "订单信息", deploy = DefineWebDeploy.Multi_Page
		+ "=pb-com_uhutu_dcom_order_z_page_OcOrderInfoPage,pg-com_uhutu_dcom_order_z_page_OcOrderDetailPage"
		+ ",pg-com_uhutu_dcom_order_z_page_OcOrderActivityPage,pg-com_uhutu_dcom_order_z_page_OcOrderPayPage")
public class OcOrderMultiPage extends RootPageMulti<BaseEntity> {

}
