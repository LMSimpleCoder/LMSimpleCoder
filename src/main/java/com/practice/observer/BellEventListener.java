package com.practice.observer;

import java.util.EventListener;

//抽象观察者类：铃声事件监听器
interface BellEventListener extends EventListener {
    //事件处理方法，听到铃声
    void heardBell(RingEvent e);
}
