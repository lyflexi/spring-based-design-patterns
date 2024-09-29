package org.lyflexi.dutypattern.genericFactory;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Author: ly
 * @Date: 2024/3/13 22:31
 */

public abstract class AbstractHandler<T,R> {
    protected AbstractHandler<T, R> nextHandler;
    protected Class<T> typeT;

    public AbstractHandler() {
        setMemberTType();
    }

    private void setMemberTType() {
        // 获取泛型类型
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            this.typeT = (Class<T>) parameterizedType.getActualTypeArguments()[0];
        }
    }

    public void setNextHandler(AbstractHandler<T, R> handler) {
        this.nextHandler = handler;
    }

    public boolean hasNext() {
        return nextHandler != null;
    }

    public R handle(T t) {
        Class<T> clazz = (Class<T>) t.getClass();
        if (hasNext()&&nextHandler.typeT.equals(clazz)){
            return nextHandler.doHandler(t);
        }
        if (!hasNext()){
            return null;
        }else {
            throw new RuntimeException("当前责任链节点: "+this.toString()+"负责的数据类型: "+typeT.toString()+"，与下个责任链节点"+nextHandler.toString()+"负责的数据类型: "+clazz.toString()+"不同");
        }
    }





    public abstract R doHandler(T t);

    public T createGenericTInstance() {
        try {
            return typeT.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Failed to create instance of " + typeT.getName(), e);
        }
    }

}
