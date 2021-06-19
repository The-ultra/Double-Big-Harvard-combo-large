import java.util.ArrayList;

public class Data_Arraylist extends ArrayList<Object> {
	
	private int max;

@Override
public boolean add(Object e) {
	
	if(this.size()>this.getMax())
		return false;
	return super.add(e);
}

public Data_Arraylist(int max) {
	// TODO Auto-generated constructor stub
	super();
	this.max=max;
}

@Override
public Object get(int index) {
	// TODO Auto-generated method stub
	return super.get(index);
}



public int getMax() {
	return max;
}
public void setMax(int max) {
	this.max = max;
}

}
