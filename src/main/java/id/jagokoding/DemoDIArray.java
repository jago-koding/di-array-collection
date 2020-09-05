package id.jagokoding;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoDIArray {
	
	@Bean
    public Integer[] numbers() {
    	return new Integer[] {1, 2, 5, 3, 7};
    }
    
    @Bean
    public MyBean myBean() {
    	return new MyBean();
    }
	
    public static void main(String[] strings) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoDIArray.class);
        MyBean myBean = context.getBean(MyBean.class);
        myBean.printNumbers();
    }
    
    class MyBean {
    	
    	@Autowired
    	private Integer[] numbers;
    	
    	public void printNumbers() {
    		System.out.println("Print numbers:");
    		Arrays.asList(numbers).forEach(number -> {
    			System.out.println(number);
    		});
    	}
    }
}