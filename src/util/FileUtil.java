package util;

import java.text.SimpleDateFormat;

public class FileUtil {
	public static String getNewFileName(String fileExt){
    	/*
    	���������������һ���µ��ļ�����������ʱ������������Ϊ�ļ�����
    	���ļ�ԭ������չ����Ϊ���ļ�����չ�����Դ˱�֤�ϴ����ļ����������ظ�
    	*/
     	
    	 //��ȡ��ǰ����ʱ��,ʹ��SimpleDateFormat�Ե�ǰ����ʱ����и�ʽ�����õ�15λ�ַ���
    	 java.util.Date now = new java.util.Date();  
       	 SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
    	String fileName = sdf.format(now);
    	 
    	 //���������StringBuffer����һ����λ�������ַ���
    	 int rnd = (int) Math.round(Math.random() * 10000);//�õ�0-9999�������
    	 StringBuffer s = new StringBuffer("0000").append(rnd);//�������ǰ������ĸ���
    	 s.delete(0, s.length() - 4); //ʹ��delete�����ӻ�����ɾ��ĳЩ��λ��delete������������ʾɾ������ʼλ�úͽ���λ��
    	 
    	 //�����ļ���
    	fileName = fileName + s.toString() + "." + fileExt;
    	return fileName;
	}
}
