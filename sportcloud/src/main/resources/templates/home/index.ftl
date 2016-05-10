<!DOCTYPE html style="height:100%;>

 <head>


<script id="echarts-js" type="text/javascript" src="http://dev-static.ntcdn.srnpr.com/js/zooindex/jquery.js"></script>

<script id="echarts-js" type="text/javascript" src="http://dev-static.ntcdn.srnpr.com/js/zooindex/echarts-all-3.js"></script>

 </head>


 <body>
 <div id="main" style="width: 100%;height:100%;"></div>
 
 
 
 <script>
 
 
 var webkitDep={
    "type": "force",
    "categories": [
        {
            "name": "体育",
            "keyword": {},
            "base": "HTMLElement"
        },
        {
            "name": "文化",
            "keyword": {},
            "base": "WebGLRenderingContext"
        },
        {
            "name": "社交",
            "keyword": {},
            "base": "SVGElement"
        },
        {
            "name": "电商",
            "keyword": {},
            "base": "CSSRule"
        },
        {
            "name": "金融",
            "keyword": {}
        }
    ],
    "nodes": [
        
    ],
    "links": [
       
    ]
}


function randomSource(){

	var iMaxCate=webkitDep["categories"].length;
	
	var iMaxNode=(Math.floor(Math.random()*5)+4)*100;
	
	
	
	
	var iMaxDeep=1;
	
	
	
	webkitDep["nodes"]=[];
	for(var i=0;i<iMaxNode;i++)
	{
	
		var iRandom=Math.floor(Math.random()*iMaxCate);
		
		var i2=Math.floor(Math.random()*iMaxCate/2);
		if(iRandom+i2<iMaxCate)
		{
			iRandom=iRandom+i2;
		}
		
	
		var oNode={
	            "name": "e"+i,
	            "value": 1,
	            "category":  iRandom
	        }
	        
	        webkitDep["nodes"].push(oNode);
	}
	
	
	
	webkitDep["links"]=[];
	for(var i=0;i<iMaxNode;i++)
	{
		var iDe=Math.ceil(Math.random()*iMaxDeep);
		
		for(var n=0;n<iDe;n++)
		{
			var oSource={
	            "source":i,
	            "target": Math.floor(Math.random()*iMaxNode)
	        }
	        webkitDep["links"].push(oSource);
		}
	
	}

}
 
 </script>
 
 
 
 
 
 
 <script>
 // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
 myChart.showLoading();
function showMychart() {
    myChart.hideLoading();
	randomSource();
	
	var aData=[];
	
	var iMaxCate=webkitDep["categories"].length;
	
	for(var i=0;i<iMaxCate;i++)
	{
		aData.push(webkitDep["categories"][i]["name"]);
	}
	
	
    option = {
    
    	title: {
            text: '${message}',
            subtext: 'this is home page copy right uhutu.com 2016',
            left: 'center',
            top:'30px;'
        },
    
        legend: {
            data: aData
        },
        series: [{
            type: 'graph',
            layout: 'force',
            animation: false,
            label: {
                normal: {
                    position: 'right',
                    formatter: '{b}'
                }
            },
            draggable: true,
            data: webkitDep.nodes.map(function (node, idx) {
                node.id = idx;
                return node;
            }),
            categories: webkitDep.categories,
            force: {
                // initLayout: 'circular'
                // gravity: 0
                // repulsion: 20,
                edgeLength: 5,
                repulsion: 20
            },
            edges: webkitDep.links
        }]
    };

    myChart.setOption(option);
}

$(function(){showMychart()});


setInterval(showMychart,20000);

 </script>


</body>

</html>