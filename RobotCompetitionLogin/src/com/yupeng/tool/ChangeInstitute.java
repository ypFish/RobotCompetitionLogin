package com.yupeng.tool;

public class ChangeInstitute {


	public static String change(String i){
		
		String changeName="";
		i=i.trim();
		if(i.equals("机械工程与应用电子技术学院")){
			return "机电";
		}else if(i.equals("电子信息与控制工程学院")){
			return "电控";
		}else if(i.equals("计算机学院")){
			return "计算机";
		}else if(i.equals("生命科学与生物工程学院")){
			return "生命";
		}else if(i.equals("软件学院")){
			return "软件";
		}else if(i.equals("经济与管理学院")){
			return "经管";
		}else if(i.equals("应用数理学院")){
			return "数理";
		}else if(i.equals("建筑工程学院")){
			return "建工";
		}else if(i.equals("环境与能源工程学院")){
			return "环能";
		}else if(i.equals("材料科学与工程学院")){
			return "材料";
		}else if(i.equals("建筑与城市规划学院")){
			return "建规";
		}else if(i.equals("人文社会科学学院")){
			return "人文";
		}else if(i.equals("外国语学院")){
			return "外语";
		}else if(i.equals("艺术设计学院")){
			return "艺术";
		}else if(i.equals("激光工程研究院")){
			return "激光";
		}else if(i.equals("循环经济研究院")){
			return "循环经济";
		}else if(i.equals("固体微结构与性能研究所")){
			return "固体";
		}else if(i.equals("高等教育研究所")){
			return "高等教育";
		}else if(i.equals("实验学院")){
			return "实验";
		}else if(i.equals("继续教育学院")){
			return "继续教育";
		}else if(i.equals("体育教学部")){
			return "体育教学";
		}else if(i.equals("北京工业大学耿丹学院")){
			return "耿丹";
		}else if(i.equals("马克思主义学院")){
			return "马哲";
		}else if(i.equals("北京-都柏林国际学院")){
			return "国际";
		}
	
		return changeName;
	}
}
