package homework;

/**
* 生产者和消费者案例的测试类
* @author : 外哥
* 邮箱 ： liwai2012220663@163.com
* 创建时间:2020年12月19日 下午6:07:29
*/
public class Test {
	public static void main(String[] args) {
		Goods goods = new Goods() ;
		goods.setCount(0);
		
		// 开启生产者线程
		new Producer(goods,"生产者").start();
		
		// 开启消费者线程
		Consumer consumer = new Consumer(goods) ;
		new Thread(consumer,"顾客1").start();  
	}
}
