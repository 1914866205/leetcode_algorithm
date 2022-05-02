package com.programmercarl.linkedlist.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ListNodeDouble
 * @Descriotion 双链表结点
 * @Author nitaotao
 * @Date 2022/5/2 17:30
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListNodeDouble {
    /**
     * 链表值
     */
    int value;
    /**
     * 头指针
     */
    ListNodeDouble prev;
    /**
     * 尾指针
     */
    ListNodeDouble next;
}
