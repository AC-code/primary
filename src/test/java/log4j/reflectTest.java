package log4j;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.junit.Test;

import com.primary.bean.ClassStu;
import com.primary.bean.Classes;
import com.primary.util.ReflectUtil;

public class reflectTest {
	@Test
	public void test() {
		ClassStu stu = new ClassStu();
		stu.setClassid(1);
		stu.setNumber(1);
		stu.setStuid(1);
		
		List<Field> fields = new ArrayList<Field>();
		for (Class<? extends Object> classes = stu.getClass(); classes != Object.class; classes = classes.getSuperclass()) {
			for (Field field : classes.getDeclaredFields()) {
				fields.add(field);
			}
		}
		
		for (Field field : fields) {
			Method getMethod = null;
			
			try {
				getMethod = stu.getClass().getMethod(ReflectUtil.getMethodForFied(field));
			} catch (SecurityException | NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			try {
				System.out.println(getMethod.invoke(stu));
			} catch (JSONException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
