/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eq3progpatterns;

/**
 *
 * @author adinashby
 */
public class ShadowTest {

    public int x = 0;

    class FirstLevel {

        public int x = 1;

        void methodInFirstLevel(int x) {
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("ShadowTest.this.x = " + ShadowTest.this.x);
        }

        class SecondLevel {

            public int x = 2;

            void methodInSecondLevel(int x) {
                System.out.println("x = " + x);
                System.out.println("this.x = " + this.x);
                System.out.println("ShadowTest.this.x = " + ShadowTest.FirstLevel.this.x);
            }
        }
    }

    public static void main(String... args) {
//        ShadowTest st = new ShadowTest();
//        ShadowTest.FirstLevel fl = st.new FirstLevel();
//        fl.methodInFirstLevel(23);

        ShadowTest st = new ShadowTest();
        ShadowTest.FirstLevel fl = st.new FirstLevel();
        ShadowTest.FirstLevel.SecondLevel sl = fl.new SecondLevel();
        sl.methodInSecondLevel(55);
    }
}
