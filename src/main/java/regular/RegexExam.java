package regular;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Matcher�����appendReplacement����Ӧ���������ַ�&\�Ľ�һ������

�������� 
�ַ���ģ�壺 
    String template="�𾴵Ŀͻ�${customerName}��ã��������ѽ��${amount}�����ʻ�${accountNumber}�ϵ����Ϊ${balance}����ӭ�´ι��٣�"; 
������ ${ ��ʼ } ��β��Ϊ���滻�ı����� 
���ݴ����Map�У�keyΪ������valueΪ��ֵ���磺 
Map-- 
    customerName = ���� 
    accountNumber = 888888888
    balance = $1000000.00
    amount = $1000.00 
���д������ 
    public static String composeMessage(String template, Map data) throw Exception 
ʵ�ֽ�����ģ���ַ����еı����򣬰������滻Ϊdata�е���ֵ�� 
���磬�����滻���Ϊ�� 
    "�𾴵Ŀͻ�������ã��������ѽ��$1000.00�����ʻ�888888888�ϵ����Ϊ$1000000.00����ӭ�´ι��٣�" 
ע�����Map���Ҳ�����ֵ���Կ��ַ���""�滻�� 
 * @author yong.zhang
 *
 */
public class RegexExam {
	 public static void main(String args[]) {  
	        HashMap data = new HashMap();  
	        String template = "�𾴵Ŀͻ�${customerName}��ã��������ѽ��${amount}��"  
	                + "���ʻ�${accountNumber}�ϵ����Ϊ${balance}����ӭ�´ι��٣�";  
	        data.put("customerName", "����");  
	        data.put("accountNumber", "888888888");  
	        data.put("balance", "$1000000.00");  
	        data.put("amount", "$1000.00");  
	        try {  
	            System.out.println(composeMessage(template, data));  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	    }  
	  
	    public static String composeMessage(String template, Map data)  
	            throws Exception {  
	        String regex = "\\$\\{(.+?)\\}";  
	        Pattern pattern = Pattern.compile(regex);  
	        Matcher matcher = pattern.matcher(template);  
	        /* 
	         * sb�����洢�滻�������ݣ�����Ѷ�δ�������ַ�����Դ�ַ����� 
	         * �洢������ 
	         */  
	        StringBuffer sb = new StringBuffer();  
	        while (matcher.find()) {  
	            String name = matcher.group(1);//����  
	            String value = (String) data.get(name);//��ֵ  
	            if (value == null) {  
	                value = "";  
	            } else {  
	                /* 
	                 * ����$������replacement��ʱ����ʾ�Բ�����ķ������ã�����Ҫ�������滻���� 
	                 * �е� $ �����滻�������Ǳ�� "\$1000.00" �� "\$1000000000.00" ������ 
	                 * ������ʹ�� matcher.appendReplacement(sb, value) �����滻ʱ�Ͳ���� 
	                 * $1 �����Ƕ���ķ��������ˣ������ʹ����ƥ����ֵamount �� balance�滻 $1 
	                 * ������õ��������� 
	                 * 
	                 * �𾴵Ŀͻ�������ã��������ѽ��amount000.00�����ʻ�888888888�ϵ���� 
	                 * Ϊbalance000000.00����ӭ�´ι��٣� 
	                 * 
	                 * Ҫ�� $ �滻�� \$ ����Ҫʹ�� \\\\\\& ���滻����Ϊһ�� \ Ҫʹ�� \\\ ���� 
	                 * ���滻����һ�� $ Ҫʹ�� \\$ �������滻���� \ ��  $ ����Ϊ�滻����ʱ������ 
	                 * �����ַ���$ �ַ���ʾ���������飬�� \ �ַ���������ת�� $ �ַ��ġ� 
	                 */  
	                value = value.replaceAll("\\$", "\\\\\\$");  
	                //System.out.println("value=" + value);  
	            }  
	            /* 
	             * ����������滻���������ڵ� value �к��� $ �����ַ������ݱ�������"\$1000.00" 
	             * �� "\$1000000000.00" �ˣ����õ�����ȷ�Ľ���� 
	             * 
	             * �𾴵Ŀͻ�������ã��������ѽ��$1000.00�����ʻ�888888888�ϵ� 
	             * ���Ϊ$1000000.00����ӭ�´ι��٣� 
	             * 
	             * ���⣬����������ʹ��Matcher�����appendReplacement()�����������滻�������� 
	             * ����ʹ��String�����replaceAll()��replaceFirst()�����������滻��������Ϊ 
	             * ���Ƕ���ֻ�ܽ���һ���Լ򵥵��滻����������ֻ���滻��һ�������ݣ�����������Ҫ��ÿ 
	             * һ��ƥ��ʽ���滻ֵ����ͬ�����Ծ�ֻ����ѭ����ʹ��appendReplacement��ʽ�������� 
	             * ���滻�ˡ� 
	             */  
	            matcher.appendReplacement(sb, value);  
	            System.out.println("sb = " + sb.toString());  
	        }  
	        //��󻹵�Ҫ��β���ӵ����滻�����ݺ���ȥ������β��Ϊ������ӭ�´ι��٣���  
	        matcher.appendTail(sb);  
	        return sb.toString();  
	    }  
	}  
