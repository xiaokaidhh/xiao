package cn.edu.jsu.xk.vo;

public abstract class AbstractPet {
	private int id;
	private String name;        //����
    private String sex;	//�Ա�
    private int age;            //����
    private String color;     //��ɫ
    private String getdata;
//    //������󷽷�
//    public abstract void printInfo();          //��Ϣ����
    
	public AbstractPet() {
		
	}
	public String toString() {
		return "��ţ�"+id+ "	������  " + name + " 	�Ա�"  + sex+ "  ��ɫ��" + color+"	�ȶ�:" + age +"	������ڣ�"+getdata;
	}

	/**
	 * @param id
	 * @param name
	 * @param sex
	 * @param age
	 * @param color
	 * @param getdata
	 */
	public AbstractPet(int id, String name, String sex, int age, String color, String getdata) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.color = color;
		this.getdata = getdata;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getGetdata() {
		return getdata;
	}
	public void setGetdata(String getdata) {
		this.getdata = getdata;
	}
	

	
}
	
	
	
	
	
	

