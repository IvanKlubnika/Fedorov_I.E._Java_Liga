import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.*;
    public class deadLock {



        static class Friend {
            private final String name;
            private static int countThread = 0;

            public Friend(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }

            public void bow(Friend bower) {
/**
*В данном случае ключевое слово synchronized, работает таким образом, что оно относится не к методу, а к блокцу метода.
 * Следовательно решается проблема deadlocka тем, что теперь второй поток может зайти в метод, и освободить для первого потока место.
 **/
                synchronized(this){
                    synchronized(bower){
                        System.out.format("%s: %s подстрелил меня!\n", this.name, bower.getName());
                        System.out.format("%s: стреляю в ответ!\n", this.name);

                        bower.bowBack(this);
                    }
                }
            }

            public void bowBack(Friend bower) {
                synchronized(this){
                    synchronized(bower) {
                        System.out.format("%s: %s  подстрелил меня!\n", this.name, bower.getName());
                    }
                }
            }
        }


        /**
         * Точка входа в программу
         *
         * @param args аргументы командной строки
         */
        public static void main(String[] args) {
            Friend alphonse = new Friend("Alphonse");
            Friend gaston = new Friend("Gaston");

            new Thread(() -> alphonse.bow(gaston)).start();
            new Thread(() -> gaston.bow(alphonse)).start();
        }

    }


