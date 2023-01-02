# pattern-spring

设计模式 spring-demo,结合实际业务场景的demo

### 状态模式+观察者模式（监听器模式）
项目需求描述：
用户从开始下订单，到支付完成，再到物流部进行发货，最终用户确认发货，整个流程涉及到很多订单状态，需要通过代码对订单机械能管理。除此以外，用户或者物流部分每一次出发的不同操作都有可能改变订单状态。如：
- 用户创建订单操作导致订单状态为 待支付状态；
- 用户支付操作导致订单状态变为待发货状态；
- 物流部门发货操作导致订单状态变为待收货状态；
- 用户确认收获操作导致订单状态变为订单完成状态；

开发任务：
设计整体结算发货及收货的流程。用户创建订单-> 支付订单->发货 -> 收货 -> 订单完成。

要求：
- 创建订单完成后，订单状态初始化为待支付。
- 订单状态包括：待支付；待发货；待收货；订单完成。（状态模式）
- 触发订单状态变化的操作：支付订单；发货；确认收货 


### 【装饰器模式+代理模式】部分订单支付完成更新平台币、红包发放等后续业务。
项目需求：部分推销商品付款完成后，需要平台对当前用户的平台币继续更新
要求：
1. 平台币的更新和红包发放业务为附属业务，不能影响主支付业务逻辑。
2. 平台币的更新和红包发放业务只对部分推广商品有效，且依赖于商品的属性变更。商品属性变更，如需取消平台必更新和发放红包业务，不可修改代码。要做到在线实时热更新。
3. 调用层无需关心该商品是否需要更新平台币或者发放红包。做到与上层调用者的完全解耦。
4. 该逻辑为支付的附属业务，随着支付完成立即触发。但不可影响支付主要逻辑。

装饰者模式：
装饰模式，动态地给一个对象添加一些额外的职责。
- Component 抽象构件
Component是一个接口或者是抽象类，就是定义我们最核心的对象，也就是最原始的对象。注意，在装饰模式中，必然有一个最基本、最核心、最原始的接口或抽象类充当component抽象构件。
- ConcreteComponent 具体构件
ConcreteComponent是最核心、最原始、最基本的接口或抽象类的实现，你要装饰的就是他。
- Decorator 装饰角色
一般是一个抽象类，做什么用呢？实现接口或者抽象方法，它里面可不一定有抽象的发放，在它的属性里必然有一个private变量指向component抽象构件。
- 具体装饰角色
concreteDecoratorA和ConcreteDecoratorB是两个具体的装饰类，你要把最核心、最原始、最基本的东西装饰成其他东西。
