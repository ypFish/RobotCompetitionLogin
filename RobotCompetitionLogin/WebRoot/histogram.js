$(function(){
var dataArr={
	"data":[
		{"id":1,"name":"百度","per":"10"},
		{"id":2,"name":"腾讯","per":"20"},
		{"id":3,"name":"新浪","per":"30"},
		{"id":4,"name":"网易","per":"40"},
		{"id":5,"name":"搜狐","per":"50"},
		{"id":5,"name":"小虾虎鱼","per":"60"},

		{"id":4,"name":"网易","per":"40"}

	]
};
new histogram().init(dataArr.data);
});

function histogram(){
	var controls={};
	var bgColor=new Array("#FF6600","#00FFCC","#2277BB","#dc7644","#BBAA22","#AA22AA","#338800","#9966FF","#ffcc33","#ED3810");
	this.init=function(data,y){
		setControls();
		buildHtml(data,y);
	}
	function setControls(){
		controls.histogramContainer=$("#histogram-container");
		controls.histogramBgLineUL=controls.histogramContainer.children("div.histogram-bg-line");
		controls.histogramContentUL=controls.histogramContainer.children("div.histogram-content");
		controls.histogramY=controls.histogramContainer.children("div.histogram-y");
	}
	function buildHtml(data,y){
		var len=data.length,perArr=new Array(),maxNum,maxTotal,yStr='';
		var contentStr='',bgLineStr='',bgLineAll='';
		var widthPer=Math.floor(100/len);
		minWidth=len*21+60;
		controls.histogramContainer.css("min-width",minWidth+"px");
		
		for(var a=0;a<len;a++){
			perArr[a]=parseInt(data[a]['per']);		
		}
		maxNum=String(perArr.max());
		if(maxNum.length>2){
			var x=parseInt(maxNum.substr(maxNum.length-2,1))+1;
			maxTotal=Math.floor(parseInt(maxNum/100))*100+x*10;
		}else{
			maxTotal=Math.floor(parseInt(maxNum/10))*10+10;
		}
		
		//y轴部分
		if(y=="%"){
			yStr+='<li>100%</li><li>80%</li><li>60%</li><li>40%</li><li>20%</li><li>0%</li>';			
		}else{
			var avg=maxTotal/5;
			for(i=5;i>=0;i--){
				yStr+='<li>'+avg*i+'</li>';
			}
		}
		
		//柱状条部分
		for(var i=0;i<len;i++){
			var per=Math.floor(parseInt(data[i]['per'])/maxTotal*100);
			var n=Math.floor(parseInt(per)/10);
			contentStr+='<li style="width:'+widthPer+'%">';
			contentStr+='<span class="histogram-box"><a style="height:'+per+'%'+';background:'+bgColor[n]+';" title="'+data[i]['per']+'"></a></span><span class="histogram-name">'+data[i]['name']+'</span>';
			contentStr+='</li>';
			bgLineStr+='<li style="width:'+widthPer+'%;"><div></div></li>';
		}
		
		//背景方格部分
		for(var j=0;j<5;j++){
			bgLineAll+='<ul>'+bgLineStr+'</ul>';
		}
		bgLineAll='<div class="histogram-bg-line">'+bgLineAll+'</div>';
		contentStr='<div class="histogram-content"><ul>'+contentStr+'</ul></div>';
		yStr='<div class="histogram-y"><ul>'+yStr+'</ul></div>';
		controls.histogramContainer.html(bgLineAll+contentStr+yStr);
		controls.histogramContainer.css("height",controls.histogramContainer.height()+"px");//主要是解决IE6中的问题		
	}
}
Array.prototype.max = function(){//最大值
 return Math.max.apply({},this) 
} 

