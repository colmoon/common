package com.moon.study.common.base.utils.tree;

/**
 * @author wuxiaojian
 * @date 2020/11/13
 */
public interface TreeFactory<I, O extends Treeable> {

    O convert(I i);

    O buildDefaultRoot();

}
