package regular;

public class SpecialCharReplace {
	 public static void main(String[] args) {  
	        String str = "$ \\";  
	        /* 
	         * string.replaceAll()�е������ַ� $ �� \  
	         *  
	         * ���� $ �ַ�����Ϊ�滻����ʱ����һ�������ַ���ָ��������ǰ��ķ������ݣ����԰� 
	         * ĳ�ַ��滻�� $ �ַ�ʱ�������ǰ�����ת���ַ� \�� 
	         * \ �ַ��Ͳ���˵�ˣ��������ת���ַ�����Ϊʲô����Ϊ�滻����ʱҪʹ���ĸ� \ �ַ� 
	         * �������ֲ�������������ʽ��������Ϊ \ �ַ�����Ϊ�滻������Ҳ��һ�������� 
	         * ������������ǰ�潲�� $ �ַ�����ת���ģ�����ҲΪ�����ַ���������replaceAll�� 
	         * Դ��Ƭ�ϣ���Դ��Ϳ��Կ��� \$ �����������ַ� 
	         *  
	         * if (nextChar == '\\') { 
	         *      cursor++; 
	         *      nextChar = replacement.charAt(cursor); 
	         *      result.append(nextChar); 
	         *      cursor++; 
	         * } else if (nextChar == '$') { 
	         *      // Skip past $ 
	         *      cursor++; 
	         *      ... 
	         * }else { 
	         *      result.append(nextChar); 
	         *      cursor++; 
	         * } 
	         */  
	        System.out.println(str.replaceAll("\\$(\\W)\\\\", "\\\\$1\\$"));// \ $  
	    }  
}
