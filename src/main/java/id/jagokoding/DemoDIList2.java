package id.jagokoding;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoDIList2 {
	
	@Bean
    public List<Integer> numbers() {
		return Arrays.asList(1, 2, 5, 3, 7);
	}
    
    @Bean
    public MyBean myBean() {
    	return new MyBean();
    }
	
    public static void main(String[] strings) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoDIList2.class);
        MyBean myBean = context.getBean(MyBean.class);
        myBean.printNumbers();
    }
    
    class MyBean {
    	
    	@Autowired
    	private List<Integer> numbers;
    	
    	public void printNumbers() {
    		System.out.println("Print numbers:");
    		numbers.forEach(number -> {
    			System.out.println(number);
    		});
    	}
    }
}