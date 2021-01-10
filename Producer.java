package homework;

/**
* 生产者线程类
* @author : 外哥
* 邮箱 ： liwai2012220663@163.com
* 创建时间:2020年12月19日 下午5:56:11
*/
public class Producer extends Thread{
	private Goods goods ;

	public Producer(Goods goods, String string) {
		super(string);
		this.goods = goods;
	}
	
	@Override
	public void run() {
		// 一直生产产品
		while ( true ) {
			synchronized (goods) { 
				if ( goods.getCount() > 0 ) {
					// 如果有产品，生产者进入无限等待状态 
					try {
						goods.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				// 如果没有产品,则经过五秒钟生产产品 
				System.out.println( getName() + "正在生产产品" + (goods.getCount()+1) );
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				// 更新产品数量
				goods.setCount( goods.getCount() + 1 );
				System.out.println( getName() + "生产出了产品" + goods.getCount() );
				
				// 唤醒所有消费者进行消费
				goods.notify();
			}
		}
		
		
	}
}
