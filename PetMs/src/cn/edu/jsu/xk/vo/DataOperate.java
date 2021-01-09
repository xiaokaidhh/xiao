package cn.edu.jsu.xk.vo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.edu.jsu.xk.dbc.DatabaseConnectionSql;
import cn.edu.jsu.xk.dbc.DatabaseConnectionSqlPet;
public class DataOperate {
	//定义姓氏
	private static String firstName="跳毛裘缪干解应宗宣丁贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁荀羊於惠甄魏加封芮羿储靳汲邴糜松井段富巫乌焦巴弓牧隗山谷车侯宓蓬全郗班仰秋仲伊宫宁仇栾暴甘钭厉戎祖武符刘姜詹束龙叶幸司韶郜黎蓟薄印宿白怀蒲台从鄂索咸籍赖卓蔺屠蒙池乔阴郁胥能苍双闻莘党翟谭贡劳逄姬申扶堵冉宰郦雍却璩桑桂濮牛寿通边扈燕冀郏浦尚农温别庄晏柴瞿阎充慕连茹习宦艾鱼容向古易慎戈廖庚终暨居衡步都耿满弘匡国文寇广禄阙东殴殳沃利蔚越夔隆师巩厍聂晁勾敖融冷訾辛阚那简饶空曾毋沙乜养鞠须丰巢关蒯相查后江红游竺权逯盖益桓公万俟司马上官欧阳夏侯诸葛闻人东方赫连皇甫尉迟公羊澹台公冶宗政濮阳淳于仲孙太叔申屠公孙乐正轩辕令狐钟离闾丘长孙慕容鲜于宇文司徒司空亓官司寇仉督子车颛孙端木巫马公西漆雕乐正壤驷公良拓拔夹谷宰父谷粱晋楚阎法汝鄢涂钦段干百里东郭南门呼延归海羊舌微生岳帅缑亢况后有琴梁丘左丘东门西门商牟佘佴伯赏南宫墨哈谯笪年爱阳佟第五言福百家姓续";
	//定义女生的名
	private static String girl="秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽 ";
	//定义男生的名
    private static String boy="伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";
    private static String color="黑灰白橘黄棕";
    
    public static int getNum(int start,int end) {//随机返回返回指定范围间的整数
    	
    	//Math.random()随机返回0.0至1.0之间的数
        return (int)(Math.random()*(end-start+1)+start);
    }
    //随机返回学号
    public static StringBuilder getStuno() {//不使用String，因为需要大量拼接字符串
    	StringBuilder xh=new StringBuilder("sb");//学号前7位相同
    	StringBuilder xh1=new StringBuilder(String.valueOf(getNum(1,99999)));//随机取后3位
    	if(xh1.length()==1) {
    		xh1=xh1.insert(0, "0000");//如果是1位数，前面增加3个0
    		xh=xh.append(xh1);//前6位与后3位拼接成学号
    	}else if(xh1.length()==2) {
    		xh1=xh1.insert(0, "000");//如果是2位数，前面增加1个0
    		xh=xh.append(xh1);
    	}else {
    		xh=xh.append(xh1);
    	}
    	return xh;
    }
    //返回颜色
    
    public static String getcolor() {
        int index=getNum(0, color.length()-1);//随机取姓氏字符串中的任意位置
        String color1=color.substring(index, index+1);
        return color1;//返回姓名
    }
    
    //随机返回中文姓名 
    
    public static String getChineseName() {
        int index=getNum(0, firstName.length()-1);//随机取姓氏字符串中的任意位置
        String first=firstName.substring(index, index+1);//获取该位置的姓氏
        int sex=getNum(0,1);//随机取性别，例如1为男生，0为女生
        String str=boy;//定义名字为男生字符串
        int length=boy.length();//获取男生字符串的长度
        if(getsex().equals("雌")){//如果随机获取为0，则名字改为女生
            str=girl;
            length=girl.length();
        }
          index=getNum(0,length-1);//随机获取名字的位置
        String second=str.substring(index, index+1);//获取该位置中的名字
        int hasThird=getNum(0,1);//随机获取名字是否有第三个字
        String third="";//默认没有第三个字
        if(hasThird==1){//如果随机获取为1，则有第三个字
            index=getNum(0,length-1);
            third=str.substring(index, index+1);
        }
        return first+second+third;//返回姓名
    }
    public static String getsex() {
    	 int sex=getNum(0,1);//随机取性别，例如1为男生，0为女生
    	 String  str="雄";
         if(sex==0){//如果随机获取为0，则名字改为女生
             str="雌";
         }
         return str;
    }
    //随机时间
    public static StringBuilder getdate() {
    	StringBuilder date=new StringBuilder("2020");//时间前2位相同
    	StringBuilder month=new StringBuilder(String.valueOf(getNum(1,12)));//随机取后3位
    	StringBuilder day=new StringBuilder(String.valueOf(getNum(1,12)));//随机取后3位
    	if(month.length()==1) {
    		month=month.insert(0, "-0");//如果是1位数，前面增加1个0
    		date=date.append(month);
    	}
    	if(month.length()==2) {
    		month=month.insert(0, "-");//如果是1位数，前面增加1个0
    		date=date.append(month);
    	}
    	
    	if(day.length()==1) {
    		day=day.insert(0, "-0");//如果是1位数，前面增加1个0
    		date=date.append(day);}
    	if(day.length()==2){
    		day=day.insert(0, "-");
    		date=date.append(day);}
    		   
    	   return date;
    	
   }
    
    //


    
    public static void main(String[] args) throws IOException, SQLException {
    	ArrayList<String> alist=new ArrayList<String>();//定义集合
    	
    	DatabaseConnectionSqlPet dbcs=new DatabaseConnectionSqlPet();//使用1中定义的连接数据库的类	
		String sql="insert into Dog values(?,?,?,?,?,?)";
		Connection conn=dbcs.getConnection();//获取数据库接
		PreparedStatement pstmt=conn.prepareStatement(sql);
		for(int i=1;i<=10100;) {
			String xh=getStuno().toString();//随机获取学号
			if(!alist.contains(xh)) {//判断学号是否唯一
				alist.add(xh);//将学号加入集合
				String xm=getChineseName()+"狗";//随机获取姓名
				String sex=getsex();
				String ys=getcolor()+"色";
				String sj=getdate().toString();
				int age=getNum(1, 10000);
				
				File file=new File("d:/ashuju.txt");
				
				
			//插入数据库
				
	    		pstmt.setInt(1,i);
	    		pstmt.setString(2,xm);
	    		pstmt.setString(3,sex);
	    		pstmt.setString(4,ys);
	    		pstmt.setInt(5,age);
	    		pstmt.setString(6,sj);
	    		pstmt.addBatch();//加入批处理等待执行
	    	
				
				try (BufferedWriter bw = new BufferedWriter(new FileWriter(file,true))) {
					String row1 =i+"\t"+xm+"\t"+sex+"\t"+ys+"\t"+age+"\t"+sj;
					   bw.write(row1);
					   bw.newLine();// 写入回车换
					   bw.close();
					  }
			
				i++;//学号唯一，循环继续往下执行
			}
			
			pstmt.executeBatch();//批量执行插入操作
		}
	}
}
