（因为用注解@PostConstruct 注解初始化,会出现 "No Session found for current thread"）的错误，所以改为用如下的方式：

2013-3-31 OK 初始化，自动注入的两种方式: （OK）

(1)获得对应的spring 注解类: 在tradeNotifyMsgProcessor类的方法中：
		TaobaoTradeMsgProcessService taobaoTradeMsgProcessService = SpringContextHolder.getBean("taobaoTradeMsgProcessService");
    	TaobaoTradeService taobaoTradeService = SpringContextHolder.getBean("taobaoTradeService");

在xml配置一下:
   <bean id="springContextHolder" class="cn.macthink.ape.util.SpringContextHolder" />
<!-- 初始化，也可以自动注入 service -->
    
	<bean id="tradeNotifyMsgProcessor" class="cn.macthink.ape.notify.TradeNotifyMsgProcessor" init-method="init"></bean>
	
	
	
(2)	方法二：
   用下面的方式注入:
    @Resource
	private TaobaoTradeMsgProcessService taobaoTradeMsgProcessService;
	
	@Resource
	private MonitorConfDao monitorConfDao;

在xml中配置:
<!-- 初始化，也可以自动注入 service -->
	<bean id="tradeNotifyMsgProcessor" class="cn.macthink.ape.notify.TradeNotifyMsgProcessor" init-method="init"></bean>
	<context:component-scan base-package="cn.macthink.ape.notify" />