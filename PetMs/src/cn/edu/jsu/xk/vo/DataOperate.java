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
	//��������
	private static String firstName="��ë���Ѹɽ�Ӧ�������ڵ��������������ʯ�޼�ť�������ϻ���½��������춻���κ�ӷ����ഢ���������ɾ��θ����ڽ��͹�����ɽ�ȳ������ȫۭ�����������������ﱩ�����������������ղ����Ҷ��˾��۬�輻��ӡ�ް׻���̨�Ӷ����̼���׿�����ɳ����������ܲ�˫��ݷ����̷�����̼������Ƚ��۪Ӻȴ�ɣ���ţ��ͨ�����༽ۣ����ũ�±�ׯ�̲����ֳ�Ľ����ϰ�°���������������θ����߾Ӻⲽ�����������Ŀܹ�»�ڶ�Ź�����εԽ��¡ʦ�������˹��������������Ǽ��Ŀ�����ɳؿ������ᳲ�������󽭺�����Ȩ�ָ��滸����ٹ˾���Ϲ�ŷ���ĺ�������˶��������ʸ�ξ�ٹ����̨��ұ���������������̫����������������ԯ�������������Ľ����������˾ͽ˾������˾���붽�ӳ�����ľ����������������ṫ���ذμй��׸����������ַ���۳Ϳ�նθɰ��ﶫ�����ź��ӹ麣����΢����˧�ÿ�������������������������Ĳ��٦�����Ϲ�ī�������갮��١�����Ը��ټ�����";
	//����Ů������
	private static String girl="���Ӣ���������Ⱦ���������֥��Ƽ�����ҷ���ʴ��������÷���������滷ѩ�ٰ���ϼ����ݺ�����𷲼Ѽ�������������Ҷ�������������ɺɯ������ٻ�������ӱ¶������������Ǻɵ���ü������ޱݼ���Է�ܰ�������԰��ӽ�������ع���ѱ�ˬ������ϣ����Ʈ�����������������������ܿ�ƺ������˿ɼ���Ӱ��֦˼�� ";
	//������������
    private static String boy="ΰ�����㿡��ǿ��ƽ�����Ļ�������������־��������ɽ�ʲ���������Ԫȫ��ʤѧ��ŷ���������ɱ�˳���ӽ��β��ɿ��ǹ���ﰲ����ï�����м�ͱ벩���Ⱦ�����׳��˼Ⱥ���İ�����ܹ����ƺ���������ԣ���ܽ���������ǫ�����֮�ֺ��ʲ����������������ά�������������󳿳�ʿ�Խ��������׵���ʱ̩ʢ��衾��ڲ�����ŷ纽��";
    private static String color="�ڻҰ��ٻ���";
    
    public static int getNum(int start,int end) {//������ط���ָ����Χ�������
    	
    	//Math.random()�������0.0��1.0֮�����
        return (int)(Math.random()*(end-start+1)+start);
    }
    //�������ѧ��
    public static StringBuilder getStuno() {//��ʹ��String����Ϊ��Ҫ����ƴ���ַ���
    	StringBuilder xh=new StringBuilder("sb");//ѧ��ǰ7λ��ͬ
    	StringBuilder xh1=new StringBuilder(String.valueOf(getNum(1,99999)));//���ȡ��3λ
    	if(xh1.length()==1) {
    		xh1=xh1.insert(0, "0000");//�����1λ����ǰ������3��0
    		xh=xh.append(xh1);//ǰ6λ���3λƴ�ӳ�ѧ��
    	}else if(xh1.length()==2) {
    		xh1=xh1.insert(0, "000");//�����2λ����ǰ������1��0
    		xh=xh.append(xh1);
    	}else {
    		xh=xh.append(xh1);
    	}
    	return xh;
    }
    //������ɫ
    
    public static String getcolor() {
        int index=getNum(0, color.length()-1);//���ȡ�����ַ����е�����λ��
        String color1=color.substring(index, index+1);
        return color1;//��������
    }
    
    //��������������� 
    
    public static String getChineseName() {
        int index=getNum(0, firstName.length()-1);//���ȡ�����ַ����е�����λ��
        String first=firstName.substring(index, index+1);//��ȡ��λ�õ�����
        int sex=getNum(0,1);//���ȡ�Ա�����1Ϊ������0ΪŮ��
        String str=boy;//��������Ϊ�����ַ���
        int length=boy.length();//��ȡ�����ַ����ĳ���
        if(getsex().equals("��")){//��������ȡΪ0�������ָ�ΪŮ��
            str=girl;
            length=girl.length();
        }
          index=getNum(0,length-1);//�����ȡ���ֵ�λ��
        String second=str.substring(index, index+1);//��ȡ��λ���е�����
        int hasThird=getNum(0,1);//�����ȡ�����Ƿ��е�������
        String third="";//Ĭ��û�е�������
        if(hasThird==1){//��������ȡΪ1�����е�������
            index=getNum(0,length-1);
            third=str.substring(index, index+1);
        }
        return first+second+third;//��������
    }
    public static String getsex() {
    	 int sex=getNum(0,1);//���ȡ�Ա�����1Ϊ������0ΪŮ��
    	 String  str="��";
         if(sex==0){//��������ȡΪ0�������ָ�ΪŮ��
             str="��";
         }
         return str;
    }
    //���ʱ��
    public static StringBuilder getdate() {
    	StringBuilder date=new StringBuilder("2020");//ʱ��ǰ2λ��ͬ
    	StringBuilder month=new StringBuilder(String.valueOf(getNum(1,12)));//���ȡ��3λ
    	StringBuilder day=new StringBuilder(String.valueOf(getNum(1,12)));//���ȡ��3λ
    	if(month.length()==1) {
    		month=month.insert(0, "-0");//�����1λ����ǰ������1��0
    		date=date.append(month);
    	}
    	if(month.length()==2) {
    		month=month.insert(0, "-");//�����1λ����ǰ������1��0
    		date=date.append(month);
    	}
    	
    	if(day.length()==1) {
    		day=day.insert(0, "-0");//�����1λ����ǰ������1��0
    		date=date.append(day);}
    	if(day.length()==2){
    		day=day.insert(0, "-");
    		date=date.append(day);}
    		   
    	   return date;
    	
   }
    
    //


    
    public static void main(String[] args) throws IOException, SQLException {
    	ArrayList<String> alist=new ArrayList<String>();//���弯��
    	
    	DatabaseConnectionSqlPet dbcs=new DatabaseConnectionSqlPet();//ʹ��1�ж�����������ݿ����	
		String sql="insert into Dog values(?,?,?,?,?,?)";
		Connection conn=dbcs.getConnection();//��ȡ���ݿ��
		PreparedStatement pstmt=conn.prepareStatement(sql);
		for(int i=1;i<=10100;) {
			String xh=getStuno().toString();//�����ȡѧ��
			if(!alist.contains(xh)) {//�ж�ѧ���Ƿ�Ψһ
				alist.add(xh);//��ѧ�ż��뼯��
				String xm=getChineseName()+"��";//�����ȡ����
				String sex=getsex();
				String ys=getcolor()+"ɫ";
				String sj=getdate().toString();
				int age=getNum(1, 10000);
				
				File file=new File("d:/ashuju.txt");
				
				
			//�������ݿ�
				
	    		pstmt.setInt(1,i);
	    		pstmt.setString(2,xm);
	    		pstmt.setString(3,sex);
	    		pstmt.setString(4,ys);
	    		pstmt.setInt(5,age);
	    		pstmt.setString(6,sj);
	    		pstmt.addBatch();//����������ȴ�ִ��
	    	
				
				try (BufferedWriter bw = new BufferedWriter(new FileWriter(file,true))) {
					String row1 =i+"\t"+xm+"\t"+sex+"\t"+ys+"\t"+age+"\t"+sj;
					   bw.write(row1);
					   bw.newLine();// д��س���
					   bw.close();
					  }
			
				i++;//ѧ��Ψһ��ѭ����������ִ��
			}
			
			pstmt.executeBatch();//����ִ�в������
		}
	}
}
