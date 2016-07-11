package util;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	public static String getJsonString(Object o){
		ObjectMapper mapper=new ObjectMapper();
		String res=null;
		try {
			res=mapper.writeValueAsString(o);
		}  catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}
}
