package com.jota.util;

import java.util.List;

public class MyMath {

	public static Number calculate(String operator,List<Number> numbers) throws Exception{
		Number total=null;
		try {
			for(Number number:numbers) {
				if(total==null) {
					total=number.doubleValue();
				}else {
				if("+".equals(operator)) {
					total=total.doubleValue()+number.doubleValue();
				}else if("-".equals(operator)) {
					total=total.doubleValue()-number.doubleValue();
				}else if("*".equals(operator) || "x".equalsIgnoreCase(operator)) {
					total=total.doubleValue()*number.doubleValue();
				}else if("/".equals(operator) || "÷".equals(operator)) {
					total=total.doubleValue()/number.doubleValue();
				}else if("^".equals(operator)) {
					total=Math.pow(total.doubleValue(),number.doubleValue());
				}
				}
			}
		}catch(Exception e) {
			throw e;
		}
		return total;
	}
	
}
