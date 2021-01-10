package homework;

/**
* 消费者Runnable
* @author : 外哥
* 邮箱 ： liwai2012220663@163.com
* 创建时间:2020年12月19日 下午6:02:38
*/
public class Consumer implements Runnable{
	private Goods goods ; 
	 
	public Consumer(Goods goods) {
		super();
		this.goods = goods;
	}

	public void run() {
		
		while ( true ) {
			synchronized (goods) {
				if ( goods.getCount() <= 0 ) {
					// 如果没有产品,唤醒生产者进行生产，则消费者进入无限等待状态 
					try {
						goods.notify();
						goods.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				// 如果有产品，则进行消费 
				System.out.println( Thread.currentThread().getName() + "正在消费产品" + goods.getCount() );
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println( Thread.currentThread().getName() + "消费了产品" + goods.getCount() );
				System.out.println("--------------------------------------");
				goods.setCount( goods.getCount() - 1 ); 
				
			} 
		}
		
	} 
}
