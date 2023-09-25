package fr.mns.java.rest.service;

public class OperationUtil {
	public static Integer multiply(Integer a,Integer b) {
		Integer result=0;
		Integer min=Math.min(a, b);
		Integer max=Math.max(a, b);
		
		if(min<0) {
			for(int i=0;i>min;i--) {
				result-=max;
			}
		}else {
			for(int i=0;i<min;i++) {
				result+=max;
			}
		}
		return result;
	}

}
