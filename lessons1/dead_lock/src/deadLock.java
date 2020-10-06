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

/**
  *Дедлока нет, так как отпускаем объект и освобождаем место для другого потока, раньше чем переходим к другому объекту
 **/
            public void bow(Friend bower) {

                synchronized(this){
                        System.out.format("%s: %s подстрелил меня!\n", this.name, bower.getName());
                        System.out.format("%s: стреляю в ответ!\n", this.name);
                }
                        bower.bowBack(this);                                
            }

            public synchronized void bowBack(Friend bower) {             
                        System.out.format("%s: %s  подстрелил меня!\n", this.name, bower.getName());
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
