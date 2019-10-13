package com.chapter1.exercise;

public class RingBuffer<E> {
    private E[] values;
    private volatile int first = 1;
    private volatile int last = 0;
    private volatile int size = 0;
    private Object lock = new Object();

    public RingBuffer(int size) {
        values = (E[]) new Object[size];
    }

    public boolean isEmpty() {
        synchronized (lock) {
            return size <= 0;
        }
    }

    public boolean isFull() {
        synchronized (lock) {
            return size >= values.length;
        }
    }

    public void enqueue(E e) throws InterruptedException {
        synchronized (lock) {
            while (isFull()) {
                lock.wait();
            }

//            if(isEmpty()) {
//                first = 0;
//                last = 0;
//            } else {
//                last = (last + 1) % values.length;
//            }

            last = (last + 1) % values.length;

            values[last] = e;

            size++;
            lock.notifyAll();
        }

    }

    public E dequeue() throws InterruptedException {
        synchronized (lock) {
            while (isEmpty()) {
                lock.wait();
            }
            E result = values[first];
            values[first] = null;
            first = (first+1)%values.length;
            size--;
            lock.notifyAll();
            return result;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final RingBuffer<Integer> ringBuffer = new RingBuffer<Integer>(3);
        final Thread provider = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 20; i++) {
                    try {
                        System.out.println("provider-->" + i);
                        ringBuffer.enqueue(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println("consumer-->" + ringBuffer.dequeue());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("gogo");
        provider.start();
        Thread.sleep(2000);
        consumer.start();
//        System.out.println(ringBuffer.dequeue());

    }
}
