package org.lyflexi.dutypattern.genericBuilder;

/**
 * @Description:
 * @Author: lyflexi
 * @project: designPartens-practice
 * @Date: 2024/9/28 18:14
 */


public class ChainBuilder<T,R> {
    private AbstractHandler<T,R> head;
    private AbstractHandler<T,R> tail;


    public ChainBuilder<T,R> addHanlder(AbstractHandler<T,R> handler){
        if (null == head){//head==null表示第一次添加到队列
            head = this.tail = handler;
            return this;
        }
        this.tail.setNextHandler(handler);//原tail节点指向新添加进来的节点
        this.tail = handler;//新添加进来的节点设置为tail节点
        return this;
    }

    public AbstractHandler<T,R> build(){
        return this.head;
    }
}
