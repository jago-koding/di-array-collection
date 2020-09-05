package id.jagokoding;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoDIList {

	@Bean
	public MyBean bean1() {
		return new MyBean("bean 1");
	}
	
	@Bean
	public MyBean bean2() {
		return new MyBean("bean 2");
	}
	
	@Bean
	public MyBean bean3() {
		return new MyBean("bean 3");
	}

	@Bean
	public DataBean dataBean() {
		return new DataBean();
	}
	
	public static void main(String[] strings) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoDIList.class);
		DataBean bean = context.getBean(DataBean.class);
		bean.printBeans();
	}

	class DataBean {

		private List<MyBean> myBeans;

		@Autowired
		public void setMyBeans(List<MyBean> myBeans) {
			this.myBeans = myBeans;
		}
		
		public void printBeans() {
			System.out.println("Print MyBeans: ");
			myBeans.forEach(myBean -> {
				myBean.sayHello();
			});
		}
	}

	class MyBean {

		private String hello;

		public MyBean(String hello) {
			this.hello = hello;
		}

		public void sayHello() {
			System.out.println("Hello, " + hello);
		}
	}
}